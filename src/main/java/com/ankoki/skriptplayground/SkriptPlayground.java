package com.ankoki.skriptplayground;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SkriptPlayground extends JavaPlugin {

	private SkriptAddon addon;

	@Override
	public void onEnable() {
		this.addon = Skript.registerAddon(this);
		this.registerElements();
	}

	private void registerElements() {
		try {
			addon.loadClasses("com.ankoki.skriptplayground.elements");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
