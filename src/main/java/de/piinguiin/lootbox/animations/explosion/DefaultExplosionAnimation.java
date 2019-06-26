package de.piinguiin.lootbox.animations.explosion;

import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import org.bukkit.Location;

public class DefaultExplosionAnimation extends AbstractLocationable implements ExplosionAnimation {

    @Override
    public void start(final Location location) {
        //TODO spawn explosion particle
        //  ParticleEffect.LARGE_EXPLODE.display(location, 2000);
    }

}
