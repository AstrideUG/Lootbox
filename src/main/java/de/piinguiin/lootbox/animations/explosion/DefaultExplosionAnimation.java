package de.piinguiin.lootbox.animations.explosion;

import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;

public class DefaultExplosionAnimation extends AbstractLocationable implements ExplosionAnimation {

    @Override
    public void start(final Location location) {
        //TODO spawn explosion particle
        //  ParticleEffect.LARGE_EXPLODE.display(location, 2000);

        final ParticleBuilder particleBuilder = new ParticleBuilder().setAmount(1).setLocation(location).setSpeed(0)
                .setEnumParticle(EnumParticle.EXPLOSION_LARGE);
        particleBuilder.playAll();
    }

}
