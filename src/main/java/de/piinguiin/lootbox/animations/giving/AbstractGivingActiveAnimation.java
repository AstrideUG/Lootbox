package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractGivingActiveAnimation extends AbstractActiveAnimation implements GivingActiveAnimation {

    protected final Entity target;
    protected final ItemStack itemStack;
    protected ArmorStand base;

    @SuppressWarnings("WeakerAccess")
    public AbstractGivingActiveAnimation(@NotNull final Location startLocation, final int ticks, @NotNull final Entity target, @NotNull final ItemStack itemStack) {
        super(startLocation, ticks, 5);
        this.target = target;
        this.itemStack = itemStack;
    }

    /**
     * @throws IllegalStateException if {@code location.getWorld()} != {@code target.getLocation().getWorld()}
     */
    @Override
    public void start(@NotNull final Location location) throws IllegalStateException {

        super.start(location);

        final Item item = location.getWorld().dropItem(location.clone().add(0, -3, 0), this.itemStack);
        item.setPickupDelay(Integer.MAX_VALUE);

        base = (ArmorStand) location.getWorld().spawnEntity(location.clone().add(0.5, 0.3, 0.5), EntityType.ARMOR_STAND);
        item.setCustomName("§6§lGewinn");
        item.setCustomNameVisible(true);
        base.setVisible(false);
        base.setGravity(false);
        base.setPassenger(item);
    }

    @NotNull
    @Override
    public Entity getTarget() {
        return target;
    }

    @NotNull
    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public void finish() {
        base.getPassenger().remove();
        base.remove();
    }
}
