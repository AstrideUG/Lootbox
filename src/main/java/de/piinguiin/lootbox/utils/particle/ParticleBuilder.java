package de.piinguiin.lootbox.utils.particle;

import de.piinguiin.lootbox.LootboxPlugin;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;

public class ParticleBuilder {

    private EnumParticle enumParticle;
    private float x, y, z;
    private float speed;
    private float offX, offY, offZ;
    private int amount;
    private final World world;

    public ParticleBuilder(final Location location) {
        this.speed = 0;
        this.amount = 1;
        this.world = location.getWorld();
        setLocation(location);
        this.offX = 0;
        this.offY = 0;
        this.offZ = 0;
    }

    public ParticleBuilder setEnumParticle(final EnumParticle enumParticle) {
        this.enumParticle = enumParticle;
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
        return new PacketPlayOutWorldParticles(enumParticle, true, x, y, z, offX, offY, offZ, speed, amount);
    }

    public void play() {

        ParticleUtils.sendPacketToAll(build());

    }


}
