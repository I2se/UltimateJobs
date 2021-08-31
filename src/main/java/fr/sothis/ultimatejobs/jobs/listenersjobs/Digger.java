package fr.sothis.ultimatejobs.jobs.listenersjobs;

import fr.sothis.ultimatejobs.Main;
import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.AffichageJob;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.jobs.expsql.ExpBucheron;
import fr.sothis.ultimatejobs.jobs.expsql.ExpDigger;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Digger implements Listener {

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

                if (profile.getJobs1().equals(JobUnit.DIGGER) || profile.getJobs2().equals(JobUnit.DIGGER) || profile.getJobs3().equals(JobUnit.DIGGER)) {
                    if(block == Material.RED_SAND) {
                        double exp = 1;
                        double coins = 1;
                        ExpDigger.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.COARSE_DIRT) {
                        double exp = 1;
                        double coins = 1;
                        ExpDigger.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.DIRT) {
                        double exp = 1;
                        double coins = 1;
                        ExpDigger.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.GRASS_BLOCK) {
                        double exp = 1;
                        double coins = 1;
                        ExpDigger.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.GRAVEL) {
                        double exp = 1;
                        double coins = 1;
                        ExpDigger.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.SAND) {
                        double exp = 1;
                        double coins = 1;
                        ExpDigger.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.CLAY) {
                        double exp = 0.75;
                        double coins = 0.75;
                        ExpDigger.addExp(uuid, player, exp);
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
}
