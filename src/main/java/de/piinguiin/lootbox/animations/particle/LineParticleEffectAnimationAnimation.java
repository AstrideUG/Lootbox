package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.colorable.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class LineParticleEffectAnimationAnimation extends ParticleEffectAnimation {

    private final Location center;
    private final double lenght;
    private final Vector direction;
    private final double density;

    public LineParticleEffectAnimationAnimation(final Location center, final double lenght, final Vector direction, final double density) {
        this.center = center;
        this.lenght = lenght;
        this.direction = direction;
        this.density = density;
    }

    @Override
    public void onUpdate() {

        final double totalLenght = this.lenght * density;

        for (double d = 0.0; d < totalLenght; d += density) {
            final Vector v = new Vector(this.direction.getX() * d, this.direction.getY() * d, this.direction.getZ() * d);
            ParticleEffect.REDSTONE.display(0, 0, 0, 0, 1, this.center.clone().add(v), 100);
        }

    }
}

