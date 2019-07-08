package de.piinguiin.lootbox.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

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

    public static final Random random = new Random(System.nanoTime());


    public static Vector getRandomVector() {
        final double x = random.nextDouble() * 2.0D - 1.0D;
        final double y = random.nextDouble() * 2.0D - 1.0D;
        final double z = random.nextDouble() * 2.0D - 1.0D;

        return (new Vector(x, y, z)).normalize();
    }


    public static Vector getRandomCircleVector() {
        final double rnd = random.nextDouble() * 2.0D * Math.PI;
        final double x = Math.cos(rnd);
        final double z = Math.sin(rnd);

        return new Vector(x, 0.0D, z);
    }


    public static double getRandomAngle() {
        return random.nextDouble() * 2.0D * Math.PI;
    }

}
