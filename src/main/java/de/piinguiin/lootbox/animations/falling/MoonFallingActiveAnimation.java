package de.piinguiin.lootbox.animations.falling;

import de.piinguiin.lootbox.animations.particle.SingleHelixAnimation;
import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class MoonFallingActiveAnimation extends AbstractActiveAnimation implements FallingActiveAnimation {

    private final Vector vector;
    private final SingleHelixAnimation singleHelixAnimation;
    private final Location center;

    public MoonFallingActiveAnimation(@NotNull final Location location, final int ticks, final int period) {
        super(location.subtract(0, 0.2, 0), ticks, period);
        this.center = currentLocation.clone().add(0.5, 1.1, 0.5);
        vector = new Vector(0, 0.1, 0);
        final double height = ticks * vector.getY();
        this.currentLocation = location.clone().add(0, height, 0);
        this.singleHelixAnimation = new SingleHelixAnimation(currentLocation, vector.getY(), 0.8, EnumParticle.CLOUD);
    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(currentLocation);
    }

    @Override
    public void tick() {
        if (isAirDownwards()) {
            currentLocation.subtract(vector);
            this.singleHelixAnimation.onUpdate();
            new ParticleBuilder(this.center).setEnumParticle(EnumParticle.SPELL_WITCH)
                    .setAmount(3).setOffSet(0.1F, 0.0F, 0.1F).play();
        } else finish();
    }

    private boolean isAirDownwards() throws NullPointerException {
        final Material type = currentLocation.getBlock().getRelative(BlockFace.DOWN).getType();
        return type.equals(Material.AIR);
    }

}
