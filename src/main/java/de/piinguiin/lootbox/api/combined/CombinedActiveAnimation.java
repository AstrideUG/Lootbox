package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.api.Animation;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface CombinedActiveAnimation extends ActiveAnimation {

    List<Animation> getAnimations();

    int getCurrentAnimationPosition();

    @NotNull Entity getTarget();

}
