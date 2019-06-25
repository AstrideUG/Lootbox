package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.animations.falling.DefaultFallingAnimation;
import de.piinguiin.lootbox.api.combined.AbstractCombinedAnimation;

import java.util.Arrays;

public final class MoonCombinedAnimation extends AbstractCombinedAnimation {

    public MoonCombinedAnimation() {
        super(Arrays.asList(new DefaultFallingAnimation()));
    }

}
