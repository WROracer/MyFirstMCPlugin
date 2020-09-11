package de.wroracer.myfirstmcplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListender implements Listener {

    @EventHandler
    public void handelPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("§aDer Spieler §6"+event.getPlayer().getName()+" §ahat den Server betreten");
    }

}
