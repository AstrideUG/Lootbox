package de.piinguiin.lootbox.impl;

import de.piinguiin.lootbox.api.ActiveAnimation;
import de.piinguiin.lootbox.factories.AnimationFactory;
import de.piinguiin.lootbox.particle.ParticleEffect;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import de.piinguiin.lootbox.utils.item.SkullMaker;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Lootbox implements de.piinguiin.lootbox.api.Lootbox {

    private final String id;
    private final String displayName;
    private final String skinUrl;
    private final List<ParticleEffect> particleEffects;
    private final List<Color> fallingColors;
    private final List<LootboxPrize> prizes;
    private ItemStack head;
    private final int buyPrice;
    private final boolean mergable;

    public Lootbox(final String id, final String displayName, final String skinUrl, final List<ParticleEffect> particleEffects,
                   final List<Color> fallingColors, final List<LootboxPrize> prizes, final int buyPrice, final boolean mergable) {
        this.id = id;
        this.displayName = displayName;
        this.skinUrl = skinUrl;
        this.particleEffects = particleEffects;
        this.fallingColors = fallingColors;
        this.prizes = prizes;
        this.buyPrice = buyPrice;
        this.mergable = mergable;
        buildHeadItem();
    }

    private void buildHeadItem() {
        final ItemStack head = new SkullMaker().withName(this.displayName).withSkinUrl(this.skinUrl).build();
        this.head = head;
    }

    @Override
    public String getId() {
        return id;
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

    @Override
    public void startAnimation(final Player player, final de.piinguiin.lootbox.api.Lootbox lootbox) {

        final ActiveAnimation activeAnimation = AnimationFactory.getAnimationFromLootbox(lootbox);


    }
}
