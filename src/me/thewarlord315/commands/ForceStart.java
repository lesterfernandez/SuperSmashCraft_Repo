package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.MessageManager;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;

import org.bukkit.entity.Player;

public class ForceStart extends SuperCommand {

	 public void onCommand(Player p, String[] args) {
         if (args.length == 0) {
                 MessageManager.getInstance().msg(p, MessageType.BAD, "You must specify an arena ID.");
                 return;
         }
         
         int id = -1;
         
         try { id = Integer.parseInt(args[0]); }
         catch (Exception e) {
                 MessageManager.getInstance().msg(p, MessageType.BAD, args[0] + " is not a valid number!");
                 return;
         }
         
         Arena a = ArenaManager.getInstance().getArena(id);
         
         if (a == null) {
                 MessageManager.getInstance().msg(p, MessageType.BAD, "There is no arena with ID " + id + "!");
                 return;
         }
         
         if (a.getState() == ArenaState.STARTED) {
                 MessageManager.getInstance().msg(p, MessageType.BAD, "Arena " + id + " has already started!");
                 return;
         }
         
         a.start();
         MessageManager.getInstance().msg(p, MessageType.GOOD, "Force started arena " + a.getID() + "!");
 }
 
 public ForceStart() {
         super("Force start an arena.", "<id>", "start");
 }
}