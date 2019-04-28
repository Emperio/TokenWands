package me.emperio.tokenwands.events;

import me.emperio.tokenwands.Wand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobDies implements Listener {
    @SuppressWarnings( "deprecation" )
    @EventHandler
    public void onPlayerKillMobEvent(EntityDeathEvent e){
        Entity dead = e.getEntity();
        Player player = (Player) e.getEntity().getLastDamageCause();
        if(e.getEntity().getLastDamageCause() instanceof Player){

            if()

        }

    }

}
