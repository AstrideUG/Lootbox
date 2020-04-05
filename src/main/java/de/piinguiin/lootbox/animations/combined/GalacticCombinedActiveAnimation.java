package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.animations.events.CombinedActiveAnimationFinishEvent;
import de.piinguiin.lootbox.animations.explosion.DefaultExplosionAnimation;
import de.piinguiin.lootbox.animations.falling.GalacticFallingActiveAnimation;
import de.piinguiin.lootbox.animations.giving.MoonGivingAbstractActiveAnimation;
import de.piinguiin.lootbox.animations.headspin.GalacticHeadSpinActiveAnimation;
import de.piinguiin.lootbox.api.combined.AbstractCombinedActiveAnimation;
import de.piinguiin.lootbox.factories.ItemFactory;
import de.piinguiin.lootbox.prizes.LootboxPrize;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class GalacticCombinedActiveAnimation extends AbstractCombinedActiveAnimation {

    private final Entity target;

    public GalacticCombinedActiveAnimation(@NotNull final Location startLocation, final Entity target, final LootboxPrize lootboxPrize) {
        super(Arrays.asList(
                new GalacticFallingActiveAnimation(startLocation, 75, 2),
                new DefaultExplosionAnimation(startLocation),
                new GalacticHeadSpinActiveAnimation(startLocation, Objects
                        .requireNonNull(ItemFactory.getAnimationHead("galactic")), 200, 1),
                new MoonGivingAbstractActiveAnimation(startLocation,
                        100, target, lootboxPrize)),
                target);
        this.target = target;
    }

    @Override
    public void finish() {
        super.finish();
        final PluginManager pluginManager = LootboxPlugin.getPlugin().getServer().getPluginManager();
        final CombinedActiveAnimationFinishEvent event = new CombinedActiveAnimationFinishEvent(this);
        pluginManager.callEvent(event);
    }

}
