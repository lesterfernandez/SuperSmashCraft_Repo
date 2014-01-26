package me.thewarlord315.Listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class PlayerBow implements Listener {
	
	@EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow && e.getEntity().getShooter() instanceof Player) {
            e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 1.0f, false);
            return;
        }
    }
}
