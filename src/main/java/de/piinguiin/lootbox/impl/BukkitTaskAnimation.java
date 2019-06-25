package de.piinguiin.lootbox.impl;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.api.Animation;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public abstract class BukkitTaskAnimation implements Animation {

    protected final Location startLocation;
    protected int ticks;
    private BukkitTask task;


    public BukkitTaskAnimation(final int ticks, final Location startLocation) {
        this.ticks = ticks;
        this.startLocation = startLocation.clone();
    }


    @Override
    public final void start(final Location location) {

        task = new BukkitRunnable() {

            @Override
            public void run() {

                if (ticks > 0) {
                    tick();
                    ticks--;
                } else finish();

            }
        }.runTaskTimer(LootboxPlugin.getPlugin(), 0, 5);

    }

    @Override
    public void finish() {
        task.cancel();
    }
}
