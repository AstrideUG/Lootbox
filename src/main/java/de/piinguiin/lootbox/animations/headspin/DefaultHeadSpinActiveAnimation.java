package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.darkdevelopers.darkbedrock.darkness.spigot.functions.BukkitLocationUtils;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
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
        armorStand = HeadableUtils.spawnArmorStand(location.clone().add(0.5, 0, 0.5), head);
        for (final Player all : Bukkit.getOnlinePlayers()) {

            all.teleport(armorStand.getEyeLocation());

        }
    }

    @Override
    public void tick() {
        if (armorStand != null) {
            //todo spawn particle around the head
            final Location location = armorStand.getLocation();
            final Location newLocation = BukkitLocationUtils.copy(location, null, null, null, null, location.getYaw() + 1.45f);
            Bukkit.broadcastMessage("Tick");
            for (final Player all : Bukkit.getOnlinePlayers()) {
                if (!all.getGameMode().equals(GameMode.SPECTATOR)) {
                    all.teleport(armorStand.getEyeLocation());
                }
            }
            armorStand.teleport(newLocation);

        } else finish();
    }

    @Override
    public void finish() {
        super.finish();
        Bukkit.broadcastMessage("finish headspin");
        new ParticleBuilder(armorStand.getEyeLocation())
                .setEnumParticle(EnumParticle.LAVA)
                .setAmount(5)
                .setSpeed(0)
                .setOffSet(0.1F, 0.1F, 0.1F)
                .play();
        armorStand.remove();
    }

    @Override
    public ItemStack getHead() {
        return head;
    }
}
