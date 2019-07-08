package de.piinguiin.lootbox.animations.particle;

import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class PyramidLineEffectAnimation extends ParticleEffectAnimation {

    private final List<LineParticleEffectAnimation> lines;

    public PyramidLineEffectAnimation(final Location center, final EnumParticle enumParticle) {
        this.lines = new ArrayList<>();
        final Location loc = center.clone();
        final LineParticleEffectAnimation l1 = new LineParticleEffectAnimation(loc.clone().add(2, 0, 2),
                10, new Vector(-2, 1.2, -2), 0.1, enumParticle);
        final LineParticleEffectAnimation l2 = new LineParticleEffectAnimation(loc.clone().add(-2, 0, 2),
                10, new Vector(2, 1.2, -2), 0.1, enumParticle);
        final LineParticleEffectAnimation l3 = new LineParticleEffectAnimation(loc.clone().add(-2, 0, -2),
                10, new Vector(2, 1.2, 2), 0.1, enumParticle);
        final LineParticleEffectAnimation l4 = new LineParticleEffectAnimation(loc.clone().add(2, 0, -2),
                10, new Vector(-2, 1.2, 2), 0.1, enumParticle);
        this.lines.add(l1);
        this.lines.add(l2);
        this.lines.add(l3);
        this.lines.add(l4);
    }

    @Override
    public void onUpdate() {

        for (final ParticleEffectAnimation pa : this.lines) {
            pa.onUpdate();
        }

    }
}
