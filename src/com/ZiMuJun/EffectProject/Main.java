package com.ZiMuJun.EffectProject;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {
    private Location locA;
    private Location locB;

    @Override
    public void onLoad() {
        super.onLoad();
        System.out.println("onLoad effect");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("onEnable effect");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
//        new PlayerPhysicalRecovery().runTaskTimerAsynchronously(this,0L,3L);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        super.onCommand(sender, command, label, args);
        if(sender instanceof Player){
            if(label.equalsIgnoreCase("ZM")) {
                Player player = (Player) sender;
                if(args.length==0||args==null){
                    sendHelp(player,0);
                    return false;
                }
                if (!player.isOnline()) {
                    return false;
                }


                if (!player.hasPermission("Effect.use")) {
                    player.sendMessage("Effect:你当前没有权限");
                } else {
                    Location loc = player.getLocation().clone();
                    if (args[0].equals("TwoCircleRunnable")) {
                        float radius = Float.parseFloat(args[1]);
                        circleRunnable(radius, loc);
                        circleRunnable(-radius, loc);
                        return true;
                    } else if (args[0].equals("Circle")) {
                        float radius = Integer.parseInt(args[1]);
                        int NTime = Integer.parseInt(args[2]);
                        Circle circle = new Circle(radius, loc, NTime);
                        circle.runTaskTimerAsynchronously(this, 0L, 1L);
                        return true;
                    } else if (args[0].equalsIgnoreCase("Line")) {
                        if(args.length > 2){
                            Line line = new Line(locA,locB,Integer.parseInt(args[1]),Particle.valueOf(args[2]));
                            line.runTaskTimerAsynchronously(this,0L,1L);
                            return true;
                        }
                        Line line = new Line(locA,locB,Integer.parseInt(args[1]));
                        line.runTaskTimerAsynchronously(this,0L,1L);
                        player.sendMessage("你执行了Line");
                        return true;
                    } else if (args[0].equalsIgnoreCase("locA")) {
                        this.locA = player.getLocation();
                        player.sendMessage("你设定了LocA");
                        return true;
                    } else if (args[0].equalsIgnoreCase("locB")) {
                        this.locB = player.getLocation();
                        player.sendMessage("你设定了LocB");
                        return true;
                    }else if(args[0].equalsIgnoreCase("LinePlay")) {
                        if (args.length < 2) {
                            player.sendMessage("请输入长度 和 时间");
                            return false;
                        }
                        PlayLine playLine = new PlayLine(player, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                        playLine.runTaskTimerAsynchronously(this, 0L, 1L);
                        player.sendMessage("你触发了特效");
                        return true;
                    }else if(args[0].equalsIgnoreCase("MarginDun")) {
                        MarginDun marginDun = new MarginDun(player, this,Particle.CRIT_MAGIC);
                        marginDun.start();
                        player.sendMessage("你触发了特效");
                        return true;
                    }else if(args[0].equalsIgnoreCase("Margin")) {
                        if(args.length == 3){
                            Margin margin = new Margin(this, args[1],Particle.valueOf(args[2]),Double.parseDouble(args[3]));
                            margin.start();
                            return true;
                        }
                        Margin margin = new Margin(this, player,Particle.ENCHANTMENT_TABLE,2);
                        margin.start();
                        return true;
                    }else if(args[0].equalsIgnoreCase("Ling")) {
                        Ling ling = new Ling(this, player);
                        ling.start();
                        return true;
                    }else if(args[0].equalsIgnoreCase("MarginTwo")) {
                        if(args.length==3){
                            MarginTwo marginTwo = new MarginTwo(this, player,Integer.parseInt(args[1]),Particle.valueOf(args[2]));
                            marginTwo.start();
                            return true;
                        }else if(args.length==4){
                            MarginTwo marginTwo = new MarginTwo(this, args[1],Integer.parseInt(args[2]),Particle.valueOf(args[3]));
                            marginTwo.start();
                            return true;
                        }else if(args.length>4){
                            player.sendMessage(" 输入时间\n 输入Location转string的字符串 时间 和 粒子");
                            return false;
                        }
                        MarginTwo marginTwo = new MarginTwo(this, player,Integer.parseInt(args[1]));
                        marginTwo.start();
                        return true;
                    } else if(args[0].equalsIgnoreCase("Help")) {
                        if(args[1] == null) {
                            sendHelp(player, 0);
                            return true;
                        }
                        sendHelp(player, Integer.parseInt(args[1]));
                        return true;
                    }else if(args[0].equalsIgnoreCase("CirclePlay")) {
                        if(args.length<4){
                            player.sendMessage(" 输入时间 和 宽度 y轴\n 输入时间 和 宽度 y轴 粒子");
                            return false;
                        }else if(args.length==5){
                            CirclePlay circlePlay = new CirclePlay(player, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]),Particle.valueOf(args[4]));
                            circlePlay.runTaskTimerAsynchronously(this,0L,1L);
                            return true;
                        }

                        CirclePlay circlePlay = new CirclePlay(player, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]));
                        circlePlay.runTaskTimerAsynchronously(this, 0L, 1L);
                        player.sendMessage("你触发了特效");
                        return true;
                    }else if(args[0].equalsIgnoreCase("CircleY")) {
                        if (args.length < 3) {
                            player.sendMessage(" 输入半径 和 高度 [从头向下]\n 输入半径 和 起始点 终点[起始->终点] \n 输入半径 起始点 终点 特效名[指定特效 起始->终点]");
                            return false;
                        } else if (args.length == 4) {
                            CircleY circleY = new CircleY(player, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                            circleY.runTaskTimerAsynchronously(this, 0L, 1L);
                            return true;
                        } else if (args.length == 5) {
                            CircleY circleY = new CircleY(player, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Particle.valueOf(args[4]));
                            circleY.runTaskTimerAsynchronously(this, 0L, 1L);
                            return true;
                        } else if (args.length > 5) {
                            player.sendMessage(" 输入半径 和 高度 [从头向下]\n 输入半径 和 起始点 终点[起始->终点] \n 输入半径 起始点 终点 特效名[指定特效 起始->终点]");
                            return false;
                        }
                        CircleY circleY = new CircleY(player, Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                        circleY.runTaskTimerAsynchronously(this, 0L, 1L);
                        return true;

                    }else if(args[0].equalsIgnoreCase("bate")) {
                        if (args.length > 4) {
                            VectorCircle vectorCircle = new VectorCircle(player, Double.parseDouble(args[1]),Double.parseDouble(args[2]), Particle.valueOf(args[3]),Boolean.valueOf(args[4]));
                            vectorCircle.Main();
                            return true;
                        }else if(args.length > 3){
                            VectorCircle vectorCircle = new VectorCircle(player, Double.parseDouble(args[1]), Particle.valueOf(args[2]));
                            vectorCircle.setY(Double.parseDouble(args[3]));
                            vectorCircle.Main();
                            return true;
                        }
                        VectorCircle vectorCircle = new VectorCircle(player, 1);
                        vectorCircle.Main();
                        return true;
                    }else if(args[0].equalsIgnoreCase("circleMaxPlay")){
                        CirclePlay circlePlay = new CirclePlay(player, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]),Particle.valueOf(args[4]),Integer.parseInt(args[5]));
                        circlePlay.runTaskTimerAsynchronously(this,0L, 1L);
                    }else{
                        sendHelp(player,0);
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void circleRunnable(final float radius, Location location){
        new BukkitRunnable(){
            int i=0;
            public void run() {
                if (this.i==360) {
                    cancel();
                }
                double radians = Math.toRadians(this.i);
                double x = Math.sin(radians)*radius;
                double z = Math.cos(radians)*radius;
                location.getWorld().spawnParticle(Particle.CLOUD,location.clone().add(x,0,z),2,0.0D,0.0D,0.0D,0.0D);
                this.i+=2;
            }
        }.runTaskTimerAsynchronously(this,0L,1L);
    }


    public void sendHelp(Player player,int number) {
        switch (number){
            case 0:
                player.sendMessage("§a§l/ZM help [number]（0-1）  【0】");
                player.sendMessage("§6=============[§a§leffect§6]=============");
                player.sendMessage("§a§l/ZM TwoCircleRunnable [r]");
                player.sendMessage("§6两个点旋转第三个参数:半径");
                player.sendMessage("");
                player.sendMessage("§a§l/ZM Circle [r] [t]");
                player.sendMessage("§6一个圆 第三个参数:半径 第四个参数:持续时间");
                player.sendMessage("");
                player.sendMessage("§a§l/ZM Line 连接LocA 和 LocB /ZM LocA,/ZM LocB 来设置Loc");
                player.sendMessage("§6玩家面向的线 长度 时间");
                player.sendMessage("");
                player.sendMessage("§a§l/ZM LinePlay [r] [t]");
                player.sendMessage("§6玩家面向的线 长度 时间");
                player.sendMessage("§6=============[§a§leffect§6]=============");
                break;
            case 1:
                player.sendMessage("§a§l/ZM help [number]（1-2）  【1】");
                player.sendMessage("§6=============[§a§leffect§6]=============");
                player.sendMessage("§a§l/ZM Margin");
                player.sendMessage("§6一个魔法阵");
                player.sendMessage("");
                player.sendMessage("§a§l/ZM MarginTwo");
                player.sendMessage("§6一个魔法阵");
                player.sendMessage("");
                player.sendMessage("§a§l/ZM MarginDun");
                player.sendMessage("§6一个盾牌的粒子特效");
                player.sendMessage("");
                player.sendMessage("§a§l/ZM Ling");
                player.sendMessage("§6一个菱形魔法的粒子特效");
                player.sendMessage("§6=============[§a§leffect§6]=============");
                break;
        }

    }



}

