package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.colorable.ColoredParticle;
import org.bukkit.Location;

public class RainbowDoubleCircleAnimation extends AnimatedParticleEffect {

    private final double radius;
    private int i;
    private final Location location;

    public RainbowDoubleCircleAnimation(final Location location, final double radius) {
        this.radius = radius;
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
        ColoredParticle.RED_DUST.sendRandomColor(particleLocA);
        ColoredParticle.RED_DUST.sendRandomColor(particleLocB);

    }
}