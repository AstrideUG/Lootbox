package de.piinguiin.lootbox.api.locationable;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class AbstractLocationable implements Locationable {

    @Nullable
    protected Location currentLocation;

    public AbstractLocationable(@Nullable final Location startLocation) {
        this.currentLocation = startLocation;
    }

    public AbstractLocationable() {
        this(null);
    }

    @Override
    public final @Nullable Location getCurrentLocation() {
        return currentLocation;
    }

}
