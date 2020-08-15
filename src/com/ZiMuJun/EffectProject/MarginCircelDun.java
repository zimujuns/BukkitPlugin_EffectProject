package com.ZiMuJun.EffectProject;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MarginCircelDun {
    public Player player;
    public Plugin plugin;

    public MarginCircelDun(Player player, Plugin plugin) {
        this.player = player;
        this.plugin = plugin;
    }

    public void start(){
        Vector vector = player.getLocation().toVector();

    }

    class DunRun extends BukkitRunnable{

        @Override
        public void run() {

        }
    }
}
