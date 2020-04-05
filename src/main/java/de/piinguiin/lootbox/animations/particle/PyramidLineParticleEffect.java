package de.piinguiin.lootbox.animations.particle;

import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class PyramidLineParticleEffect extends ParticleEffect {

    private final List<LineParticleEffect> lines;

    public PyramidLineParticleEffect(final Location center, final EnumParticle enumParticle) {
        this.lines = new ArrayList<>();
        final Location loc = center.clone();
        final LineParticleEffect l1 = new LineParticleEffect(loc.clone().add(2, 0, 2),
                10, new Vector(-2, 1.2, -2), 0.1, enumParticle);
        final LineParticleEffect l2 = new LineParticleEffect(loc.clone().add(-2, 0, 2),
                10, new Vector(2, 1.2, -2), 0.1, enumParticle);
        final LineParticleEffect l3 = new LineParticleEffect(loc.clone().add(-2, 0, -2),
                10, new Vector(2, 1.2, 2), 0.1, enumParticle);
        final LineParticleEffect l4 = new LineParticleEffect(loc.clone().add(2, 0, -2),
                10, new Vector(-2, 1.2, 2), 0.1, enumParticle);
        this.lines.add(l1);
        this.lines.add(l2);
        this.lines.add(l3);
        this.lines.add(l4);
    }

    @Override
    public void onUpdate() {

        for (final ParticleEffect pa : this.lines) {
            pa.onUpdate();
        }

    }
}
