package de.piinguiin.lootbox.animations.particle.colored;

import de.piinguiin.lootbox.animations.particle.AnimatedParticleEffect;
import de.piinguiin.lootbox.utils.particle.colorable.ColoredParticle;
import org.bukkit.Location;

public class ColoredDoubleCircleAnimation extends AnimatedParticleEffect {

    private final double radius;
    private int i;
    private final int r;
    private final int g;
    private final int b;
    private final Location location;

    public ColoredDoubleCircleAnimation(final double radius, final int r, final int g, final int b, final Location location) {
        this.radius = radius;
        this.i = 0;
        this.r = r;
        this.g = g;
        this.b = b;
        this.location = location;
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
        ColoredParticle.RED_DUST.send(particleLocA, 100, r, g, b);
        ColoredParticle.RED_DUST.send(particleLocB, 100, r, g, b);

    }
}