package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.api.Animation;
import de.piinguiin.lootbox.api.startable.Startable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.List;

public class AbstractCombinedActiveAnimation extends AbstractActiveAnimation implements CombinedActiveAnimation {

    private final List<Animation> animations;
    private int currentAnimationPosition;

    public AbstractCombinedActiveAnimation(final List<Animation> animations) {
        super(Integer.MAX_VALUE);
        this.animations = animations;
        this.currentAnimationPosition = 0;
        Bukkit.broadcastMessage("init " + getClass().getSimpleName() + " with " + toString());

    }

    @Override
    public void start(final Location location) {
        super.start(location);
        startNext(location);
    }

    @Override
    public final void tick() {
        Bukkit.broadcastMessage(ChatColor.RED + "runned tick in " + getClass().getSimpleName() + "(" + toString() + ")");

        Bukkit.broadcastMessage(ChatColor.GREEN + "is finished" + isFinished());
        Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "animations size" + animations.size());
        Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "currentAnimationPosition" + currentAnimationPosition);
        Bukkit.broadcastMessage(ChatColor.AQUA + "if " + (currentAnimationPosition < animations.size()));

        if (currentAnimationPosition < animations.size()) {
            final Animation currentAnimation = animations.get(currentAnimationPosition);
            Bukkit.broadcastMessage("aaa");
            currentLocation = currentAnimation.getCurrentLocation();
            Bukkit.broadcastMessage("bbb");
            if (currentAnimation instanceof ActiveAnimation) {
                Bukkit.broadcastMessage("ccc");
                if (((ActiveAnimation) currentAnimation).isFinished()) {
                    startNext(currentLocation);
                    Bukkit.broadcastMessage("ddd1");

                    try {
                        Thread.sleep(10000);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                } else Bukkit.broadcastMessage("ddd2");
            } else {
                Bukkit.broadcastMessage("eee");
                startNext(currentLocation);
            }
        } else finish();
        Bukkit.broadcastMessage("fff");
    }

    @Override
    public List<Animation> getAnimations() {
        return animations;
    }

    @Override
    public int getCurrentAnimationPosition() {
        return currentAnimationPosition;
    }

    private void startNext(final Location location) {
        final Startable nextAnimation = animations.get(currentAnimationPosition);
        nextAnimation.start(location);
        this.currentAnimationPosition++;
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
