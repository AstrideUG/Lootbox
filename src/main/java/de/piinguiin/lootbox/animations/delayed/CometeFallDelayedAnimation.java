package de.piinguiin.lootbox.animations.delayed;

import de.piinguiin.lootbox.LootboxPlugin;
import de.piinguiin.lootbox.animations.DelayedAnimation;
import de.piinguiin.lootbox.factories.ItemFactory;
import de.piinguiin.lootbox.utils.particle.colorable.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class CometeFallDelayedAnimation extends DelayedAnimation {

    private final int radius;
    private final Random random;

    public CometeFallDelayedAnimation(final Location location, final int periode, final int radius) {
        super(location, periode, false);
        this.radius = radius;
        this.random = new Random();
    }

    @Override
    public void action() {
        summonComete();
    }

    @Override
    public void end() {

    }

    private void summonComete() {

        final Location summon = location.clone().add(getRandomDouble(), 20, getRandomDouble());
        final Comete comete = new Comete(summon);
        comete.summon();

    }

    private double getRandomDouble() {

        double d = 0.3 + random.nextInt(radius) + random.nextDouble();

        if (random.nextBoolean()) {
            d = -d;
        }

        return d;
    }

    public static class Comete {

        private ArmorStand armorStand;
        private final Location location;

        public Comete(final Location location) {
            this.location = location;
        }

        public void summon() {
            final ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(this.location, EntityType.ARMOR_STAND);
            armorStand.setVisible(false);
            armorStand.setSmall(true);
            armorStand.setHelmet(ItemFactory.getComete());
            this.armorStand = armorStand;

            startTimer();
        }

        private void startTimer() {

            new BukkitRunnable() {

                @Override
                public void run() {

                    if ((!armorStand.getLocation().clone().subtract(0, 1, 0).getBlock().getType().equals(Material.AIR))) {
                        ParticleEffect.EXPLOSION_NORMAL.display(0, 0, 0, 0, 1, armorStand.getEyeLocation(), 100);
                        Bukkit.broadcastMessage(armorStand.getLocation().getBlock().getType().toString());
                        armorStand.remove();
                        Bukkit.broadcastMessage("removed");
                        cancel();
                    }

                }
            }.runTaskTimer(LootboxPlugin.getPlugin(), 0, 3);


        }


    }

}
