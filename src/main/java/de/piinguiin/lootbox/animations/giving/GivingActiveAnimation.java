package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.api.ActiveAnimation;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface GivingActiveAnimation extends ActiveAnimation {

    @NotNull Entity getTarget();

    @NotNull ItemStack getItemStack();

}
