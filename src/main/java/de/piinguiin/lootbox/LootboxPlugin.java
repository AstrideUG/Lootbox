package de.piinguiin.lootbox;

import de.piinguiin.lootbox.io.FileManager;
import de.piinguiin.lootbox.types.LootboxManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LootboxPlugin  extends JavaPlugin {

    private static LootboxPlugin plugin;
    private static FileManager fileManager;
    private static LootboxManager lootboxManager;

    @Override
    public void onEnable() {
        init();
        log("finished enabling.");
    }

    private void init() {
        plugin = this;
        fileManager = new FileManager();
        lootboxManager = new LootboxManager();
        log("finished initialization.");
    }

    public static LootboxPlugin getPlugin() {
        return plugin;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static LootboxManager getLootboxManager() {
        return lootboxManager;
    }

    private static void log(String message) {
        plugin.getLogger().info(message);
    }

    public static void log(Exception ex) {
        log(ex.getMessage());
    }
}