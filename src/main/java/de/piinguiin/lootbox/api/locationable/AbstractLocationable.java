package de.piinguiin.lootbox.api.locationable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class AbstractLocationable implements Locationable {

    protected @NotNull Location currentLocation;

    public AbstractLocationable(@NotNull final Location startLocation) {
        this.currentLocation = startLocation;
        Bukkit.broadcastMessage("§6§lConstuctor of AbstractLocationable was called with currentLocation = " + currentLocation);
    }

    @Override
    public final @NotNull Location getCurrentLocation() {
        return currentLocation;
    }

}
