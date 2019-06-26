package de.piinguiin.lootbox.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.Random;

public class MathUtil {
    public static Vector rotateAroundAxisX(final Vector v, final double angle) {
        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);
        final double y = v.getY() * cos - v.getZ() * sin;
        final double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    public static Vector rotateAroundAxisY(final Vector v, final double angle) {
        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);
        final double x = v.getX() * cos + v.getZ() * sin;
        final double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    public static Vector rotateAroundAxisZ(final Vector v, final double angle) {
        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);
        final double x = v.getX() * cos - v.getY() * sin;
        final double y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }

    public static Vector rotateVector(final Vector v, final double angleX, final double angleY, final double angleZ) {
        rotateAroundAxisX(v, angleX);
        rotateAroundAxisY(v, angleY);
        rotateAroundAxisZ(v, angleZ);
        return v;
    }

    public static double angleToXAxis(final Vector vector) {
        return Math.atan2(vector.getX(), vector.getY());
    }


    public static Vector getBackVector(final Location loc) {
        final float newZ = (float) (loc.getZ() + 0.75D * Math.sin(Math.toRadians(loc.getYaw() + 90.0F)));
        final float newX = (float) (loc.getX() + 0.75D * Math.cos(Math.toRadians(loc.getYaw() + 90.0F)));
        return new Vector(newX - loc.getX(), 0.0D, newZ - loc.getZ());
    }

    public static Vector rotateVectorYX(final Vector v, final float yawDegrees, final float pitchDegrees) {
        final double yaw = Math.toRadians(-1.0F * yawDegrees);

        final double cosYaw = Math.cos(yaw);
        final double cosPitch = Math.cos((double) pitchDegrees);
        final double sinYaw = Math.sin(yaw);
        final double sinPitch = Math.sin((double) pitchDegrees);

        final double initialY = v.getY();
        double initialZ = v.getZ();
        double z = initialY * sinPitch - initialZ * cosPitch;
        final double y = initialY * cosPitch + initialZ * sinPitch;

        initialZ = z;
        final double initialX = v.getX();
        z = initialZ * cosYaw - initialX * sinYaw;
        final double x = initialZ * sinYaw + initialX * cosYaw;

        return new Vector(x, y, z);
    }

    public static Vector getRandomCircleVector() {
        final Random rndm = new Random();
        final double rnd = rndm.nextDouble() * 2.0D * 3.141592653589793D;
        final double x = Math.cos(rnd);
        final double z = Math.sin(rnd);

        return new Vector(x, 0.0D, z);
    }

    public static double randomDouble(final double min, final double max) {
        return Math.random() < 0.5D ? (1.0D - Math.random()) * (max - min) + min : Math.random() * (max - min) + min;
    }

    public static float randomRangeFloat(final float min, final float max) {
        return (float) (Math.random() < 0.5D ? (1.0D - Math.random()) * (max - min) + min :
                Math.random() * (max - min) + min);
    }

    public static int randomRangeInt(final int min, final int max) {
        return (int) (Math.random() < 0.5D ? (1.0D - Math.random()) * (max - min + 1) + min :
                Math.random() * (max - min + 1) + min);
    }

    public static double offset(final Entity a, final Entity b) {
        return offset(a.getLocation().toVector(), b.getLocation().toVector());
    }

    public static double offset(final Location a, final Location b) {
        return offset(a.toVector(), b.toVector());
    }

    public static double offset(final Vector a, final Vector b) {
        return a.subtract(b).length();
    }

    public static double square(final double num) {
        return num * num;
    }

    public static int floor(final double num) {
        final int floor = (int) num;
        return floor == num ? floor : floor - (int) (Double.doubleToRawLongBits(num) >>> 63);
    }
}