package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import de.slikey.effectlib.util.ParticleEffect;
import net.darkdevelopers.darkbedrock.darkness.spigot.functions.BukkitLocationUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

public class DefaultHeadSpinActiveAnimation extends AbstractActiveAnimation implements HeadSpinActiveAnimation, Headable {

    private final ItemStack head;
    private ArmorStand armorStand;

    public DefaultHeadSpinActiveAnimation(final ItemStack head) {
        super(Integer.MAX_VALUE);
        this.head = head;
    }

    @Override
    public void start(final Location location) {
        super.start(location);
        if (currentLocation != null) {
            armorStand = HeadableUtils.spawnArmorStand(currentLocation, head);
        } else throw new NullPointerException("currentLocation can not be null");
    }

    @Override
    public void tick() {
        if (armorStand != null) {
            //todo spawn particle around the head
            ParticleEffect.SMOKE.display(armorStand.getEyeLocation(), 0.3);
            final Location location = armorStand.getLocation();
            final Location newLocation = BukkitLocationUtils.copy(location, null, null, null, null, location.getYaw() + 0.145f);
            armorStand.teleport(newLocation);

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
