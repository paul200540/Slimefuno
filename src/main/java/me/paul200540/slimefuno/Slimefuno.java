package me.paul200540.slimefuno;

import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

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
        ItemStack categoryItem2 = new CustomItem(SkullItem.fromHash("931b6c35a8ac8366a4db51b042a8728dd2e8e5f2fe44aff08fcf5af3b921c6dd"), "&a&lSlimefuno &2&lResources", "", "&a> Click to open");

        // Give your Category a unique id.
        NamespacedKey categoryId = new NamespacedKey(this, "Slimefuno");
        NamespacedKey categoryId2 = new NamespacedKey(this, "Slimefuno Resources");
        Category category = new Category(categoryId, categoryItem);
        Category category2 = new Category(categoryId2, categoryItem2);

        /*
         * 2. Create a new SlimefunItemStack
         * This class has many constructors, it is very important
         * that you give each item a unique id.
         */
        SlimefunItemStack slimefunItem = new SlimefunItemStack("CLEAR_SLIME", Material.LIME_STAINED_GLASS, "&a&lClear &2&lSlime", "&a&lSlime that's clear??? Woah!");

        /*
         * 3. Creating a Recipe
         * The Recipe is an ItemStack Array with a length of 9.
         * It represents a Shaped Recipe in a 3x3 crafting grid.
         * The machine in which this recipe is crafted in is specified
         * further down as the RecipeType.
         */
        ItemStack[] recipe = { new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.GLASS), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK), new ItemStack(Material.SLIME_BLOCK) };

        /*
         * 4. Registering the Item
         * Now you just have to register the item.
         * RecipeType.ENHANCED_CRAFTING_TABLE refers to the machine in
         * which this item is crafted in.
         * Recipe Types from Slimefun itself will automatically add the recipe to that machine.
         */
        SlimefunItem item = new SlimefunItem(category2, slimefunItem, RecipeType.MAGIC_WORKBENCH, recipe);
        item.register(this);
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
