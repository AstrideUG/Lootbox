package de.piinguiin.lootbox.animations.events;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.animations.combined.MoonCombinedActiveAnimation;
import de.piinguiin.lootbox.animations.headspin.HeadSpinActiveAnimation;
import de.piinguiin.lootbox.api.Animation;
import de.piinguiin.lootbox.api.Lootbox;
import de.piinguiin.lootbox.api.combined.CombinedActiveAnimation;
import net.darkdevelopers.darkbedrock.darkness.spigot.listener.Listener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
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

        if (block.getType().equals(Material.REDSTONE_BLOCK)) {
            event.setCancelled(true);
            player.sendMessage("staaaaaaaaaaaaaaart");
            final MoonCombinedActiveAnimation moonCombinedActiveAnimation = new MoonCombinedActiveAnimation(block.getLocation(), player);
            Bukkit.broadcastMessage(moonCombinedActiveAnimation.toString());
            moonCombinedActiveAnimation.start(block.getLocation().clone().add(0.5, 0, 0.5));
        }

    }

    @EventHandler
    public static void onInteractAtEntity(final PlayerInteractAtEntityEvent event) {
        final Player player = event.getPlayer();

        final Lootbox lootbox = LootboxPlugin.getLootboxManager().getRunningLootboxOpening().get(player);
        final CombinedActiveAnimation combinedActiveAnimation = lootbox.getCombinedActiveAnimation();
        final Animation animation = combinedActiveAnimation.getAnimations().get(combinedActiveAnimation.getCurrentAnimationPosition());

        if (!(animation instanceof HeadSpinActiveAnimation)) {
            return;
        }

        player.sendMessage("is headspin animation");
        ((HeadSpinActiveAnimation) animation).finish();
    }

}
