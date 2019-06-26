package de.piinguiin.lootbox.api;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class AbstractActiveAnimation extends AbstractLocationable implements ActiveAnimation {

    @SuppressWarnings("WeakerAccess")
    protected int ticks;
    private int taskId;
    @SuppressWarnings("WeakerAccess")
    protected boolean finished;

    public AbstractActiveAnimation(final int ticks) {
        super(null);
        this.ticks = ticks;
    }

    @Override
    public void start(final Location location) {
        currentLocation = location;
        Bukkit.broadcastMessage("Started " + getClass().getSimpleName() + " with location " + location);

        taskId = new BukkitRunnable() {
            @Override
            public void run() {
                if (ticks > 0) {
                    tick();
                    Bukkit.broadcastMessage("ticked " + getClass().getSimpleName() + " on location: " + currentLocation);
                    ticks--;
                } else finish();
            }
        }.runTaskTimer(LootboxPlugin.getPlugin(), 0, 2).getTaskId();
    }

    @Override
    public void finish() {
        Bukkit.broadcastMessage("finished " + getClass().getSimpleName() + " on location: " + currentLocation);
        finished = true;
        Bukkit.getScheduler().cancelTask(taskId);
    }

    @Override
    public final boolean isFinished() {
        return finished;
    }

    @Override
    public int getTicks() {
        return ticks;
    }

}
