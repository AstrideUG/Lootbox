package de.piinguiin.lootbox.prizes;

import de.piinguiin.lootbox.utils.item.ItemCreator;
import net.darkdevelopers.darkbedrock.darkness.general.functions.FormattingUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LootboxPrize {

    String displayName;
    ItemStack item;
    int amount;
    boolean money;
    int percent;
    private final LootboxPrizeRarity rarity;

    public LootboxPrize(final String displayName, @NotNull final ItemStack item, final int amount, final int percent, final LootboxPrizeRarity rarity) {
        this.displayName = displayName;
        this.item = item;
        this.amount = amount;
        this.money = item.getType().equals(Material.DOUBLE_PLANT);
        this.percent = percent;
        this.rarity = rarity;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isMoney() {
        return money;
    }

    public int getPercent() {
        return percent;
    }

    public LootboxPrizeRarity getRarity() {
        return rarity;
    }

    public void onWin(final Player player) {

        if (isMoney()) {
            //TODO add money to db
            player.sendMessage("lootbox.prize.win.money");
            return;
        }

        final ItemStack winItem = new ItemCreator().material(this.item.getType()).amount(this.amount).build();
        //TODO give item to player
        player.sendMessage("lootbox.prize.win.item");
    }

    public ItemStack getDisplayItem() {
        final ItemStack item;
        if (isMoney()) {
            item = new ItemCreator().material(Material.DOUBLE_PLANT).displayName("§e§l" + FormattingUtils.format(amount) + "$")
                    .build();
            return item;
        }
        item = new ItemCreator().material(this.item.getType()).displayName("§7§o" + amount + "x " + displayName).build();
        return item;
    }

    public static enum LootboxPrizeRarity {

        COMMON("Gewöhnlich", "gewöhnlichen", "§f"),
        UNCOMMON("Ungewöhnlich", "ungewöhnlichen", "§8"),
        RARE("Selten", "seltenen", "§9"),
        EPIC("Episch", "epischen", "§5"),
        LEGENDARY("Legendär", "legendären", "§6");

        private final String name;
        private final String adjective;
        private final String getColor;

        LootboxPrizeRarity(final String name, final String adjective, final String getColor) {
            this.name = name;
            this.adjective = adjective;
            this.getColor = getColor;
        }

        public String getAdjective() {
            return adjective;
        }

        public String getName() {
            return name;
        }

        public String getGetColor() {
            return getColor;
        }

        public static LootboxPrizeRarity getByClassName(final String className) {

            for (final LootboxPrizeRarity lootboxPrizeRarity : LootboxPrizeRarity.values()) {
                if (lootboxPrizeRarity.name.equalsIgnoreCase(className)) {
                    return lootboxPrizeRarity;
                }
            }
            return null;

        }

    }

}
