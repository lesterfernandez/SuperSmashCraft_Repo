package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.MessageManager;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;

import org.bukkit.entity.Player;

public class Leave extends SuperCommand {
	
	public void onCommand(Player p, String[] args) {
        if (ArenaManager.getInstance().getArena(p) == null) {
                MessageManager.getInstance().msg(p, MessageType.BAD, "You are not already in an arena!");
                return;
        }
        
        ArenaManager.getInstance().getArena(p).removePlayer(p);
	}
	public Leave() {
        super("Leave an arena.", "", "leave");
	}
}