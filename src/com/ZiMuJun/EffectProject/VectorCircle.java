package com.ZiMuJun.EffectProject;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static java.lang.Math.cos;
import static java.lang.Math.toRadians;
import static java.lang.StrictMath.sin;

public class VectorCircle extends BukkitRunnable {
    private Player p;
    private double r;
    private double y=-2;
    private double angle = 360;
    private double num = 8;
    private Boolean isw = false;
    Particle particle;

    /**
     * 这个是用来绘制平A的攻击范围的粒子
     * 用于： 被动大剑术-测试 特效
     * 用于：剑刃风暴 特效
     * @param p
     * @param r
     * @param angle
     * @param particle
     * @param isw
     */
    public VectorCircle(Player p, double r, double angle, Particle particle,Boolean isw) {
        this.p = p;
        this.r = r;
        this.angle = angle;
        this.particle = particle;
        this.isw = isw;
    }

    public VectorCircle(Player player, double r, Particle particle) {
        this.p = player;
        this.r = r;
        this.particle = particle;
    }

    public VectorCircle(Player player,double r) {
        this.p = player;
        this.r = r;
        this.particle = Particle.REDSTONE;
    }

    public void Main(){

        if(angle<360){
            if(!isw){
                for (int i = 0; i < angle; i += num) {
                    double angle = java.lang.Math.toRadians(i);
                    double x = r * cos(angle);
                    double z = r * sin(angle);
                    //控制距离 负号玩家正面 加号玩家背面
                    Vector v = new Vector(x, 0, z);
                    Vector v2 = new Vector(v.getX(), v.getY(), v.getZ());
                    rotateAroundAxisY(v2, p.getLocation().getYaw());
                    Location loc = p.getLocation().add(v2.getX()+1, v2.getY()+(0.01*i), v2.getZ());
                    p.spawnParticle(particle, loc,2,0.0D,0.0D,0.0D,0.0D);
                }
                return;
            }else{
                double a = 1.8;
                for (int i = 0; i < angle; i += num) {
                    double angle = java.lang.Math.toRadians(i);
                    double x = r * cos(angle);
                    double z = r * sin(angle);
                    //控制距离 负号玩家正面 加号玩家背面
                    Vector v = new Vector(x, 0, z);
                    Vector v2 = new Vector(v.getX(), v.getY(), v.getZ());
                    rotateAroundAxisY(v2, p.getLocation().getYaw());
                    Location loc = p.getLocation().add(v2.getX()+1, v2.getY()+(a-(0.01*i)), v2.getZ());
                    p.spawnParticle(particle, loc,2,0.0D,0.0D,0.0D,0.0D);
                }
                return;
            }

        }
        for (int i = 0; i < angle; i += 8) {
            double angle = java.lang.Math.toRadians(i);
            double x = r * cos(angle);
            double z = r * sin(angle);
            //控制距离 负号玩家正面 加号玩家背面
            Vector v0 = new Vector(x, y, z);
            rotateAroundAxisX(v0, 90);
            Vector v01 = new Vector(v0.getX(), v0.getY(), v0.getZ());
            rotateAroundAxisX(v01, -90);
            Vector v = new Vector(v01.getX(), v01.getY(), v01.getZ());
            rotateAroundAxisX(v, p.getLocation().getPitch() - 90);
            Vector v2 = new Vector(v.getX(), v.getY(), v.getZ());
            rotateAroundAxisY(v2, p.getLocation().getYaw());
            Location loc = p.getLocation().add(v2.getX(), v2.getY()+1.5, v2.getZ());
            p.spawnParticle(particle, loc,2,0.0D,0.0D,0.0D,0.0D);
        }
    }

    @Override
    public void run() {
        Main();
    }

    public static Vector rotateAroundAxisX(Vector v, double angle) {
        angle = toRadians(angle);
        double y, z, cos, sin;
        cos = cos(angle);
        sin = sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    public static Vector rotateAroundAxisY(Vector v, double angle) {
        angle = -angle;
        angle = toRadians(angle);
        double x, z, cos, sin;
        cos = cos(angle);
        sin = sin(angle);
        x = v.getX() * cos + v.getZ() * sin;
        z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    public static Vector rotateAroundAxisZ(Vector v, double angle) {
        angle = toRadians(angle);
        double y, x, cos, sin;
        cos = cos(angle);
        sin = sin(angle);
        y = v.getY() * cos - v.getX() * sin;
        x = v.getY() * sin + v.getX() * cos;
        return v.setY(y).setX(x);
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setY(double y) {
        this.y = -y;
    }
}
