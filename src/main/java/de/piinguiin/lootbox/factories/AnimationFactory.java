package de.piinguiin.lootbox.factories;

import de.piinguiin.lootbox.animation.CosmicAnimation;
import de.piinguiin.lootbox.animation.DefaultAnimation;
import de.piinguiin.lootbox.animation.GalacticAnimation;
import de.piinguiin.lootbox.animation.MoonAnimation;
import de.piinguiin.lootbox.api.IAnimation;
import de.piinguiin.lootbox.api.ILootbox;
import de.piinguiin.lootbox.types.CosmicLootbox;
import de.piinguiin.lootbox.types.GalacticLootbox;
import de.piinguiin.lootbox.types.MoonLootbox;

public class AnimationFactory {

    public static IAnimation getAnimationFromLootbox(ILootbox lootbox){

        if(lootbox instanceof MoonLootbox){
            return  new MoonAnimation();
        }

        if(lootbox instanceof GalacticLootbox){
            return  new GalacticAnimation();
        }

        if(lootbox instanceof CosmicLootbox){
            return  new CosmicAnimation();
        }

        return new DefaultAnimation();
    }

}
