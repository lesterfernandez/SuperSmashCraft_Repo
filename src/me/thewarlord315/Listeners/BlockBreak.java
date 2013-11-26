package me.thewarlord315.Listeners;

import me.thewarlord315.supersmashcraft.ArenaManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
        
        @EventHandler
        public void onBlockBreak(BlockBreakEvent e) {
                if (ArenaManager.getInstance().getArena(e.getPlayer()) == null) return;
                e.setCancelled(true);
        }
}