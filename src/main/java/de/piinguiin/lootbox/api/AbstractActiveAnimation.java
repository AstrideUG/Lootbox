package de.piinguiin.lootbox.api;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractActiveAnimation extends AbstractLocationable implements ActiveAnimation {

    @SuppressWarnings("WeakerAccess")
    protected int ticks, period;
    private int taskId;
    @SuppressWarnings("WeakerAccess")
    protected boolean finished;

    public AbstractActiveAnimation(final int ticks, final int period) {
        this(null, ticks, period);
    }

    public AbstractActiveAnimation(@Nullable final Location startLocation, final int ticks, final int period) {
        super(startLocation);
        this.ticks = ticks;
        this.period = period;
    }

    @Override
    public void start(@NotNull final Location location) {
        currentLocation = location;
        //      Bukkit.broadcastMessage("§5Started " + getClass() + " with location " + location);

        taskId = new BukkitRunnable() {
            @Override
            public void run() {
                //     Bukkit.broadcastMessage("§3§lTicks: " + ticks);
                if (ticks > 0) {
                    tick();
                    //        Bukkit.broadcastMessage("§5§nticked " + AbstractActiveAnimation.this.getClass().getSimpleName() + " on location: " + currentLocation);
                    ticks--;
                } else finish();
            }
        }.runTaskTimer(LootboxPlugin.getPlugin(), 0, period).getTaskId();
    }

    @Override
    public void finish() {
        //   Bukkit.broadcastMessage("§9finished " + getClass().getSimpleName() + " on location: " + currentLocation);

        finished = true;
        //  Bukkit.getScheduler().cancelTask(taskId);
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
