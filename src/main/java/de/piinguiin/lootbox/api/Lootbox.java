package de.piinguiin.lootbox.api;

import de.piinguiin.lootbox.api.combined.CombinedActiveAnimation;
import de.piinguiin.lootbox.prizes.LootboxPrize;

public interface Lootbox {

    CombinedActiveAnimation getCombinedActiveAnimation();

    LootboxPrize getRandomPrize();

}
