package de.piinguiin.lootbox.api;

import de.piinguiin.lootbox.particle.ParticleEffect;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ILootbox {

    String getName();

    String getDisplayName();

    String getSkinURL();

    ItemStack getHeadItem();

    List<ParticleEffect> getParticleEffects();

    List<Color> getFallingColors();

    List<LootboxPrize> getPrizes();

    int getBuyingPrice();

    boolean isMergable();
}
