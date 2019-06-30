package de.piinguiin.lootbox.utils.particle;

import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ParticleUtils {

    public static void sendPacketToPlayer(final PacketPlayOutWorldParticles packet, final Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);

    }

    public static void sendPacketToAll(final PacketPlayOutWorldParticles packet) {

        for (final Player all : Bukkit.getOnlinePlayers()) {
            sendPacketToPlayer(packet, all);
        }
    }

}
