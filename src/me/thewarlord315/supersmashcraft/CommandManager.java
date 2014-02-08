package me.thewarlord315.supersmashcraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import me.thewarlord315.commands.Bowser;
import me.thewarlord315.commands.Create;
import me.thewarlord315.commands.Delete;
import me.thewarlord315.commands.ForceStart;
import me.thewarlord315.commands.ForceStop;
import me.thewarlord315.commands.Join;
import me.thewarlord315.commands.Kirby;
import me.thewarlord315.commands.Leave;
import me.thewarlord315.commands.Mario;
import me.thewarlord315.commands.MegaMan;
import me.thewarlord315.commands.Reload;
import me.thewarlord315.commands.SetLocation;
import me.thewarlord315.commands.SuperCommand;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {
	
	private ArrayList<SuperCommand> cmds = new ArrayList<SuperCommand>();
    
    public void setup() {
            cmds.add(new Create());
            cmds.add(new Delete());
            cmds.add(new ForceStart());
            cmds.add(new ForceStop());
            cmds.add(new Join());
            cmds.add(new Leave());
            cmds.add(new Reload());
            cmds.add(new SetLocation());
            cmds.add(new Mario());
            cmds.add(new Kirby());
            cmds.add(new MegaMan());
            cmds.add(new Bowser());
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
            if (!(sender instanceof Player)) {
                    MessageManager.getInstance().msg(sender, MessageType.BAD, "Only players can use SuperSmashCraft!");
                    return true;
            }
            
            Player p = (Player) sender;
            
            if (cmd.getName().equalsIgnoreCase("supersmashcraft")) {
                    if (args.length == 0) {
                            for (SuperCommand mc : cmds) MessageManager.getInstance().msg(p, MessageType.INFO, "/ssc " + aliases(mc) + " " + mc.getUsage() + " - " + mc.getMessage());
                            return true;
                    }
                    
                    SuperCommand c = getCommand(args[0]);
                    
                    if (c == null) {
                            MessageManager.getInstance().msg(sender, MessageType.BAD, "That command doesn't exist!");
                            return true;
                    }
                    
                    Vector<String> a = new Vector<String>(Arrays.asList(args));
                    a.remove(0);
                    args = a.toArray(new String[a.size()]);
                    
                    c.onCommand(p, args);
                    
                    return true;
            }
            return true;
    }
    
    private String aliases(SuperCommand cmd) {
            String fin = "";
            
            for (String a : cmd.getAliases()) {
                    fin += a + " | ";
            }
            
            return fin.substring(0, fin.lastIndexOf(" | "));
    }
    
    private SuperCommand getCommand(String name) {
            for (SuperCommand cmd : cmds) {
                    if (cmd.getClass().getSimpleName().equalsIgnoreCase(name)) return cmd;
                    for (String alias : cmd.getAliases()) if (name.equalsIgnoreCase(alias)) return cmd;
            }
            return null;
    }
}