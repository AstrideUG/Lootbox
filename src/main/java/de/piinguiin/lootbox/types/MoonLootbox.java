package de.piinguiin.lootbox.types;

import de.piinguiin.lootbox.impl.Lootbox;
import de.piinguiin.lootbox.particle.ParticleEffect;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MoonLootbox extends Lootbox {

    public MoonLootbox(String id, String displayName, String skinUrl, List<ParticleEffect> particleEffects,
                       List<Color> fallingColors, List<LootboxPrize> prizes, int buyPrice, boolean mergable) {
        super(id, displayName, skinUrl, particleEffects, fallingColors, prizes, buyPrice, mergable);
    }

}
