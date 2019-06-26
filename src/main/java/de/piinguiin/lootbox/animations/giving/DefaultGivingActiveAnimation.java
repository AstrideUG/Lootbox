package de.piinguiin.lootbox.animations.giving;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DefaultGivingActiveAnimation extends AbstractGivingAnimation {

    public DefaultGivingActiveAnimation(@Nullable final Location startLocation, @NotNull final Entity target, @NotNull final ItemStack itemStack) {
        super(startLocation, target, itemStack);
    }

    public DefaultGivingActiveAnimation(final Entity target, final ItemStack itemStack) {
        this(null, target, itemStack);
    }

}
