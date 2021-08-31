package fr.sothis.ultimatejobs.jobs;

import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.Profile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SetJobsSQL {
    public static void selectJob(UUID uuid, Player player, JobUnit job) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM profiles WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String playerName = resultSet.getString("playerName");
                final int level = resultSet.getInt("level");
                final double coins = resultSet.getDouble("coins");
                final JobUnit jobs1 = JobUnit.valueOf(resultSet.getString("jobs1"));
                final JobUnit jobs2 = JobUnit.valueOf(resultSet.getString("jobs2"));
                final JobUnit jobs3 = JobUnit.valueOf(resultSet.getString("jobs3"));
                final Profile profile = new Profile(id, uuid, playerName, level, coins, jobs1, jobs2, jobs3);

                if(profile.getJobs1().equals(job) || profile.getJobs2().equals(job) || profile.getJobs3().equals(job)) {
                    player.sendMessage(ChatColor.RED + "Vous avez deja ce job !");
                } else if(profile.getJobs1().equals(JobUnit.NONE)) {
                    setJobSQL1(uuid, player, job);
                } else if(profile.getJobs2().equals(JobUnit.NONE)) {
                    setJobSQL2(uuid, player, job);
                } else if(profile.getJobs3().equals(JobUnit.NONE)) {
                    setJobSQL3(uuid, player, job);
                } else {
                    player.sendMessage(ChatColor.RED + "Vous avez trop de job !");
                }
            }
            connection.close();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setJobSQL1(UUID uuid, Player player, JobUnit job) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE profiles SET jobs1 = ? WHERE uuid = ?");

            preparedStatement.setString(1, String.valueOf(job));
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            player.sendMessage(ChatColor.GREEN + "Vous avez maintenant le job "+ AffichageJob.affJob(job));

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setJobSQL2(UUID uuid, Player player, JobUnit job) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE profiles SET jobs2 = ? WHERE uuid = ?");

            preparedStatement.setString(1, String.valueOf(job));
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            player.sendMessage(ChatColor.GREEN + "Vous avez maintenant le job "+ AffichageJob.affJob(job));

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setJobSQL3(UUID uuid, Player player, JobUnit job) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE profiles SET jobs3 = ? WHERE uuid = ?");

            preparedStatement.setString(1, String.valueOf(job));
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            player.sendMessage(ChatColor.GREEN + "Vous avez maintenant le job "+ AffichageJob.affJob(job));

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setJobNull1(UUID uuid, Player player, JobUnit job) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE profiles SET jobs1 = ? WHERE uuid = ?");

            preparedStatement.setString(1, String.valueOf(JobUnit.NONE));
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            player.sendMessage(ChatColor.RED + "Suppresion de votre job "+ AffichageJob.affJob(job));

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setJobNull2(UUID uuid, Player player, JobUnit job) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE profiles SET jobs2 = ? WHERE uuid = ?");

            preparedStatement.setString(1, String.valueOf(JobUnit.NONE));
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            player.sendMessage(ChatColor.RED + "Suppresion de votre job "+ AffichageJob.affJob(job));

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setJobNull3(UUID uuid, Player player, JobUnit job) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE profiles SET jobs3 = ? WHERE uuid = ?");

            preparedStatement.setString(1, String.valueOf(JobUnit.NONE));
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            player.sendMessage(ChatColor.RED + "Suppresion de votre job "+ AffichageJob.affJob(job));

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
