package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;
import me.thewarlord315.supersmashcraft.ArenaManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Mario extends SuperCommand {
	
	int id = -1;
	
	Arena a = ArenaManager.getInstance().getArena(id);
	
	public void onCommand(Player p, String[] args) {
		if (ArenaManager.getInstance().getArena(p).getState() == ArenaState.WAITING) {
			p.getInventory().addItem(new ItemStack(Material.FIREBALL));
			return; 
		}
		p.sendMessage(ChatColor.RED + "You must be in a waiting game to choose this character!");
		return;
	}
	public Mario() {
        super("Get the mario kit!.", "<id>", "Mario");
	}
}