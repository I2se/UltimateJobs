package fr.sothis.ultimatejobs.jobs.expsql;

import fr.sothis.ultimatejobs.database.DatabaseManager;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ExpDigger {

    public static double getExp(UUID uuid, Player player) {
        double exp_digger = 0.0;
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM expjobs WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String playerName = resultSet.getString("playerName");
                exp_digger = resultSet.getDouble("exp_digger");
            }
            connection.close();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return exp_digger;
    }

    public static void addExp(UUID uuid, Player player, double exp) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE expjobs SET exp_digger = ? WHERE uuid = ?");
            final double expdb = getExp(uuid, player);
            final double addexp = expdb + exp;

            preparedStatement.setDouble(1, addexp);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void removeExp(UUID uuid, Player player, double exp) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE expjobs SET exp_digger = ? WHERE uuid = ?");
            final double expdb = getExp(uuid, player);
            final double removeexp = expdb - exp;

            preparedStatement.setDouble(1, removeexp);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void setExp(UUID uuid, Player player, double exp) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE expjobs SET exp_digger = ? WHERE uuid = ?");

            preparedStatement.setDouble(1, exp);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
