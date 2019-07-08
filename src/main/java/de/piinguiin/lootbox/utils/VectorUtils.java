package de.piinguiin.lootbox.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;


public final class VectorUtils {
    public static final Vector rotateAroundAxisX(final Vector v, final double angle) {
        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);
        final double y = v.getY() * cos - v.getZ() * sin;
        final double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }


    public static final Vector rotateAroundAxisY(final Vector v, final double angle) {
        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);
        final double x = v.getX() * cos + v.getZ() * sin;
        final double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }


    public static final Vector rotateAroundAxisZ(final Vector v, final double angle) {
        final double cos = Math.cos(angle);
        final double sin = Math.sin(angle);
        final double x = v.getX() * cos - v.getY() * sin;
        final double y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }


    public static final Vector rotateVector(final Vector v, final double angleX, final double angleY, final double angleZ) {
        rotateAroundAxisX(v, angleX);
        rotateAroundAxisY(v, angleY);
        rotateAroundAxisZ(v, angleZ);
        return v;
    }


    public static final Vector rotateVector(final Vector v, final Location location) {
        return rotateVector(v, location.getYaw(), location.getPitch());
    }


    public static final Vector rotateVector(final Vector v, final float yawDegrees, final float pitchDegrees) {
        final double yaw = Math.toRadians((-1.0F * (yawDegrees + 90.0F)));
        final double pitch = Math.toRadians(-pitchDegrees);

        final double cosYaw = Math.cos(yaw);
        final double cosPitch = Math.cos(pitch);
        final double sinYaw = Math.sin(yaw);
        final double sinPitch = Math.sin(pitch);


        double initialX = v.getX();
        final double initialY = v.getY();
        double x = initialX * cosPitch - initialY * sinPitch;
        final double y = initialX * sinPitch + initialY * cosPitch;


        final double initialZ = v.getZ();
        initialX = x;
        final double z = initialZ * cosYaw - initialX * sinYaw;
        x = initialZ * sinYaw + initialX * cosYaw;

        return new Vector(x, y, z);
    }


    public static final double angleToXAxis(final Vector vector) {
        return Math.atan2(vector.getX(), vector.getY());
    }
}
