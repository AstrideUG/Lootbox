package de.piinguiin.lootbox.utils;

import de.inventivegames.hologram.Hologram;
import de.inventivegames.hologram.HologramAPI;
import org.bukkit.Location;

public class ClusteredHologram {

    private final Location location;
    private final String[] text;
    private final Hologram[] holograms;

    public ClusteredHologram(final Location location, final String[] text) {
        this.location = location;
        this.text = text;
        this.holograms = new Hologram[text.length];
    }

    public void spawn() {

        for (int i = 0; i < text.length; i++) {
            final String display = text[i];
            final Hologram holo = HologramAPI.createHologram(this.location, display);
            this.holograms[i] = holo;
            this.location.subtract(0, 0.25, 0);
            holo.spawn();
        }

    }

    public void despawn() {

        for (int i = 0; i < this.holograms.length; i++) {
            HologramAPI.removeHologram(this.holograms[i]);
        }

    }
}
