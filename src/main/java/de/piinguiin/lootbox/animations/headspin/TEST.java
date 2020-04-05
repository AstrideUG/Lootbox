package de.piinguiin.lootbox.animations.headspin;

import de.piinguiin.lootbox.animations.particle.ParticleEffect;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TEST extends ParticleEffect {

    private final double radius;
    private int i;
    private final Location location;
    private final EntityArmorStand a1;
    private final EntityArmorStand a2;

    public TEST(final double radius, final Location location) {
        this.radius = radius;
        this.i = 0;
        this.location = location;
        a1 = createArmorstand();
        a2 = createArmorstand();
    }

    @Override
    public void onUpdate() {

        final Location particleLocA = this.location.clone();
        final Location particleLocB = this.location.clone();

        i++;
        final double angle = 6.3D * (double) this.i / 150;
        final double x = Math.cos(angle) * this.radius;
        final double z = Math.sin(angle) * this.radius;

        particleLocA.add(x, 0, z);
        particleLocB.add(-x, 0, -z);

        a1.setLocation(particleLocA.getX(), particleLocA.getY(), particleLocA.getZ(), 0, 0);
        a2.setLocation(particleLocB.getX(), particleLocB.getY(), particleLocB.getZ(), 0, 0);

        for (final Player all : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityTeleport(a1));
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityTeleport(a2));
        }

    }

    private EntityArmorStand createArmorstand() {

        final EntityArmorStand eas = new EntityArmorStand(((CraftWorld) location.getWorld()).getHandle());
        final PacketPlayOutSpawnEntityLiving spawnPacket = new PacketPlayOutSpawnEntityLiving(eas);
        //eas.setInvisible(true);

        eas.setGravity(false);
        eas.setSmall(true);

        for (final Player all : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(spawnPacket);
        }

        return eas;
    }

}