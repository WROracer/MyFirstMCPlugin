package de.wroracer.myfirstmcplugin.main;

import de.wroracer.myfirstmcplugin.commands.*;
import de.wroracer.myfirstmcplugin.listeners.JoinListender;
import de.wroracer.myfirstmcplugin.util.RecipeLoader;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private static Main plugin;

    public void onEnable() {
        plugin = this;
        MuteCommand muteCommand = new MuteCommand();

        new RecipeLoader().registerRecipes();

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("kit").setExecutor(new KitCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("party").setExecutor(new PartyCommand());
        getCommand("cc").setExecutor(new ChatClearCommand());
        getCommand("mute").setExecutor(muteCommand);
        getCommand("inv").setExecutor(new InvCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListender(), this);
        pluginManager.registerEvents(muteCommand,this);

        for (Player curent : Bukkit.getOnlinePlayers()){
            curent.sendMessage("§aDu siehst heute aber gut aus §6"+curent.getName()+" §e!");
        }
    }

    public static Main getPlugin() {return plugin;}
}
