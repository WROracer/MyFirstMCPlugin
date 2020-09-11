package de.wroracer.myfirstmcplugin.commands;

import de.wroracer.myfirstmcplugin.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor {

    private int taskID;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
        if (sender instanceof Player){

            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
                int countdown = 60;
                @Override
                public void run() {
                    switch (countdown) {
                        case 60: case 30: case 15: case 10: case 5: case 4: case 3: case 2:
                            Bukkit.broadcastMessage("§7Die Party Startet in §6" + countdown+" §7Sekunde");
                            break;
                        case 1:
                            Bukkit.broadcastMessage("§7Die Party Startet in §6einer §7Sekunde");
                            break;
                        case 0:
                            Bukkit.broadcastMessage("§6§lDIE PARTY BEGINNT!!!!!!!!");
                            Bukkit.getScheduler().cancelTask(taskID);
                            return;
                        default:
                            break;
                    }
                    countdown--;
                }
            }, 0,20 );

        }
        return false;
    }
}
