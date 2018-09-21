package me.auto.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import me.auto.main.Main;

public class Config {
	
	private Config() {
		throw new IllegalStateException("Utility class.");
	}
	
	static Plugin plugin = Main.plugin();
	static String s = "config-version";

	public static FileConfiguration getDefault() {
		File f = new File(plugin.getDataFolder(), "config.yml");
		if(!f.exists()) {
			genDefault(f);
		}
		FileConfiguration fc = new YamlConfiguration();
		try {
			fc.load(f);
		} catch(Exception e) {
			Main.logger().log(Level.SEVERE, "Could not load config.yml.");
		}
		plugin.getLogger().log(Level.INFO, "Loaded config.yml successfully.");
		if(fc.getString(s) != plugin.getDescription().getVersion()) {
			setDefaultOptions(fc, f);
			fc.set(s, plugin.getDescription().getVersion());
			try {
				fc.save(f);
			}catch (Exception e) {}
		}
		return fc;
	}
	
	private static void genDefault(File f) {
		f.getParentFile().mkdirs();
		FileConfiguration fc = new YamlConfiguration();
		try {
			fc.load(f);
		} catch (Exception e) {}
		setDefaultOptions(fc, f);
		try {
			fc.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void setDefaultOptions(FileConfiguration fc, File f) {
		HashMap<String, Object> options = new HashMap<>();
		options.put(s, plugin.getDescription().getVersion());
		for(String s : options.keySet()) {
			if(!fc.contains(s)) {
				fc.set(s, options.get(s));
				Main.logger().log(Level.INFO, () -> "Added default option " + s + " to the default config.");
			}
		}
		try {
			fc.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
