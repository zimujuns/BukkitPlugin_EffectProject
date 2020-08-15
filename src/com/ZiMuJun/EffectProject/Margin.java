package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Margin {
    private Location location;
    private Plugin plugin;
    private Player player;
    private Particle particle = Particle.CLOUD;
    private double y;
    public Margin(Plugin plugin, Player player,Particle particle,double y) {
        this.plugin = plugin;
        this.location = player.getLocation();
        this.particle = particle;
        this.y = y;
    }

    public Margin(Plugin plugin,String Location,Particle particle,double y) {
        this.plugin = plugin;
        this.location.deserialize(StringToLocation.toLocation(Location));
        this.particle = particle;
        this.y = y;
    }

    public void start(){
        Circle circle = new Circle(3,location.add(0,y,0),1,particle);

        circle.runTaskTimerAsynchronously(plugin,0L,1L);

        Line line = new Line(location.clone().add(4,y,0),location.clone().add(0,y,-4),1,particle);
        Line line1 = new Line(location.clone().add(4,y,0),location.clone().add(0,y,4),1,particle);
        Line line2 = new Line(location.clone().add(-4,y,0),location.clone().add(0,y,-4),1,particle);
        Line line3 = new Line(location.clone().add(-4,y,0),location.clone().add(0,y,4),1,particle);

        Line lineA = new Line(location.clone().add(2.7,y,2.7),location.clone().add(2.7,y,-2.7),1,particle);
        Line lineA1 = new Line(location.clone().add(2.7,y,2.7),location.clone().add(-2.7,y,2.7),1,particle);
        Line lineA2 = new Line(location.clone().add(-2.7,y,-2.7),location.clone().add(2.7,y,-2.7),1,particle);
        Line lineA3 = new Line(location.clone().add(-2.7,y,-2.7),location.clone().add(-2.7,y,2.7),1,particle);


        line.runTaskTimerAsynchronously(plugin,0L,1L);
        line1.runTaskTimerAsynchronously(plugin,0L,1L);
        line2.runTaskTimerAsynchronously(plugin,0L,1L);
        line3.runTaskTimerAsynchronously(plugin,0L,1L);

        lineA.runTaskTimerAsynchronously(plugin,0L,1L);
        lineA1.runTaskTimerAsynchronously(plugin,0L,1L);
        lineA2.runTaskTimerAsynchronously(plugin,0L,1L);
        lineA3.runTaskTimerAsynchronously(plugin,0L,1L);


    }
}
