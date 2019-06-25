package de.piinguiin.lootbox;

import org.bukkit.plugin.java.JavaPlugin;

public class Lootbox extends JavaPlugin {

    private static Lootbox plugin;

    @Override
    public void onEnable() {
        init();
        log("finished enabling.");
    }

    private void init(){
        plugin = this;
        log("finished initialization.");
    }

    public static Lootbox getPlugin() {
        return plugin;
    }

    private static void log(String message){
        plugin.getLogger().info(message);
    }

    public static void log(Exception ex){
        log(ex.getMessage());
    }

}
