package de.piinguiin.lootbox.animations.particle;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class CrossedBallParticleEffectAnimation extends ParticleEffectAnimation {

    private final Location location;
    private final double maxHeight;
    private final EnumParticle particle;
    private final double radius;
    boolean up;
    float height;
    int step;

    public CrossedBallParticleEffectAnimation(final Location location, final double maxHeight, final EnumParticle particle, final double radius) {
        this.location = location;
        this.maxHeight = maxHeight;
        this.particle = particle;
        this.radius = radius;
        this.up = true;
        this.height = 0.0F;
        this.step = 0;
    }

    public void onUpdate() {
        if (this.up) {
            if (this.height < maxHeight) {
                this.height = (float) ((double) this.height + 0.05D);
            } else {
                this.up = false;
            }
        } else if (this.height > 0.0F) {
            this.height = (float) ((double) this.height - 0.05D);
        } else {
            this.up = true;
        }

        final double inc = 0.06283185307179587D;
        final double angle = (double) this.step * inc;
        final Vector v = new Vector();
        v.setX(Math.cos(angle) * radius);
        v.setZ(Math.sin(angle) * radius);
        new ParticleBuilder(location.clone().add(v).add(0.0D, (double) this.height, 0.0D))
                .setEnumParticle(particle).play();
        this.step += 4;
    }

}
