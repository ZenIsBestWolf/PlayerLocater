package me.zenisbestwolf.playerlocater.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import me.zenisbestwolf.playerlocater.Main;

public class LocateCommand implements CommandExecutor {
	private Main plugin;
	
	public LocateCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("whereis").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("playerlocater.locate")) {
			String dimension;
			Player target;
			if (args.length == 0 && sender instanceof Player)
				target = (Player) sender;
			else if (args.length == 0 && !(sender instanceof Player)) {
				sender.sendMessage("Error: Please specify a player.");
				return true;
			}
			else
				target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("Error: Cannot find that player!");
				return true;
			}
			String rawDimension = target.getWorld().getEnvironment().toString();
			if (rawDimension == "NORMAL")
				dimension = "Overworld";
			else if (rawDimension == "NETHER")
				dimension = "Nether";
			else if (rawDimension == "THE_END")
				dimension = "End";
			else
				dimension = "unknown dimension of \"" + rawDimension + "\"";
			sender.sendMessage(target.getDisplayName() + " is in the " + dimension + " dimension at (" + target.getLocation().getBlockX() + ", " + target.getLocation().getBlockY() + ", " + target.getLocation().getBlockZ() + ").");
			return true;
		} else {
			sender.sendMessage("You do not have permission to execute this command.");
		}
		return false;
	}
}
