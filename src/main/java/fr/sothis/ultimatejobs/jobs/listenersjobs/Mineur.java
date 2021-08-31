package fr.sothis.ultimatejobs.jobs.listenersjobs;

import fr.sothis.ultimatejobs.Main;
import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.AffichageJob;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.jobs.expsql.ExpMineur;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Mineur implements Listener {

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        Material block = e.getBlock().getType();

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
                final double coin = resultSet.getDouble("coins");
                final JobUnit jobs1 = JobUnit.valueOf(resultSet.getString("jobs1"));
                final JobUnit jobs2 = JobUnit.valueOf(resultSet.getString("jobs2"));
                final JobUnit jobs3 = JobUnit.valueOf(resultSet.getString("jobs3"));
                final Profile profile = new Profile(id, uuid, playerName, level, coin, jobs1, jobs2, jobs3);

                if(profile.getJobs1().equals(JobUnit.MINEUR) || profile.getJobs2().equals(JobUnit.MINEUR) || profile.getJobs3().equals(JobUnit.MINEUR)) {
                    if(block == Material.STONE) {
                        double exp = 0.5;
                        double coins = 0.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.ANDESITE) {
                        double exp = 0.5;
                        double coins = 0.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.GRANITE) {
                        double exp = 0.5;
                        double coins = 0.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.DIORITE) {
                        double exp = 0.5;
                        double coins = 0.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.COAL_ORE) {
                        double exp = 2.0;
                        double coins = 3.0;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.IRON_ORE) {
                        double exp = 3.0;
                        double coins = 3.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.GOLD_ORE) {
                        double exp = 4.0;
                        double coins = 5.0;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.LAPIS_ORE) {
                        double exp = 6;
                        double coins = 7.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.REDSTONE_ORE) {
                        double exp = 2;
                        double coins = 2.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.DIAMOND_ORE) {
                        double exp = 10;
                        double coins = 10;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.EMERALD_ORE) {
                        double exp = 15;
                        double coins = 15;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.NETHER_QUARTZ_ORE) {
                        double exp = 2.5;
                        double coins = 2.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.NETHER_GOLD_ORE) {
                        double exp = 10;
                        double coins = 10;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.ANCIENT_DEBRIS) {
                        double exp = 10;
                        double coins = 10;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.SANDSTONE) {
                        double exp = 0.15;
                        double coins = 0.15;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.CHISELED_SANDSTONE) {
                        double exp = 0.15;
                        double coins = 0.15;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.CUT_SANDSTONE) {
                        double exp = 0.15;
                        double coins = 0.15;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.OBSIDIAN) {
                        double exp = 5;
                        double coins = 5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.NETHER_BRICK) {
                        double exp = 1.0;
                        double coins = 1.0;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.NETHERRACK) {
                        double exp = 0.1;
                        double coins = 0.1;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.PRISMARINE) {
                        double exp = 2.5;
                        double coins = 2.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.DARK_PRISMARINE) {
                        double exp = 2.5;
                        double coins = 2.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.PRISMARINE_BRICKS) {
                        double exp = 2.5;
                        double coins = 2.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.COBBLESTONE_WALL) {
                        double exp = 2.5;
                        double coins = 2.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.MOSSY_COBBLESTONE_WALL) {
                        double exp = 2.5;
                        double coins = 2.5;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.NETHER_BRICK_FENCE) {
                        double exp = 1;
                        double coins = 1;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.NETHER_BRICK_STAIRS) {
                        double exp = 3;
                        double coins = 3;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    }
                }
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @EventHandler
    public void onTntBreak(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        Material block = e.getBlock().getType();

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
                final double coin = resultSet.getDouble("coins");
                final JobUnit jobs1 = JobUnit.valueOf(resultSet.getString("jobs1"));
                final JobUnit jobs2 = JobUnit.valueOf(resultSet.getString("jobs2"));
                final JobUnit jobs3 = JobUnit.valueOf(resultSet.getString("jobs3"));
                final Profile profile = new Profile(id, uuid, playerName, level, coin, jobs1, jobs2, jobs3);

                if(profile.getJobs1().equals(JobUnit.MINEUR) || profile.getJobs2().equals(JobUnit.MINEUR) || profile.getJobs3().equals(JobUnit.MINEUR)) {
                    if(block == Material.RAIL) {
                        double exp = 2;
                        double coins = 2;
                        ExpMineur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.IRON_ORE) {
                        double exp = 5;
                        double coins = 5;
                        ExpMineur.removeExp(uuid, player, exp);
                        Main.getEconomy().withdrawPlayer(player, coins);
                    } else if(block == Material.GOLD_ORE) {
                        double exp = 6;
                        double coins = 6;
                        ExpMineur.removeExp(uuid, player, exp);
                        Main.getEconomy().withdrawPlayer(player, coins);
                    } else if(block == Material.DIAMOND_ORE) {
                        double exp = 10;
                        double coins = 10;
                        ExpMineur.removeExp(uuid, player, exp);
                        Main.getEconomy().withdrawPlayer(player, coins);
                    } else if(block == Material.EMERALD_ORE) {
                        double exp = 15;
                        double coins = 15;
                        ExpMineur.removeExp(uuid, player, exp);
                        Main.getEconomy().withdrawPlayer(player, coins);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
