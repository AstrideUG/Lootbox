package de.piinguiin.lootbox.types;

import de.piinguiin.lootbox.impl.Lootbox;
import de.piinguiin.lootbox.particle.ParticleEffect;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GalacticLootbox  extends Lootbox {

    public GalacticLootbox(String name, String displayName, String skinUrl, List<ParticleEffect> particleEffects,
                           List<Color> fallingColors, List<LootboxPrize> prizes, int buyPrice, boolean mergable) {
        super(name, displayName, skinUrl, particleEffects, fallingColors, prizes, buyPrice, mergable);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDisplayName() {
        return super.getDisplayName();
    }

    @Override
    public String getSkinURL() {
        return super.getSkinURL();
    }

    @Override
    public ItemStack getHeadItem() {
        return super.getHeadItem();
    }

    @Override
    public List<ParticleEffect> getParticleEffects() {
        return super.getParticleEffects();
    }

    @Override
    public List<Color> getFallingColors() {
        return super.getFallingColors();
    }

    @Override
    public List<LootboxPrize> getPrizes() {
        return super.getPrizes();
    }

    @Override
    public int getBuyingPrice() {
        return super.getBuyingPrice();
    }

    @Override
    public boolean isMergable() {
        return super.isMergable();
    }
}
