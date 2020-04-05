package de.piinguiin.lootbox.animations.delayed;

import de.piinguiin.lootbox.animations.DelayedAnimation;
import de.piinguiin.lootbox.animations.particle.LineParticleEffect;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShootingstarDelayedAnimation extends DelayedAnimation {

    private final List<LineParticleEffect> list;
    private final Random random;

    public ShootingstarDelayedAnimation(final Location location, final boolean allAtOnce) {
        super(location, 3, allAtOnce);
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    @Override
    public void action() {

        final double x = random.nextInt(5) + random.nextDouble();
        final double y = 10;
        final double z = random.nextInt(5) + random.nextDouble();

        final Location b = location.clone().add(x, y, z);

        final LineParticleEffect newLine = new LineParticleEffect(location, b, 0.1, EnumParticle.FLAME);
        this.list.add(newLine);

        if (allAtOnce) {
            for (final LineParticleEffect lineParticleEffect : list) {
                lineParticleEffect.onUpdate();
            }
        }

    }

    @Override
    public void end() {

    }
}
