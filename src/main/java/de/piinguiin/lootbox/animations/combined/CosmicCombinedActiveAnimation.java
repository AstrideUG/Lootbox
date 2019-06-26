package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.api.combined.AbstractCombinedActiveAnimation;

import java.util.Collections;

public class CosmicCombinedActiveAnimation extends AbstractCombinedActiveAnimation {

    public CosmicCombinedActiveAnimation() {
        this(Collections.unmodifiableList(/*falling | explosion | head rotation | give*/));
    }

}