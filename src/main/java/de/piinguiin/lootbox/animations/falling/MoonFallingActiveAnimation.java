package de.piinguiin.lootbox.animations.falling;

import de.piinguiin.lootbox.animations.particle.SingleHelixParticleEffectAnimation;
import de.piinguiin.lootbox.api.AbstractActiveAnimation;
import de.piinguiin.lootbox.utils.item.SkullMaker;
import de.piinguiin.lootbox.utils.particle.ParticleBuilder;
import de.piinguiin.lootbox.utils.particle.colorable.ColoredParticle;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class MoonFallingActiveAnimation extends AbstractActiveAnimation implements FallingActiveAnimation {

    private final Vector vector;
    private final SingleHelixParticleEffectAnimation singleHelixParticleEffectAnimation;
    private final SingleHelixParticleEffectAnimation singleHelixParticleEffectAnimation2;
    private final Location center;
    private final ArmorStand little;

    public MoonFallingActiveAnimation(@NotNull final Location location, final int ticks, final int period) {
        super(location.subtract(0, 0.2, 0), ticks, period);
        this.center = currentLocation.clone().add(0.5, 1.1, 0.5);
        vector = new Vector(0, 0.1, 0);
        final double height = ticks * vector.getY();
        this.currentLocation = location.clone().add(0, height, 0);
        this.singleHelixParticleEffectAnimation = new SingleHelixParticleEffectAnimation(currentLocation, vector.getY(), 0.8, EnumParticle.CLOUD);
        this.singleHelixParticleEffectAnimation2 = new SingleHelixParticleEffectAnimation(currentLocation, vector.getY(), 0.8, EnumParticle.SPELL_WITCH);
        this.little = (ArmorStand) this.center.getWorld().spawnEntity(this.center.clone().subtract(0, 0.2, 0), EntityType.ARMOR_STAND);
        this.little.setGravity(false);
        this.little.setVisible(false);
        this.little.setSmall(true);
        final ItemStack littleHead = new SkullMaker().withSkinUrl("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622")
                .build();
        this.little.setHelmet(littleHead);
    }

    @Override
    public void start(@NotNull final Location location) {
        super.start(currentLocation);
    }

    @Override
    public void tick() {
        if (isAirDownwards()) {
            currentLocation.subtract(vector);
            this.singleHelixParticleEffectAnimation.onUpdate();
            this.singleHelixParticleEffectAnimation2.onUpdate();


            new ParticleBuilder(this.center.clone().add(0, 0.6, 0)).setEnumParticle(EnumParticle.FIREWORKS_SPARK)
                    .setAmount(1).setOffSet(0.05F, 0.05F, 0.05F).play();


            ColoredParticle.MOB_SPELL.send(this.center, 100, 255, 255, 255);
        } else finish();
    }

    @Override
    public void finish() {
        super.finish();
        this.little.remove();
    }

    private boolean isAirDownwards() throws NullPointerException {
        final Material type = currentLocation.getBlock().getRelative(BlockFace.DOWN).getType();
        return type.equals(Material.AIR);
    }

}
