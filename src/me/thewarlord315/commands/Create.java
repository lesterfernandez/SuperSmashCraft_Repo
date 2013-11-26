package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.MessageManager;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;
import me.thewarlord315.supersmashcraft.SettingsManager;

import org.bukkit.entity.Player;

public class Create extends SuperCommand {

	 public void onCommand(Player p, String[] args) {
         int id = ArenaManager.getInstance().getArenas().size() + 1;
         
         SettingsManager.getArenas().createConfigurationSection("arenas." + id);
         SettingsManager.getArenas().set("arenas." + id + ".numPlayers", 10);
         
         MessageManager.getInstance().msg(p, MessageType.GOOD, "Created Arena " + id + "!");
         
         ArenaManager.getInstance().setupArenas();
 }
 
 public Create() {
         super("Create an arena, ", "", "create");
 }
}