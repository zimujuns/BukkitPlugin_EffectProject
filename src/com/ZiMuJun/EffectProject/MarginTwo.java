package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MarginTwo {
    private Plugin plugin;
    private Player player;
    private Location location;
    private Particle particle = Particle.CRIT_MAGIC;
    private int radius = 1;
    private int time=0;

    public MarginTwo(Plugin plugin, Player player,int time) {
        this.plugin = plugin;
        this.location = player.getLocation();
        this.time = time;
    }

    public MarginTwo(Plugin plugin, Player player,int time,Particle particle) {
        this.plugin = plugin;
        this.location = player.getLocation();
        this.time = time;
        this.particle = particle;
    }

    public MarginTwo(Plugin plugin, String location,int time,Particle particle) {
        this.plugin = plugin;
        this.location = Location.deserialize(StringToLocation.toLocation(location));
        this.time = time;
        this.particle = particle;
    }


    public void start(){
        System.out.println(location.toString());

        Line line = new Line(location.clone().add(6,0,3),location.clone().add(6,0,-3),time,particle);
        Line line1 = new Line(location.clone().add(3,0,6),location.clone().add(-3,0,6),time,particle);
        Line line2 = new Line(location.clone().add(-6,0,3),location.clone().add(-6,0,-3),time,particle);
        Line line3 = new Line(location.clone().add(-3,0,-6),location.clone().add(3,0,-6),time,particle);

        line.runTaskTimerAsynchronously( plugin,0L,1L);
        line1.runTaskTimerAsynchronously( plugin,0L,1L);
        line2.runTaskTimerAsynchronously( plugin,0L,1L);
        line3.runTaskTimerAsynchronously( plugin,0L,1L);

        Line lineA = new Line(location.clone().add(6,0,-3),location.clone().add(3,0,-6),time,particle);
        Line lineB = new Line(location.clone().add(6,0,3),location.clone().add(3,0,6),time,particle);
        Line lineC = new Line(location.clone().add(-3,0,6),location.clone().add(-6,0,3),time,particle);
        Line lineD = new Line(location.clone().add(-6,0,-3),location.clone().add(-3,0,-6),time,particle);

        lineA.runTaskTimerAsynchronously( plugin,0L,1L);
        lineB.runTaskTimerAsynchronously( plugin,0L,1L);
        lineC.runTaskTimerAsynchronously( plugin,0L,1L);
        lineD.runTaskTimerAsynchronously( plugin,0L,1L);

        Circle circle = new Circle(radius,location.clone().add(6,0,0),time,particle);
        Circle circle1 = new Circle(radius,location.clone().add(-6,0,0),time,particle);
        Circle circle2 = new Circle(radius,location.clone().add(0,0,6),time,particle);
        Circle circle3 = new Circle(radius,location.clone().add(0,0,-6),time,particle);
        Circle circle4 = new Circle(radius,location.clone().add(4.5,0,4.5),time,particle);
        Circle circle5 = new Circle(radius,location.clone().add(4.5,0,-4.5),time,particle);
        Circle circle6 = new Circle(radius,location.clone().add(-4.5,0,4.5),time,particle);
        Circle circle7 = new Circle(radius,location.clone().add(-4.5,0,-4.5),time,particle);

        circle.runTaskTimerAsynchronously(plugin,0L,1L);
        circle1.runTaskTimerAsynchronously(plugin,0L,1L);
        circle2.runTaskTimerAsynchronously(plugin,0L,1L);
        circle3.runTaskTimerAsynchronously(plugin,0L,1L);
        circle4.runTaskTimerAsynchronously(plugin,0L,1L);
        circle5.runTaskTimerAsynchronously(plugin,0L,1L);
        circle6.runTaskTimerAsynchronously(plugin,0L,1L);
        circle7.runTaskTimerAsynchronously(plugin,0L,1L);

        Line lineA2 = new Line(location.clone().add(4.5,0,4.5),location.clone().add(-6,0,0),time,particle);
        Line lineA3 = new Line(location.clone().add(4.5,0,-4.5),location.clone().add(-6,0,0),time,particle);
        lineA2.runTaskTimerAsynchronously( plugin,0L,1L);
        lineA3.runTaskTimerAsynchronously( plugin,0L,1L);

        Line lineB2 = new Line(location.clone().add(-4.5,0,-4.5),location.clone().add(6,0,0),time,particle);
        Line lineB3 = new Line(location.clone().add(-4.5,0,4.5),location.clone().add(6,0,0),time,particle);
        lineB2.runTaskTimerAsynchronously( plugin,0L,1L);
        lineB3.runTaskTimerAsynchronously( plugin,0L,1L);

        Line lineC2 = new Line(location.clone().add(-4.5,0,-4.5),location.clone().add(0,0,6),time,particle);
        Line lineC3 = new Line(location.clone().add(4.5,0,-4.5),location.clone().add(0,0,6),time,particle);
        lineC2.runTaskTimerAsynchronously( plugin,0L,1L);
        lineC3.runTaskTimerAsynchronously( plugin,0L,1L);

        Line lineD2 = new Line(location.clone().add(4.5,0,4.5),location.clone().add(0,0,-6),time,particle);
        Line lineD3 = new Line(location.clone().add(-4.5,0,4.5),location.clone().add(0,0,-6),time,particle);
        lineD2.runTaskTimerAsynchronously( plugin,0L,1L);
        lineD3.runTaskTimerAsynchronously( plugin,0L,1L);

    }
}
