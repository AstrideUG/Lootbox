package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import net.darkdevelopers.darkbedrock.darkness.spigot.functions.BukkitLocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DefaultHeadSpinActiveAnimation extends AbstractActiveAnimation implements HeadSpinActiveAnimation, Headable {

    private final ItemStack head;
    private ArmorStand armorStand;

    public DefaultHeadSpinActiveAnimation(@NotNull final Location location, @NotNull final ItemStack head) {
        super(location, Integer.MAX_VALUE);
        this.head = head;
    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(location);
        armorStand = HeadableUtils.spawnArmorStand(currentLocation, head);
    }

    @Override
    public void tick() {
        if (armorStand != null) {
            //todo spawn particle around the head
            final Location location = armorStand.getLocation();
            final Location newLocation = BukkitLocationUtils.copy(location, null, null, null, null, location.getYaw() + 0.145f);
            Bukkit.broadcastMessage("§4§lALT: " + location);
            Bukkit.broadcastMessage("§4§lNEU: " + newLocation);
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
