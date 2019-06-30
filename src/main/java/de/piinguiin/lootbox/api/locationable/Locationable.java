package de.piinguiin.lootbox.api.locationable;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public interface Locationable {

    @NotNull Location getCurrentLocation();

}
