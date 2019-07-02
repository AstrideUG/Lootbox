package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DefaultGivingActiveActiveAnimation extends AbstractGivingActiveAnimation {

    public DefaultGivingActiveActiveAnimation(@NotNull final Location startLocation, final int ticks, @NotNull final Entity target, @NotNull final ItemStack itemStack) {
        super(startLocation, ticks, target, itemStack);
    }

    @Override
    public void tick() {
        new ParticleBuilder(base.getEyeLocation().clone().add(0, 0.2, 0)).setOffSet(0.3F, 0.3F, 0.3F)
                .setEnumParticle(EnumParticle.HEART).play();
    }
}
