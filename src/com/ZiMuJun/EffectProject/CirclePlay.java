package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CirclePlay extends BukkitRunnable {

    private Player player;
    private int i=0,
                v=1;
    private Particle particle = Particle.CLOUD;
    private double Time,
                    y=0,
                    x=0,
                    z=0,
                    radians=0,
                    radius=0;



    public CirclePlay(Player player, double time, double radius,double y) {
        this.player = player;
        this.Time = time*20;
        this.radius = radius;
        this.y = y;
    }

    public CirclePlay(Player player, double time, double radius,double y,Particle particle) {
        this.player = player;
        this.Time = time*20;
        this.radius = radius;
        this.y = y;
        this.particle = particle;
    }

    public CirclePlay(Player player, double time, double radius,double y,Particle particle,int v) {
        this.player = player;
        this.Time = time*20;
        this.radius = radius;
        this.y = y;
        this.particle = particle;
        this.v=v;
    }

    @Override
    public void run() {
        if(Time<=0){
            cancel();
        }
        if(v>1){
            for(int j=0;j<6;j++){
                radians = Math.toRadians(i)*v;
                x = Math.sin(radians)*radius;
                z = Math.cos(radians)*radius;
                i+= 6;
                Location location = player.getLocation().add(x, y, z);
                location.getWorld().spawnParticle(particle, location, 0, 0.0D, 0.0D, 0.0D, 0.0D);
            }
        }else {
            radians = Math.toRadians(i);
            x = Math.sin(radians) * radius;
            z = Math.cos(radians) * radius;
            Location location = player.getLocation().add(x, y, z);
            location.getWorld().spawnParticle(particle, location, 0, 0.0D, 0.0D, 0.0D, 0.0D);
            i+= 8;
        }

        Time--;
    }
}
