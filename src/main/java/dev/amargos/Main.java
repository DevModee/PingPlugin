package dev.amargos;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("ping").setExecutor(new PingCommand());
    }
}