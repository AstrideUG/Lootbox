package de.piinguiin.lootbox.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {
    public static List<Player> getNear(final Location location, final double radius) {
        final List<Player> near = new ArrayList<>();
        final Collection<Entity> ents = location.getWorld().getNearbyEntities(location, radius, radius, radius);
        for (final Entity ent : ents) {
            if (ent instanceof Player) {
                near.add((Player) ent);
            }
        }
        return near;
    }
}
