package me.MaxCode.PeopleCraftHut;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileChecker {

	public void checkFiles() {
		
		
		File file = new File("plugins/PeopleCraft-Hut/" + "HutDB.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File file2 = new File("plugins/PeopleCraft-Hut/" + "Villager.yml");
		FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		if (!file2.exists()) {
			try {
				cfg2.save(file2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
