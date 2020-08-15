package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Locale;

public class MarginDun {
    //护盾特效
    private Plugin plugin;
    private Location location;
    private double y;
    private Particle particle = Particle.CLOUD;
    public MarginDun(Player player, Plugin plugin){
        this.location = player.getLocation();
        this.plugin = plugin;
    }

    public MarginDun(Player player, Plugin plugin, Particle particle){
        this.location = player.getLocation();
        this.plugin = plugin;
        this.particle = particle;
    }

    public MarginDun(String location, Plugin plugin, Particle particle){
        this.location.deserialize(StringToLocation.toLocation(location));
        this.plugin = plugin;
        this.particle = particle;
    }

    public void start(){
        Line line = new Line(location.clone().add(2,y,4),location.clone().add(4,y,0),1,particle);
        Line line1 = new Line(location.clone().add(2,y,-4),location.clone().add(4,y,0),1,particle);
        Line line2 = new Line(location.clone().add(-3,y,-2),location.clone().add(2,y,-4),1,particle);
        Line line3 = new Line(location.clone().add(-3,y,2),location.clone().add(2,y,4),1,particle);
        Line line4 = new Line(location.clone().add(-4,y,0),location.clone().add(-3,y,-2),1,particle);
        Line line5 = new Line(location.clone().add(-4,y,0),location.clone().add(-3,y,2),1,particle);

        line.runTaskTimerAsynchronously(plugin,0L,1L);
        line1.runTaskTimerAsynchronously(plugin,0L,1L);
        line2.runTaskTimerAsynchronously(plugin,0L,1L);
        line3.runTaskTimerAsynchronously(plugin,0L,1L);
        line4.runTaskTimerAsynchronously(plugin,0L,1L);
        line5.runTaskTimerAsynchronously(plugin,0L,1L);
    }

}
