package de.piinguiin.lootbox;

import org.bukkit.plugin.java.JavaPlugin;

public class LootboxPlugin  extends JavaPlugin {

    private static LootboxPlugin plugin;

    @Override
    public void onEnable() {
        init();
        log("finished enabling.");
    }

    private void init() {
        plugin = this;
        log("finished initialization.");
    }

    public static LootboxPlugin getPlugin() {
        return plugin;
    }

    private static void log(String message) {
        plugin.getLogger().info(message);
    }

    public static void log(Exception ex) {
        log(ex.getMessage());
    }
}