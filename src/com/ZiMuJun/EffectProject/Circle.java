package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import sun.plugin2.main.server.Plugin;

public class Circle extends BukkitRunnable {
    private float radius;
    private Location location;
    private Plugin plugin = null;
    private int time;
    private Particle particle = Particle.CLOUD;

    public Circle(float radius, Location location, int NTime)
    {
        this.radius = radius;
        this.location = location;
        this.time = NTime*20;
    }

    public Circle(float radius, Location location, int NTime,Particle particle)
    {
        this.radius = radius;
        this.location = location;
        this.time = NTime*20;
        this.particle = particle;
    }

    public Particle getParticle() {
        return particle;
    }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }

    @Override
    public void run()
    {
        if(time == 0)
        {
            cancel();  // 终止线程
        }
        // your code ...
        for (int i = 0; i < 360; i++)
        {
            if (i == 360)
            {
                return;
            }
            double radians = Math.toRadians(i);
            double x = Math.sin(radians) * radius;
            double z = Math.cos(radians) * radius;
            location.getWorld().spawnParticle(particle, location.clone().add(x, 0, z), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            i+=6;
        }
        this.time--;
    }
}
