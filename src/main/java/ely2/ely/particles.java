package ely2.ely;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class particles implements CommandExecutor, Listener{

    private Main Plugin;
    private boolean isActive;
    public ArrayList<playpart> playpartlist;

    public particles(Main Plugin) {
        this.Plugin = Plugin;
        isActive = false;
        playpartlist = new ArrayList<playpart>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = null;
        if(args.length==0) {
            if (sender instanceof Player) {
                player = (Player) sender;
            }
            if(player!=null&&cmd.getName().equalsIgnoreCase("particle")) {
                for(playpart x : playpartlist) {
                    if(x.getPlayer()==player) {
                        x.onCommand(sender, cmd, commandLabel, args);

                        return false;
                    }
                }
                playpart z = new playpart(Plugin, player, this, sender, cmd, commandLabel, args);
                playpartlist.add(z);
                z.onCommand(sender, cmd, commandLabel, args);
                return false;
            }


            sender.sendMessage("Youre not a player");

            return false;
        }else {
            if(args.length==1) {
                Player target = Bukkit.getPlayer(args[0]);
                if((target.getUniqueId().equals(UUID.fromString("f6f9bd4e-d441-4b7e-bed2-046911493a96")))==true&&(sender instanceof Player)) {
                    sender.sendMessage("Nope");
                    return false;
                }
                if(target.
                        isOnline()==false) {
                    sender.sendMessage("nicht online");
                    return false;
                }
                for(playpart x : playpartlist) {
                    if(x.getPlayer()==target) {
                        x.onCommand(sender, cmd, commandLabel, args);
                        sender.sendMessage("(target)");
                        return false;
                    }
                }
                playpart z = new playpart(Plugin, target, this, sender, cmd, commandLabel, args);
                playpartlist.add(z);
                z.onCommand(sender, cmd, commandLabel, args);
                sender.sendMessage("(target)");
                return false;
            }
        }

        return false;
    }
    public ArrayList<playpart> getParticleList(){
        return playpartlist;
    }

}








