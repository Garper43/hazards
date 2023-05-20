package org.garper.plugins.hazards;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.garper.plugins.hazards.hazards.Cold;
import org.garper.plugins.hazards.hazards.Hazard;
import org.garper.plugins.hazards.hazards.SunRadiation;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Hazard[] hazards = {new SunRadiation(), new Cold()};
        BukkitScheduler scheduler = Bukkit.getScheduler();

        scheduler.runTaskTimer(this, () -> {
            Object[] playersArray = Bukkit.getOnlinePlayers().toArray();

            for(Object p : playersArray) {
                Player player = (Player) p;
                GameMode gameMode = player.getGameMode();

                if(gameMode == GameMode.CREATIVE || gameMode == GameMode.SPECTATOR) {
                    continue;
                }

                for(Hazard h : hazards) {
                    h.check((Player) p);
                }
            }

        }, 0L, Config.HAZARD_CHECK_FREQUENCY * 10L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
