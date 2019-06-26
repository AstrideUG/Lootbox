package de.piinguiin.lootbox.api.combined;

import de.piinguiin.lootbox.api.ActiveAnimation;

import java.util.List;

public interface CombinedActiveAnimation extends ActiveAnimation {

    List<ActiveAnimation> getAnimations();

}
