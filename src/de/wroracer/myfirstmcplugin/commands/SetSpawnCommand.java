package de.wroracer.myfirstmcplugin.commands;

import de.wroracer.myfirstmcplugin.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("myfirstplugin.spawn")){
                if (args.length ==0){

                    FileConfiguration config = Main.getPlugin().getConfig();
                    config.set("Spawn.World", player.getWorld().getName());
                    config.set("Spawn.X", player.getLocation().getX());
                    config.set("Spawn.Y", player.getLocation().getY());
                    config.set("Spawn.Z", player.getLocation().getZ());
                    config.set("Spawn.Yaw", player.getLocation().getYaw());
                    config.set("Spawn.Pitch", player.getLocation().getPitch());
                    Main.getPlugin().saveConfig();
                    player.sendMessage("§aDu hast den §6Spawnpunkt §aUmgesetzt!");
                }else
                    player.sendMessage("§cBitte benutze §6/setspawn");
            }else
                player.sendMessage("§cDazu hast du keine Rechte");
        }
        return false;
    }
}
