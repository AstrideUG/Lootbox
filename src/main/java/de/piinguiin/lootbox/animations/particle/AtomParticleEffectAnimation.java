package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.VectorUtils;
import de.piinguiin.lootbox.utils.particle.colorable.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class AtomParticleEffectAnimation extends ParticleEffectAnimation {

    private final double radius;

    private final int particlesOrbital;

    private final int orbitals;

    private final double rotation;

    private final double angularVelocity = 0.039269908169872414D;

    private int step = 0;

    private final Location location;

    public AtomParticleEffectAnimation(final Location center) {
        this.location = center.clone();
        this.radius = 3.0D;
        this.particlesOrbital = 10;
        this.orbitals = 3;
        this.rotation = 0.0D;
    }

    public AtomParticleEffectAnimation(final double radius, final int particlesOrbital, final int orbitals,
                                       final double rotation, final Location location) {
        this.radius = radius;
        this.particlesOrbital = particlesOrbital;
        this.orbitals = orbitals;
        this.rotation = rotation;
        this.location = location.clone();
    }

    @Override
    public void onUpdate() {
        final Location location = this.location;
        for (int i = 0; i < this.particlesOrbital; i++) {
            final double angle = this.step * this.angularVelocity;
            for (int j = 0; j < this.orbitals; j++) {
                final double xRotation = Math.PI / this.orbitals * j;
                final Vector v = (new Vector(Math.cos(angle), Math.sin(angle), 0.0D)).multiply(this.radius);
                VectorUtils.rotateAroundAxisX(v, xRotation);
                VectorUtils.rotateAroundAxisY(v, this.rotation);
                location.add(v);
                ParticleEffect.DRIP_LAVA.display(0, 0, 0, 0, 1, location, 100);
                location.subtract(v);
            }
            this.step++;
        }
    }
}
