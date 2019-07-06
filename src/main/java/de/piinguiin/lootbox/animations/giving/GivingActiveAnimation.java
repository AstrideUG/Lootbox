package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public interface GivingActiveAnimation extends ActiveAnimation {

    @NotNull Entity getTarget();

    @NotNull LootboxPrize getPrize();

}
