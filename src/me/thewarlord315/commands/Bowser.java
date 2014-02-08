package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Bowser extends SuperCommand {
	
int id = -1;
	
	Arena a = ArenaManager.getInstance().getArena(id);
	
	public void onCommand(Player p, String[] args) {
		if (ArenaManager.getInstance().getArena(p).getState() == ArenaState.WAITING) {
			p.getInventory().addItem(new ItemStack(Material.WOOD_SWORD));
			p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			p.setGameMode(GameMode.SURVIVAL);
			return; 
		}
		if (ArenaManager.getInstance().getArena(p).getState() == ArenaState.COUNTING_DOWN) {
			p.getInventory().addItem(new ItemStack(Material.WOOD_SWORD));
			p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			p.setGameMode(GameMode.SURVIVAL);
			return; 
		}
		p.sendMessage(ChatColor.RED + "You must be in a waiting game to choose this character!");
		return;
	}
	public Bowser() {
        super("Select the Bowser character!.", "<id>", "Mario");
	}
}