package me.bukkit.mkservices.disasterar.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.bukkit.mkservices.disasterar.Main;
import me.bukkit.mkservices.disasterar.utils.U;

public class onCommand implements Listener{

	@EventHandler
    public void teste(PlayerCommandPreprocessEvent event){
		Player p = event.getPlayer();
		
            for (String key : Main.getPlugin().getConfig().getConfigurationSection("Commands").getKeys(true)) {
                
                
                if(event.getMessage().equalsIgnoreCase("/" + key)){
                	
                	for(String messages : Main.getPlugin().getConfig().getStringList("Commands." + key)) {
                		
                		p.sendMessage(U.color(messages).replaceAll("%player%", p.getName()));
                		}
                	
                		event.setCancelled(true);
                	}
            }
            
            if (event.getMessage().equalsIgnoreCase("/ar reload")) {
            	p.sendMessage(U.color("&aYou have sucefully reloaded the config!"));
				Main.getPlugin().reloadConfig();
				
				event.setCancelled(true);
            }
    }
}
