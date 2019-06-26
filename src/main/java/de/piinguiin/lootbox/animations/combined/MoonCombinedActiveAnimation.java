package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.animations.explosion.DefaultExplosionAnimation;
import de.piinguiin.lootbox.animations.falling.DefaultFallingActiveAnimation;
import de.piinguiin.lootbox.animations.giving.DefaultGivingActiveAnimation;
import de.piinguiin.lootbox.animations.headspin.DefaultHeadSpinActiveAnimation;
import de.piinguiin.lootbox.api.combined.AbstractCombinedActiveAnimation;
import org.bukkit.Location;

import java.util.Arrays;

public final class MoonCombinedActiveAnimation extends AbstractCombinedActiveAnimation {

    public MoonCombinedActiveAnimation(final Location startLocation) {
        super(Arrays.asList(
                new DefaultFallingActiveAnimation(10, startLocation),
                new DefaultExplosionAnimation(),
                new DefaultHeadSpinActiveAnimation(),
                new DefaultGivingActiveAnimation()
        ));
    }

}
