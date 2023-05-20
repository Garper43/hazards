package org.garper.plugins.hazards.hazards;

import org.bukkit.entity.Player;

public interface Hazard {
    boolean check(Player player);
}
