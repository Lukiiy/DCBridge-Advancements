package me.lukiiy.DCBAchiev;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DCBAdvancement extends JavaPlugin {
    @Getter private static DCBAdvancement instance;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        instance = this;
        setupConfig();

        getCommand("dcbadvancements").setExecutor(new ReloadCMD());
        getServer().getPluginManager().registerEvents(new Listen(), this);
    }

    @Override
    public void onDisable() {}

    // Config
    public void setupConfig() {
        saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }

    public static String confString(String path) {return instance.config.getString(path);}
}
