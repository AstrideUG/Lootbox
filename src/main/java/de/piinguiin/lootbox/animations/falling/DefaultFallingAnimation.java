package de.piinguiin.lootbox.animations.falling;

import de.piinguiin.lootbox.api.AbstractAnimation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;

public final class DefaultFallingAnimation extends AbstractAnimation implements FallingAnimation {

    @Override
    public void tick() {
        if (isAirDownwards()) {
            //TODO spawn particle
            currentLocation.subtract(0, 0.2, 0); //TODO configure substraction vector
        } else finish();
    }

    @Override
    public void start(final Location location) {
        currentLocation = location;
    }

    private boolean isAirDownwards() {
        return currentLocation.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR);
    }

}
