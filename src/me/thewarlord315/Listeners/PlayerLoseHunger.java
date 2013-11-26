package me.thewarlord315.Listeners;

import me.thewarlord315.supersmashcraft.ArenaManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerLoseHunger implements Listener {

        @EventHandler
        public void onPlayerLoseHunger(FoodLevelChangeEvent e) {
                if (!(e.getEntity() instanceof Player)) return;
                if (ArenaManager.getInstance().getArena(((Player) e.getEntity())) != null) e.setCancelled(true);
        }
}