package de.piinguiin.lootbox.animations.listeners;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.animations.headspin.HeadSpinActiveAnimation;
import de.piinguiin.lootbox.animations.headspin.TestRun;
import de.piinguiin.lootbox.api.Animation;
import de.piinguiin.lootbox.api.combined.CombinedActiveAnimation;
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

        if (LootboxPlugin.getLootboxManager().getRunningCombinedAnimations().containsKey(player.getUniqueId())) {
            player.sendMessage("allready running");
            return;
        }

        if (block.getType().equals(Material.COBBLE_WALL)) {
            event.setCancelled(true);
            /*
            final LootboxPrize prize = new LootboxPrize("§6§lToller Gewinn", new ItemStack(Material.BOOK), 1, 100, LootboxPrize.LootboxPrizeRarity.RARE);
            final MoonCombinedActiveAnimation moonCombinedActiveAnimation = new MoonCombinedActiveAnimation(block.getLocation(), player, prize);
            moonCombinedActiveAnimation.start(block.getLocation().clone().add(0.5, 0, 0.5));
            final LootboxManager lootboxManager = LootboxPlugin.getLootboxManager();
            lootboxManager.getRunningCombinedAnimations().put(player.getUniqueId(), moonCombinedActiveAnimation);


            final LootboxPrize prize = new LootboxPrize("§6§lBuch", new ItemStack(Material.BOOK), 1, 100, LootboxPrize.LootboxPrizeRarity.LEGENDARY);
            final GalacticCombinedActiveAnimation galacticCombinedActiveAnimation = new GalacticCombinedActiveAnimation(block.getLocation(), player, prize);
            galacticCombinedActiveAnimation.start(block.getLocation().clone().add(0.5, 0, 0.5));
            final LootboxManager lootboxManager = LootboxPlugin.getLootboxManager();
            lootboxManager.getRunningCombinedAnimations().put(player.getUniqueId(), galacticCombinedActiveAnimation);
*/

            new TestRun(block.getLocation().clone().add(0.5, 1, 0.5)) {

            }.runTaskTimer(LootboxPlugin.getPlugin(), 0, 1);

        }

    }

    @EventHandler
    public static void onInteractAtEntity(final PlayerInteractAtEntityEvent event) {
        final Player player = event.getPlayer();


        if (!(event.getRightClicked() instanceof ArmorStand)) {
            player.sendMessage("leider kein armorstand. Kuh oder so...");
            return;
        }

        if (!(event.getRightClicked() instanceof ArmorStand)) {
            return;
        }

        event.setCancelled(true);
        final CombinedActiveAnimation combinedActiveAnimation = LootboxPlugin.getLootboxManager().getRunningCombinedAnimations().get(player.getUniqueId());
        final Animation animation = combinedActiveAnimation.getAnimations().get(combinedActiveAnimation.getCurrentAnimationPosition());

        if (!(animation instanceof HeadSpinActiveAnimation)) {
            return;
        }

        event.setCancelled(true);
        ((HeadSpinActiveAnimation) animation).finish();
    }

}
