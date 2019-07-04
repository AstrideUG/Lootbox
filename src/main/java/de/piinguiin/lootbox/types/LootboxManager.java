package de.piinguiin.lootbox.types;

import de.piinguiin.lootbox.api.Lootbox;
import de.piinguiin.lootbox.api.combined.CombinedActiveAnimation;
import de.piinguiin.lootbox.factories.LootboxFactory;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LootboxManager {

    private final Map<String, Lootbox> lootboxes;
    private final Map<UUID, CombinedActiveAnimation> runningCombinedAnimations;

    public LootboxManager() {
        this.lootboxes = new HashMap<>();
        this.runningCombinedAnimations = new HashMap<>();
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

    public Map<UUID, CombinedActiveAnimation> getRunningCombinedAnimations() {
        return runningCombinedAnimations;
    }
}
