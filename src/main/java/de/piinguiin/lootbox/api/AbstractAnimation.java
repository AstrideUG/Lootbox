package de.piinguiin.lootbox.api;

import org.bukkit.Location;

public abstract class AbstractAnimation implements Animation {

    protected Location currentLocation;
    @SuppressWarnings("WeakerAccess")
    protected boolean finished;

    @Override
    public void finish() {
        finished = true;
    }

    @Override
    public final boolean isFinished() {
        return finished;
    }

    @Override
    public final Location getCurrentLocation() {
        return currentLocation;
    }

}
