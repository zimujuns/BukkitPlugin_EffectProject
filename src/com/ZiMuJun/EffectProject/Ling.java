package com.ZiMuJun.EffectProject;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Ling {
    private Plugin plugin;
    private Player player;

    private Particle particle = Particle.CLOUD;

    public Particle getParticle() {
        return particle;
    }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }

    public Ling(Plugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    public Ling(Plugin plugin, Player player,Particle particle) {
        this.plugin = plugin;
        this.player = player;
        this.particle = particle;
    }

    public void start(){
        //前
        Line line = new Line(player.getLocation().add(7,0,0),player.getLocation().add(3,0,1),1, particle);
        Line line1 = new Line(player.getLocation().add(7,0,0),player.getLocation().add(3,0,-1),1, particle);
        //后
        Line line2 = new Line(player.getLocation().add(-7,0,0),player.getLocation().add(-3,0,1),1, particle);
        Line line3 = new Line(player.getLocation().add(-7,0,0),player.getLocation().add(-3,0,-1),1, particle);
        //左
        Line line4 = new Line(player.getLocation().add(0,0,7),player.getLocation().add(1,0,3),1, particle);
        Line line5 = new Line(player.getLocation().add(0,0,7),player.getLocation().add(-1,0,3),1, particle);
        //右
        Line line6 = new Line(player.getLocation().add(0,0,-7),player.getLocation().add(1,0,-3),1, particle);
        Line line7 = new Line(player.getLocation().add(0,0,-7),player.getLocation().add(-1,0,-3),1, particle);


        Line lineA = new Line(player.getLocation().add(-3,0,1),player.getLocation().add(-1,0,3),1, particle);
        Line lineA1 = new Line(player.getLocation().add(3,0,1),player.getLocation().add(1,0,3),1, particle);
        Line lineA2 = new Line(player.getLocation().add(1,0,-3),player.getLocation().add(3,0,-1),1, particle);
        Line lineA3 = new Line(player.getLocation().add(-1,0,-3),player.getLocation().add(-3,0,-1),1, particle);

        Circle circle = new Circle(5,player.getLocation(),1,particle);


        line.runTaskTimerAsynchronously( plugin,0L,1L);
        line1.runTaskTimerAsynchronously( plugin,0L,1L);
        line2.runTaskTimerAsynchronously( plugin,0L,1L);
        line3.runTaskTimerAsynchronously( plugin,0L,1L);
        line4.runTaskTimerAsynchronously( plugin,0L,1L);
        line5.runTaskTimerAsynchronously( plugin,0L,1L);
        line6.runTaskTimerAsynchronously( plugin,0L,1L);
        line7.runTaskTimerAsynchronously( plugin,0L,1L);

        lineA.runTaskTimerAsynchronously(plugin,0L,1L);
        lineA1.runTaskTimerAsynchronously(plugin,0L,1L);
        lineA2.runTaskTimerAsynchronously(plugin,0L,1L);
        lineA3.runTaskTimerAsynchronously(plugin,0L,1L);

        circle.runTaskTimerAsynchronously(plugin,0L,1L);
    }
}
