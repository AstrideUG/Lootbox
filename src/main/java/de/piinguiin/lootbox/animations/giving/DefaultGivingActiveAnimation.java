package de.piinguiin.lootbox.animations.giving;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DefaultGivingActiveAnimation extends AbstractGivingAnimation {

    public DefaultGivingActiveAnimation(@NotNull final Location startLocation, @NotNull final Entity target, @NotNull final ItemStack itemStack) {
        super(startLocation, target, itemStack);
    }

}
