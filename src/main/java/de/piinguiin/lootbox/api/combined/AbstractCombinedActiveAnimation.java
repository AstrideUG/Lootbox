package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.api.Animation;
import de.piinguiin.lootbox.api.startable.Startable;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AbstractCombinedActiveAnimation extends AbstractActiveAnimation implements CombinedActiveAnimation {

    private final List<Animation> animations;
    private int currentAnimationPosition;

    public AbstractCombinedActiveAnimation(final List<Animation> animations) {
        super(Integer.MAX_VALUE);
        this.animations = animations;
        this.currentAnimationPosition = -1;
        //    Bukkit.broadcastMessage("init " + getClass().getSimpleName() + " with " + toString());

    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(location);
        startNext(location);
    }

    @Override
    public final void tick() {

        if (currentAnimationPosition < animations.size()) {
            final Animation currentAnimation = animations.get(currentAnimationPosition);
            currentLocation = currentAnimation.getCurrentLocation();
            //    Bukkit.broadcastMessage("bbb");
            if (currentAnimation instanceof ActiveAnimation) {
                //       Bukkit.broadcastMessage("ccc");
                if (((ActiveAnimation) currentAnimation).isFinished()) {
                    startNext(currentLocation);
                    //             Bukkit.broadcastMessage("ddd1");
                } //else Bukkit.broadcastMessage("ddd2");
            } else {
                // Bukkit.broadcastMessage("eee");
                startNext(currentLocation);
            }
        } else finish();
        // Bukkit.broadcastMessage("fff");
    }

    @Override
    public List<Animation> getAnimations() {
        return animations;
    }

    @Override
    public int getCurrentAnimationPosition() {
        return currentAnimationPosition;
    }

    private void startNext(@NotNull final Location location) {
        if (location == null) throw new IllegalArgumentException("location for startNext can not be null");


        this.currentAnimationPosition++;
        //    Bukkit.broadcastMessage("§d§l1");

        final Startable nextAnimation = animations.get(currentAnimationPosition);
        //    Bukkit.broadcastMessage("§enextAnimation for " + getClass().getSimpleName() + " is " + nextAnimation);
        //     Bukkit.broadcastMessage("§d§l2");
        nextAnimation.start(location);
        //   Bukkit.broadcastMessage("§d§l3");
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
