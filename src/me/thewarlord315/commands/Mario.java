package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;
import me.thewarlord315.supersmashcraft.ArenaManager;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Mario extends SuperCommand {
	
int id = -1;
	
	Arena a = ArenaManager.getInstance().getArena(id);
	
	public void onCommand(Player p, String[] args) {
		if (ArenaManager.getInstance().getArena(p).getState() == ArenaState.WAITING) {
			p.getInventory().addItem(new ItemStack(Material.FIREBALL));
			
			 ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
	            LeatherArmorMeta mhelmet = (LeatherArmorMeta) helmet.getItemMeta();
				  mhelmet.setColor(Color.RED);
				  mhelmet.setColor(Color.AQUA);
				  helmet.setItemMeta(mhelmet);
			
			 ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
	            LeatherArmorMeta mchest = (LeatherArmorMeta) chest.getItemMeta();
				  mchest.setColor(Color.RED);
				  mchest.setColor(Color.AQUA);
				  chest.setItemMeta(mchest);
			
			 ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
	            LeatherArmorMeta mleg = (LeatherArmorMeta) legs.getItemMeta();
				  mleg.setColor(Color.RED);
				  mleg.setColor(Color.AQUA);
				  legs.setItemMeta(mleg);
				  
			 ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
	            LeatherArmorMeta meta4 = (LeatherArmorMeta) boots.getItemMeta();
				  meta4.setColor(Color.RED);
				  boots.setItemMeta(meta4);
				  p.getInventory().setHelmet(helmet);
				  p.getInventory().setChestplate(chest);
				  p.getInventory().setLeggings(legs);
				  p.getInventory().setBoots(boots);
				  p.setGameMode(GameMode.SURVIVAL);
				  
			return; 
		}
		p.sendMessage(ChatColor.RED + "You must be in a waiting game to choose this character!");
		return;
	}
	public Mario() {
        super("Get the mario kit!.", "<id>", "Mario");
	}
}