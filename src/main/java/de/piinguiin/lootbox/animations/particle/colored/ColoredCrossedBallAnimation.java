package de.piinguiin.lootbox.animations.particle.colored;

import de.piinguiin.lootbox.animations.particle.AnimatedParticleEffect;
import de.piinguiin.lootbox.utils.particle.colorable.ColoredParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ColoredCrossedBallAnimation extends AnimatedParticleEffect {

    private final Location location;
    private final double maxHeight;
    private final int r;
    private final int g;
    private final int b;
    private final double radius;
    boolean up;
    float height;
    int step;

    public ColoredCrossedBallAnimation(final Location location, final double maxHeight, final double radius, final int r, final int g, final int b) {
        this.location = location;
        this.maxHeight = maxHeight;
        this.r = r;
        this.g = g;
        this.b = b;
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
        ColoredParticle.RED_DUST.send(location.clone().add(v).add(0.0D, (double) this.height, 0.0D), 100, r, g, b);
        this.step += 4;
    }

}
