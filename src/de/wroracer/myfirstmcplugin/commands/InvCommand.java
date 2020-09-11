package de.wroracer.myfirstmcplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InvCommand implements CommandExecutor {

    private HashMap<String, ItemStack[]> inventorySave = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 1){

                if (args[0].equalsIgnoreCase("save")){
                    inventorySave.put(player.getName(),player.getInventory().getContents());
                    player.getInventory().clear();
                    player.sendMessage("§aDein Inventar wurde §6Gespeichert§a!");
                } else if (args[0].equalsIgnoreCase("get")){
                    if (inventorySave.containsKey(player.getName())){
                        player.getInventory().setContents(inventorySave.get(player.getName()));
                        inventorySave.remove(player.getName());
                        player.sendMessage("§aDein Inventar wurde §6Geladen§a!");
                    } else
                        player.sendMessage("§cDu hast moch kein Inventar Gespeichert!");


                }else
                    player.sendMessage("§cBitte benutze $6/inv save§7/§6get§c");

            }else
                player.sendMessage("§cBitte benutze $6/inv save§7/§6get§c");
        }
        return false;
    }
}
