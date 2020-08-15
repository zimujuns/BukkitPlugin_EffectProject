package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class randomparticle extends BukkitRunnable {
    private Player player;
    private Particle particle;

    public randomparticle(Player player, Particle particle) {
        this.player = player;
        this.particle = particle;
    }

    @Override
    public void run() {
        Location location = player.getLocation();
    }
}
