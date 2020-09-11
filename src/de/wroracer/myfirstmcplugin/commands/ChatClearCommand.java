package de.wroracer.myfirstmcplugin.commands;

import net.minecraft.server.v1_8_R3.CommandDebug;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if (sender instanceof Player){
            Player player =(Player) sender;
            if (player.hasPermission("myfirstplugin.cc")){
                if (args.length == 0){

                    for (int i = 0; i <= 150; i++){
                        Bukkit.broadcastMessage(" ");
                    }
                    Bukkit.broadcastMessage("§aDer Chat wurde von §6"+ player.getName()+"§a geleert!");
                }else
                    player.sendMessage("§cBitte benutze §6/cc§c!");
            }else
                player.sendMessage("§cDazu hast du keine Rechte");
        }
        return false;
    }
}
