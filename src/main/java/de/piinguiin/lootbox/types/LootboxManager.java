package de.piinguiin.lootbox.types;

import de.piinguiin.lootbox.api.Lootbox;
import de.piinguiin.lootbox.factories.LootboxFactory;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class LootboxManager {

    private final Map<String, Lootbox> lootboxes;
    private final Map<Player, Lootbox> runningLootboxOpening;

    public LootboxManager() {
        this.lootboxes = new HashMap<>();
        this.runningLootboxOpening = new HashMap<>();
        loadLootboxes();
    }

    private void loadLootboxes() {

        final Lootbox moon = LootboxFactory.getLootboxFromGSON("Moon");
        final Lootbox galactic = LootboxFactory.getLootboxFromGSON("Galatic");
        final Lootbox cosmic = LootboxFactory.getLootboxFromGSON("Cosmic");

        this.lootboxes.put("Moon", moon);
        this.lootboxes.put("Galatic", galactic);
        this.lootboxes.put("Cosmic", cosmic);

    }

    public Map<String, Lootbox> getLootboxes() {
        return lootboxes;
    }

    @Nullable
    public Lootbox getLootbox(final String id) {
        return this.lootboxes.getOrDefault(id, null);
    }

    public Map<Player, Lootbox> getRunningLootboxOpening() {
        return runningLootboxOpening;
    }
}
