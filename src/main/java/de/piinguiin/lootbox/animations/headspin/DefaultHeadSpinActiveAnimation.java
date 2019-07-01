package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;

public class DefaultHeadSpinActiveAnimation extends AbstractActiveAnimation implements HeadSpinActiveAnimation, Headable {

    private final ItemStack head;
    private ArmorStand armorStand;
    private double y = 0.0;
    private int particleTick = 0;

    public DefaultHeadSpinActiveAnimation(@NotNull final Location location, @NotNull final ItemStack head, final int period) {
        super(location, Integer.MAX_VALUE, period);
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

            if (particleTick == 10) {
                new ParticleBuilder(armorStand.getEyeLocation())
                        .setEnumParticle(EnumParticle.LAVA)
                        .setAmount(3)
                        .setSpeed(0)
                        .play();
                particleTick = 0;
            } else {
                particleTick++;

            }
            armorStand.setHeadPose(new EulerAngle(0.0, y, 0.0));
            y += 0.025;


        } else finish();
    }

    @Override
    public void finish() {
        super.finish();
        Bukkit.broadcastMessage("finish headspin");
        new ParticleBuilder(armorStand.getEyeLocation())
                .setEnumParticle(EnumParticle.SUSPENDED)
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
