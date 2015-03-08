package me.MaxCode.PeopleCraftHut;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("deprecation")
public class VillagerManager implements Listener {

	
	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Hut" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	public void VillagerErstellen(Player p) {
		
		Location loc = p.getLocation();
		
		Villager v = (Villager) loc.getWorld().spawnCreature(loc, CreatureType.VILLAGER);
		
		v.setCustomName(ChatColor.GREEN + "" + ChatColor.BOLD + "Hut-Shop");
		v.setCustomNameVisible(true);
		v.setNoDamageTicks(Integer.MAX_VALUE);
		v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 25000, 25000));
		v.setCanPickupItems(false);
		
		
		
		p.sendMessage(str + "Villager wurde erstellt!");
	}
	
	
	
	public void VillagerLoeschen(Player p) {
		
		
		for (Entity ent : p.getNearbyEntities(5, 5, 5)) {
			
			if (ent instanceof Villager) {
			if (((Villager) ent).getCustomName() != null) {
			if (((Villager) ent).getCustomName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Hut-Shop")) {
				
				ent.remove();
			
				p.sendMessage(str + "Villager wurde geloescht!");
			}
			}
			}
			
			
		}
		
	}
	
	
	//Unused
	public int getVillagers() {
		
		File file = new File("plugins/PeopleCraft-Hut/" + "Villager.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int villagers = 0;
		
		for (String v : cfg.getConfigurationSection("Villager.").getKeys(false)) {
			villagers++;
			v.toString();
		}
		
		
		
		return villagers;
	}
	
	
	
	@EventHandler
	public void villagerDE(EntityDeathEvent e){
		
		String name = e.getEntity().getCustomName();
		
		if (name != null) {
		if (name.equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Hut-Shop")) {
			
			e.getEntity().setHealth(20);
			e.getEntity().setNoDamageTicks(Integer.MAX_VALUE);
			
		}
		}
		
		
	}
	
	
	@EventHandler
	public void PI(PlayerInteractEntityEvent e) {
		
		
		Entity en = e.getRightClicked();
		Player p = e.getPlayer();
		
			if (en instanceof Villager) {
			if (((Villager) en).getCustomName().equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Hut-Shop")) {
			
				e.setCancelled(true);
				((Villager) en).setNoDamageTicks(Integer.MAX_VALUE);
				PCH_openHutMenu ohm = new PCH_openHutMenu();
				ohm.openHutMenu(p);
			
			
			
			}
			}
	}
	
	
	
	
}
