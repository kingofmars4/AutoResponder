package me.bukkit.mkservices.disasterar;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.bukkit.mkservices.disasterar.listeners.onCommand;

public class Main extends JavaPlugin{

	public static Plugin plugin;
	public static Plugin getPlugin(){return plugin;}
	
	public void onEnable() {
		plugin = this;
		ligarConfig();
		getServer().getPluginManager().registerEvents(new onCommand(), this);
	}
	
	public void ligarConfig() {
			this.saveDefaultConfig();
			getConfig().options().copyDefaults(false);
			saveConfig();
	}
	
}
