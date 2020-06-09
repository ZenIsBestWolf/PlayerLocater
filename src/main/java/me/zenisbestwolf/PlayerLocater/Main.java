package me.zenisbestwolf.playerlocater;

import org.bukkit.plugin.java.JavaPlugin;
import me.zenisbestwolf.playerlocater.commands.*;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		new LocateCommand(this);
	}
}