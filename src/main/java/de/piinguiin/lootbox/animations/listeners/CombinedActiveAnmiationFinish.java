package de.piinguiin.lootbox.animations.listeners;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.animations.events.CombinedActiveAnimationFinishEvent;
import de.piinguiin.lootbox.types.LootboxManager;
import net.darkdevelopers.darkbedrock.darkness.spigot.listener.Listener;
import org.bukkit.event.EventHandler;

import java.util.UUID;

public class CombinedActiveAnmiationFinish extends Listener {

    public CombinedActiveAnmiationFinish(final LootboxPlugin plugin) {
        super(plugin, plugin.getServer().getPluginManager(), "");
    }

    @EventHandler
    public static void onFinish(final CombinedActiveAnimationFinishEvent event) {

        final UUID uniqueId = event.getCombinedActiveAnimation().getTarget().getUniqueId();
        final LootboxManager lootboxManager = LootboxPlugin.getLootboxManager();
        lootboxManager.getRunningCombinedAnimations().remove(uniqueId);

    }

}
