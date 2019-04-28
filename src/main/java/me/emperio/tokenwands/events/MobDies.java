package me.emperio.tokenwands.events;

import me.emperio.tokenwands.TokenWands;
import me.emperio.tokenwands.Wand;
import me.emperio.tokenwands.util.EmpUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobDies implements Listener {

    TokenWands plugin;
    public MobDies(TokenWands instance){
        this.plugin = instance;
    }


    @EventHandler
    public void onPlayerKillMobEvent(EntityDeathEvent e){
        Entity dead = e.getEntity();
        Player player = (Player) e.getEntity().getKiller();
        if(player != null){

            if(plugin.getEntityTokenChances().containsKey(dead.getType().name())){
                int currentTokens = (int) plugin.getTokenManager().getTokens(player).orElse(0);
                plugin.getTokenManager().setTokens(player, currentTokens + 1);
                player.sendMessage(EmpUtil.getColored("&a&l+1 TOKEN"));
            }

        }

    }

}
