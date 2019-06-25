package de.piinguiin.lootbox.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.Random;

public class MathUtil
{
    public static final Vector rotateAroundAxisX(Vector v, double angle)
    {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double y = v.getY() * cos - v.getZ() * sin;
        double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    public static final Vector rotateAroundAxisY(Vector v, double angle)
    {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos + v.getZ() * sin;
        double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    public static final Vector rotateAroundAxisZ(Vector v, double angle)
    {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = v.getX() * cos - v.getY() * sin;
        double y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }

    public static final Vector rotateVector(Vector v, double angleX, double angleY, double angleZ)
    {
        rotateAroundAxisX(v, angleX);
        rotateAroundAxisY(v, angleY);
        rotateAroundAxisZ(v, angleZ);
        return v;
    }

    public static final double angleToXAxis(Vector vector)
    {
        return Math.atan2(vector.getX(), vector.getY());
    }


    public static Vector getBackVector(Location loc)
    {
        float newZ = (float)(loc.getZ() + 0.75D * Math.sin(Math.toRadians(loc.getYaw() + 90.0F)));
        float newX = (float)(loc.getX() + 0.75D * Math.cos(Math.toRadians(loc.getYaw() + 90.0F)));
        return new Vector(newX - loc.getX(), 0.0D, newZ - loc.getZ());
    }

    public static final Vector rotateVectorYX(Vector v, float yawDegrees, float pitchDegrees)
    {
        double yaw = Math.toRadians(-1.0F * yawDegrees);
        double pitch = pitchDegrees;

        double cosYaw = Math.cos(yaw);
        double cosPitch = Math.cos(pitch);
        double sinYaw = Math.sin(yaw);
        double sinPitch = Math.sin(pitch);

        double initialY = v.getY();
        double initialZ = v.getZ();
        double z = initialY * sinPitch - initialZ * cosPitch;
        double y = initialY * cosPitch + initialZ * sinPitch;

        initialZ = z;
        double initialX = v.getX();
        z = initialZ * cosYaw - initialX * sinYaw;
        double x = initialZ * sinYaw + initialX * cosYaw;

        return new Vector(x, y, z);
    }

    public static Vector getRandomCircleVector()
    {
        Random rndm = new Random();
        double rnd = rndm.nextDouble() * 2.0D * 3.141592653589793D;
        double x = Math.cos(rnd);
        double z = Math.sin(rnd);

        return new Vector(x, 0.0D, z);
    }

    public static double randomDouble(double min, double max)
    {
        return Math.random() < 0.5D ? (1.0D - Math.random()) * (max - min) + min : Math.random() * (max - min) + min;
    }

    public static float randomRangeFloat(float min, float max)
    {
        return (float)(Math.random() < 0.5D ? (1.0D - Math.random()) * (max - min) + min :
                Math.random() * (max - min) + min);
    }

    public static int randomRangeInt(int min, int max)
    {
        return (int)(Math.random() < 0.5D ? (1.0D - Math.random()) * (max - min + 1) + min :
                Math.random() * (max - min + 1) + min);
    }

    public static double offset(Entity a, Entity b)
    {
        return offset(a.getLocation().toVector(), b.getLocation().toVector());
    }

    public static double offset(Location a, Location b)
    {
        return offset(a.toVector(), b.toVector());
    }

    public static double offset(Vector a, Vector b)
    {
        return a.subtract(b).length();
    }

    public static double square(double num)
    {
        return num * num;
    }

    public static int floor(double num)
    {
        int floor = (int)num;
        return floor == num ? floor : floor - (int)(Double.doubleToRawLongBits(num) >>> 63);
    }
}