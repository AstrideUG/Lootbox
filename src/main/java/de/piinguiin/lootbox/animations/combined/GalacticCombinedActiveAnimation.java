package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.api.combined.AbstractCombinedActiveAnimation;

import java.util.Collections;

public class GalacticCombinedActiveAnimation extends AbstractCombinedActiveAnimation {

    public GalacticCombinedActiveAnimation() {
        this(Collections.unmodifiableList(/*falling | explosion | head rotation | give*/));
    }

}