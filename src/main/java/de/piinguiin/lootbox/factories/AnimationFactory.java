package de.piinguiin.lootbox.factories;


import de.piinguiin.lootbox.animations.combined.CosmicCombinedAnimation;
import de.piinguiin.lootbox.animations.combined.GalacticCombinedAnimation;
import de.piinguiin.lootbox.animations.combined.MoonCombinedAnimation;
import de.piinguiin.lootbox.api.Animation;
import de.piinguiin.lootbox.api.Lootbox;
import de.piinguiin.lootbox.types.CosmicLootbox;
import de.piinguiin.lootbox.types.GalacticLootbox;
import de.piinguiin.lootbox.types.MoonLootbox;
import org.jetbrains.annotations.Nullable;

public class AnimationFactory {

    @Nullable
    public static Animation getAnimationFromLootbox(final Lootbox lootbox) {

        if (lootbox instanceof MoonLootbox) {
            return new MoonCombinedAnimation();
        }

        if (lootbox instanceof GalacticLootbox) {
            return new GalacticCombinedAnimation();
        }

        if (lootbox instanceof CosmicLootbox) {
            return new CosmicCombinedAnimation();
        }

        return null;
    }

}
