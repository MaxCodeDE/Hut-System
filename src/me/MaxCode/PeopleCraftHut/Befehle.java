package me.MaxCode.PeopleCraftHut;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Befehle implements CommandExecutor{

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Hut" + ChatColor.DARK_GRAY + "] ";
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		
		if (cmd.getName().equalsIgnoreCase("hut")) {
			
		if (args.length == 0) {
			
			PCH_openHutMenu ohm = new PCH_openHutMenu();
			ohm.openHutMenu(p);
			
		}
			
			
		}
		
		return false;
	}

	
	

	
	
	
	
}
