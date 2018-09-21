package me.auto.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.auto.utils.Config;

public class Main extends JavaPlugin{
	
	static Plugin plugin;
	static Logger logger;
	static FileConfiguration conf;
	
	/**
	 * returns the plugin
	 * @return Plugin instance
	 */
	public static Plugin plugin() {
		return plugin;
	}
	
	/**
	 * returns the logger
	 * @return Logger instance
	 */
	public static Logger logger() {
		return logger;
	}
	
	public static FileConfiguration config() {
		return conf;
	}

	/**
	 * tasks to execute on startup
	 */
	public void onEnable() {
		plugin = this;
		logger = Bukkit.getLogger();
		conf = Config.getDefault();
		logger.log(Level.INFO, getName() + " enabled.");
	}
	
	/**
	 * tasks to execute on shutdown
	 */
	@Override
	public void onDisable() {
		logger.log(Level.INFO, getName() + " disabled.");
	}
	
}
