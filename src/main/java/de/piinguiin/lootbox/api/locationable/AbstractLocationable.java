package de.piinguiin.lootbox.api.locationable;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractLocationable implements Locationable {

    @Nullable
    protected Location currentLocation;

    public AbstractLocationable(@Nullable final Location startLocation) {
        this.currentLocation = startLocation;
    }

    public AbstractLocationable() {
        this(null);
    }

    @Override
    @Nullable
    public final Location getCurrentLocation() {
        return currentLocation;
    }

}
