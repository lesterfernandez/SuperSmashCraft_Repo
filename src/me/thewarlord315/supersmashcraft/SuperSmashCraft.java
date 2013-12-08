package me.thewarlord315.supersmashcraft;

import me.thewarlord315.Listeners.BlockBreak;
import me.thewarlord315.Listeners.PlayerCake;
import me.thewarlord315.Listeners.PlayerDeath;
import me.thewarlord315.Listeners.PlayerFireball;
import me.thewarlord315.Listeners.PlayerLeave;
import me.thewarlord315.Listeners.PlayerLoseHunger;
import me.thewarlord315.Listeners.SignManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperSmashCraft extends JavaPlugin {
	
	public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new SignManager(), this);
        
        ArenaManager.getInstance().setupArenas();
        
        CommandManager cm = new CommandManager();
        cm.setup();
        getCommand("supersmashcraft").setExecutor(cm);
        
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new PlayerDeath(), this);
        pm.registerEvents(new PlayerLeave(), this);
        pm.registerEvents(new PlayerLoseHunger(), this);
        pm.registerEvents(new PlayerFireball(), this);
        pm.registerEvents(new PlayerCake(), this);
	}
	public static Plugin getPlugin() {
        return Bukkit.getServer().getPluginManager().getPlugin("SuperSmashCraft");
	}
}