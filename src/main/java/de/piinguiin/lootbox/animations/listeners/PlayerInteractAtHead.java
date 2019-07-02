package de.piinguiin.lootbox.animations.listeners;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.animations.combined.MoonCombinedActiveAnimation;
import de.piinguiin.lootbox.animations.headspin.HeadSpinActiveAnimation;
import de.piinguiin.lootbox.api.Animation;
import de.piinguiin.lootbox.api.combined.CombinedActiveAnimation;
import de.piinguiin.lootbox.types.LootboxManager;
import net.darkdevelopers.darkbedrock.darkness.spigot.listener.Listener;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractAtHead extends Listener {

    public PlayerInteractAtHead(final LootboxPlugin plugin) {
        super(plugin, plugin.getServer().getPluginManager(), "");
    }

    @EventHandler
    public static void test(final PlayerInteractEvent event) {

        final Player player = event.getPlayer();

        final Block block = event.getClickedBlock();

        if (block == null) {
            return;
        }

        if (LootboxPlugin.getLootboxManager().getRunningLootboxOpening().containsKey(player.getUniqueId())) {
            player.sendMessage("allready running");
            return;
        }

        if (block.getType().equals(Material.REDSTONE_BLOCK)) {
            event.setCancelled(true);
            final MoonCombinedActiveAnimation moonCombinedActiveAnimation = new MoonCombinedActiveAnimation(block.getLocation(), player);
            moonCombinedActiveAnimation.start(block.getLocation().clone().add(0.5, 0, 0.5));
            final LootboxManager lootboxManager = LootboxPlugin.getLootboxManager();
            lootboxManager.getRunningLootboxOpening().put(player.getUniqueId(), moonCombinedActiveAnimation);
        }

    }

    @EventHandler
    public static void onInteractAtEntity(final PlayerInteractAtEntityEvent event) {
        final Player player = event.getPlayer();


        if (!(event.getRightClicked() instanceof ArmorStand)) {
            player.sendMessage("leider kein armorstand. Kuh oder so...");
            return;
        }


        final CombinedActiveAnimation combinedActiveAnimation = LootboxPlugin.getLootboxManager().getRunningLootboxOpening().get(player.getUniqueId());
        final Animation animation = combinedActiveAnimation.getAnimations().get(combinedActiveAnimation.getCurrentAnimationPosition());

        if (!(animation instanceof HeadSpinActiveAnimation)) {
            return;
        }

        event.setCancelled(true);
        ((HeadSpinActiveAnimation) animation).finish();
    }

}