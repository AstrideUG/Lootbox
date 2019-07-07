package de.piinguiin.lootbox.animations.delayed;

import de.piinguiin.lootbox.animations.DelayedAnimation;
import de.piinguiin.lootbox.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;

public class SoundPlayDelayedAnimation extends DelayedAnimation {

    private final List<PlayableSound> sounds;
    private final double radius;

    public SoundPlayDelayedAnimation(final Location location, final int periode, final boolean allAtOnce,
                                     final List<PlayableSound> sounds, final double radius) {
        super(location, periode, allAtOnce);
        this.sounds = sounds;
        this.radius = radius;
    }

    @Override
    public void action() {
        if (allAtOnce) {

            for (final PlayableSound sounds : this.sounds) {
                playForRadius(sounds);
            }

        } else {

            playForRadius(this.sounds.get(pointer));

            if (pointer < this.sounds.size() - 1) {
                pointer++;
            } else {
                pointer = 0;
            }
        }
    }

    @Override
    public void end() {
    }

    private void playForRadius(final PlayableSound sound) {

        for (final Player player : Utils.getNear(location, radius)) {
            player.playSound(this.location, sound.getSound(), sound.getA(), sound.getB());
        }

    }

    public static class PlayableSound {

        private final Sound sound;
        private final float a;
        private final float b;

        public PlayableSound(final Sound sound, final float a, final float b) {
            this.sound = sound;
            this.a = a;
            this.b = b;
        }

        public Sound getSound() {
            return sound;
        }

        public float getA() {
            return a;
        }

        public float getB() {
            return b;
        }
    }

}
