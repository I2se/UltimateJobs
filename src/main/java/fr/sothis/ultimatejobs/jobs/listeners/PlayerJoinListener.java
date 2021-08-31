package fr.sothis.ultimatejobs.jobs.listeners;

import fr.sothis.ultimatejobs.Main;
import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.ExpJobs;
import fr.sothis.ultimatejobs.database.tables.LevelJobs;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        final UUID uuid = player.getUniqueId();
        final String displayName = player.getDisplayName();

        e.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + displayName );

        // Table Profiles
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

                final ArrayList<Profile> profiles = Main.getINSTANCE().getProfiles();
                if(profiles.contains(profile)){
                    profiles.remove(profile);
                }
                profiles.add(profile);
            } else {
                createNewProfile(uuid, displayName);


            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Table ExpJobs
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM expjobs WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String playerName = resultSet.getString("playerName");
                final double exp_alchimiste = resultSet.getDouble("exp_alchimiste");
                final double exp_constructeur = resultSet.getDouble("exp_constructeur");
                final double exp_crafteur = resultSet.getDouble("exp_crafteur");
                final double exp_digger = resultSet.getDouble("exp_digger");
                final double exp_enchanteur = resultSet.getDouble("exp_enchanteur");
                final double exp_explorateur = resultSet.getDouble("exp_explorateur");
                final double exp_fermier = resultSet.getDouble("exp_fermier");
                final double exp_pecheur = resultSet.getDouble("exp_pecheur");
                final double exp_chasseur = resultSet.getDouble("exp_chasseur");
                final double exp_mineur = resultSet.getDouble("exp_mineur");
                final double exp_forgeron = resultSet.getDouble("exp_forgeron");
                final double exp_bucheron = resultSet.getDouble("exp_bucheron");

                final ExpJobs expJobs = new ExpJobs(id, uuid, playerName, exp_alchimiste, exp_constructeur, exp_crafteur, exp_digger, exp_enchanteur, exp_explorateur, exp_fermier, exp_pecheur, exp_chasseur, exp_mineur, exp_forgeron, exp_bucheron);

                final ArrayList<ExpJobs> Expjobs = Main.getINSTANCE().getExpJobs();
                if(Expjobs.contains(expJobs)){
                    Expjobs.remove(expJobs);
                }
                Expjobs.add(expJobs);
            } else {
                createNewExpJobs(uuid, displayName);


            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Table LevelJobs
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leveljobs WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String playerName = resultSet.getString("playerName");
                final int level_alchimiste = resultSet.getInt("level_alchimiste");
                final int level_constructeur = resultSet.getInt("level_constructeur");
                final int level_crafteur = resultSet.getInt("level_crafteur");
                final int level_digger = resultSet.getInt("level_digger");
                final int level_enchanteur = resultSet.getInt("level_enchanteur");
                final int level_explorateur = resultSet.getInt("level_explorateur");
                final int level_fermier = resultSet.getInt("level_fermier");
                final int level_pecheur = resultSet.getInt("level_pecheur");
                final int level_chasseur = resultSet.getInt("level_chasseur");
                final int level_mineur = resultSet.getInt("level_mineur");
                final int level_forgeron = resultSet.getInt("level_forgeron");
                final int level_bucheron = resultSet.getInt("level_bucheron");

                final LevelJobs levelJobs = new LevelJobs(id, uuid, playerName, level_alchimiste, level_constructeur, level_crafteur, level_digger, level_enchanteur, level_explorateur, level_fermier, level_pecheur, level_chasseur, level_mineur, level_forgeron, level_bucheron);

                final ArrayList<LevelJobs> Leveljobs = Main.getINSTANCE().getLevelJobs();
                if(Leveljobs.contains(levelJobs)){
                    Leveljobs.remove(levelJobs);
                }
                Leveljobs.add(levelJobs);
            } else {
                createNewLevelJobs(uuid, displayName);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createNewProfile(UUID uuid, String displayName) throws SQLException {
        final Profile profile = new Profile(0, uuid, displayName, 0, 0, JobUnit.NONE, JobUnit.NONE, JobUnit.NONE);
        final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO profiles (uuid, playerName, level, coins, jobs1, jobs2, jobs3) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, uuid.toString());
        preparedStatement.setString(2, profile.getPlayerName());
        preparedStatement.setInt(3, profile.getLevel());
        preparedStatement.setDouble(4, profile.getCoins());
        preparedStatement.setString(5, String.valueOf(profile.getJobs1()));
        preparedStatement.setString(6, String.valueOf(profile.getJobs2()));
        preparedStatement.setString(7, String.valueOf(profile.getJobs3()));

        final int row = preparedStatement.executeUpdate();
        final ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(row > 0 && resultSet.next()) {
            final int id = resultSet.getInt(1);

            profile.setId(id);
            Main.getINSTANCE().getProfiles().add(profile);
        }

        connection.close();
    }

    private void createNewExpJobs(UUID uuid, String displayName) throws SQLException {
        final ExpJobs expJobs = new ExpJobs(0, uuid, displayName, 0.0, 0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
        final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO expjobs (uuid, playerName, exp_alchimiste, exp_constructeur, exp_crafteur, exp_digger, exp_enchanteur, exp_explorateur, exp_fermier, exp_pecheur, exp_chasseur, exp_mineur, exp_forgeron, exp_bucheron) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, uuid.toString());
        preparedStatement.setString(2, expJobs.getPlayerName());
        preparedStatement.setDouble(3, expJobs.getExp_alchimiste());
        preparedStatement.setDouble(4, expJobs.getExp_constructeur());
        preparedStatement.setDouble(5, expJobs.getExp_crafteur());
        preparedStatement.setDouble(6, expJobs.getExp_digger());
        preparedStatement.setDouble(7, expJobs.getExp_enchanteur());
        preparedStatement.setDouble(8, expJobs.getExp_explorateur());
        preparedStatement.setDouble(9, expJobs.getExp_fermier());
        preparedStatement.setDouble(10, expJobs.getExp_pecheur());
        preparedStatement.setDouble(11, expJobs.getExp_chasseur());
        preparedStatement.setDouble(12, expJobs.getExp_mineur());
        preparedStatement.setDouble(13, expJobs.getExp_forgeron());
        preparedStatement.setDouble(14, expJobs.getExp_bucheron());


        final int row = preparedStatement.executeUpdate();
        final ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(row > 0 && resultSet.next()) {
            final int id = resultSet.getInt(1);

            expJobs.setId(id);
            Main.getINSTANCE().getExpJobs().add(expJobs);
        }

        connection.close();
    }

    private void createNewLevelJobs(UUID uuid, String displayName) throws SQLException {
        final LevelJobs levelJobs = new LevelJobs(0, uuid, displayName, 0, 0,0,0,0,0,0,0,0,0,0,0);
        final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO leveljobs (uuid, playerName, level_alchimiste, level_constructeur, level_crafteur, level_digger, level_enchanteur, level_explorateur, level_fermier, level_pecheur, level_chasseur, level_mineur, level_forgeron, level_bucheron) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, uuid.toString());
        preparedStatement.setString(2, levelJobs.getPlayerName());
        preparedStatement.setInt(3, levelJobs.getExp_alchimiste());
        preparedStatement.setInt(4, levelJobs.getExp_constructeur());
        preparedStatement.setInt(5, levelJobs.getExp_crafteur());
        preparedStatement.setInt(6, levelJobs.getExp_digger());
        preparedStatement.setInt(7, levelJobs.getExp_enchanteur());
        preparedStatement.setInt(8, levelJobs.getExp_explorateur());
        preparedStatement.setInt(9, levelJobs.getExp_fermier());
        preparedStatement.setInt(10, levelJobs.getExp_pecheur());
        preparedStatement.setInt(11, levelJobs.getExp_chasseur());
        preparedStatement.setInt(12, levelJobs.getExp_mineur());
        preparedStatement.setInt(13, levelJobs.getExp_forgeron());
        preparedStatement.setInt(14, levelJobs.getExp_bucheron());


        final int row = preparedStatement.executeUpdate();
        final ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(row > 0 && resultSet.next()) {
            final int id = resultSet.getInt(1);

            levelJobs.setId(id);
            Main.getINSTANCE().getLevelJobs().add(levelJobs);
        }

        connection.close();
    }
}