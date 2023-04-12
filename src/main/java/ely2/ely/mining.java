package ely2.ely;

/*
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class mining implements Listener{

    private UUID uuid;
    private Main Plugin;
    private boolean isActive;
    private boolean isActiveC;
    private boolean isActiveI;
    private boolean isActiveG;
    private boolean isActiveNG;
    private boolean isActiveQ;
    private Inventory inv;
    public mining(Main Plugin, String uuid){

        this.uuid=UUID.fromString(uuid);
        this.Plugin=Plugin;
        Plugin.getServer().getPluginManager().registerEvents(this, Plugin);
        inv = Plugin.getServer().createInventory(null, 27, "Miningchest");
        isActive = false;
        isActiveC = true;
        isActiveI = true;
        isActiveG = true;
        isActiveNG = true;
        isActiveQ = true;

    }

    @EventHandler
    public void onMine(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(p.getUniqueId().equals(uuid)==true) {
            if(isActive==true) {
                if(e.getBlock().getType().equals(Material.COBBLESTONE)==true&&isActiveC==true) {
                    e.setDropItems(false);
                    inv.addItem(new ItemStack(Material.STONE));
                }
                if(e.getBlock().getType().equals(Material.STONE)==true&&isActiveC==true) {
                    e.setDropItems(false);
                    inv.addItem(new ItemStack(Material.STONE));
                }
                if(e.getBlock().getType().equals(Material.IRON_ORE)==true&&isActiveI==true) {
                    e.setDropItems(false);
                    inv.addItem(new ItemStack(Material.IRON_INGOT));
                }
                if(e.getBlock().getType().equals(Material.GOLD_ORE)==true&&isActiveG==true) {
                    e.setDropItems(false);
                    inv.addItem(new ItemStack(Material.GOLD_INGOT));
                }
                if(e.getBlock().getType().equals(Material.NETHER_GOLD_ORE)==true&&isActiveNG==true) {
                    int x = e.getBlock().getDrops().size();
                    e.setDropItems(false);
                    inv.addItem(new ItemStack(Material.GOLD_NUGGET, x));
                }
                if(e.getBlock().getType().equals(Material.NETHER_QUARTZ_ORE)==true&&isActiveQ==true) {
                    int x = e.getBlock().getDrops().size();
                    e.setDropItems(false);
                    inv.addItem(new ItemStack(Material.QUARTZ, x));
                }


            }
        }

    }



    public boolean isActiveC() {
        return isActiveC;
    }

    public void setActiveC(boolean isActiveC) {
        this.isActiveC = isActiveC;
    }

    public boolean isActiveI() {
        return isActiveI;
    }

    public void setActiveI(boolean isActiveI) {
        this.isActiveI = isActiveI;
    }

    public boolean isActiveG() {
        return isActiveG;
    }

    public void setActiveG(boolean isActiveG) {
        this.isActiveG = isActiveG;
    }

    public boolean isActiveNG() {
        return isActiveNG;
    }

    public void setActiveNG(boolean isActiveNG) {
        this.isActiveNG = isActiveNG;
    }

    public boolean isActiveQ() {
        return isActiveQ;
    }

    public void setActiveQ(boolean isActiveQ) {
        this.isActiveQ = isActiveQ;
    }

    public void open(Player player) {
        player.openInventory(inv);
    }

    public void setActive(boolean isActive, Player p) {
        this.isActive = isActive;
        if(isActive==true) {
        }else {
        }
    }

    public boolean isActive() {
        return isActive;
    }

}*/
