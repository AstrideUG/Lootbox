package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.AbstractAnimation;
import de.piinguiin.lootbox.api.Animation;
import org.bukkit.Location;

import java.util.List;

public abstract class AbstractCombinedAnimation extends AbstractAnimation implements CombinedAnimation {

    private final List<Animation> animations;
    private int currentAnimationPosition;

    public AbstractCombinedAnimation(final List<Animation> animations) {
        this.animations = animations;
        this.currentAnimationPosition = 0;
    }

    @Override
    public final void start(final Location location) {
        startNext(location);
    }

    @Override
    public final void tick() {
        if (currentAnimationPosition < animations.size()) {
            final Animation currentAnimation = animations.get(currentAnimationPosition);
            if (currentAnimation.isFinished()) {
                currentLocation = currentAnimation.getCurrentLocation();
                startNext(currentLocation);
            }
        } else finish();
    }

    @Override
    public final List<Animation> getAnimations() {
        return animations;
    }

    private void startNext(final Location location) {
        final Animation nextAnimation = animations.get(currentAnimationPosition);
        nextAnimation.start(location);
        this.currentAnimationPosition++;
    }


}
