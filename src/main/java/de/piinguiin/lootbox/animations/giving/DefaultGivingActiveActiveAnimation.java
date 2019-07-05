package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.animations.particle.CrossedBallAnimation;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DefaultGivingActiveActiveAnimation extends AbstractGivingActiveAnimation {

    private CrossedBallAnimation crossedBallAnimation;
    private final List<Item> droppedItems;
    private int dropTick;

    public DefaultGivingActiveActiveAnimation(@NotNull final Location startLocation, final int ticks, @NotNull final Entity target, @NotNull final ItemStack itemStack) {
        super(startLocation, ticks, target, itemStack);
        this.droppedItems = new ArrayList<>();
        this.dropTick = 0;
    }

    @Override
    public void start(@NotNull final Location location) throws IllegalStateException {
        super.start(location);
        this.crossedBallAnimation = new CrossedBallAnimation(base.getEyeLocation().clone().subtract(0, 0.2, 0),
                0.4D, EnumParticle.VILLAGER_HAPPY, 0.5);
    }

    @Override
    public void tick() {
        this.crossedBallAnimation.onUpdate();

        if (dropTick == 5) {
            this.droppedItems.add(dropItem(itemStack));
            dropTick = 0;
        } else {
            dropTick++;
        }

    }

    @Override
    public void finish() {
        super.finish();

        for (int i = 0; i < droppedItems.size(); i++) {

            final Item item = this.droppedItems.get(i);
            item.setPickupDelay(0);
            item.remove();
            this.droppedItems.remove(item);
        }

    }

    private Item dropItem(final ItemStack itemStack) {

        final Item item = currentLocation.getWorld().dropItemNaturally(base.getEyeLocation().clone().add(0, 0.4, 0)
                , itemStack);
        item.setPickupDelay(Integer.MAX_VALUE);
        return item;

    }
}
