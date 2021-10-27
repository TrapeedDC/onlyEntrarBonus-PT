package me.onlyjoser.onlytemplate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class Main extends JavaPlugin implements Listener {
	
	public static Main getPlugin() {
        return Main.getPlugin(Main.class);
    }	
	
	public void onEnable() {
		System.out.println("");
		System.out.println("onlyEntrarBonus - Versão: v1.0");
		System.out.println("O plugin está ligado.");
		System.out.println("");
		
		Bukkit.getPluginManager().registerEvents(this, this);
		saveDefaultConfig();

	}
	public void onDisable() {
		HandlerList.unregisterAll();
		System.out.println("");
		System.out.println("onlyEntrarBonus - Versão: v1.0");
		System.out.println("O plugin está desligado.");
		System.out.println("");
	}

	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		if(p.hasPermission("onlyentrarbonus_avisar")) {
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage(getConfig().getString("logar_especial").replace("&", "§").replace("{player}", p.getName().replace("%player%", p.getName())));
			Bukkit.broadcastMessage("");
			ActionBarAPI.sendActionBarToAllPlayers(Main.getPlugin().getConfig().getString("logar_especial_actionbar").replace("&", "§").replace("{player}", p.getName().replace("%player%", p.getName())));
		}
		if(!p.hasPlayedBefore()) {
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage(getConfig().getString("primeiro_login").replace("&", "§").replace("{player}", p.getName()));
			Bukkit.broadcastMessage("");
			ActionBarAPI.sendActionBar(p, Main.getPlugin().getConfig().getString("primeiro_login_actionbar").replace("&", "§").replace("{player}", p.getName()));
		}
	}
}
