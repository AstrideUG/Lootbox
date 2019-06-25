package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.api.combined.AbstractCombinedAnimation;

import java.util.Collections;

public class GalacticCombinedAnimation extends AbstractCombinedAnimation {

    public GalacticCombinedAnimation() {
        this(Collections.unmodifiableList(/*falling | explosion | head rotation | give*/));
    }

}