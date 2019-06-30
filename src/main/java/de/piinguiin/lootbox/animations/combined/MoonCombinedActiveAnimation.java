package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.animations.explosion.DefaultExplosionAnimation;
import de.piinguiin.lootbox.animations.falling.DefaultFallingActiveAnimation;
import de.piinguiin.lootbox.animations.giving.DefaultGivingActiveAnimation;
import de.piinguiin.lootbox.animations.headspin.DefaultHeadSpinActiveAnimation;
import de.piinguiin.lootbox.api.combined.AbstractCombinedActiveAnimation;
import de.piinguiin.lootbox.factories.ItemFactory;
import de.piinguiin.lootbox.utils.item.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public final class MoonCombinedActiveAnimation extends AbstractCombinedActiveAnimation {

    public MoonCombinedActiveAnimation(@NotNull final Location startLocation, final Entity target) {
        super(Arrays.asList(
                new DefaultFallingActiveAnimation(startLocation, 75),
                new DefaultExplosionAnimation(startLocation),
                new DefaultHeadSpinActiveAnimation(startLocation, Objects.requireNonNull(ItemFactory.getAnimationHead("moon"))),
                new DefaultGivingActiveAnimation(startLocation, target, new ItemCreator().material(Material.DOUBLE_PLANT).displayName("§6§lwin").build())));
    }

}
