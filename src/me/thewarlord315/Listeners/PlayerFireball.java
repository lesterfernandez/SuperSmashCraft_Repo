package me.thewarlord315.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerFireball implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
	        if (!(e.getAction() == Action.RIGHT_CLICK_AIR)) return;
	       
	        if (!(e.getItem().getType() == Material.FIREBALL)) return;
	       
	        Fireball f = e.getPlayer().launchProjectile(Fireball.class);
	        f.setIsIncendiary(false);
	        f.setYield(0);
	                }
}
