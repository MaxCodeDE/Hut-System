package me.MaxCode.PeopleCraftHut;

import java.io.File;
import java.io.IOException;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class Event_InvClick implements Listener {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Hut" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	public int  preis = 5000;
	
	@EventHandler
	public void invClick(InventoryClickEvent e) {
		
		
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equals(str)) {
		if (e.getSlotType() != SlotType.OUTSIDE) {
		if (e.getCurrentItem() != null) {                                //TO-DO Geht nicht
		if (e.getCurrentItem() != null) {
		
		ItemStack huttype = e.getCurrentItem();
		
		
		File file = new File("plugins/PeopleCraft-Hut/" + "HutDB.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if(cfg.isSet("HutDB." + p.getName() + "." + huttype.getType().toString())) {
		
		
		
		PCH_setHut sh = new PCH_setHut();
		sh.setHut(p, huttype);
		
		p.closeInventory();
		
		
		} else {
			this.buyHut(p, huttype);
		}
		
		}
		
		}
		}
		}
		}
	
	
		public int getPreis() {
			return preis;
		}
		
		
		public Economy econ;
		@SuppressWarnings("static-access")
		public Event_InvClick(PeopleCraftHut PCH) {
			econ = PCH.economy;
		}
		
		
		
		@SuppressWarnings("deprecation")
		public void buyHut(Player p, ItemStack huttype) {
			
			File file = new File("plugins/PeopleCraft-Hut/" + "HutDB.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
			
			if(econ.has(p.getName(), preis)) {
				econ.withdrawPlayer(p.getName(), preis);
				cfg.set("HutDB." + p.getName() + "." + huttype.getType().toString(), 0);
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				p.sendMessage(str + "Hut wurde gekauft!");
			} else {
				p.sendMessage(str + "Nicht genug bux!");
			}
			p.closeInventory();
			
			
		}
	
	}
	
	
