package de.piinguiin.lootbox;

import de.piinguiin.lootbox.animations.listeners.CombinedActiveAnmiationFinish;
import de.piinguiin.lootbox.animations.listeners.PlayerInteractAtHead;
import de.piinguiin.lootbox.io.FileManager;
import de.piinguiin.lootbox.types.LootboxManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class LootboxPlugin extends JavaPlugin {

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
        new PlayerInteractAtHead(this);
        new CombinedActiveAnmiationFinish(this);
        log("finished initialization. ");
    }


    @Override
    public void onDisable() {
        final World world = Bukkit.getWorld("world");
        for (final Entity ents : world.getEntities()) {
            if (ents instanceof ArmorStand) {

                if (ents.getPassenger() != null) {
                    ents.getPassenger().remove();
                }

                ents.remove();
            }
        }
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

    public static void log(final String message) {
        plugin.getLogger().info(message);
    }

    public static void log(final Exception ex) {
        log(ex.getMessage());
    }
}