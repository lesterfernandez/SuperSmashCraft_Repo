package me.thewarlord315.Listeners;

import java.util.ArrayList;
import java.util.HashMap;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.LocationUtil;
import me.thewarlord315.supersmashcraft.MessageManager;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;
import me.thewarlord315.supersmashcraft.SettingsManager;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignManager implements Listener {
	
	 private static HashMap<Sign, Integer> signs = new HashMap<Sign, Integer>();
     
     public SignManager() {
                 
                 if (SettingsManager.getLobbySigns().<ConfigurationSection>get("signs") == null) SettingsManager.getLobbySigns().createConfigurationSection("signs");
                 
                 for (String str : SettingsManager.getLobbySigns().<ConfigurationSection>get("signs").getKeys(true)) {
                         ConfigurationSection section = SettingsManager.getLobbySigns().get("signs." + str);
                         
                         Location loc = LocationUtil.locationFromConfig(section.getConfigurationSection("location"), false);
                         Sign s = (Sign) loc.getBlock().getState();
                         
                         signs.put(s, section.getInt("arenaNumber"));
                 }
         }
         
         public static ArrayList<Sign> getSigns(Arena a) {
                 ArrayList<Sign> s = new ArrayList<Sign>();
                 
                 for (Sign sign : signs.keySet()) {
                         if (ArenaManager.getInstance().getArena(signs.get(sign)) == a) s.add(sign);
                 }
                 
                 return s;
         }
         
         @EventHandler
         public void onSignChange(SignChangeEvent e) {
                 if (e.getLine(0).equalsIgnoreCase("[ssc]")) {
                         int id;
                         try { id = Integer.parseInt(e.getLine(1)); }
                         catch (Exception ex) { MessageManager.getInstance().msg(e.getPlayer(), MessageType.BAD, "That is not a valid arena number!"); return; }
                         
                         Arena a = ArenaManager.getInstance().getArena(id);
                         if (a == null) {
                                 MessageManager.getInstance().msg(e.getPlayer(), MessageType.BAD, "That is not a valid arena!");
                                 return;
                         }
                         
                         ConfigurationSection section = SettingsManager.getLobbySigns().createConfigurationSection("signs." + SettingsManager.getLobbySigns().<ConfigurationSection>get("signs").getKeys(true).size() + 1);
                         
                         ConfigurationSection location = section.createSection("location");
                         location.set("world", e.getBlock().getLocation().getWorld().getName());
                         location.set("x", e.getBlock().getLocation().getX());
                         location.set("y", e.getBlock().getLocation().getY());
                         location.set("z", e.getBlock().getLocation().getZ());
                         
                         section.set("arenaNumber", id);
                         
                         signs.put((Sign) e.getBlock().getState(), a.getID());
                         
                         e.setLine(2, a.getCurrentPlayers() + " Players");
                         e.setLine(3, a.getState().toString());
                 }
         }
         
         @EventHandler
         public void onPlayerInteract(PlayerInteractEvent e) {
                 if (!(e.getAction() == Action.RIGHT_CLICK_AIR) && !(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;

         if (e.getClickedBlock() == null || e.getClickedBlock().getState() == null) return;

                 if (e.getClickedBlock().getState() instanceof Sign) {
                         Sign s = (Sign) e.getClickedBlock().getState();
                         if (s.getLine(0).equalsIgnoreCase("[ssc]")) {
                                 ArenaManager.getInstance().getArena(Integer.parseInt(s.getLine(1))).addPlayer(e.getPlayer());
                         }
                 }
         }
 }