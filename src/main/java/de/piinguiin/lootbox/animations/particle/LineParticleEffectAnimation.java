package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class LineParticleEffectAnimation extends ParticleEffectAnimation {

    private final Location center;
    private final double lenght;
    private final Vector direction;
    private final double density;
    private final EnumParticle enumParticle;

    public LineParticleEffectAnimation(final Location center, final double lenght, final Vector direction, final double density, final EnumParticle enumParticle) {
        this.center = center;
        this.lenght = lenght;
        this.direction = direction;
        this.density = density;
        this.enumParticle = enumParticle;
    }

    @Override
    public void onUpdate() {

        final double totalLenght = this.lenght * density;

        for (double d = 0.0; d < totalLenght; d += density) {
            final Vector v = new Vector(this.direction.getX() * d, this.direction.getY() * d, this.direction.getZ() * d);
            new ParticleBuilder(this.center.clone().add(v), enumParticle).play();
        }

    }
}

