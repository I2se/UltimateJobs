package fr.sothis.ultimatejobs.database;

public enum DatabaseManager {

    JOBS(new DatabaseCredentials("host", "user", "pass", "dbName", 3306));

    private DatabaseAccess databaseAccess;

    DatabaseManager(DatabaseCredentials credentials) {
        this.databaseAccess = new DatabaseAccess(credentials);
    }

    public DatabaseAccess getDatabaseAccess() {
        return databaseAccess;
    }

    public static void initAllDatabaseConnections() {
        for(DatabaseManager databaseManager : values()) {
            databaseManager.databaseAccess.initPool();
        }
    }

    public static void closeAllDatabaseConnections() {
        for(DatabaseManager databaseManager : values()) {
            databaseManager.databaseAccess.closePool();
        }
    }
}
