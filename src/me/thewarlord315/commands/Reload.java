package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.MessageManager;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;

import org.bukkit.entity.Player;

public class Reload extends SuperCommand {

    public void onCommand(Player p, String[] args) {
        ArenaManager.getInstance().setupArenas();
        MessageManager.getInstance().msg(p, MessageType.GOOD, "Reloaded arenas!");
    }
    public Reload() {
        super("Reload the arenas.", "", "reload");
    }
}