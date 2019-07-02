package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import de.piinguiin.lootbox.utils.particle.colorable.ColoredParticle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;

public class DefaultHeadSpinActiveAnimation extends AbstractActiveAnimation implements HeadSpinActiveAnimation, Headable {

    private final ItemStack head;
    private ArmorStand armorStand;
    private double y = 0.0;
    //private int particleTick = 0;
    private Location particleLocA, particleLocB;
    private final float radius = 0.7F;
    int i = 0;

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
/*
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
            */

            particleLocA = armorStand.getEyeLocation().clone();
            particleLocB = armorStand.getEyeLocation().clone();

            i++;
            final double angle = 6.283185307179586D * (double) this.i / 50.0D;
            final double x = Math.cos(angle) * 0.7D;
            final double z = Math.sin(angle) * 0.7D;

            particleLocA.add(x, 0, z);
            particleLocB.add(-x, 0, -z);

            //new ParticleBuilder(particleLocA).setEnumParticle(EnumParticle.FIREWORKS_SPARK).play();
            // new ParticleBuilder(particleLocB).setEnumParticle(EnumParticle.FIREWORKS_SPARK).play();
            ColoredParticle.RED_DUST.send(particleLocB, 100, 255, 255, 255);
            ColoredParticle.RED_DUST.send(particleLocA, 100, 255, 255, 255);

            particleLocA.subtract(x, 0, z);
            particleLocB.subtract(-x, 0, -z);


            armorStand.setHeadPose(new EulerAngle(0.0, y, 0.0));
            y += 0.025;


        } else finish();
    }

    @Override
    public void finish() {
        super.finish();
        new ParticleBuilder(armorStand.getEyeLocation())
                .setEnumParticle(EnumParticle.FLAME)
                .setAmount(10)
                .setSpeed(1)
                .setOffSet(0.1F, 0.1F, 0.1F)
                .play();
        armorStand.remove();
    }

    @Override
    public ItemStack getHead() {
        return head;
    }
}
