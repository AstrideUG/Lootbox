package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.api.startable.Startable;
import org.bukkit.Location;

import java.util.List;

public abstract class AbstractCombinedActiveAnimation extends AbstractActiveAnimation implements CombinedActiveAnimation {

    private final List<ActiveAnimation> animations;
    private int currentAnimationPosition;

    public AbstractCombinedActiveAnimation(final List<ActiveAnimation> animations) {
        super(Integer.MAX_VALUE);
        this.animations = animations;
        this.currentAnimationPosition = 0;
    }

    @Override
    public final void tick() {
        if (currentAnimationPosition < animations.size()) {
            final ActiveAnimation currentAnimation = animations.get(currentAnimationPosition);
            if (currentAnimation.isFinished()) {
                currentLocation = currentAnimation.getCurrentLocation();
                startNext(currentLocation);
            }
        } else finish();
    }

    @Override
    public List<ActiveAnimation> getAnimations() {
        return animations;
    }

    private void startNext(final Location location) {
        final Startable nextAnimation = animations.get(currentAnimationPosition);
        nextAnimation.start(location);
        this.currentAnimationPosition++;
    }


}
