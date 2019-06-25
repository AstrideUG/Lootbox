package de.piinguiin.lootbox.types;

import com.sun.istack.internal.Nullable;
import de.piinguiin.lootbox.api.Lootbox;
import de.piinguiin.lootbox.factories.LootboxFactory;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class LootboxManager {

    private HashMap<String, Lootbox> lootboxes;
    private HashMap<Lootbox, Player> runningLootboxOpening;

    public LootboxManager(){
        this.lootboxes = new HashMap<>();
        this.runningLootboxOpening = new HashMap<>();
        loadLootboxes();
    }

    private void loadLootboxes(){

        Lootbox moon = LootboxFactory.getLootboxFromGSON("Moon");
        Lootbox galactic = LootboxFactory.getLootboxFromGSON("Galatic");
        Lootbox cosmic = LootboxFactory.getLootboxFromGSON("Cosmic");

        this.lootboxes.put("Moon",moon);
        this.lootboxes.put("Galatic",galactic);
        this.lootboxes.put("Cosmic",cosmic);

    }

    public HashMap<String, Lootbox> getLootboxes() {
        return lootboxes;
    }

    @Nullable
    public Lootbox getLootbox(String id){
        return this.lootboxes.getOrDefault(id,null);
    }

    public void startLootbox(Lootbox lootbox, Player player){

        this.runningLootboxOpening.put(lootbox,player);

    }

    public void stopLootbox(Lootbox lootbox){
        this.runningLootboxOpening.remove(lootbox);
    }

}
