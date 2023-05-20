package org.garper.plugins.hazards.hazards;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;

public class Cold implements Hazard {
    ArrayList<Biome> coldBiomes = new ArrayList<>(Arrays.asList(
    Biome.SNOWY_PLAINS,
    Biome.ICE_SPIKES,
    Biome.SNOWY_TAIGA,
    Biome.SNOWY_BEACH,
    Biome.GROVE,
    Biome.SNOWY_SLOPES,
    Biome.JAGGED_PEAKS,
    Biome.FROZEN_PEAKS,
    Biome.FROZEN_RIVER,
    Biome.COLD_OCEAN,
    Biome.DEEP_COLD_OCEAN,
    Biome.FROZEN_OCEAN,
    Biome.DEEP_FROZEN_OCEAN
    ));

    @Override
    public boolean check(Player player) {
        if(!coldBiomes.contains(player.getLocation().getBlock().getBiome()) ||
            ((player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE) ||
            player.getLocation().getBlock().getLightFromBlocks() > 5)) {

            return false;
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 50, 1));

        return true;
    }

}
