package de.piinguiin.lootbox.animations.headspin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

public class TestRun extends BukkitRunnable {

    private final TEST test;

    public TestRun(final Location loc) {
        test = new TEST(1, loc);
        Bukkit.broadcastMessage("tick");
    }

    @Override
    public void run() {
        test.onUpdate();
        Bukkit.broadcastMessage("tick");
    }
}
