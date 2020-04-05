package de.piinguiin.lootbox.animations.particle;

import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.Random;

public class ShootingstarParticleEffect extends ParticleEffect {

    private final Location startLocation;
    private final Random random;
    private final int maxRadius;
    private final double height;

    public ShootingstarParticleEffect(final Location startLocation, final int maxRadius, final double height) {
        this.startLocation = startLocation.clone();
        this.random = new Random();
        this.maxRadius = maxRadius;
        this.height = height;
    }

    @Override
    public void onUpdate() {
        final double x = random.nextInt(maxRadius) + random.nextDouble();
        final double z = random.nextInt(maxRadius) + random.nextDouble();

        final Location start = this.startLocation.clone();

        if (random.nextBoolean()) {
            start.add(x, height, z);
        } else {
            start.add(-x, height, -z);
        }

        final Vector dir = start.toVector().subtract(this.startLocation.toVector());
        new LineParticleEffect(this.startLocation, height, dir, 0.1, EnumParticle.FIREWORKS_SPARK).onUpdate();


    }


}
