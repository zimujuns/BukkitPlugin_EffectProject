package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PlayLine extends BukkitRunnable {

    private Player player;
    private double number;
    private int Time;

    public PlayLine(Player player, int number, int Time) {
        this.player = player;
        this.number = number;
        this.Time = Time*20;
    }

    @Override
    public void run() {

        if(Time == 0){
            cancel();
        }

        Location loc = player.getLocation();
        loc.add(0,1,0);
        Vector vector = loc.getDirection();
        vector.add(vector);
        for(int i=0;i<number;i++){
            loc.add(vector);
            loc.getWorld().spawnParticle(Particle.CLOUD,loc,0,0.0D,0.0D,0.0D,0.0D);
        }
        Time--;
    }
}

