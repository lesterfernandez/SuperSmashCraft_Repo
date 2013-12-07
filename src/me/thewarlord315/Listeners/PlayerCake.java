package me.thewarlord315.Listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerCake implements Listener {
	
	 private ArrayList<Player> jumpers = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
	        if (!(e.getAction() == Action.RIGHT_CLICK_AIR)) return;
	       
	        if (!(e.getItem().getType() == Material.CAKE)) return;
	        
	        e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
            jumpers.add(e.getPlayer());
	}
	
	@EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
            if (e.getEntity() instanceof Player) {
                    Player p = (Player) e.getEntity();
                    if (e.getCause() == DamageCause.FALL && jumpers.contains(p)) {
                            e.setDamage(0.0);
                            jumpers.remove(p);
                    }
            }
    }
}
