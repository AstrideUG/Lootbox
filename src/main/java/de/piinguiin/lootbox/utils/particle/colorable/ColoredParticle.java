package de.piinguiin.lootbox.utils.particle.colorable;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public enum ColoredParticle {

    MOB_SPELL("SPELL_MOB"), MOB_SPELL_AMBIENT("SPELL_MOB_AMBIENT"), RED_DUST("REDSTONE");

    private ColoredParticle(final String name) {
        this.name = name;
    }

    String name;

    public void send(final Location location, final List<Player> players, final int r, final int g, final int b) {
        ParticleEffect.valueOf(name).display(r / 255, g / 255, b / 255, 1, 0, location, players);
    }

    public void send(final Location location, final int Distance, final int r, final int g, final int b) {
        ParticleEffect.valueOf(name).display(r / 255, g / 255, b / 255, 1, 0, location, Distance);
    }

}