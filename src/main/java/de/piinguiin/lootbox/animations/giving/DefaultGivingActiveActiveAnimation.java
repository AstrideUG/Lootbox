package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.animations.particle.CrossedBallAnimation;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DefaultGivingActiveActiveAnimation extends AbstractGivingActiveAnimation {

    private CrossedBallAnimation crossedBallAnimation;

    public DefaultGivingActiveActiveAnimation(@NotNull final Location startLocation, final int ticks, @NotNull final Entity target, @NotNull final ItemStack itemStack) {
        super(startLocation, ticks, target, itemStack);

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
    }
}
