package de.piinguiin.lootbox.types;

import de.piinguiin.lootbox.animations.combined.MoonCombinedActiveAnimation;
import de.piinguiin.lootbox.api.Lootbox;
import de.piinguiin.lootbox.api.combined.CombinedActiveAnimation;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class MoonLootbox implements Lootbox {

    private final CombinedActiveAnimation combinedActiveAnimation;

    public MoonLootbox(final Location loc, final Entity target) {
        this.combinedActiveAnimation = new MoonCombinedActiveAnimation(loc, target, getRandomPrize());
    }

    @Override
    public CombinedActiveAnimation getCombinedActiveAnimation() {
        return this.combinedActiveAnimation;
    }

    @Override
    public LootboxPrize getRandomPrize() {
        return null;
    }
}
