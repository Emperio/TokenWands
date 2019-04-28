package me.emperio.tokenwands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;


public class CustomRecipes {

    TokenWands plugin;

    public CustomRecipes(TokenWands instance){
        this.plugin = instance;
    }

    public void initializeRecipes(){




        /**for(String s : plugin.getConfig().getConfigurationSection("wands").getKeys(false)){
            Wand w = new Wand(s);

            ShapedRecipe recipe = new ShapedRecipe(w.getWand());
            recipe.shape(" # ", " % ", " % ");
            recipe.setIngredient('#', w.getCraftingItem());
            recipe.setIngredient('%', Material.STICK);
            plugin.getServer().addRecipe(recipe);
            plugin.getServer().getConsoleSender().sendMessage(s + ChatColor.YELLOW + "successfully initialized");

        }**/

    }





}
