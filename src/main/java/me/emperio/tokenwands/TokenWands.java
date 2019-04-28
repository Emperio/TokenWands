package me.emperio.tokenwands;

import me.emperio.tokenwands.events.PlayerUsesWand;
import me.emperio.tokenwands.wands.LeapWand;
import me.emperio.tokenwands.wands.RegenWand;
import me.emperio.tokenwands.wands.SpeedWand;
import me.emperio.tokenwands.wands.StrengthWand;
import me.realized.tokenmanager.TokenManagerPlugin;
import me.realized.tokenmanager.api.TokenManager;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class TokenWands extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new StrengthWand().initializeRecipe();
        new SpeedWand().initializeRecipe();
        new LeapWand().initializeRecipe();
        new RegenWand().initializeRecipe();
        findTokenManager();
        getServer().getPluginManager().registerEvents(new PlayerUsesWand(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void findTokenManager() {
        Plugin plugin = getServer().getPluginManager().getPlugin("TokenManager");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof TokenManager)) {
            getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[TokenWands] "+ ChatColor.RED + " TokenManager NOT FOUND");

        }
        getServer().getConsoleSender().sendMessage("[TokenWands] "+ ChatColor.GREEN + " Successfully hooked into TokenManager");

    }

    public TokenManager getTokenManager() {
        Plugin plugin = getServer().getPluginManager().getPlugin("TokenManager");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof TokenManager)) {
            getServer().getConsoleSender().sendMessage("[TokenWands] "+ ChatColor.RED + " TokenManager NOT FOUND");
            return null; // Maybe you want throw an exception instead
        }
        return (TokenManager) plugin;

    }

    public HashMap<String, Integer> getEntityTokenChances(){
        HashMap<String, Integer> hm = new HashMap<>();
        for(String each : getConfig().getConfigurationSection("tokenchance").getKeys(false)){
            int value = getConfig().getInt("tokenchance." + each);
            hm.put(each, value);
        }

        return hm;
    }


}
