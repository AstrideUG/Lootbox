package de.piinguiin.lootbox.api;

import de.piinguiin.lootbox.api.finishable.Finishable;
import org.bukkit.Location;

public interface Animation extends Finishable {

    void tick();

    void start(Location location);

    boolean isFinished();

    Location getCurrentLocation();

}
