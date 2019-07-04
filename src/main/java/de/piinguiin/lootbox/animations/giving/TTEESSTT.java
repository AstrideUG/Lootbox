package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class TTEESSTT {
    boolean up;
    float height;
    int step;


    public void onUpdate(final Entity p) {
        if (this.up) {
            if (this.height < 2.0F) {
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
        v.setX(Math.cos(angle) * 1.1D);
        v.setZ(Math.sin(angle) * 1.1D);
        //Particle.sendParticleOnLocation(p.getLocation().clone().add(v).add(0.0D, (double)this.height, 0.0D), EnumParticle.SPELL_WITCH, 0, 1);
        new ParticleBuilder(p.getLocation().clone().add(v).add(0.0D, (double) this.height, 0.0D)).setEnumParticle(EnumParticle.VILLAGER_HAPPY).play();
        this.step += 4;
    }
}
