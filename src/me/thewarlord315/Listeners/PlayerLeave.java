package me.thewarlord315.Listeners;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.ArenaManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

        @EventHandler
        public void onPlayerQuit(PlayerQuitEvent e) {
                Arena a = ArenaManager.getInstance().getArena(e.getPlayer());
                if (a == null) return;
                a.removePlayer(e.getPlayer());
        }
}