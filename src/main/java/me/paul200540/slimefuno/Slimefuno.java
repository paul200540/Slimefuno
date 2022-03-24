package me.paul200540.slimefuno;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Slimefuno extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        /*
         * 1. Creating a new Category
         * This Category will use the following ItemStack
         */
        ItemStack categoryItem = new CustomItem(SkullItem.fromHash("4934a9f5ab1789a7d8dd96d32493cdacff577d8c81e7b23917dff2e32bd0bc10"), "&a&lSlimefuno", "", "&a> Click to open");

        // Give your Category a unique id.
        NamespacedKey categoryId = new NamespacedKey(this, "Slimefuno");
        Category category = new Category(categoryId, categoryItem);

        /*
         * 2. Create a new SlimefunItemStack
         * This class has many constructors, it is very important
         * that you give each item a unique id.
         */
        SlimefunItemStack CLEAR_SLIME = new SlimefunItemStack("CLEAR_SLIME", Material.LIME_STAINED_GLASS, "&a&lClear &2&lSlime", "&a&lSlime that's clear??? Woah!");
        SlimefunItemStack CONDENSED_SLIME = new SlimefunItemStack("CONDENSED_SLIME", Material.SLIME_BLOCK, "&a&lCondensed &2&lSlime", "&a&lIt's so condensed that you", "&a&lcan't even see through it!");
        SlimefunItemStack SLIME_HAIR = new SlimefunItemStack("SLIME_HAIR", Material.STRING, "&a&lSlime &2&lHair", "&a&lIt's so soft and fluffy that you can", "&a&ljust curl your fingers around it!");
        CLEAR_SLIME.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 5);
        /*
         * 3. Creating a Recipe
         * The Recipe is an ItemStack Array with a length of 9.
         * It represents a Shaped Recipe in a 3x3 crafting grid.
         * The machine in which this recipe is crafted in is specified
         * further down as the RecipeType.
         */
        ItemStack[] ClearSlimeRecipe = { new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.GLASS), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK) };
        ItemStack[] CondensedSlimeRecipe = {CLEAR_SLIME, CLEAR_SLIME, CLEAR_SLIME, CLEAR_SLIME, CLEAR_SLIME, CLEAR_SLIME, CLEAR_SLIME, CLEAR_SLIME, CLEAR_SLIME};
        ItemStack[] SlimeHairRecipe = {new ItemStack(Material.STRING), new ItemStack(Material.STRING), new ItemStack(Material.STRING), new ItemStack(Material.STRING), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.STRING), new ItemStack(Material.STRING), new ItemStack(Material.STRING), new ItemStack(Material.STRING)};
        /*
         * 4. Registering the Item
         * Now you just have to register the item.
         * RecipeType.ENHANCED_CRAFTING_TABLE refers to the machine in
         * which this item is crafted in.
         * Recipe Types from Slimefun itself will automatically add the recipe to that machine.
         */
        SlimefunItem item = new SlimefunItem(category, CLEAR_SLIME, RecipeType.MAGIC_WORKBENCH, ClearSlimeRecipe);
        SlimefunItem item2 = new SlimefunItem(category, CONDENSED_SLIME, RecipeType.MAGIC_WORKBENCH, CondensedSlimeRecipe);
        SlimefunItem item3 = new SlimefunItem(category, SLIME_HAIR, RecipeType.MAGIC_WORKBENCH, SlimeHairRecipe);
        item.register(this);
        item2.register(this);
        item3.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
