package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;

public class SpiralParticleEffectAnimationAnimation extends ParticleEffectAnimation {

    private final Location location;
    private final EnumParticle particle;
    private final double radius;
    private final double height;
    private final double angle;
    private double t;
    private final Dircetion dircetion;
    private final int particleAmount, ySpeed;

    public SpiralParticleEffectAnimationAnimation(final Location location, final EnumParticle particle, final double radius,
                                                  final double height, final double angle, final int particleAmount, final int ySpeed, final Dircetion dircetion) {
        this.location = location;
        this.particle = particle;
        this.radius = radius;
        this.height = height;
        this.t = 0;
        this.dircetion = dircetion;
        this.angle = angle;
        this.particleAmount = particleAmount;
        this.ySpeed = ySpeed;

        if (dircetion.equals(Dircetion.DOWN)) {
            this.location.add(0, height, 0);
        }

    }

    @Override
    public void onUpdate() {

        // V umso höher desto schneller runter
        t += Math.PI / ySpeed;
        final Location loc = this.location.clone();
        //                                                        V umso höher desto mehr particle
        for (double phi = 0; phi <= 2 * Math.PI; phi += Math.PI / particleAmount) {
            final double x = radius * (4 * Math.PI - t) * Math.cos(t + phi);
            final double y = angle * t;
            final double z = radius * (4 * Math.PI - t) * Math.sin(t + phi);

            if (dircetion.equals(Dircetion.UP)) {
                loc.add(x, y, z);
                new ParticleBuilder(loc).setEnumParticle(this.particle).play();
                loc.subtract(x, y, z);
            } else {
                loc.subtract(x, y, z);
                new ParticleBuilder(loc).setEnumParticle(this.particle).play();
                loc.add(x, y, z);
            }

        }

    }

    public static enum Dircetion {

        UP, DOWN

    }
}
