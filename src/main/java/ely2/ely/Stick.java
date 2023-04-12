package ely2.ely;

import java.util.ArrayList;
import java.util.UUID;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Stick implements Listener {

    private Main plugin;
    private Player player;
    private ItemStack item;
    private ArrayList<String> lore;
    private ArrayList<String> enable;
    private ArrayList<String> disable;

    public Stick(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD + "Dont loose!");
        enable = new ArrayList<String>();
        enable.add(ChatColor.GREEN + "Enable");
        disable = new ArrayList<String>();
        disable.add(ChatColor.GOLD + "Disable");
    }


    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) && (e.getItem().getItemMeta().getLore().equals(lore))) {
            Inventory i = p.getServer().createInventory(null, 9, "Menu");

            ItemStack z = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta zm = z.getItemMeta();
            zm.setDisplayName("Partikel");
            for (playpart x : plugin.getParticles().playpartlist) {
                ArrayList<String> xy = new ArrayList<String>();
                if (x.getPlayer() == p) {
                    if (x.isActive() == true) {
                        xy.add(ChatColor.DARK_RED + "Klick to disable");
                    } else {
                        xy.add(ChatColor.GREEN + "Klick to enable");
                    }
                } else {
                    xy.add(ChatColor.GREEN + "Klick to enable");
                }
                zm.setLore(xy);
            }
            z.setItemMeta(zm);
            i.setItem(0, z);


            ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwningPlayer(p);
            meta.setDisplayName("Get Playerhead");
            ArrayList<String> hg = new ArrayList<String>();
            hg.add(ChatColor.BOLD.GOLD + "Get one Playerhead of a online Player for 10 Diamonds");
            meta.setLore(hg);
            skull.setItemMeta(meta);
            i.setItem(1, skull);


            if ((p.getUniqueId().equals(UUID.fromString("f6f9bd4e-d441-4b7e-bed2-046911493a96")) == true)) {
                ItemStack em = new ItemStack(Material.EMERALD, 1);    //2
                ItemMeta emm = em.getItemMeta();
                emm.setDisplayName(ChatColor.DARK_PURPLE + "VIP");
                em.setItemMeta(emm);
                i.setItem(8, em);
            }

            /*if (p.getUniqueId().equals(UUID.fromString("f6f9bd4e-d441-4b7e-bed2-046911493a96")) == true) {
                ItemStack em = new ItemStack(Material.DIAMOND_PICKAXE, 1);    //2
                ItemMeta emm = em.getItemMeta();
                emm.setDisplayName("Mining");
                em.setItemMeta(emm);
                i.setItem(7, em);
            }*/

            /*if (p.getUniqueId().equals(UUID.fromString("f6f9bd4e-d441-4b7e-bed2-046911493a96")) == true) {
                ItemStack em = new ItemStack(Material.CHEST, 1);    //2
                ItemMeta emm = em.getItemMeta();
                emm.setDisplayName("Miningchest");
                em.setItemMeta(emm);
                i.setItem(6, em);
            }*/

            if (p.getUniqueId().equals(UUID.fromString("f6f9bd4e-d441-4b7e-bed2-046911493a96")) == true) {
                ItemStack em = new ItemStack(Material.COMPASS, 1);    //2
                ItemMeta emm = em.getItemMeta();
                emm.setDisplayName("Locate");
                em.setItemMeta(emm);
                i.setItem(5, em);
            }


            p.openInventory(i);


        }

    }


    @EventHandler
    public void onlickInv(InventoryClickEvent w) {
        Player pp = (Player) w.getWhoClicked();
        //pp.sendMessage("Inventory click");
        if (w.getView().getTitle().equals("Menu")) {
            //pp.sendMessage("Inventory click in Menu");
            //if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT.SHIFT_LEFT))) {
                /*if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Mining")){
                    w.setCancelled(true);
                    pp.closeInventory();
                    Inventory i = pp.getServer().createInventory(null, 9, "Select");
                    ItemStack em = new ItemStack(Material.COBBLESTONE, 1);    //2
                    ItemMeta emm = em.getItemMeta();
                    emm.setDisplayName("Cobblestone");
                    if(plugin.getMining().isActiveC()==true) {
                        emm.setLore(disable);
                    }else {
                        emm.setLore(enable);
                    }
                    em.setItemMeta(emm);
                    i.setItem(0, em);

                    ItemStack dm = new ItemStack(Material.IRON_ORE, 1);    //2
                    ItemMeta dmm = dm.getItemMeta();
                    dmm.setDisplayName("Iron");
                    if(plugin.getMining().isActiveI()==true) {
                        dmm.setLore(disable);
                    }else {
                        dmm.setLore(enable);
                    }
                    dm.setItemMeta(dmm);
                    i.setItem(1, dm);

                    ItemStack fm = new ItemStack(Material.GOLD_ORE, 1);    //2
                    ItemMeta fmm = fm.getItemMeta();
                    fmm.setDisplayName("Gold");
                    if(plugin.getMining().isActiveG()==true) {
                        fmm.setLore(disable);
                    }else {
                        fmm.setLore(enable);
                    }
                    fm.setItemMeta(fmm);
                    i.setItem(2, fm);

                    ItemStack cm = new ItemStack(Material.NETHER_GOLD_ORE, 1);    //2
                    ItemMeta cmm = cm.getItemMeta();
                    cmm.setDisplayName("Nethergold");
                    if(plugin.getMining().isActiveNG()==true) {
                        cmm.setLore(disable);
                    }else {
                        cmm.setLore(enable);
                    }
                    cm.setItemMeta(cmm);
                    i.setItem(3, cm);

                    ItemStack gm = new ItemStack(Material.NETHER_QUARTZ_ORE, 1);    //2
                    ItemMeta gmm = gm.getItemMeta();
                    gmm.setDisplayName("Quartz");
                    if(plugin.getMining().isActiveQ()==true) {
                        gmm.setLore(disable);
                    }else {
                        gmm.setLore(enable);
                    }
                    gm.setItemMeta(gmm);
                    i.setItem(4, gm);

                    pp.openInventory(i);
                }
            }*/


            if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT))) {
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Partikel")) {
                    w.setCancelled(true);
                    //pp.sendMessage("Currently not available");
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "particle " + pp.getName());
                        /*ArrayList<String> xy = new ArrayList<String>();
                        for(playpart n : plugin.getParticles().getParticleList()){
                            if(n.getPlayer()==pp) {
                                if(n.isActive()) {
                                    xy.add(ChatColor.DARK_RED + "Klick to disable");
                                } else{
                                    xy.add(ChatColor.GREEN + "Klick to enable");
                                }
                            }
                        }
                        w.getCurrentItem().getItemMeta().getLore();*/
                }

                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Get Playerhead")) {
                    w.setCancelled(true);
                    pp.closeInventory();
                    Inventory ii = pp.getServer().createInventory(null, 9, "Heads");
                    int x = -1;
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        x++;
                        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
                        SkullMeta meta = (SkullMeta) skull.getItemMeta();
                        meta.setOwningPlayer(p);
                        meta.setDisplayName(p.getName());
                        skull.setItemMeta(meta);
                        ii.setItem(x, skull);
                    }
                    pp.openInventory(ii);
                }

                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Locate")) {
                    w.setCancelled(true);
                    pp.closeInventory();
                    Inventory ii = pp.getServer().createInventory(null, 9, "Choose");

                    int x = -1;
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        x++;
                        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
                        SkullMeta meta = (SkullMeta) skull.getItemMeta();
                        meta.setOwner(p.getName());
                        meta.setDisplayName(p.getName());
                        skull.setItemMeta(meta);
                        ii.setItem(x, skull);
                    }
                    pp.openInventory(ii);
                }

                /*if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Mining")){
                    w.setCancelled(true);
                    pp.closeInventory();
                    if(plugin.getMining().isActive()==false) {
                        plugin.getMining().setActive(true, pp);
                        pp.sendMessage("IsActive");
                    }else {
                        plugin.getMining().setActive(false, pp);
                        pp.sendMessage("Deactivated");
                    }
                }*/


                /*if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Miningchest")) {
                    w.setCancelled(true);
                    pp.closeInventory();
                    plugin.getMining().open(pp);
                }*/


                if (w.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "VIP")) {
                    w.setCancelled(true);
                    pp.closeInventory();
                    Inventory ii = pp.getServer().createInventory(null, 9, "VIP");
                    ItemStack an = new ItemStack(Material.ANVIL, 1);    //2
                    ItemMeta anm = an.getItemMeta();
                    anm.setDisplayName("Repair");
                    ArrayList<String> lorre = new ArrayList<String>();
                    lorre.add(ChatColor.GOLD + "Nutz den Befehl /test 2!");
                    anm.setLore(lorre);
                    an.setItemMeta(anm);
                    ii.setItem(0, an);

                    ItemStack gp = new ItemStack(Material.GOLDEN_PICKAXE, 1);    //3
                    ItemMeta gpm = gp.getItemMeta();
                    gpm.setDisplayName("Haste IV (5min)");
                    gp.setItemMeta(gpm);
                    ii.setItem(1, gp);


                    ItemStack ne = new ItemStack(Material.GLASS_BOTTLE, 1);        //4
                    ItemMeta nem = ne.getItemMeta();
                    nem.setDisplayName("Clear Effect");
                    ne.setItemMeta(nem);
                    ii.setItem(2, ne);

                    ItemStack ec = new ItemStack(Material.ENDER_CHEST, 1);        //1
                    ItemMeta ecm = ec.getItemMeta();
                    ecm.setDisplayName("EC");
                    ec.setItemMeta(ecm);
                    ii.setItem(3, ec);

                    ItemStack iv = new ItemStack(Material.PAPER, 1);        //5
                    ItemMeta ivm = iv.getItemMeta();
                    ivm.setDisplayName("Inventory");
                    iv.setItemMeta(ivm);
                    ii.setItem(4, iv);

                    ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);        //1
                    ItemMeta xpm = xp.getItemMeta();
                    xpm.setDisplayName("XP");
                    xp.setItemMeta(xpm);
                    ii.setItem(5, xp);

                    ItemStack sp = new ItemStack(Material.FEATHER, 1);    //3
                    ItemMeta spm = sp.getItemMeta();
                    spm.setDisplayName("Speed IV (5min)");
                    sp.setItemMeta(spm);
                    ii.setItem(6, sp);

                    pp.openInventory(ii);
                }

            }
            w.setCancelled(true);
        }


        if (w.getView().getTitle().equals("VIP")) {
            if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT))) {
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Repair")) {
                    w.setCancelled(true);
						/*int x = -1;
						pp.closeInventory();
						Inventory ix = pp.getServer().createInventory(null,27, "Repair");
					for (ItemStack p: pp.getInventory().getContents()) {
							if(p.getType()!=null){
						x++;
						ItemStack y = new ItemStack(p);
						SkullMeta meta = (SkullMeta) p.getItemMeta();
						y.setItemMeta(meta);
						ix.setItem(x, y);
							}
					}
						pp.openInventory(ix);
					}*/
                }
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Haste IV (5min)")) {
                    w.setCancelled(true);
                    pp.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 6000, 3));
                }
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Speed IV (5min)")) {
                    w.setCancelled(true);
                    pp.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 3));
                }
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Clear Effect")) {

                    w.setCancelled(true);
                    pp.removePotionEffect(PotionEffectType.FAST_DIGGING);
                    pp.removePotionEffect(PotionEffectType.SPEED);
                }
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("EC")) {
                    int x = -1;
                    w.setCancelled(true);
                    pp.closeInventory();
                    Inventory ix = pp.getServer().createInventory(null, 18, "EC");
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        x++;
                        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
                        SkullMeta meta = (SkullMeta) skull.getItemMeta();
                        meta.setOwner(p.getName());
                        meta.setDisplayName(p.getName());
                        skull.setItemMeta(meta);
                        ix.setItem(x, skull);
                    }
                    pp.openInventory(ix);
                }
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("XP")) {
                    w.setCancelled(true);
                    pp.giveExpLevels(40);
                }
                if (w.getCurrentItem().getItemMeta().getDisplayName().equals("Inventory")) {
                    int x = -1;
                    w.setCancelled(true);
                    pp.closeInventory();
                    Inventory ix = pp.getServer().createInventory(null, 18, "Inventory");
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        x++;
                        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
                        SkullMeta meta = (SkullMeta) skull.getItemMeta();
                        meta.setOwner(p.getName());
                        meta.setDisplayName(p.getName());
                        skull.setItemMeta(meta);
                        ix.setItem(x, skull);
                    }
                    pp.openInventory(ix);
                }
            }
            w.setCancelled(true);
        }
        if (w.getView().getTitle().equals("EC")) {
            if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT))) {
                if (w.getCurrentItem().getType() != Material.AIR) {
                    w.setCancelled(true);
                    pp.openInventory(Bukkit.getPlayer(w.getCurrentItem().getItemMeta().getDisplayName()).getEnderChest());
                } else {
                    w.setCancelled(true);
                }

            }
            w.setCancelled(true);
        }
        if (w.getView().getTitle().equals("Inventory")) {
            if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT))) {
                if (w.getCurrentItem().getType() != Material.AIR) {
                    w.setCancelled(true);
                    pp.openInventory(Bukkit.getPlayer(w.getCurrentItem().getItemMeta().getDisplayName()).getInventory());
                } else {
                    w.setCancelled(true);
                }

            }
            w.setCancelled(true);
        }


        if (w.getView().getTitle().equals("Choose")) {
            if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT))) {
                if (w.getCurrentItem().getType() != Material.AIR) {
                    w.setCancelled(true);
                    pp.sendMessage("Coords: " + (Math.round(Bukkit.getPlayer(w.getCurrentItem().getItemMeta().getDisplayName()).getLocation().getX())) + " " + (Math.round(Bukkit.getPlayer(w.getCurrentItem().getItemMeta().getDisplayName()).getLocation().getY())) + " " + Math.round(Bukkit.getPlayer(w.getCurrentItem().getItemMeta().getDisplayName()).getLocation().getZ()));
                } else {
                    w.setCancelled(true);
                }
            }
        }

        if (w.getView().getTitle().equals("Heads")) {
            pp.sendMessage("Menu heads");
            if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT))) {
                if (w.getCurrentItem().getType() != Material.AIR) {
                    pp.sendMessage("Head klicked");
                    if (pp.getInventory().contains(Material.DIAMOND, 10)) {
                        pp.getInventory().removeItem(new ItemStack(Material.DIAMOND, 10));
                        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
                        SkullMeta meta = (SkullMeta) skull.getItemMeta();
                        meta.setOwner(Bukkit.getPlayer(w.getCurrentItem().getItemMeta().getDisplayName()).getName());
                        meta.setDisplayName(w.getCurrentItem().getItemMeta().getDisplayName() + "`s Head");
                        skull.setItemMeta(meta);
                        pp.getInventory().addItem(skull);
                    } else {
                        pp.sendMessage("You have not enough Diamonds");
                    }
                }

            }
            w.setCancelled(true);
        }
        if (w.getView().getTitle().equals("Repair")) {
            if ((w.getRawSlot() < w.getInventory().getSize()) && (w.getClick().equals(ClickType.LEFT))) {
                if (w.getCurrentItem().getType() != Material.AIR) {
                    for (ItemStack p : pp.getInventory().getContents()) {
                        if (p == w.getCurrentItem()) {
                            p.setDurability((short) 0);
                        }
                    }
                    w.setCancelled(true);

                } else {
                    w.setCancelled(true);
                }

            }
            w.setCancelled(true);
        }

       /* if(w.getView().getTitle().equals("Select")) {
            if((w.getRawSlot()< w.getInventory().getSize())&&(w.getClick().equals(ClickType.LEFT))) {
                if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Cobblestone")) {
                    w.setCancelled(true);
                    if(plugin.getMining().isActiveC()==true) {
                        plugin.getMining().setActiveC(false);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(enable);
                        w.getCurrentItem().setItemMeta(x);
                    }else {
                        plugin.getMining().setActiveC(true);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(disable);
                        w.getCurrentItem().setItemMeta(x);
                    }
                }
                if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Iron")) {
                    w.setCancelled(true);
                    if(plugin.getMining().isActiveI()==true) {
                        plugin.getMining().setActiveI(false);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(enable);
                        w.getCurrentItem().setItemMeta(x);
                    }else {
                        plugin.getMining().setActiveI(true);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(disable);
                        w.getCurrentItem().setItemMeta(x);
                    }
                }
                if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Gold")) {
                    w.setCancelled(true);
                    if(plugin.getMining().isActiveG()==true) {
                        plugin.getMining().setActiveG(false);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(enable);
                        w.getCurrentItem().setItemMeta(x);
                    }else {
                        plugin.getMining().setActiveG(true);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(disable);
                        w.getCurrentItem().setItemMeta(x);
                    }
                }
                if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Nethergold")) {
                    w.setCancelled(true);
                    if(plugin.getMining().isActiveNG()==true) {
                        plugin.getMining().setActiveNG(false);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(enable);
                        w.getCurrentItem().setItemMeta(x);
                    }else {
                        plugin.getMining().setActiveNG(true);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(disable);
                        w.getCurrentItem().setItemMeta(x);
                    }
                }
                if(w.getCurrentItem().getItemMeta().getDisplayName().equals("Quartz")) {
                    w.setCancelled(true);
                    if(plugin.getMining().isActiveQ()==true) {
                        plugin.getMining().setActiveQ(false);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(enable);
                        w.getCurrentItem().setItemMeta(x);
                    }else {
                        plugin.getMining().setActiveQ(true);
                        ItemMeta x = w.getCurrentItem().getItemMeta();
                        x.setLore(disable);
                        w.getCurrentItem().setItemMeta(x);
                    }
                }
            }
        }

    }*/


    /*private Material ItemStack(Material diamond, int i) {
        // TODO Auto-generated method stub
        return null;
    }*/


    }
}