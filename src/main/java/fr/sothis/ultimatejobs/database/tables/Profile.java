package fr.sothis.ultimatejobs.database.tables;

import fr.sothis.ultimatejobs.jobs.JobUnit;

import java.util.UUID;

public class Profile {

    private int id;
    private UUID uuid;
    private String playerName;
    private int level;
    private double coins;
    private JobUnit jobs1;
    private JobUnit jobs2;
    private JobUnit jobs3;

    public Profile(int id, UUID uuid, String playerName, int level, double coins, JobUnit jobs1, JobUnit jobs2, JobUnit jobs3) {
        this.id = id;
        this.uuid = uuid;
        this.playerName = playerName;
        this.level = level;
        this.coins = coins;
        this.jobs1 = jobs1;
        this.jobs2 = jobs2;
        this.jobs3 = jobs3;
    }

    public int getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getLevel() {
        return level;
    }

    public double getCoins() {
        return coins;
    }

    public JobUnit getJobs1() {
        return jobs1;
    }

    public JobUnit getJobs2() {
        return jobs2;
    }

    public JobUnit getJobs3() {
        return jobs3;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public void setJobs1(JobUnit jobs1) {
        this.jobs1 = jobs1;
    }

    public void setJobs2(JobUnit jobs2) {
        this.jobs2 = jobs2;
    }

    public void setJobs3(JobUnit jobs3) {
        this.jobs3 = jobs3;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Profile createDefaultProfile() {
        return new Profile(1,UUID.randomUUID(), "Default", 0, 0.0, JobUnit.NONE, JobUnit.NONE, JobUnit.NONE);
    }

    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(!(o instanceof Profile)) {
            return false;
        } else {
            return ((Profile) o).getId() == this.id;
        }

    }
}
