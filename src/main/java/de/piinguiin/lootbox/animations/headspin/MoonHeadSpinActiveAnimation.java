package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.animations.particle.colored.ColoredDoubleCircleAnimation;
import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.api.headable.Headable;
import de.piinguiin.lootbox.api.headable.HeadableUtils;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;

public class MoonHeadSpinActiveAnimation extends AbstractActiveAnimation implements HeadSpinActiveAnimation, Headable {

    private final ItemStack head;
    private ArmorStand armorStand;
    private double y = 0.0;
    private ColoredDoubleCircleAnimation circle;

    public MoonHeadSpinActiveAnimation(@NotNull final Location location, @NotNull final ItemStack head,
                                       final int ticks, final int period) {
        super(location, ticks, period);
        this.head = head;
    }


    @Override
    public void start(@NotNull final Location location) {
        super.start(location);
        armorStand = HeadableUtils.spawnArmorStand(location.clone().add(0.5, 0, 0.5), head);
        circle = new ColoredDoubleCircleAnimation(0.7, 255, 255, 255, armorStand.getEyeLocation());
        //this.circle = new ColoredCrossedBallAnimation(armorStand.getEyeLocation().clone().subtract(0, 0.2, 0), 0.7, 0.7, 255, 255, 255);
    }

    @Override
    public void tick() {
        if (armorStand != null) {

            this.circle.onUpdate();
            armorStand.setHeadPose(new EulerAngle(0.0, y, 0.0));
            y += 0.025;

        } else finish();
    }

    @Override
    public void finish() {
        super.finish();
        new ParticleBuilder(armorStand.getEyeLocation()).setEnumParticle(EnumParticle.FIREWORKS_SPARK).setAmount(50)
                .setSpeed(1)
                .setOffSet(0.15F, 0.15F, 0.15F)
                .play();
        armorStand.remove();
    }

    @Override
    public ItemStack getHead() {
        return head;
    }
}
