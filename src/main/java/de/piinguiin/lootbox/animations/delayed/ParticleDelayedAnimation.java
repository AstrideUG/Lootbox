package de.piinguiin.lootbox.animations.delayed;

import de.piinguiin.lootbox.animations.DelayedAnimation;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import org.bukkit.Location;

public class ParticleDelayedAnimation extends DelayedAnimation {

    private final ParticleBuilder particleBuilder;

    public ParticleDelayedAnimation(final Location location, final int periode, final boolean allAtOnce, final ParticleBuilder particleBuilder) {
        super(location, periode, allAtOnce);
        this.particleBuilder = particleBuilder;
    }

    @Override
    public void action() {
        this.particleBuilder.play();
    }

    @Override
    public void end() {

    }
}
