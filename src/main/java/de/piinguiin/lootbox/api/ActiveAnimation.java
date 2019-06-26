package de.piinguiin.lootbox.api;

import de.piinguiin.lootbox.api.finishable.Finishable;
import de.piinguiin.lootbox.api.tickable.Tickable;

public interface ActiveAnimation extends Animation, Finishable, Tickable {
}
