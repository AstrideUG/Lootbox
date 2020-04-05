package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class LineParticleEffect extends ParticleEffect {

    private final Location center;
    private final double length;
    private final Vector direction;
    private final double density;
    private final EnumParticle enumParticle;
    private final Location b;

    public LineParticleEffect(final Location center, final double lenght, final Vector direction,
                              final double density, final EnumParticle enumParticle) {
        this.center = center;
        this.length = lenght;
        this.direction = direction;
        this.density = density;
        this.enumParticle = enumParticle;
        this.b = null;
    }

    public LineParticleEffect(final Location center, final Location b, final double density,
                              final EnumParticle enumParticle) {
        this.center = center;
        this.b = b;
        this.length = calcLength();
        this.direction = b.clone().toVector().subtract(b.toVector());
        this.density = density;
        this.enumParticle = enumParticle;

    }

    private double calcLength() {
        final double l = b.toVector().multiply(center.toVector()).length();
        return l;
    }

    @Override
    public void onUpdate() {

        for (double d = 0.0; d < length; d += density) {
            final Vector v = new Vector(this.direction.getX() * d, this.direction.getY() * d, this.direction.getZ() * d);
            new ParticleBuilder(this.center.clone().add(v), enumParticle).play();
        }

    }
}

