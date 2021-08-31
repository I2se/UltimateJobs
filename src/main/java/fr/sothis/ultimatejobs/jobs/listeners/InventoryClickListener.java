package fr.sothis.ultimatejobs.jobs.listeners;

import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.jobs.inventory.RefreshInv;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.util.UUID;

import static fr.sothis.ultimatejobs.jobs.SetJobsSQL.*;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;

        Player player = (Player) e.getWhoClicked();
        UUID uuid = player.getUniqueId();

        int slot = e.getSlot();

        switch (e.getCurrentItem().getType()) {

            case BREWING_STAND:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Alchimiste")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.ALCHIMISTE);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Alchimiste")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.ALCHIMISTE);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.ALCHIMISTE);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.ALCHIMISTE);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case BRICK_STAIRS:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Constructeur")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.CONSTRUCTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Constructeur")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.CONSTRUCTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.CONSTRUCTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.CONSTRUCTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case SMITHING_TABLE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Crafteur")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.CRAFTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Crafteur")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.CRAFTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.CRAFTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.CRAFTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case IRON_SHOVEL:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Digger")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.DIGGER);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Digger")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.DIGGER);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.DIGGER);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.DIGGER);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case BOW:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Chasseur")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.CHASSEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Chasseur")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.CHASSEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.CHASSEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.CHASSEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case BEACON:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Random")) {
                    e.setCancelled(true);
                    RefreshInv.refreshjoin(uuid, player);
                }
                 break;

            case PLAYER_HEAD:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Profile")) {
                    e.setCancelled(true);
                    RefreshInv.refreshjoin(uuid, player);
                }
                break;

            case ANVIL:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Forgeron")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.FORGERON);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Forgeron")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.FORGERON);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.FORGERON);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.FORGERON);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case ENCHANTING_TABLE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Enchanteur")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.ENCHANTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Enchanteur")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.ENCHANTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.ENCHANTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.ENCHANTEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case GRASS_BLOCK:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Explorateur")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.EXPLORATEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Explorateur")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.EXPLORATEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.EXPLORATEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.EXPLORATEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case WHEAT:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Fermier")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.FERMIER);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Fermier")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.FERMIER);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.FERMIER);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.FERMIER);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case SALMON:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Pecheur")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.PECHEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Pecheur")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.PECHEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.PECHEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.PECHEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case IRON_PICKAXE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Mineur")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.MINEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Mineur")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.MINEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.MINEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.MINEUR);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case IRON_AXE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Bucheron")) {
                    if(e.getClick().isRightClick()) {
                        selectJob(uuid, player, JobUnit.BUCHERON);
                        e.setCancelled(true);
                        RefreshInv.refreshjoin(uuid, player);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Remove Bucheron")) {
                    if(slot == 11) {
                        setJobNull1(uuid, player, JobUnit.BUCHERON);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 13) {
                        setJobNull2(uuid, player, JobUnit.BUCHERON);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    } else if(slot == 15) {
                        setJobNull3(uuid, player, JobUnit.BUCHERON);
                        e.setCancelled(true);
                        RefreshInv.refreshremove(uuid, player);
                    }
                }
                break;

            case GRAY_STAINED_GLASS_PANE:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(" ")) {
                    e.setCancelled(true);
                }
                break;

            case BARRIER:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Aucun métier")) {
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "Vous ne pouvez pas supprimer un métier que vous n'avez pas !");
                }

            default: break;
        }
    }
}
