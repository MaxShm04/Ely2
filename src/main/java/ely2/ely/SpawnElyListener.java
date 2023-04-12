package ely2.ely;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SpawnElyListener implements org.bukkit.event.Listener {

    private Main plugin;
    private int[] spawnPos1, spawnPos2, mid;
    private int distX, distY, distZ;


    public SpawnElyListener(Main plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        spawnPos1 = new int[3];
        spawnPos2 = new int[3];
        mid = new int[3];
        distX = 0;
        distY = 0;
        distZ = 0;
    }


    @EventHandler
    public void onFlight(EntityToggleGlideEvent e){
        if(e.getEntity().getType().equals(EntityType.PLAYER)) {
            e.getEntity().sendMessage("Toggled");
        }
    }

    @EventHandler
    public void onSpawn(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(Math.abs(p.getLocation().getBlockX()-mid[0])<=distX && Math.abs(p.getLocation().getBlockY()-mid[1])<=distY && Math.abs(p.getLocation().getBlockZ()-mid[2])<=distZ){
            p.sendMessage("inside");
            if(hasEly(p) == false) {
                p.sendMessage("has no ely");
                if (p.getInventory().getChestplate() == null) {
                    p.sendMessage("no chest, get Ely");
                    ItemStack ely = new ItemStack(Material.ELYTRA, 1);    //2
                    ItemMeta anm = ely.getItemMeta();
                    anm.setDisplayName("Elytra");
                    ArrayList<String> lorre = new ArrayList<String>();
                    lorre.add(ChatColor.GOLD + "Have fun");
                    anm.setLore(lorre);
                    ely.setItemMeta(anm);
                    p.getInventory().setChestplate(ely);
                    return;
                }
                if (hasAvaliableSlot(p)) {
                    ItemStack ely = new ItemStack(Material.ELYTRA, 1);    //2
                    ItemMeta anm = ely.getItemMeta();
                    anm.setDisplayName("Elytra");
                    ArrayList<String> lorre = new ArrayList<String>();
                    lorre.add(ChatColor.GOLD + "Have fun");
                    anm.setLore(lorre);
                    ely.setItemMeta(anm);
                    p.getInventory().addItem(ely);
                    return;
                }
            }
        }
    }

    public boolean setSpawnPos1(int x, int y, int z){
        spawnPos1 = new int[]{x, y, z};
        int a  = Math.abs(spawnPos1[0]-spawnPos2[0]);
        int b = Math.abs(spawnPos1[1]-spawnPos2[1]);
        int c = Math.abs(spawnPos1[2]-spawnPos2[2]);
        mid = new int[]{a, b, c};
        distX = Math.abs(mid[0]-spawnPos2[0]);
        distY = Math.abs(mid[1]-spawnPos2[1]);
        distZ = Math.abs(mid[2]-spawnPos2[2]);
        return true;
    }
    public boolean setSpawnPos2(int x, int y, int z){
        spawnPos2 = new int[]{x, y, z};
        int a = Math.abs(spawnPos1[0]-spawnPos2[0]);
        int b = Math.abs(spawnPos1[1]-spawnPos2[1]);
        int c = Math.abs(spawnPos1[2]-spawnPos2[2]);
        mid = new int[]{a, b, c};
        distX = Math.abs(mid[0]-spawnPos2[0]);
        distY = Math.abs(mid[1]-spawnPos2[1]);
        distZ = Math.abs(mid[2]-spawnPos2[2]);
        return true;

    }
    public boolean hasAvaliableSlot(Player player){
        Inventory inv = player.getInventory();
        for (ItemStack item: inv.getContents()) {
            if(item == null) {
                return true;
            }
        }
        return false;
    }
    public boolean hasEly(Player player){
        Inventory inv = player.getInventory();
        ArrayList<String> lorre = new ArrayList<String>();
        lorre.add(ChatColor.GOLD + "Have fun");
        for (ItemStack item: inv.getContents()) {
            if(item != null){
                if(item.getItemMeta().getLore()!= null) {
                    if (item.getItemMeta().getLore() == lorre) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean test(Player player) {
        for Player p :
        return false;
    }
}
