package org.garper.plugins.hazards.hazards;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SunRadiation implements Hazard {

    @Override
    public boolean check(Player player) {
        if(player.getLocation().getBlock().getLightFromSky() < 15 ||
            (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().getType() == Material.CARVED_PUMPKIN)) {

            return false;
        }

        player.damage(1);

        return true;
    }

}
