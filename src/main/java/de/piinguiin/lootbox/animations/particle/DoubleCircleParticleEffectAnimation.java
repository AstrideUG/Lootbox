package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;

public class DoubleCircleParticleEffectAnimation extends ParticleEffectAnimation {

    private final double radius;
    private final EnumParticle particle;
    private int i;
    private final Location location;

    public DoubleCircleParticleEffectAnimation(final Location location, final double radius, final EnumParticle particle) {
        this.radius = radius;
        this.particle = particle;
        this.i = 0;
        this.location = location.clone();
    }

    @Override
    public void onUpdate() {

        final Location particleLocA = this.location.clone();
        final Location particleLocB = this.location.clone();

        i++;
        final double angle = 6.283185307179586D * (double) this.i / 50.0D;
        final double x = Math.cos(angle) * this.radius;
        final double z = Math.sin(angle) * this.radius;

        particleLocA.add(x, 0, z);
        particleLocB.add(-x, 0, -z);
        new ParticleBuilder(particleLocA).setEnumParticle(this.particle).play();
        new ParticleBuilder(particleLocB).setEnumParticle(this.particle).play();

    }
}