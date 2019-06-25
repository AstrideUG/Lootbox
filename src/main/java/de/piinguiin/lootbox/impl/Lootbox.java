package de.piinguiin.lootbox.impl;

import de.piinguiin.lootbox.api.ILootbox;
import de.piinguiin.lootbox.particle.ParticleEffect;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import de.piinguiin.lootbox.utils.item.SkullMaker;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class Lootbox implements ILootbox {

    String name,displayName,skinUrl;
    List<ParticleEffect> particleEffects;
    List<Color> fallingColors;
    List<LootboxPrize> prizes;
    ItemStack head;
    int buyPrice;
    boolean mergable;

    public Lootbox(String name, String displayName, String skinUrl, List<ParticleEffect> particleEffects,
                   List<Color> fallingColors, List<LootboxPrize> prizes, int buyPrice, boolean mergable) {
        this.name = name;
        this.displayName = displayName;
        this.skinUrl = skinUrl;
        this.particleEffects = particleEffects;
        this.fallingColors = fallingColors;
        this.prizes = prizes;
        this.buyPrice = buyPrice;
        this.mergable = mergable;
        buildHeadItem();
    }

    private void buildHeadItem(){
        ItemStack head = new SkullMaker().withName(this.displayName).withSkinUrl(this.skinUrl).build();
        this.head = head;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getSkinURL() {
        return skinUrl;
    }

    @Override
    public ItemStack getHeadItem() {
        return head;
    }

    @Override
    public List<ParticleEffect> getParticleEffects() {
        return particleEffects;
    }

    @Override
    public List<Color> getFallingColors() {
        return fallingColors;
    }

    @Override
    public List<LootboxPrize> getPrizes() {
        return prizes;
    }

    @Override
    public int getBuyingPrice() {
        return buyPrice;
    }

    @Override
    public boolean isMergable() {
        return mergable;
    }
}
