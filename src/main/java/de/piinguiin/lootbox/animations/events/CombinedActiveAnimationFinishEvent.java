package de.piinguiin.lootbox.animations.events;

import de.piinguiin.lootbox.api.combined.CombinedActiveAnimation;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CombinedActiveAnimationFinishEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final CombinedActiveAnimation combinedActiveAnimation;

    public CombinedActiveAnimationFinishEvent(final CombinedActiveAnimation combinedActiveAnimation) {
        this.combinedActiveAnimation = combinedActiveAnimation;
    }

    public CombinedActiveAnimation getCombinedActiveAnimation() {
        return combinedActiveAnimation;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
