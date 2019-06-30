package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.api.locationable.AbstractLocationable;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class AbstractGivingAnimation extends AbstractLocationable implements GivingAnimation {

    private final Entity target;
    private final ItemStack itemStack;

    @SuppressWarnings("WeakerAccess")
    public AbstractGivingAnimation(@NotNull final Location startLocation, @NotNull final Entity target, @NotNull final ItemStack itemStack) {
        super(startLocation);
        this.target = target;
        this.itemStack = itemStack;
    }

    /**
     * @throws IllegalStateException if {@code location.getWorld()} != {@code target.getLocation().getWorld()}
     */
    @Override
    public void start(@NotNull final Location location) throws IllegalStateException {
        final Item item = location.getWorld().dropItem(location, this.itemStack);
        item.setPickupDelay(Integer.MAX_VALUE);
        final Location targetLocation = target.getLocation();
        if (targetLocation.getWorld() != location.getWorld()) {
            throw new IllegalStateException("targetLocation.getWorld() can not != location.getWorld()");
        }
        final Vector vectorBetweenPoints = targetLocation.toVector().subtract(location.toVector());
        item.setVelocity(vectorBetweenPoints);

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

}
