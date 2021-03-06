package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;

public class DefaultHeadSpinActiveAnimation extends AbstractActiveAnimation implements HeadSpinActiveAnimation, Headable {

    /**
     * simple head spin animation
     */

    private final ItemStack head;
    private ArmorStand armorStand;
    private double y = 0.0;

    public DefaultHeadSpinActiveAnimation(@NotNull final Location location, @NotNull final ItemStack head,
                                          final int ticks, final int period) {
        super(location, ticks, period);
        this.head = head;
    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(location);
        armorStand = HeadableUtils.spawnArmorStand(location.clone().add(0.5, 0, 0.5), head);
    }

    @Override
    public void tick() {
        if (armorStand != null) {
            armorStand.setHeadPose(new EulerAngle(0.0, y, 0.0));
            y += 0.025;

        } else finish();
    }

    @Override
    public void finish() {
        super.finish();
        armorStand.remove();
    }

    @Override
    public ItemStack getHead() {
        return head;
    }
}
