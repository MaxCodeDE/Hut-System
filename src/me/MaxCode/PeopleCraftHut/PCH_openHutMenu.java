package me.MaxCode.PeopleCraftHut;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PCH_openHutMenu {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Hut" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	public void openHutMenu(Player p) {
		

		Inventory inv = Bukkit.createInventory(p, 9, str);
		
		ArrayList<String> lore = new ArrayList<String>();
		
		File file = new File("plugins/PeopleCraft-Hut/" + "HutDB.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		ItemStack grass = new ItemStack(Material.GRASS);
		ItemMeta grassmeta = grass.getItemMeta();
		grassmeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► " + "Grass-Hut");
		if(cfg.isSet("HutDB." + p.getName() + "." + grass.getType().toString())) {
			lore.add("");
			lore.add(ChatColor.GRAY + "Klicken zum aufsetzen");
		} else {
			lore.add("");
			lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Kosten: " + ChatColor.GRAY + "5000 Bux");
		}
		grassmeta.setLore(lore);
		lore.clear();
		grass.setItemMeta(grassmeta);
		inv.setItem(0, grass);
		
		
		
		ItemStack dirt = new ItemStack(Material.DIRT);
		ItemMeta dirtmeta = dirt.getItemMeta();
		dirtmeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► " + "Erde-Hut");
		if(cfg.isSet("HutDB." + p.getName() + "." + dirt.getType().toString())) {
			lore.add("");
			lore.add(ChatColor.GRAY + "Klicken zum aufsetzen");
		} else {
			lore.add("");
			lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Kosten: " + ChatColor.GRAY + "5000 Bux");
		}
		dirtmeta.setLore(lore);
		lore.clear();
		dirt.setItemMeta(dirtmeta);
		inv.setItem(1, dirt);
		
		
		
		ItemStack glass = new ItemStack(Material.GLASS);
		ItemMeta glassmeta = glass.getItemMeta();
		glassmeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► " + "Glass-Hut");
		if(cfg.isSet("HutDB." + p.getName() + "." + glass.getType().toString())) {
			lore.add("");
			lore.add(ChatColor.GRAY + "Klicken zum aufsetzen");
		} else {
			lore.add("");
			lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Kosten: " + ChatColor.GRAY + "5000 Bux");
		}
		glassmeta.setLore(lore);
		lore.clear();
		glass.setItemMeta(glassmeta);
		inv.setItem(2, glass);
		
		
		
		ItemStack blatt = new ItemStack(Material.LEAVES);
		ItemMeta blattmeta = blatt.getItemMeta();
		blattmeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► " + "Blatt-Hut");
		if(cfg.isSet("HutDB." + p.getName() + "." + blatt.getType().toString())) {
			lore.add("");
			lore.add(ChatColor.GRAY + "Klicken zum aufsetzen");
		} else {
			lore.add("");
			lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Kosten: " + ChatColor.GRAY + "5000 Bux");
		}
		blattmeta.setLore(lore);
		lore.clear();
		blatt.setItemMeta(blattmeta);
		inv.setItem(3, blatt);
		
		
		
		ItemStack kiste = new ItemStack(Material.CHEST);
		ItemMeta kistemeta = kiste.getItemMeta();
		kistemeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "► " + "Kisten-Hut");
		if(cfg.isSet("HutDB." + p.getName() + "." + kiste.getType().toString())) {
			lore.add("");
			lore.add(ChatColor.GRAY + "Klicken zum aufsetzen");
		} else {
			lore.add("");
			lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "Kosten: " + ChatColor.GRAY + "5000 Bux");
		}
		kistemeta.setLore(lore);
		lore.clear();
		kiste.setItemMeta(kistemeta);
		inv.setItem(4, kiste);
		
		
		
		
		p.openInventory(inv);
	}
	
	
	
	
}
