package de.piinguiin.lootbox.api.headable;

import de.piinguiin.lootbox.LootboxPlugin;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class HeadableUtils {

    @Nullable
    public static ArmorStand spawnArmorStand(final Location location, final ItemStack head) {
        final Entity entity = location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        if (!(entity instanceof ArmorStand)) {
            LootboxPlugin.getPlugin().getLogger().warning("Spawned entity is not an instance of armorstand!");
            return null;
        }
        final ArmorStand armorStand = (ArmorStand) entity;
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setHelmet(head);
        return armorStand;
    }

}
