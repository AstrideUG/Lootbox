package de.piinguiin.lootbox.utils.particle;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ParticleBuilder {

    private EnumParticle enumParticle;
    private float x, y, z;
    private float speed;
    private float offX, offY, offZ;
    private int amount;

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

    public ParticleBuilder setAmount(final int amount) {
        this.amount = amount;
        return this;
    }

    public ParticleBuilder setLocation(final Location location) {
        this.x = (float) location.getX();
        this.y = (float) location.getX();
        this.z = (float) location.getX();
        return this;
    }

    private PacketPlayOutWorldParticles build() {
        return new PacketPlayOutWorldParticles(enumParticle, true, x, y, z, offX, offY, offZ, speed, amount);
    }

    public void play(final Player player) {

        ParticleUtils.sendPacketToPlayer(build(), player);
    }

    public void playAll() {
        ParticleUtils.sendPacketToAll(build());
    }

}
