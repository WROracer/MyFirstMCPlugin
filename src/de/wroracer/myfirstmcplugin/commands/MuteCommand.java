package de.wroracer.myfirstmcplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class MuteCommand implements CommandExecutor, Listener {

    private ArrayList<String> mutedPlayers = new ArrayList<>();

    @EventHandler
    public void handelMutedChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if (mutedPlayers.contains(player.getName())){
            player.sendMessage("§cDu bist Aktuell Gemuted, Wehalb du nicht Chaten kannst");
            event.setCancelled(true);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player =(Player) sender;
            if (player.hasPermission("myfirstplugin.mute")){
                if (args.length ==1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){

                        if (!mutedPlayers.contains(target.getName())){
                            if (!target.hasPermission("myfirstplugin.mutenot")){
                                mutedPlayers.add(target.getName());
                                player.sendMessage("§aDer Spieler wurde Gemuted");
                                target.sendMessage("§cDu wurdes Gemuted");
                            }else
                                player.sendMessage("§cDu kannst den Spieler §6"+args[0]+" §cnicht Muten!");
                        }else {
                            mutedPlayers.remove(target.getName());
                            player.sendMessage("§aDer Spieler wurde Entmuted");
                            target.sendMessage("§aDu wurdes Entmuted");
                        }

                    }else
                        sender.sendMessage("§cDer Spieler §6"+args[0]+" §cist nicht auf dem Server!");

                }else
                    player.sendMessage("§cBitte benutze §6/mute {player}§c!");
            }else
                player.sendMessage("§cDazu hast du keine Rechte");
        }
        return false;
    }

}
