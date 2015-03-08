package me.MaxCode.PeopleCraftHut;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PCH_setHut {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Hut" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	
	@SuppressWarnings("deprecation")
	public void setHut(Player p, ItemStack huttype) {
		
		
		p.getInventory().setHelmet(huttype);
		p.updateInventory();
		
		String hutname = huttype.getType().toString();
		
		p.sendMessage(str + "Du hast jetzt einen '" + hutname + "' Hut!");
		
		
		
	}
	
	
	
}
