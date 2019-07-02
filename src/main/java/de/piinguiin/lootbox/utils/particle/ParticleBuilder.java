package de.piinguiin.lootbox.utils.particle;

import de.piinguiin.lootbox.LootboxPlugin;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class ParticleBuilder {

    private EnumParticle enumParticle;
    private ParticleForm form;
    private float x, y, z;
    private float speed;
    private float offX, offY, offZ;
    private int amount;
    private final World world;

    private double circleRadius;

    public ParticleBuilder(final Location location) {
        this.speed = 0;
        this.amount = 1;
        this.world = location.getWorld();
        setLocation(location);
        this.offX = 0;
        this.offY = 0;
        this.offZ = 0;
        this.circleRadius = 0.0;
        this.form = ParticleForm.DEFAULT;
    }

    public ParticleBuilder setEnumParticle(final EnumParticle enumParticle) {
        this.enumParticle = enumParticle;
        this.form = ParticleForm.DEFAULT;
        return this;
    }

    public ParticleBuilder setForm(final ParticleForm form) {
        this.form = form;
        return this;
    }

    public ParticleBuilder setX(final float x) {
        this.x = x;
        return this;
    }

    public ParticleBuilder setY(final float y) {
        this.y = y;
        return this;
    }

    public ParticleBuilder setZ(final float z) {
        this.z = z;
        return this;
    }

    public ParticleBuilder setSpeed(final float speed) {
        this.speed = speed;
        return this;
    }

    public ParticleBuilder setOffX(final float offX) {
        this.offX = offX;
        return this;
    }

    public ParticleBuilder setOffY(final float offY) {
        this.offY = offY;
        return this;
    }

    public ParticleBuilder setOffZ(final float offZ) {
        this.offZ = offZ;
        return this;
    }

    public ParticleBuilder setCircleRadius(final double circleRadius) {
        this.circleRadius = circleRadius;
        return this;
    }

    public ParticleBuilder setColor(final Color color) {
        this.offX = color.getRed();
        this.offY = color.getGreen();
        this.offZ = color.getBlue();
        return this;
    }

    public ParticleBuilder setAmount(final int amount) {
        this.amount = amount;
        return this;
    }

    public ParticleBuilder setOffSet(final float... offXYZ) {

        if (offXYZ.length != 3) {
            LootboxPlugin.getPlugin().getLogger().warning("cannot set offSet. Float array lenght must be 3!");
            return this;
        }

        this.offX = offXYZ[0];
        this.offY = offXYZ[1];
        this.offZ = offXYZ[2];
        return this;
    }

    public ParticleBuilder setLocation(final Location location) {
        this.x = (float) location.getX();
        this.y = (float) location.getY();
        this.z = (float) location.getZ();
        return this;
    }

    public Location getLocation() {
        return new Location(this.world, x, y, z);
    }

    private PacketPlayOutWorldParticles build() {
        return new PacketPlayOutWorldParticles(enumParticle, true, x, y, z, offX, offY, offZ, speed, amount, null);
    }

    public void play() {
        switch (form) {

            case CIRCLE:
                final Location center = getLocation();
                final double radius = this.circleRadius;
                final List<Location> particleLocs = new ArrayList<>();
                for (double r = 0.0D; r < 360.0D; r += 15.0D) {
                    final double angle = r * Math.PI / 180.0D;
                    final double x = center.getX() + radius * Math.cos(angle);
                    final double z = center.getZ() + radius * Math.sin(angle);
                    final Location loc = center.clone();
                    loc.setX(x);
                    loc.setZ(z);
                    particleLocs.add(loc);
                }

                for (final Location locs : particleLocs) {
                    ParticleUtils.sendPacketToAll(new PacketPlayOutWorldParticles(enumParticle, true,
                            (float) locs.getX(), (float) locs.getY(), (float) locs.getZ(), offX, offY, offZ, speed, amount));
                }

                break;

            case DEFAULT:
            default:
                ParticleUtils.sendPacketToAll(build());
                break;

        }
    }

    public static enum ParticleForm {


        DEFAULT,
        CIRCLE

    }

}
