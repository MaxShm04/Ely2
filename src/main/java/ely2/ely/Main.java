package ely2.ely;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin implements Listener {

    private particles Particles;
    //	private tp tp;
    private ec ec;
    private Stick stick;
    private Main plugin;
    //private mining mining;
    private ely2.ely.SpawnElyListener listen;
    private int[] undo;
    private int lastC;

    public static void main(String[] args) {

    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.getLogger().info("Your plugin has been enabled!");
        plugin = this;
        listen = new ely2.ely.SpawnElyListener(this);
        Particles = new particles(this);
        getCommand("particle").setExecutor(Particles);
        ec = new ec(this);
        getCommand("test").setExecutor(ec);
        stick = new Stick(plugin);
        undo = new int[3];
        lastC = 0;              //ElySpawn
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Your plugin has been disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }
        if (cmd.getName().equalsIgnoreCase("uuid")) {
            if (args.length == 1) {
                if (this.getServer().getPlayer(args[0]) != null) {
                    sender.sendMessage(this.getServer().getPlayer(args[0]).getUniqueId().toString());
                    return true;
                }
            }
            if (args.length == 0) {
                if (player != null) {
                    sender.sendMessage(player.getUniqueId().toString());
                    return true;
                }
            }

        }

        if (cmd.getName().equalsIgnoreCase("basic")) { // Wenn der Spieler /basic eingegeben hat, dann mache das folgende...
            // tue etwas...
            if (player != null) {
                ItemStack i = new ItemStack(Material.STICK);
                ItemMeta m = i.getItemMeta();
                m.setDisplayName("Menu");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(ChatColor.GOLD + "Dont loose!");
                m.setLore(lore);
                m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                i.setItemMeta(m);
                player.getInventory().addItem(i);
                return false;

            } else {
                sender.sendMessage("type /help to see the commands!");// tue irgendwas anderes...

            }
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("spawnpos1")) {
            if (args.length == 3) {
                listen.setSpawnPos1(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                undo = new int[]{Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
                sender.sendMessage(undo[0] + " " + undo[1] + " " + undo[2]);
                lastC = 1;
                return true;
            }
            if (args.length == 0 && sender instanceof Player) {
                listen.setSpawnPos1(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
                undo = new int[]{player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()};
                sender.sendMessage(undo[0] + " " + undo[1] + " " + undo[2]);
                lastC = 1;
                return true;
            }
        }
        if (cmd.getName().equalsIgnoreCase("spawnpos2")) {
            if (args.length == 3) {
                listen.setSpawnPos2(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                undo = new int[]{Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
                sender.sendMessage(undo[0] + " " + undo[1] + " " + undo[2]);
                lastC = 2;
                return true;
            } else {
                if (args.length == 0 && sender instanceof Player) {
                    listen.setSpawnPos2(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
                    undo = new int[]{player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()};
                    sender.sendMessage(undo[0] + " " + undo[1] + " " + undo[2]);
                    lastC = 2;
                    return true;
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("dundo")) {
            if (lastC == 1) {
                listen.setSpawnPos1(undo[0], undo[1], undo[2]);
                sender.sendMessage(undo[0] + " " + undo[1] + " " + undo[2]);
            }
            if (lastC == 2) {
                listen.setSpawnPos2(undo[0], undo[1], undo[2]);
                sender.sendMessage(undo[0] + " " + undo[1] + " " + undo[2]);
            }
            lastC = 0;
        }
        return false;
    }

    public particles getParticles() {
        return Particles;
    }
    /*public mining getMining() {
        return mining;
    }*/

	/*public void onPlayerMove(PlayerMoveEvent evt) {
		Location loc = evt.getPlayer().getLocation();
		World w = loc.getWorld();
		loc.setY(loc.getY() + 5); // Gewünschte Position: 5 Blöcke über dem Spieler
		Block b = w.getBlockAt(loc); // Ein Block-Objekt bekommt man mithilfe eines Welt-Objekts und einer Location
		b.setType(Material.STONE);
	}*/
}
