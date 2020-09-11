package de.wroracer.myfirstmcplugin.commands;

import com.avaje.ebeaninternal.server.loadcontext.DLoadBeanContext;
import de.wroracer.myfirstmcplugin.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("myfirstplugin.spawn")){
                if (args.length == 0){

                    FileConfiguration config = Main.getPlugin().getConfig();
                    World world = Bukkit.getWorld(config.getString("Spawn.World"));
                    Double x = config.getDouble("Spawn.X");
                    Double y = config.getDouble("Spawn.Y");
                    Double z = config.getDouble("Spawn.Z");
                    Float yaw =(float) config.getDouble("Spawn.Yaw");
                    Float pitch =(float) config.getDouble("Spawn.Pitch");
                    Location location = new Location(world, x,y,z,yaw,pitch);
                    player.teleport(location);
                }else
                    player.sendMessage("§cBitte benutze §6/spawn");
            }else
                player.sendMessage("§cDazu hast du keine Rechte");
        }
        return false;
    }
}
