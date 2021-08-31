package fr.sothis.ultimatejobs.jobs.listenersjobs;

import fr.sothis.ultimatejobs.Main;
import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.AffichageJob;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.jobs.expsql.ExpBucheron;
import fr.sothis.ultimatejobs.jobs.expsql.ExpChasseur;
import net.minecraft.server.v1_16_R3.EntityWolf;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTameEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Chasseur implements Listener {

    @EventHandler
    public void onTameEntity(EntityTameEvent e){
        Player player = (Player) e.getOwner();
        UUID uuid = player.getUniqueId();
        Entity entity = e.getEntity();

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

                if (profile.getJobs1().equals(JobUnit.CHASSEUR) || profile.getJobs2().equals(JobUnit.CHASSEUR) || profile.getJobs3().equals(JobUnit.CHASSEUR)) {
                    if(entity instanceof Wolf) {
                        double exp = 20;
                        double coins = 20;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Ocelot) {
                        double exp = 20;
                        double coins = 20;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Horse) {
                        double exp = 20;
                        double coins = 20;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @EventHandler
    public void onKillEntity(EntityDeathEvent e){
        Player player = (Player) e.getEntity().getKiller();
        UUID uuid = player.getUniqueId();
        Entity entity = e.getEntity();

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

                if (profile.getJobs1().equals(JobUnit.CHASSEUR) || profile.getJobs2().equals(JobUnit.CHASSEUR) || profile.getJobs3().equals(JobUnit.CHASSEUR)) {
                    if(entity instanceof Chicken) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Cow) {
                        double exp = 5.0;
                        double coins = 6.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Pig) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Sheep) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Wolf) {
                        double exp = 10;
                        double coins = 10;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Creeper) {
                        double exp = 15;
                        double coins = 15;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Skeleton) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Spider) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Zombie) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Blaze) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof CaveSpider) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Enderman) {
                        double exp = 2.0;
                        double coins = 2.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Ghast) {
                        double exp = 30;
                        double coins = 30;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Giant) {
                        double exp = 250;
                        double coins = 250;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof IronGolem) {
                        double exp = 30;
                        double coins = 30;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof MushroomCow) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Silverfish) {
                        double exp = 3.0;
                        double coins = 3.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Snowman) {
                        double exp = 2.0;
                        double coins = 2.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Squid) {
                        double exp = 2.0;
                        double coins = 2.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Rabbit) {
                        double exp = 2.0;
                        double coins = 2.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Guardian) {
                        double exp = 2.0;
                        double coins = 2.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Shulker) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Phantom) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Drowned) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Husk) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Wither) {
                        double exp = 50;
                        double coins = 50;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof EnderDragon) {
                        double exp = 2000;
                        double coins = 2000;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Player) {
                        double exp = 9.0;
                        double coins = 9.0;
                        ExpChasseur.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
