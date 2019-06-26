package de.piinguiin.lootbox.prizes;

import de.piinguiin.lootbox.utils.item.ItemCreator;
import net.darkdevelopers.darkbedrock.darkness.general.functions.FormattingUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LootboxPrize {

    String displayName;
    ItemStack item;
    int amount;
    boolean money;
    int percent;

    public LootboxPrize(final String displayName, final ItemStack item, final int amount, final boolean money, final int percent) {
        this.displayName = displayName;
        this.item = item;
        this.amount = amount;
        this.money = money;
        this.percent = percent;
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
}
