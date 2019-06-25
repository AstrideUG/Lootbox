package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.api.combined.AbstractCombinedAnimation;

import java.util.Collections;

public class CosmicCombinedAnimation extends AbstractCombinedAnimation {

    public CosmicCombinedAnimation() {
        this(Collections.unmodifiableList(/*falling | explosion | head rotation | give*/));
    }

}