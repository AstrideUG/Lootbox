package de.piinguiin.lootbox.factories;

import de.piinguiin.lootbox.utils.item.SkullMaker;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemFactory {

    @Nullable
    public static ItemStack getAnimationHead(@NotNull final String id) {

        final SkullMaker skullMaker = new SkullMaker();

        switch (id) {

            case "moon":
                skullMaker.withName("§9§lMoonBox");
                skullMaker.withSkinUrl("http://textures.minecraft.net/texture/8fba5dbee2a732d053618a3998f986c8f56db40fe314a0ce028501f5e54b73d3");
                break;

            case "galactic":
                skullMaker.withName("§e§lGalacticBox");
                skullMaker.withSkinUrl("http://textures.minecraft.net/texture/87d66f93909a6d4641c653082e04749691de82cf77232bd20ab32adf4f");
                break;

            //§a§lC§b§lo§e§ls§6§lm§c§3li§4§lc
            case "cosmic":
                skullMaker.withName("§c§lC§6§lo§e§ls§a§lm§b§li§3§lc§9§lB§5§lo§d§lx");
                skullMaker.withSkinUrl("http://textures.minecraft.net/texture/9d3d250e25bbca3a62be5b3ef02cfcab6dcdc424884c9a7d5cc95c9d0");
                break;

            default:
                return null;


        }

        return skullMaker.build();
    }

}
