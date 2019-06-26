package de.piinguiin.lootbox.api;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class AbstractActiveAnimation extends AbstractLocationable implements ActiveAnimation {

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
        taskId = new BukkitRunnable() {
            @Override
            public void run() {
                if (ticks > 0) {
                    tick();
                    ticks--;
                } else finish();
            }
        }.runTaskTimer(LootboxPlugin.getPlugin(), 0, 2).getTaskId();
    }

    @Override
    public final void finish() {
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
