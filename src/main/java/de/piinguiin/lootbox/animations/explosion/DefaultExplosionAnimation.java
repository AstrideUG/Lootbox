package de.piinguiin.lootbox.animations.explosion;

import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import de.piinguiin.lootbox.utils.Utils;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DefaultExplosionAnimation extends AbstractLocationable implements ExplosionAnimation {

    /**
     * simple explosion with knockback
     */

    public DefaultExplosionAnimation(@NotNull final Location startLocation) {
        super(startLocation);
    }

    @Override
    public void start(@NotNull final Location location) {
        new ParticleBuilder(currentLocation)
                .setEnumParticle(EnumParticle.EXPLOSION_HUGE).setAmount(1).play();

        for (final Player near : Utils.getNear(currentLocation, 3.5)) {
            near.setVelocity(near.getLocation().getDirection().multiply(-1).setY(0.4));
            near.playSound(currentLocation, Sound.EXPLODE, 1, 0.8F);

        }

    }

}
