package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Line extends BukkitRunnable {
    private Location locationA;
    private Location locationB;
    private Particle particle = Particle.CLOUD;
    private int Time;

    public Line(Location locationA, Location locationB,int Time) {
        this.locationA = locationA;
        this.locationB = locationB;
        this.Time = Time*20;
    }
    public Line(Location locationA, Location locationB,int Time,Particle particle) {
        this.locationA = locationA;
        this.locationB = locationB;
        this.Time = Time*20;
        this.particle = particle;
    }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }

    public Particle getParticle(){
        return particle;
    }

    @Override
    public void run() {
        if(Time == 0){
            cancel();
        }
        Vector vectorAB = locationB.clone().subtract(locationA).toVector();
        double vector_length = vectorAB.length();
        //向量长度
        vectorAB.normalize();
        //向量单位
        for(double i=0D;i<vector_length;i+=0.5){
            Vector vector = (Vector) vectorAB.clone().multiply(i);
            locationA.add(vector);
//            locationA.getWorld().spawnParticle(particle,locationA,1,0.0D,0.0D,0.0D,0.0D);
            locationA.getWorld().spawnParticle(Particle.REDSTONE, locationA, 0, 0.001, 0, 0, 1);
            locationA.subtract(vector);
        }
        this.Time--;
    }
}
