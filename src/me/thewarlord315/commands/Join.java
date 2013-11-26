package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.MessageManager;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;
import me.thewarlord315.supersmashcraft.ArenaManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Join extends SuperCommand {

	  public void onCommand(Player p, String[] args) {
          if (ArenaManager.getInstance().getArena(p) != null) {
                  MessageManager.getInstance().msg(p, MessageType.BAD, "You are already in an arena!");
                  return;
          }
          
          if (args.length == 0) {
                  MessageManager.getInstance().msg(p, MessageType.BAD, "You must specify an arena number!");
                  return;
          }
          
          int id = -1;
          
          try { id = Integer.parseInt(args[0]); }
          catch (Exception e) { MessageManager.getInstance().msg(p, MessageType.BAD, args[0] + " is not a number!"); }
          
          Arena a = ArenaManager.getInstance().getArena(id);
          
          if (a == null) {
                  MessageManager.getInstance().msg(p, MessageType.BAD, "That arena doesn't exist!");
                  return;
          }
          
          if (a.getState() == ArenaState.DISABLED || a.getState() == ArenaState.STARTED) {
                  MessageManager.getInstance().msg(p, MessageType.BAD, "That arena is " + a.getState().toString().toLowerCase() + "!");
                  return;
          }
          
          a.addPlayer(p);
          p.sendMessage(ChatColor.AQUA + "You may get your kit by doing /ssc then looking through the commands to look for a character.");
          p.sendMessage(ChatColor.AQUA + "After you have looked through all the characters you may do /ssc <character> !");
  }
  
  public Join() {
          super("Join an arena.", "<id>", "join");
  }
}