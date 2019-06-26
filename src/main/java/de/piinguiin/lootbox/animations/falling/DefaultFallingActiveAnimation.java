package de.piinguiin.lootbox.animations.falling;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public final class DefaultFallingActiveAnimation extends AbstractActiveAnimation implements FallingActiveAnimation {

    private final Vector vector;

    public DefaultFallingActiveAnimation(final int ticks, @Nullable final Location location) {
        super(ticks);

        vector = new Vector(0, 0.2, 0);
        final double hight = ticks * vector.getY();

        this.currentLocation = location != null ? location.clone().add(0, hight, 0) : null;
    }

    @SuppressWarnings("unused")
    public DefaultFallingActiveAnimation(final int ticks) {
        this(ticks, null);
    }

    @Override
    public void tick() {
        if (currentLocation != null)
            if (isAirDownwards()) {
                //TODO spawn particle
                currentLocation.subtract(vector); //TODO configure substraction vector
            } else finish();
        else {
            LootboxPlugin.getPlugin().getLogger().warning("can't spawn particle to location `null`");
            finish();
        }
    }

    /**
     * @throws NullPointerException if currentLocation is null
     */
    private boolean isAirDownwards() throws NullPointerException {
        return currentLocation.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR);
    }

}
