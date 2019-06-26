package de.piinguiin.lootbox.factories;


import de.piinguiin.lootbox.animations.combined.CosmicCombinedActiveAnimation;
import de.piinguiin.lootbox.animations.combined.GalacticCombinedActiveAnimation;
import de.piinguiin.lootbox.animations.combined.MoonCombinedActiveAnimation;
import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.api.Lootbox;
import de.piinguiin.lootbox.types.CosmicLootbox;
import de.piinguiin.lootbox.types.GalacticLootbox;
import de.piinguiin.lootbox.types.MoonLootbox;
import org.jetbrains.annotations.Nullable;

public class AnimationFactory {

    @Nullable
    public static ActiveAnimation getAnimationFromLootbox(final Lootbox lootbox) {

        if (lootbox instanceof MoonLootbox) {
            return new MoonCombinedActiveAnimation();
        }

        if (lootbox instanceof GalacticLootbox) {
            return new GalacticCombinedActiveAnimation();
        }

        if (lootbox instanceof CosmicLootbox) {
            return new CosmicCombinedActiveAnimation();
        }

        return null;
    }

}
