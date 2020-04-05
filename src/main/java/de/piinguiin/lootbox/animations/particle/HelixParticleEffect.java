package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;

public class HelixParticleEffect extends ParticleEffect {

    private final double hight;
    private final double subtract;
    private final double radius;
    private final EnumParticle particle;
    private int i;
    private final Location location;

    public HelixParticleEffect(final Location center,
                               final double hight, final double subtract, final double radius, final EnumParticle particle) {
        this.hight = hight;
        this.subtract = subtract;
        this.radius = radius;
        this.particle = particle;
        this.i = 0;
        this.location = center.clone().add(0, hight, 0);
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
        this.location.subtract(0, this.subtract, 0);

    }
}
