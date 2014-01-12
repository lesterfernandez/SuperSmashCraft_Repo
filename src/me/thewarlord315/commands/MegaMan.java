package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class MegaMan extends SuperCommand {

int id = -1;
	
	Arena a = ArenaManager.getInstance().getArena(id);
	
	public void onCommand(Player p, String[] args) {
		if (ArenaManager.getInstance().getArena(p).getState() == ArenaState.WAITING) {
			//p.getInventory().addItem(new ItemStack(Material.?????))
			
			 ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
	            LeatherArmorMeta mhelmet = (LeatherArmorMeta) helmet.getItemMeta();
				  mhelmet.setColor(Color.BLUE);
				  helmet.setItemMeta(mhelmet);
			
			 ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
	            LeatherArmorMeta mchest = (LeatherArmorMeta) chest.getItemMeta();
				  mchest.setColor(Color.BLUE);
				  chest.setItemMeta(mchest);
			
			 ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
	            LeatherArmorMeta mleg = (LeatherArmorMeta) legs.getItemMeta();
				  mleg.setColor(Color.BLUE);
				  legs.setItemMeta(mleg);
				  
			 ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
	            LeatherArmorMeta meta4 = (LeatherArmorMeta) boots.getItemMeta();
				  meta4.setColor(Color.BLUE);
				  boots.setItemMeta(meta4);
				  p.getInventory().setHelmet(helmet);
				  p.getInventory().setChestplate(chest);
				  p.getInventory().setLeggings(legs);
				  p.getInventory().setBoots(boots);
				  p.setGameMode(GameMode.SURVIVAL);
				  
			return; 
		}
		if (ArenaManager.getInstance().getArena(p).getState() == ArenaState.COUNTING_DOWN) {
			//p.getInventory().addItem(new ItemStack(Material.?????))
			
			 ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
	            LeatherArmorMeta mhelmet = (LeatherArmorMeta) helmet.getItemMeta();
				  mhelmet.setColor(Color.BLUE);
				  helmet.setItemMeta(mhelmet);
			
			 ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
	            LeatherArmorMeta mchest = (LeatherArmorMeta) chest.getItemMeta();
				  mchest.setColor(Color.BLUE);
				  chest.setItemMeta(mchest);
			
			 ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
	            LeatherArmorMeta mleg = (LeatherArmorMeta) legs.getItemMeta();
				  mleg.setColor(Color.BLUE);
				  legs.setItemMeta(mleg);
				  
			 ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
	            LeatherArmorMeta meta4 = (LeatherArmorMeta) boots.getItemMeta();
				  meta4.setColor(Color.BLUE);
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
	public MegaMan() {
        super("Select the MegaMan character!.", "<id>", "Megaman");
	}
	
}
