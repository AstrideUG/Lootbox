package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

public class DefaultHeadSpinActiveAnimation extends AbstractActiveAnimation implements HeadSpinActiveAnimation, Headable {

    private final ItemStack head;
    private ArmorStand armorStand;

    public DefaultHeadSpinActiveAnimation(final int ticks, final ItemStack head) {
        super(ticks);
        this.head = head;
    }

    @Override
    public void start(final Location location) {
        super.start(location);
        armorStand = HeadableUtils.spawnArmorStand(currentLocation, head);
    }

    @Override
    public void tick() {
        if (armorStand != null) {
            //todo spawn particle around the head
        } else finish();
    }

    @Override
    public ItemStack getHead() {
        return head;
    }

}
