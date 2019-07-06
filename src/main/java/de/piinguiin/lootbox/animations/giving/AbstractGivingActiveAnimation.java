package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractGivingActiveAnimation extends AbstractActiveAnimation implements GivingActiveAnimation {

    protected final Entity target;
    protected final LootboxPrize prize;
    protected ArmorStand base;
    private ArmorStand rarityDisplay;

    @SuppressWarnings("WeakerAccess")
    public AbstractGivingActiveAnimation(@NotNull final Location startLocation, final int ticks,
                                         @NotNull final Entity target, @NotNull final LootboxPrize lootboxPrize) {
        super(startLocation, ticks, 2);
        this.target = target;
        this.prize = lootboxPrize;
    }

    /**
     * @throws IllegalStateException if {@code location.getWorld()} != {@code target.getLocation().getWorld()}
     */
    @Override
    public void start(@NotNull final Location location) throws IllegalStateException {

        super.start(location);

        final Item item = location.getWorld().dropItem(location.clone().add(0, -3, 0), this.prize.getDisplayItem());
        item.setPickupDelay(Integer.MAX_VALUE);
        base = (ArmorStand) location.getWorld().spawnEntity(location.clone().add(0.5, 0.3, 0.5), EntityType.ARMOR_STAND);
        item.setCustomName(this.prize.getDisplayItem().getItemMeta().getDisplayName());
        item.setCustomNameVisible(true);
        base.setVisible(false);
        base.setGravity(false);
        base.setPassenger(item);
        rarityDisplay = (ArmorStand) location.getWorld().spawnEntity(location.clone().add(0.5, -2.7, 0.5), EntityType.ARMOR_STAND);
        rarityDisplay.setGravity(false);
        rarityDisplay.setVisible(false);
        rarityDisplay.setCustomNameVisible(true);
        final LootboxPrize.LootboxPrizeRarity rarity = prize.getRarity();
        rarityDisplay.setCustomName(rarity.getGetColor() + ChatColor.BOLD + rarity.getName().toUpperCase());
    }

    @NotNull
    @Override
    public Entity getTarget() {
        return target;
    }

    public LootboxPrize getPrize() {
        return prize;
    }


    @Override
    public void finish() {

        if (base == null) {
            return;
        }

        if (base.getPassenger() != null) {
            base.getPassenger().remove();
        }

        base.remove();
        rarityDisplay.remove();
    }
}
