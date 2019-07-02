package de.piinguiin.lootbox.animations.combined;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.animations.events.CombinedActiveAnimationFinishEvent;
import de.piinguiin.lootbox.animations.explosion.DefaultExplosionAnimation;
import de.piinguiin.lootbox.animations.falling.DefaultFallingActiveAnimation;
import de.piinguiin.lootbox.animations.giving.DefaultGivingActiveActiveAnimation;
import de.piinguiin.lootbox.animations.headspin.DefaultHeadSpinActiveAnimation;
import de.piinguiin.lootbox.api.combined.AbstractCombinedActiveAnimation;
import de.piinguiin.lootbox.factories.ItemFactory;
import de.piinguiin.lootbox.utils.item.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public final class MoonCombinedActiveAnimation extends AbstractCombinedActiveAnimation {

    private final Entity target;

    public MoonCombinedActiveAnimation(@NotNull final Location startLocation, final Entity target) {
        super(Arrays.asList( // 75
                new DefaultFallingActiveAnimation(startLocation, 20, 2),
                new DefaultExplosionAnimation(startLocation),
                new DefaultHeadSpinActiveAnimation(startLocation, Objects.requireNonNull(ItemFactory.getAnimationHead("moon")), 200, 1),
                new DefaultGivingActiveActiveAnimation(startLocation, 40, target, new ItemCreator().material(Material.DOUBLE_PLANT).displayName("§6§lwin").build())), target);
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
