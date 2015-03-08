package me.MaxCode.PeopleCraftHut;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class PeopleCraftHut extends JavaPlugin {

	
	public static Economy economy = null;
	
	
	
	@Override
	public void onEnable() {
		
		FileChecker fc = new FileChecker();
		fc.checkFiles();
		
		System.out.print("[PeopleCraft-Hut] wurde aktiviert!");
		setupEconomy();
		
		this.getCommand("hut").setExecutor(new Befehle());
		this.getCommand("hutv").setExecutor(new VillagerBefehle());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Event_InvClick(this), this);
		pm.registerEvents(new VillagerManager(), this);
		
	}
	
	
	
	@Override
	public void onDisable() {
		
		
		
	}
	
	
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
	
	
}
