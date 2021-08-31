package fr.sothis.ultimatejobs.jobs.listenersjobs;

import fr.sothis.ultimatejobs.Main;
import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.AffichageJob;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.jobs.expsql.ExpChasseur;
import fr.sothis.ultimatejobs.jobs.expsql.ExpFermier;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Fermier implements Listener {

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

                if (profile.getJobs1().equals(JobUnit.FERMIER) || profile.getJobs2().equals(JobUnit.FERMIER) || profile.getJobs3().equals(JobUnit.FERMIER)) {
                    if(entity instanceof Wolf) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Ocelot) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Horse) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Parrot) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Llama) {
                        double exp = 5.0;
                        double coins = 5.0;
                        ExpFermier.addExp(uuid, player, exp);
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
    public void onBreedEntity(EntityBreedEvent e) {
        Player player = (Player) e.getBreeder();
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

                if (profile.getJobs1().equals(JobUnit.FERMIER) || profile.getJobs2().equals(JobUnit.FERMIER) || profile.getJobs3().equals(JobUnit.FERMIER)) {
                    if(entity instanceof Horse) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Sheep) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Cow) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof MushroomCow) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Pig) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Chicken) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Wolf) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Ocelot) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Rabbit) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Llama) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(entity instanceof Turtle) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
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
    public void onShearsEntity(PlayerShearEntityEvent e) {
        Player player = e.getPlayer();
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

                if (profile.getJobs1().equals(JobUnit.FERMIER) || profile.getJobs2().equals(JobUnit.FERMIER) || profile.getJobs3().equals(JobUnit.FERMIER)) {
                    if(entity instanceof Sheep) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
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
    public void onBucketFill(PlayerBucketFillEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        Material item = e.getBucket();


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

                if (profile.getJobs1().equals(JobUnit.FERMIER) || profile.getJobs2().equals(JobUnit.FERMIER) || profile.getJobs3().equals(JobUnit.FERMIER)) {
                    if(item == Material.MILK_BUCKET) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
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
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        Material block = e.getBlock().getType();
        Block grower = e.getBlock();


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

                if (profile.getJobs1().equals(JobUnit.FERMIER) || profile.getJobs2().equals(JobUnit.FERMIER) || profile.getJobs3().equals(JobUnit.FERMIER)) {
                    if(block == Material.CHORUS_PLANT) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.CHORUS_FLOWER) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.BEETROOTS) {
                        if (grower.getBlockData() instanceof Ageable) {
                            Ageable blockData = (Ageable) grower.getState().getBlockData();
                            int curAge = blockData.getAge();
                            if (!(curAge <= 7)) {
                                double exp = 4.0;
                                double coins = 4.0;
                                ExpFermier.addExp(uuid, player, exp);
                                Main.getEconomy().depositPlayer(player, coins);
                                AffichageJob.sendActionBar(player, exp, coins);
                            }
                        }
                    } else if(block == Material.CHORUS_PLANT) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
                        Main.getEconomy().depositPlayer(player, coins);
                        AffichageJob.sendActionBar(player, exp, coins);
                    } else if(block == Material.CHORUS_PLANT) {
                        double exp = 4.0;
                        double coins = 4.0;
                        ExpFermier.addExp(uuid, player, exp);
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
