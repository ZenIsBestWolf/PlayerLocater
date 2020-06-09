package me.zenisbestwolf.PlayerLocater;

import org.bukkit.plugin.java.JavaPlugin;

import me.zenisbestwolf.PlayerLocater.commands.LocateCommand;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		new LocateCommand(this);
	}
}