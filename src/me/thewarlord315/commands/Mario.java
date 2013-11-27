package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;
import me.thewarlord315.supersmashcraft.ArenaManager;

import org.bukkit.ChatColor;
import org.bukkit.Color;
<<<<<<< HEAD
import org.bukkit.GameMode;
=======
>>>>>>> bf33a1d96a77b946a4c2692bee03369e83f45982
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
<<<<<<< HEAD
				  mhelmet.setColor(Color.RED);
=======
				  mhelmet.setColor(Color.AQUA);
>>>>>>> bf33a1d96a77b946a4c2692bee03369e83f45982
				  helmet.setItemMeta(mhelmet);
			
			 ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
	            LeatherArmorMeta mchest = (LeatherArmorMeta) chest.getItemMeta();
<<<<<<< HEAD
				  mchest.setColor(Color.RED);
=======
				  mchest.setColor(Color.AQUA);
>>>>>>> bf33a1d96a77b946a4c2692bee03369e83f45982
				  chest.setItemMeta(mchest);
			
			 ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
	            LeatherArmorMeta mleg = (LeatherArmorMeta) legs.getItemMeta();
<<<<<<< HEAD
				  mleg.setColor(Color.RED);
=======
				  mleg.setColor(Color.AQUA);
>>>>>>> bf33a1d96a77b946a4c2692bee03369e83f45982
				  legs.setItemMeta(mleg);
				  
			 ItemStack boots = new ItemStack(Material.LEATHER_BOOTS); // defines itemstack	
	            LeatherArmorMeta meta4 = (LeatherArmorMeta) boots.getItemMeta(); //grabs ItemMeta
<<<<<<< HEAD
				  meta4.setColor(Color.RED); // sets color
				  boots.setItemMeta(meta4); //sets itemstack's itemmeta
				  p.getInventory().setHelmet(helmet);
				  p.getInventory().setChestplate(chest);
				  p.getInventory().setLeggings(legs);
				  p.getInventory().setBoots(boots);
				  p.setGameMode(GameMode.SURVIVAL);
=======
				  meta4.setColor(Color.AQUA); // sets color
				  boots.setItemMeta(meta4); //sets itemstack's itemmeta
				  p.getInventory().addItem(helmet);
				  p.getInventory().addItem(chest);
				  p.getInventory().addItem(legs);
				  p.getInventory().addItem(boots);
>>>>>>> bf33a1d96a77b946a4c2692bee03369e83f45982
				  
			return; 
		}
		p.sendMessage(ChatColor.RED + "You must be in a waiting game to choose this character!");
		return;
	}
	public Mario() {
        super("Get the mario kit!.", "<id>", "Mario");
	}
}