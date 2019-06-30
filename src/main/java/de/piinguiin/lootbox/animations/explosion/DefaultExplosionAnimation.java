package de.piinguiin.lootbox.animations.explosion;

import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class DefaultExplosionAnimation extends AbstractLocationable implements ExplosionAnimation {

    public DefaultExplosionAnimation(@NotNull final Location startLocation) {
        super(startLocation);
    }

    @Override
    public void start(@NotNull final Location location) {
        new ParticleBuilder(currentLocation)
                .setEnumParticle(EnumParticle.EXPLOSION_HUGE)
                .setAmount(2)
                .setSpeed(0)
                .play();
    }


    //MoonFalling -> MoonExplosion -> MoonHeadspin -> MoonGiving
    //GalacticFalling -> GalacticExplosion -> GalacticHeadspin -> GalacticGiving
}
