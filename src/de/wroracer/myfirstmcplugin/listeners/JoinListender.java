package de.wroracer.myfirstmcplugin.listeners;

import de.wroracer.myfirstmcplugin.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class JoinListender implements Listener {

    @EventHandler
    public void handelPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("§aDer Spieler §6"+player.getName()+" §ahat den Server betreten");

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = board.registerNewObjective("abcd","abcd");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§6§lWilkommen!");
        objective.getScore(" ").setScore(3);
        objective.getScore("§aHallo §6" + player.getName()+" §a!").setScore(2);
        objective.getScore("§aViel Spaß auf dem Server").setScore(1);
        player.setScoreboard(board);

        player.getInventory().addItem(new ItemBuilder(Material.GOLD_AXE).setName("§6Axt des Todes").setLore("§aLore1","§5Lore2").buid());
        player.getInventory().addItem(new ItemBuilder(Material.WOOL,(short)6).setLore("§cTest Lore").setAmount(42).buid());
        System.out.println("Login Event");
    }

}
