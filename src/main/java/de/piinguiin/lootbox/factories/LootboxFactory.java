package de.piinguiin.lootbox.factories;

import de.piinguiin.lootbox.api.ILootbox;
import de.piinguiin.lootbox.types.MoonLootbox;

public class LootboxFactory {

    public static ILootbox getLootboxFromBSON(){
        return new MoonLootbox();
    }

}
