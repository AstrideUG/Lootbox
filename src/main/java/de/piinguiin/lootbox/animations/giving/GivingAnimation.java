package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.api.Animation;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface GivingAnimation extends Animation {

    @NotNull Entity getTarget();

    @NotNull ItemStack getItemStack();

}
