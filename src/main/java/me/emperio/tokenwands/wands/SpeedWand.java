package me.emperio.tokenwands.wands;

import me.emperio.tokenwands.Wand;
import me.emperio.tokenwands.util.EmpUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class SpeedWand extends Wand {

    public SpeedWand(){

    }
    String wandName = "speed";
    @SuppressWarnings("Duplicates")
    public void initializeRecipe(){

        name = "speed";
        wandName = name;
        String itemName = plugin.getConfig().getString("wands." + name + ".name");
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        List<String> rawLore = (List<String>) plugin.getConfig().getList("wands." + name + ".lore");
        ArrayList<String> lore = new ArrayList<>();

        for(String each : rawLore){
            lore.add(EmpUtil.getColored(each));
        }

        meta.setDisplayName(EmpUtil.getColored(itemName));
        meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        ShapedRecipe r = new ShapedRecipe(item);
        r.shape(" & ", " * ", " * ");
        Material ingredient = Material.getMaterial(plugin.getConfig().getString("wands." + name + ".item"));
        r.setIngredient('*', Material.STICK);
        r.setIngredient('&', ingredient);
        recipe = r;
        plugin.getServer().addRecipe(r);
        plugin.getServer().getLogger().info("[TokenWands] Initialised Recipe for " + name + " wand");
    }

    private int effectAmp = plugin.getConfig().getInt("wands." + wandName + ".amplifier");
    private int length = plugin.getConfig().getInt("wands." + wandName + ".length");
    public PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, length, effectAmp);
    public int cost = plugin.getConfig().getInt("wands." + wandName + ".cost");

    public String getWandDisplayName(){

        String rawItemName = EmpUtil.getColored(plugin.getConfig().getString("wands." + wandName + ".name"));

        return ChatColor.stripColor(rawItemName);


    }

}
