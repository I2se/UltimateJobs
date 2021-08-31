package fr.sothis.ultimatejobs.jobs;

import java.util.Arrays;
import java.util.List;

public enum JobUnit {

    NONE("Aucun Métier", 0),
    ALCHIMISTE("Alchimiste", 1),
    CONSTRUCTEUR("Constructeur", 2),
    CRAFTEUR("Crafteur", 3),
    DIGGER("Digger", 4),
    ENCHANTEUR("Enchanteur", 5),
    EXPLORATEUR("Explorateur", 6),
    FERMIER("Fermier", 7),
    PECHEUR("Pecheur", 8),
    CHASSEUR("Chasseur", 9),
    MINEUR("Mineur", 10),
    FORGERON("Forgeron", 11),
    BUCHERON("Bucheron", 12);

    private String name;
    private int filter;

    JobUnit(String name,int filter) {
        this.name = name;
        this.filter = filter;
    }

    public static JobUnit getByName(String name) {
        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(JobUnit.NONE);
    }

    public static JobUnit getByPower(int filter) {
        return Arrays.stream(values()).filter(r -> r.getFilter() == filter).findAny().orElse(JobUnit.NONE);
    }

    public String getName() {
        return name;
    }

    public int getFilter() {
        return filter;
    }
}
