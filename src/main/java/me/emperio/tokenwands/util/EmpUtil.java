package me.emperio.tokenwands.util;

import org.bukkit.ChatColor;

public class EmpUtil {

    public static String getColored(String message){

        String messageToSend =  ChatColor.translateAlternateColorCodes('&', message);

        return messageToSend;


    }

}
