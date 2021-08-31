package fr.sothis.ultimatejobs.jobs.level;

import fr.sothis.ultimatejobs.database.DatabaseManager;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class LevelDigger {

    public static int getLevel(UUID uuid, Player player) {
        int level_digger = 0;
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leveljobs WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String playerName = resultSet.getString("playerName");
                level_digger = resultSet.getInt("level_digger");
            }
            connection.close();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return level_digger;
    }

    public static void setLevel(UUID uuid, Player player, int level) {
        try {
            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE leveljobs SET level_digger = ? WHERE uuid = ?");

            preparedStatement.setInt(1, level);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
