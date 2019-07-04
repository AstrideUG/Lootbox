package de.piinguiin.lootbox.animations.falling;

import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public final class DefaultFallingActiveAnimation extends AbstractActiveAnimation implements FallingActiveAnimation {

    private final Vector vector;
    //private final HelixAnimation helixAnimation;
    //private final SpiralAnimation spiralAnimation;

    public DefaultFallingActiveAnimation(@NotNull final Location location, final int ticks, final int period) {
        super(location, ticks, period);

        vector = new Vector(0, 0.3, 0);
        final double height = ticks * vector.getY();
        this.currentLocation = location.clone().add(0.5, height, 0.5);
        /*
        this.helixAnimation = new HelixAnimation(location, height, 0.3, 0.7, EnumParticle.CRIT);
        this.spiralAnimation = new SpiralAnimation(location.clone().add(0.5, 0, 0.5), EnumParticle.FLAME,
                0.3, 6.2, 0.5, 3, 10, SpiralAnimation.Dircetion.DOWN);

         */
    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(currentLocation);
    }

    @Override
    public void tick() {
        if (isAirDownwards()) {

            //new ParticleBuilder(currentLocation).setEnumParticle(EnumParticle.CLOUD).setAmount(2).play();

            // this.helixAnimation.onUpdate();
            //this.spiralAnimation.onUpdate();

            currentLocation.subtract(vector);
        } else finish();
    }

    private boolean isAirDownwards() throws NullPointerException {
        final Material type = currentLocation.getBlock().getRelative(BlockFace.DOWN).getType();
        return type.equals(Material.AIR);
    }

}
