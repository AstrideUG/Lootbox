package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.Animation;

import java.util.List;

public interface CombinedAnimation extends Animation {

    List<Animation> getAnimations();

}
