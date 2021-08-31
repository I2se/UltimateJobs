package fr.sothis.ultimatejobs.jobs.inventory;

import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.AffichageJob;
import fr.sothis.ultimatejobs.jobs.AffichageLevel;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class RefreshInv {

    public static void refreshremove(UUID uuid, Player player) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM profiles WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String playerName = resultSet.getString("playerName");
                final int level = resultSet.getInt("level");
                final float coins = resultSet.getFloat("coins");
                final JobUnit jobs1 = JobUnit.valueOf(resultSet.getString("jobs1"));
                final JobUnit jobs2 = JobUnit.valueOf(resultSet.getString("jobs2"));
                final JobUnit jobs3 = JobUnit.valueOf(resultSet.getString("jobs3"));
                final Profile profile = new Profile(id, uuid, playerName, level, coins, jobs1, jobs2, jobs3);

                Inventory invremove = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Ultimate" + ChatColor.GOLD + "Jobs" + ChatColor.GRAY + " - Remove");

                if (profile.getJobs1().equals(JobUnit.NONE)) {
                    invremove.setItem(11, new ItemBuilder(Material.BARRIER).setName(ChatColor.GOLD + "Aucun métier").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.ALCHIMISTE)) {
                    invremove.setItem(11, new ItemBuilder(Material.BREWING_STAND).setName(ChatColor.RED + "Remove Alchimiste").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.CONSTRUCTEUR)) {
                    invremove.setItem(11, new ItemBuilder(Material.BRICK_STAIRS).setName(ChatColor.RED + "Remove Constructeur").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.CRAFTEUR)) {
                    invremove.setItem(11, new ItemBuilder(Material.SMITHING_TABLE).setName(ChatColor.RED + "Remove Crafteur").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.DIGGER)) {
                    invremove.setItem(11, new ItemBuilder(Material.IRON_SHOVEL).setName(ChatColor.RED + "Remove Digger").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.ENCHANTEUR)) {
                    invremove.setItem(11, new ItemBuilder(Material.ENCHANTING_TABLE).setName(ChatColor.RED + "Remove Enchanteur").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.EXPLORATEUR)) {
                    invremove.setItem(11, new ItemBuilder(Material.GRASS_BLOCK).setName(ChatColor.RED + "Remove Explorateur").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.FERMIER)) {
                    invremove.setItem(11, new ItemBuilder(Material.WHEAT).setName(ChatColor.RED + "Remove Fermier").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.PECHEUR)) {
                    invremove.setItem(11, new ItemBuilder(Material.SALMON).setName(ChatColor.RED + "Remove Pecheur").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.CHASSEUR)) {
                    invremove.setItem(11, new ItemBuilder(Material.BOW).setName(ChatColor.RED + "Remove Chasseur").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.MINEUR)) {
                    invremove.setItem(11, new ItemBuilder(Material.IRON_PICKAXE).setName(ChatColor.RED + "Remove Mineur").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.FORGERON)) {
                    invremove.setItem(11, new ItemBuilder(Material.ANVIL).setName(ChatColor.RED + "Remove Forgeron").toItemStack());
                } else if (profile.getJobs1().equals(JobUnit.BUCHERON)) {
                    invremove.setItem(11, new ItemBuilder(Material.IRON_AXE).setName(ChatColor.RED + "Remove Bucheron").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                }
                if (profile.getJobs2().equals(JobUnit.NONE)) {
                    invremove.setItem(13, new ItemBuilder(Material.BARRIER).setName(ChatColor.GOLD + "Aucun métier").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.ALCHIMISTE)) {
                    invremove.setItem(13, new ItemBuilder(Material.BREWING_STAND).setName(ChatColor.RED + "Remove Alchimiste").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.CONSTRUCTEUR)) {
                    invremove.setItem(13, new ItemBuilder(Material.BRICK_STAIRS).setName(ChatColor.RED + "Remove Constructeur").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.CRAFTEUR)) {
                    invremove.setItem(13, new ItemBuilder(Material.SMITHING_TABLE).setName(ChatColor.RED + "Remove Crafteur").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.DIGGER)) {
                    invremove.setItem(13, new ItemBuilder(Material.IRON_SHOVEL).setName(ChatColor.RED + "Remove Digger").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.ENCHANTEUR)) {
                    invremove.setItem(13, new ItemBuilder(Material.ENCHANTING_TABLE).setName(ChatColor.RED + "Remove Enchanteur").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.EXPLORATEUR)) {
                    invremove.setItem(13, new ItemBuilder(Material.GRASS_BLOCK).setName(ChatColor.RED + "Remove Explorateur").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.FERMIER)) {
                    invremove.setItem(13, new ItemBuilder(Material.WHEAT).setName(ChatColor.RED + "Remove Fermier").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.PECHEUR)) {
                    invremove.setItem(13, new ItemBuilder(Material.SALMON).setName(ChatColor.RED + "Remove Pecheur").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.CHASSEUR)) {
                    invremove.setItem(13, new ItemBuilder(Material.BOW).setName(ChatColor.RED + "Remove Chasseur").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.MINEUR)) {
                    invremove.setItem(13, new ItemBuilder(Material.IRON_PICKAXE).setName(ChatColor.RED + "Remove Mineur").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.FORGERON)) {
                    invremove.setItem(13, new ItemBuilder(Material.ANVIL).setName(ChatColor.RED + "Remove Forgeron").toItemStack());
                } else if (profile.getJobs2().equals(JobUnit.BUCHERON)) {
                    invremove.setItem(13, new ItemBuilder(Material.IRON_AXE).setName(ChatColor.RED + "Remove Bucheron").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                }
                if (profile.getJobs3().equals(JobUnit.NONE)) {
                    invremove.setItem(15, new ItemBuilder(Material.BARRIER).setName(ChatColor.GOLD + "Aucun métier").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.ALCHIMISTE)) {
                    invremove.setItem(15, new ItemBuilder(Material.BREWING_STAND).setName(ChatColor.RED + "Remove Alchimiste").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.CONSTRUCTEUR)) {
                    invremove.setItem(15, new ItemBuilder(Material.BRICK_STAIRS).setName(ChatColor.RED + "Remove Constructeur").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.CRAFTEUR)) {
                    invremove.setItem(15, new ItemBuilder(Material.SMITHING_TABLE).setName(ChatColor.RED + "Remove Crafteur").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.DIGGER)) {
                    invremove.setItem(15, new ItemBuilder(Material.IRON_SHOVEL).setName(ChatColor.RED + "Remove Digger").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.ENCHANTEUR)) {
                    invremove.setItem(15, new ItemBuilder(Material.ENCHANTING_TABLE).setName(ChatColor.RED + "Remove Enchanteur").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.EXPLORATEUR)) {
                    invremove.setItem(15, new ItemBuilder(Material.GRASS_BLOCK).setName(ChatColor.RED + "Remove Explorateur").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.FERMIER)) {
                    invremove.setItem(15, new ItemBuilder(Material.WHEAT).setName(ChatColor.RED + "Remove Fermier").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.PECHEUR)) {
                    invremove.setItem(15, new ItemBuilder(Material.SALMON).setName(ChatColor.RED + "Remove Pecheur").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.CHASSEUR)) {
                    invremove.setItem(15, new ItemBuilder(Material.BOW).setName(ChatColor.RED + "Remove Chasseur").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.MINEUR)) {
                    invremove.setItem(15, new ItemBuilder(Material.IRON_PICKAXE).setName(ChatColor.RED + "Remove Mineur").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.FORGERON)) {
                    invremove.setItem(15, new ItemBuilder(Material.ANVIL).setName(ChatColor.RED + "Remove Forgeron").toItemStack());
                } else if (profile.getJobs3().equals(JobUnit.BUCHERON)) {
                    invremove.setItem(15, new ItemBuilder(Material.IRON_AXE).setName(ChatColor.RED + "Remove Bucheron").addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                }

                invremove.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(10, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(12, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(14, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(16, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(20, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invremove.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());

                player.closeInventory();
                player.openInventory(invremove);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void refreshjoin(UUID uuid, Player player) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM profiles WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String playerName = resultSet.getString("playerName");
                final int level = resultSet.getInt("level");
                final double coins = resultSet.getDouble("coins");
                final JobUnit jobs1 = JobUnit.valueOf(resultSet.getString("jobs1"));
                final JobUnit jobs2 = JobUnit.valueOf(resultSet.getString("jobs2"));
                final JobUnit jobs3 = JobUnit.valueOf(resultSet.getString("jobs3"));
                final Profile profile = new Profile(id, uuid, playerName, level, coins, jobs1, jobs2, jobs3);

                ArrayList<String> statprofile = new ArrayList<>();
                statprofile.add("");
                statprofile.add(ChatColor.GOLD + "Vos jobs:");
                statprofile.add(ChatColor.GRAY + AffichageJob.affJob(jobs1) + " " + AffichageLevel.afflevel(jobs1, uuid, player));
                statprofile.add(ChatColor.GRAY + AffichageJob.affJob(jobs2) + " " + AffichageLevel.afflevel(jobs2, uuid, player));
                statprofile.add(ChatColor.GRAY + AffichageJob.affJob(jobs3) + " " + AffichageLevel.afflevel(jobs3, uuid, player));

                ArrayList<String> cliquelore = new ArrayList<>();
                cliquelore.add("");
                cliquelore.add(ChatColor.GRAY + "Cliquez-gauche pour plus d'info");
                cliquelore.add(ChatColor.GRAY + "Cliquez-droit pour obtenir le job");

                Inventory invjoin = Bukkit.createInventory(null, 54, ChatColor.AQUA + "Ultimate" + ChatColor.GOLD + "Jobs" + ChatColor.GRAY + " - Join");

                invjoin.setItem(10, new ItemBuilder(Material.BREWING_STAND).setName(ChatColor.GOLD + "Alchimiste").setLore(cliquelore).toItemStack());
                invjoin.setItem(12, new ItemBuilder(Material.BRICK_STAIRS).setName(ChatColor.GOLD + "Constructeur").setLore(cliquelore).toItemStack());
                invjoin.setItem(14, new ItemBuilder(Material.SMITHING_TABLE).setName(ChatColor.GOLD + "Crafteur").setLore(cliquelore).toItemStack());
                invjoin.setItem(16, new ItemBuilder(Material.IRON_SHOVEL).setName(ChatColor.GOLD + "Digger").setLore(cliquelore).addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                invjoin.setItem(28, new ItemBuilder(Material.ENCHANTING_TABLE).setName(ChatColor.GOLD + "Enchanteur").setLore(cliquelore).toItemStack());
                invjoin.setItem(30, new ItemBuilder(Material.GRASS_BLOCK).setName(ChatColor.GOLD + "Explorateur").setLore(cliquelore).toItemStack());
                invjoin.setItem(32, new ItemBuilder(Material.WHEAT).setName(ChatColor.GOLD + "Fermier").setLore(cliquelore).toItemStack());
                invjoin.setItem(34, new ItemBuilder(Material.SALMON).setName(ChatColor.GOLD + "Pecheur").setLore(cliquelore).toItemStack());
                invjoin.setItem(20, new ItemBuilder(Material.BOW).setName(ChatColor.GOLD + "Chasseur").setLore(cliquelore).toItemStack());
                invjoin.setItem(38, new ItemBuilder(Material.IRON_PICKAXE).setName(ChatColor.GOLD + "Mineur").setLore(cliquelore).addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                invjoin.setItem(24, new ItemBuilder(Material.ANVIL).setName(ChatColor.GOLD + "Forgeron").setLore(cliquelore).toItemStack());
                invjoin.setItem(42, new ItemBuilder(Material.IRON_AXE).setName(ChatColor.GOLD + "Bucheron").setLore(cliquelore).addItemFlag(ItemFlag.HIDE_ATTRIBUTES).toItemStack());
                invjoin.setItem(22, new ItemBuilder(Material.BEACON).setName(ChatColor.DARK_PURPLE + "Random").toItemStack());
                invjoin.setItem(40, new ItemBuilder(Material.PLAYER_HEAD).setHead(player.getName()).setName(ChatColor.AQUA + "Profile").setLore(statprofile).toItemStack());
                invjoin.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(1, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(3, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(5, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(7, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(9, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(11, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(13, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(15, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(17, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(18, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(19, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(21, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(27, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(29, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(31, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(33, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(36, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(37, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(39, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(41, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(43, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(44, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(45, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(46, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(47, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(48, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(49, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(50, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(51, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(52, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());
                invjoin.setItem(53, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").toItemStack());

                player.closeInventory();
                player.openInventory(invjoin);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
