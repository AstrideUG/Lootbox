package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class DefaultGivingAbstractActiveAnimation extends AbstractGivingActiveAnimation {


    public DefaultGivingAbstractActiveAnimation(@NotNull final Location startLocation,
                                                final int ticks, @NotNull final Entity target, @NotNull final LootboxPrize prize) {
        super(startLocation, ticks, target, prize);
    }

    @Override
    public void start(@NotNull final Location location) throws IllegalStateException {
        super.start(location);
    }

    @Override
    public void tick() {
    }

    @Override
    public void finish() {
        super.finish();
    }
}
