package me.emperio.tokenwands.events;

import me.emperio.tokenwands.TokenWands;
import me.emperio.tokenwands.util.EmpUtil;
import me.emperio.tokenwands.wands.LeapWand;
import me.emperio.tokenwands.wands.RegenWand;
import me.emperio.tokenwands.wands.SpeedWand;
import me.emperio.tokenwands.wands.StrengthWand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class PlayerUsesWand implements Listener {

    TokenWands plugin;
    public PlayerUsesWand(TokenWands instance){
        this.plugin = instance;
    }

    @EventHandler
    public void playerUsedWand(PlayerInteractEvent e){

        Player player = e.getPlayer();

        if(e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction()
                .equals(Action.LEFT_CLICK_AIR)){

            if(!e.hasItem()){
                return;
            }
            String rawName = e.getPlayer().getItemInHand().getItemMeta().getDisplayName();
            String displayName = ChatColor.stripColor(e.getPlayer().getItemInHand().getItemMeta().getDisplayName());
            PotionEffect effect;


            int tokenCost;

            if(displayName.equalsIgnoreCase(new LeapWand().getWandDisplayName())){

                effect = new LeapWand().effect;
                tokenCost = new LeapWand().cost;

            }
            else if(displayName.equalsIgnoreCase(new SpeedWand().getWandDisplayName())){
                effect = new SpeedWand().effect;
                tokenCost = new SpeedWand().cost;
            }
            else if(displayName.equalsIgnoreCase(new StrengthWand().getWandDisplayName())){
                effect = new StrengthWand().effect;
                tokenCost = new StrengthWand().cost;
            }
            else if(displayName.equalsIgnoreCase(new RegenWand().getWandDisplayName())){
                effect = new RegenWand().effect;
                tokenCost = new RegenWand().cost;
            }
            else{
                return;
            }


            int currentTokens = (int) plugin.getTokenManager().getTokens(player).orElse(0);
            if(tokenCost > currentTokens){
                player.sendMessage(EmpUtil.getColored("&cYou do not have the sufficient funds to use " + rawName));
                return;
            }
            ArrayList<PotionEffectType> effects = new ArrayList<>();
            for(PotionEffect each : player.getActivePotionEffects()){

                effects.add(each.getType());

            }

            if(effects.contains(effect.getType())){

                player.sendMessage(EmpUtil.getColored(plugin.getConfig().getString("lang.buff-already-active")));
                return;

            }

            player.addPotionEffect(effect);



            plugin.getTokenManager().setTokens(player, currentTokens - tokenCost);
            player.sendMessage(EmpUtil.getColored("&c&l-" + tokenCost) + " TOKENS");
            player.sendMessage(EmpUtil.getColored(plugin.getConfig().getString("lang.wand-used") + " " + rawName));



        }

    }


}
