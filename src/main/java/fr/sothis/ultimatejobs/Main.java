package fr.sothis.ultimatejobs;

import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.ExpJobs;
import fr.sothis.ultimatejobs.database.tables.LevelJobs;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.jobs.commands.Job;
import fr.sothis.ultimatejobs.jobs.listeners.InventoryClickListener;
import fr.sothis.ultimatejobs.jobs.listeners.PlayerJoinListener;
import fr.sothis.ultimatejobs.jobs.listenersjobs.Bucheron;
import fr.sothis.ultimatejobs.jobs.listenersjobs.Chasseur;
import fr.sothis.ultimatejobs.jobs.listenersjobs.Digger;
import fr.sothis.ultimatejobs.jobs.listenersjobs.Mineur;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Main extends JavaPlugin {

    private static Main INSTANCE;

    private ArrayList<Profile> profiles = new ArrayList<>();
    private ArrayList<ExpJobs> expJobs = new ArrayList<>();
    private ArrayList<LevelJobs> levelJobs = new ArrayList<>();

    @Override
    public void onEnable() {
        setup();
        System.out.println(ChatColor.GRAY + "[" + ChatColor.GREEN + "ON" + ChatColor.GRAY + "] UltimateUnivers Plugin");
        DatabaseManager.initAllDatabaseConnections();

        // Dependency Vault
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        timer();
    }

    public void setup() {
        INSTANCE = this;

        registerCommands();
        registerListeners();
    }

    public void registerCommands() {

        getCommand("job").setExecutor(new Job());
        getCommand("job").setTabCompleter(new Job());
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);

        // Listeners Jobs
        pm.registerEvents(new Mineur(), this);
        pm.registerEvents(new Bucheron(), this);
        pm.registerEvents(new Chasseur(), this);
        pm.registerEvents(new Digger(), this);
    }

    public static Main getINSTANCE() {
        return INSTANCE;
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public ArrayList<ExpJobs> getExpJobs() {
        return expJobs;
    }

    public ArrayList<LevelJobs> getLevelJobs() {
        return levelJobs;
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.GRAY + "[" + ChatColor.RED + "OFF" + ChatColor.GRAY + "] UltimateUnivers Plugin");
        DatabaseManager.closeAllDatabaseConnections();
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    // Dependency Vault

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if(!(sender instanceof Player)) {
            log.info("Only players are supported for this Example Plugin, but you should not do this!!!");
            return true;
        }

        Player player = (Player) sender;

        if(command.getLabel().equals("test-economy")) {
            // Lets give the player 1.05 currency (note that SOME economic plugins require rounding!)
            sender.sendMessage(String.format("You have %s", econ.format(econ.getBalance(player.getName()))));
            EconomyResponse r = econ.depositPlayer(player, 1.05);
            if(r.transactionSuccess()) {
                sender.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
            } else {
                sender.sendMessage(String.format("An error occurred: %s", r.errorMessage));
            }
            return true;
        } else if(command.getLabel().equals("test-permission")) {
            // Lets test if user has the node "example.plugin.awesome" to determine if they are awesome or just suck
            if(perms.has(player, "example.plugin.awesome")) {
                sender.sendMessage("You are awesome!");
            } else {
                sender.sendMessage("You suck!");
            }
            return true;
        } else {
            return false;
        }
    }

    public static void timer() {
        Timer levelchrono = new Timer();

        levelchrono.schedule(new TimerTask() {

            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    UUID uuid = player.getUniqueId();

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
                            final double coins = resultSet.getDouble("coins");
                            final JobUnit jobs1 = JobUnit.valueOf(resultSet.getString("jobs1"));
                            final JobUnit jobs2 = JobUnit.valueOf(resultSet.getString("jobs2"));
                            final JobUnit jobs3 = JobUnit.valueOf(resultSet.getString("jobs3"));
                            final Profile profile = new Profile(id, uuid, playerName, level, coins, jobs1, jobs2, jobs3);

                            if (profile.getJobs1().equals(JobUnit.NONE)) {
                                return;
                            } else if (profile.getJobs1().equals(JobUnit.ALCHIMISTE)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelAlchimiste(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.CONSTRUCTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelConstructeur(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.CRAFTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelCrafteur(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.DIGGER)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelDigger(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.ENCHANTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelEnchanteur(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.EXPLORATEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelExplorateur(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.FERMIER)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelFermier(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.PECHEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelPecheur(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.CHASSEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelChasseur(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.MINEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelMineur(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.FORGERON)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelForgeron(uuid, player);
                            } else if (profile.getJobs1().equals(JobUnit.BUCHERON)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelBucheron(uuid, player);
                            }
                            if (profile.getJobs2().equals(JobUnit.NONE)) {
                                return;
                            } else if (profile.getJobs2().equals(JobUnit.ALCHIMISTE)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelAlchimiste(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.CONSTRUCTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelConstructeur(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.CRAFTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelCrafteur(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.DIGGER)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelDigger(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.ENCHANTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelEnchanteur(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.EXPLORATEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelExplorateur(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.FERMIER)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelFermier(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.PECHEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelPecheur(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.CHASSEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelChasseur(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.MINEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelMineur(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.FORGERON)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelForgeron(uuid, player);
                            } else if (profile.getJobs2().equals(JobUnit.BUCHERON)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelBucheron(uuid, player);
                            }
                            if (profile.getJobs3().equals(JobUnit.NONE)) {
                                return;
                            } else if (profile.getJobs3().equals(JobUnit.ALCHIMISTE)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelAlchimiste(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.CONSTRUCTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelConstructeur(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.CRAFTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelCrafteur(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.DIGGER)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelDigger(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.ENCHANTEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelEnchanteur(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.EXPLORATEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelExplorateur(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.FERMIER)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelFermier(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.PECHEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelPecheur(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.CHASSEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelChasseur(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.MINEUR)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelMineur(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.FORGERON)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelForgeron(uuid, player);
                            } else if (profile.getJobs3().equals(JobUnit.BUCHERON)) {
                                fr.sothis.ultimatejobs.jobs.LevelJobs.levelBucheron(uuid, player);
                            }
                        }
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }, 1000, 10000);
    }
}
