package de.piinguiin.lootbox.animations.giving;

import de.piinguiin.lootbox.animations.DelayedAnimation;
import de.piinguiin.lootbox.animations.delayed.ItemDropDelayedAnimation;
import de.piinguiin.lootbox.animations.delayed.ParticleDelayedAnimation;
import de.piinguiin.lootbox.animations.delayed.SoundPlayDelayedAnimation;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoonGivingAbstractActiveAnimation extends AbstractGivingActiveAnimation {

    private final List<DelayedAnimation> delayedAnimations;


    public MoonGivingAbstractActiveAnimation(@NotNull final Location startLocation, final int ticks,
                                             @NotNull final Entity target, @NotNull final LootboxPrize lootboxPrize) {
        super(startLocation, ticks, target, lootboxPrize);
        this.delayedAnimations = new ArrayList<>();
    }

    @Override
    public void start(@NotNull final Location location) throws IllegalStateException {
        super.start(location);
        final List<ItemStack> items = Arrays.asList(prize.getDisplayItem());
        final List<SoundPlayDelayedAnimation.PlayableSound> sounds = Arrays.asList(
                new SoundPlayDelayedAnimation.PlayableSound(Sound.NOTE_BASS, 1, 0.1F), new SoundPlayDelayedAnimation.PlayableSound(Sound.NOTE_BASS, 1, 0.8F),
                new SoundPlayDelayedAnimation.PlayableSound(Sound.NOTE_BASS, 1, 1.1F));
        this.delayedAnimations.add(new ItemDropDelayedAnimation(base.getEyeLocation().clone().add(0, 0.4, 0), 10,
                false, true, items));
        this.delayedAnimations.add(new SoundPlayDelayedAnimation(base.getLocation(), 2, false, sounds, 10));
        this.delayedAnimations.add(new ParticleDelayedAnimation(this.base.getEyeLocation(), 5, false,
                new ParticleBuilder(base.getEyeLocation()).setAmount(5).setEnumParticle(EnumParticle.FIREWORKS_SPARK).setOffSet(0.7F, 0.7F, 0.7F)));
    }

    @Override
    public void tick() {
        for (final DelayedAnimation delayedAnimation : this.delayedAnimations) {
            delayedAnimation.tick();
        }
    }

    @Override
    public void finish() {
        super.finish();
        for (final DelayedAnimation delayedAnimation : this.delayedAnimations) {
            delayedAnimation.end();
        }
    }

}
