package ely2.ely;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class playpart {

    private boolean isActive;
    private Main Plugin;
    private Player player;
    private particles part;
    public playpart(Main plugin, Player player, particles part,CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.Plugin=plugin;
        isActive = false;
        this.player=player;
        this.part=part;
    }
    public Player getPlayer() {
        return player;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public boolean isActive() {
        return isActive;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        World world = player.getWorld();
        if(isActive!=true) {
            isActive=true;
            sender.sendMessage("isActive true");
            new BukkitRunnable() {
                @Override
                public void run() {
                    if((isActive==true)&&(player.isOnline()==true)) {
                        int x = 5;
                        world.spawnParticle(Particle.FLAME, player.getLocation().getX(),player.getLocation().getY()+3,player.getLocation().getZ(), 10, 0.3, 0.3, 0.3, 0);
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));
                        world.spawnParticle(Particle.REDSTONE, player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(), x, 0.0, 0.0, 0.0, 0, new Particle.DustOptions(Color.PURPLE, 1));

                    }}}.runTaskTimer(Plugin, 0, 20);

        }else {
            isActive=false;
            sender.sendMessage("isActive false");
        }
        return false;
    }
}