package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.api.Animation;
import de.piinguiin.lootbox.api.startable.Startable;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AbstractCombinedActiveAnimation extends AbstractActiveAnimation implements CombinedActiveAnimation {

    private final List<Animation> animations;
    private int currentAnimationPosition;
    private final @NotNull Entity target;

    public AbstractCombinedActiveAnimation(final List<Animation> animations, @NotNull final Entity target) {
        super(Integer.MAX_VALUE, 2);
        this.animations = animations;
        this.currentAnimationPosition = -1;
        this.target = target;
    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(location);
        startNext(location);
    }

    @Override
    public final void tick() {

        if (currentAnimationPosition < animations.size() - 1) {
            final Animation currentAnimation = animations.get(currentAnimationPosition);
            currentLocation = currentAnimation.getCurrentLocation();

            if (currentAnimation instanceof ActiveAnimation) {

                if (((ActiveAnimation) currentAnimation).isFinished()) {
                    startNext(currentLocation);
                }
            } else {

                startNext(currentLocation);
            }
        } else finish();

    }

    @Override
    public List<Animation> getAnimations() {
        return animations;
    }

    @Override
    public @NotNull Entity getTarget() {
        return target;
    }

    @Override
    public int getCurrentAnimationPosition() {
        return currentAnimationPosition;
    }

    private void startNext(@NotNull final Location location) {
        if (location == null) throw new IllegalArgumentException("location for startNext can not be null");

        this.currentAnimationPosition++;
        final Startable nextAnimation = animations.get(currentAnimationPosition);
        nextAnimation.start(location);
    }

    @Override
    public String toString() {
        return "AbstractCombinedActiveAnimation{" +
                "animations=" + animations +
                ", currentAnimationPosition=" + currentAnimationPosition +
                ", ticks=" + ticks +
                ", finished=" + finished +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
