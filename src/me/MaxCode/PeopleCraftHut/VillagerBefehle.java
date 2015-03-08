package me.MaxCode.PeopleCraftHut;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VillagerBefehle implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("hutv")) {
		if (p.isOp()) {
		
			
		if (args.length == 1) {
		if (args[0].equalsIgnoreCase("erstellen")) {
		if (p.isOp()) {
			VillagerManager vm = new VillagerManager();
			vm.VillagerErstellen(p);
		}
		}
		}
		
		
		if (args.length == 1) {
		if (args[0].equalsIgnoreCase("loeschen")) {
		if (p.isOp()) {
			VillagerManager vm = new VillagerManager();
			vm.VillagerLoeschen(p);
		}
		}
		}
		
			
			
		}
		}
		
		
		
		
		return false;
	}

}
