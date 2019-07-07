package de.piinguiin.lootbox.animations.delayed;

import de.piinguiin.lootbox.animations.DelayedAnimation;
import de.piinguiin.lootbox.utils.particle.colorable.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class ItemDropDelayedAnimation extends DelayedAnimation {

    private final List<ItemStack> items;
    private final List<Item> droppedItems;
    private final boolean dropNaturally;

    public ItemDropDelayedAnimation(final Location location, final int periode, final boolean allAtOnce, final boolean dropNaturally,
                                    final List<ItemStack> items) {
        super(location, periode, allAtOnce);
        this.items = items;
        this.droppedItems = new ArrayList<>();
        this.dropNaturally = dropNaturally;
    }

    @Override
    public void action() {
        if (allAtOnce) {

            for (final ItemStack items : this.items) {
                dropSingle(items);
            }

        } else {
            dropSingle(this.items.get(pointer));
            if (pointer < this.items.size() - 1) {
                pointer++;
            } else {
                pointer = 0;
            }

        }
    }

    @Override
    public void end() {
        if (this.droppedItems.isEmpty()) {
            return;
        }

        for (int i = 0; i < this.droppedItems.size(); i++) {
            final Item item = this.droppedItems.get(i);
            final Location loc = item.getLocation();
            ParticleEffect.CLOUD.display(0, 0, 0, 0, 1, loc, 100);
            this.droppedItems.get(i).remove();
        }
    }

    private void dropSingle(final ItemStack itemStack) {
        final Item item = this.location.getWorld().dropItemNaturally(this.location, itemStack);
        item.setPickupDelay(Integer.MAX_VALUE);
        if (!dropNaturally) {
            final float velX = -0.2F + (float) (Math.random() * 0.41D);
            final float velY = 0.7F + (float) (Math.random() * 0.7D);
            final float velZ = -0.2F + (float) (Math.random() * 0.415D);
            item.setVelocity(new Vector(velX, velY, velZ));
        }
        this.droppedItems.add(item);
    }

}
