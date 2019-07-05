package de.piinguiin.lootbox.animations.falling;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public final class DefaultFallingActiveAnimation extends AbstractActiveAnimation implements FallingActiveAnimation {

    private final Vector vector;

    public DefaultFallingActiveAnimation(@NotNull final Location location, final int ticks, final int period) {
        super(location, ticks, period);

        vector = new Vector(0, 0.3, 0);
        final double height = ticks * vector.getY();
        this.currentLocation = location.clone().add(0.5, height, 0.5);


    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(currentLocation);
    }

    @Override
    public void tick() {
        if (isAirDownwards()) {
            new ParticleBuilder(currentLocation).setEnumParticle(EnumParticle.CLOUD).setAmount(2).play();
            currentLocation.subtract(vector);
        } else finish();
    }

    private boolean isAirDownwards() throws NullPointerException {
        final Material type = currentLocation.getBlock().getRelative(BlockFace.DOWN).getType();
        return type.equals(Material.AIR);
    }

}
