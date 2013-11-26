package me.thewarlord315.supersmashcraft;

import java.io.File;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class SettingsManager {
	
	private static SettingsManager arenas = new SettingsManager("arenas");
    private static SettingsManager lobbySigns = new SettingsManager("lobbysigns");
    
    public static SettingsManager getArenas() {
            return arenas;
    }
    
    public static SettingsManager getLobbySigns() {
            return lobbySigns;
    }
    
    /*****/
    
    private SettingsManager(String fileName) {
            System.out.println(SuperSmashCraft.getPlugin());
            
            if (!SuperSmashCraft.getPlugin().getDataFolder().exists()) SuperSmashCraft.getPlugin().getDataFolder().mkdir();
            
            file = new File(SuperSmashCraft.getPlugin().getDataFolder(), fileName + ".yml");
            
            if (!file.exists()) {
                    try { file.createNewFile(); }
                    catch (Exception e) { e.printStackTrace(); }
            }
            
            config = YamlConfiguration.loadConfiguration(file);
    }
    
    private File file;
    private FileConfiguration config;
    
    public void set(String path, Object value) {
            config.set(path, value);
            try { config.save(file); }
            catch (Exception e) { e.printStackTrace(); }
    }
    
    public ConfigurationSection createConfigurationSection(String path) {
            ConfigurationSection cs = config.createSection(path);
            try { config.save(file); }
            catch (Exception e) { e.printStackTrace(); }
            return cs;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T get(String path) {
            return (T) config.get(path);
    }
}