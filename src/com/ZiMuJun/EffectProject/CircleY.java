package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CircleY extends BukkitRunnable {
    private Player player;
    private int i=0,j=120,l=240;
    private Particle particle = Particle.CLOUD;
    private double y=0,y1=0,
            x=0,x1=0,x2=0,
            z=0,z1=0,z2=0,
            radians=0,
            radius;


    public CircleY(Player player, double radius,double y) {
        this.player = player;
        this.radius = radius;
        this.y = y;
    }

    public CircleY(Player player, double radius,double y,double y1) {
        this.player = player;
        this.radius = radius;
        this.y = y;
        this.y1 = y1;
    }

    public CircleY(Player player, double radius,double y,double y1,Particle particle) {
        this.player = player;
        this.radius = radius;
        this.y = y;
        this.y1 = y1;
        this.particle = particle;
    }

    @Override
    public void run() {
        if(y>0 && y1<y) {
            y-=0.3;
            if (y <= y1) {
                cancel();
            }
        }else if(y>=0 && y1>y) {
            y += 0.3;
            if (y >= y1) {
                cancel();
            }
        }

        radians = Math.toRadians(i);
        x = Math.sin(radians);
        z = Math.cos(radians);

        radians = Math.toRadians(j);
        x1 = Math.sin(radians);
        z1 = Math.cos(radians);

        radians = Math.toRadians(l);
        x2 = Math.sin(radians);
        z2 = Math.cos(radians);

        Location location = player.getLocation().add(x,y,z);
        location.getWorld().spawnParticle(particle,location,0,0.0D,0.0D,0.0D,0.0D);

        Location location1 = player.getLocation().add(x1,y,z1);
        location.getWorld().spawnParticle(particle,location1,0,0.0D,0.0D,0.0D,0.0D);

        Location location2 = player.getLocation().add(x2,y,z2);
        location.getWorld().spawnParticle(particle,location2,0,0.0D,0.0D,0.0D,0.0D);

        i+=10;
        j+=10;
        l+=10;
    }
}
