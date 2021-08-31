package fr.sothis.ultimatejobs.jobs.commands;

import fr.sothis.ultimatejobs.database.DatabaseManager;
import fr.sothis.ultimatejobs.database.tables.Profile;
import fr.sothis.ultimatejobs.jobs.AffichageJob;
import fr.sothis.ultimatejobs.jobs.AffichageLevel;
import fr.sothis.ultimatejobs.jobs.inventory.InvJobs;
import fr.sothis.ultimatejobs.jobs.JobUnit;
import fr.sothis.ultimatejobs.jobs.SetJobsSQL;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static fr.sothis.ultimatejobs.jobs.SetJobsSQL.*;

public class Job implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            UUID uuid = player.getUniqueId();

            if(label.equalsIgnoreCase("job")) {
                if(args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Merci de preciser la commande que vous souhaitez effectué");
                } else if(args.length >= 3) {
                    player.sendMessage(ChatColor.RED + "Merci de preciser la commande que vous souhaitez effectué");
                } else if(args[0].equalsIgnoreCase("join")) {
                    if (args.length == 1) {
                        InvJobs.invopenJoin(uuid, player);
                    }
                    if (args.length == 2) {
                        switch (args[1]) {
                            case "alchimiste":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.ALCHIMISTE);
                                break;

                            case "constructeur":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.CONSTRUCTEUR);
                                break;

                            case "crafteur":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.CRAFTEUR);
                                break;

                            case "digger":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.DIGGER);
                                break;

                            case "enchanteur":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.ENCHANTEUR);
                                break;

                            case "explorateur":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.EXPLORATEUR);
                                break;

                            case "fermier":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.FERMIER);
                                break;

                            case "pecheur":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.PECHEUR);
                                break;

                            case "chasseur":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.CHASSEUR);
                                break;

                            case "mineur":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.MINEUR);
                                break;

                            case "forgeron":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.FORGERON);
                                break;

                            case "bucheron":
                                SetJobsSQL.selectJob(uuid, player, JobUnit.BUCHERON);
                                break;

                            default:
                                sender.sendMessage(ChatColor.RED + "Commande Inconnue");
                                break;
                        }
                    }
                } else if(args[0].equalsIgnoreCase("remove")) {
                    if (args.length == 1) {
                        InvJobs.openinvRemove(uuid, player);
                    }
                    if (args.length == 2) {
                        try {
                            final Connection connection = DatabaseManager.JOBS.getDatabaseAccess().getConnection();
                            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM profiles WHERE uuid = ?");

                            preparedStatement.setString(1, uuid.toString());
                            preparedStatement.executeQuery();

                            final ResultSet resultSet = preparedStatement.getResultSet();

                            if (resultSet.next()) {
                                player.sendMessage(ChatColor.GOLD + "Votre compte a été trouvée dans la bdd (Profiles)");

                                final int id = resultSet.getInt("id");
                                final String playerName = resultSet.getString("playerName");
                                final int level = resultSet.getInt("level");
                                final double coins = resultSet.getDouble("coins");
                                final JobUnit jobs1 = JobUnit.valueOf(resultSet.getString("jobs1"));
                                final JobUnit jobs2 = JobUnit.valueOf(resultSet.getString("jobs2"));
                                final JobUnit jobs3 = JobUnit.valueOf(resultSet.getString("jobs3"));
                                final Profile profile = new Profile(id, uuid, playerName, level, coins, jobs1, jobs2, jobs3);

                                switch (args[1]) {
                                    case "alchimiste":
                                        if (profile.getJobs1().equals(JobUnit.ALCHIMISTE)) {
                                            setJobNull1(uuid, player, JobUnit.ALCHIMISTE);
                                        } else if (profile.getJobs2().equals(JobUnit.ALCHIMISTE)) {
                                            setJobNull2(uuid, player, JobUnit.ALCHIMISTE);
                                        } else if (profile.getJobs3().equals(JobUnit.ALCHIMISTE)) {
                                            setJobNull3(uuid, player, JobUnit.ALCHIMISTE);
                                        }
                                        break;

                                    case "constructeur":
                                        if (profile.getJobs1().equals(JobUnit.CONSTRUCTEUR)) {
                                            setJobNull1(uuid, player, JobUnit.CONSTRUCTEUR);
                                        } else if (profile.getJobs2().equals(JobUnit.CONSTRUCTEUR)) {
                                            setJobNull2(uuid, player, JobUnit.CONSTRUCTEUR);
                                        } else if (profile.getJobs3().equals(JobUnit.CONSTRUCTEUR)) {
                                            setJobNull3(uuid, player, JobUnit.CONSTRUCTEUR);
                                        }
                                        break;

                                    case "crafteur":
                                        if (profile.getJobs1().equals(JobUnit.CRAFTEUR)) {
                                            setJobNull1(uuid, player, JobUnit.CRAFTEUR);
                                        } else if (profile.getJobs2().equals(JobUnit.CRAFTEUR)) {
                                            setJobNull2(uuid, player, JobUnit.CRAFTEUR);
                                        } else if (profile.getJobs3().equals(JobUnit.CRAFTEUR)) {
                                            setJobNull3(uuid, player, JobUnit.CRAFTEUR);
                                        }
                                        break;

                                    case "digger":
                                        if (profile.getJobs1().equals(JobUnit.DIGGER)) {
                                            setJobNull1(uuid, player, JobUnit.DIGGER);
                                        } else if (profile.getJobs2().equals(JobUnit.DIGGER)) {
                                            setJobNull2(uuid, player, JobUnit.DIGGER);
                                        } else if (profile.getJobs3().equals(JobUnit.DIGGER)) {
                                            setJobNull3(uuid, player, JobUnit.DIGGER);
                                        }
                                        break;

                                    case "enchanteur":
                                        if (profile.getJobs1().equals(JobUnit.ENCHANTEUR)) {
                                            setJobNull1(uuid, player, JobUnit.ENCHANTEUR);
                                        } else if (profile.getJobs2().equals(JobUnit.ENCHANTEUR)) {
                                            setJobNull2(uuid, player, JobUnit.ENCHANTEUR);
                                        } else if (profile.getJobs3().equals(JobUnit.ENCHANTEUR)) {
                                            setJobNull3(uuid, player, JobUnit.ENCHANTEUR);
                                        }
                                        break;

                                    case "explorateur":
                                        if (profile.getJobs1().equals(JobUnit.EXPLORATEUR)) {
                                            setJobNull1(uuid, player, JobUnit.EXPLORATEUR);
                                        } else if (profile.getJobs2().equals(JobUnit.EXPLORATEUR)) {
                                            setJobNull2(uuid, player, JobUnit.EXPLORATEUR);
                                        } else if (profile.getJobs3().equals(JobUnit.EXPLORATEUR)) {
                                            setJobNull3(uuid, player, JobUnit.EXPLORATEUR);
                                        }
                                        break;

                                    case "fermier":
                                        if (profile.getJobs1().equals(JobUnit.FERMIER)) {
                                            setJobNull1(uuid, player, JobUnit.FERMIER);
                                        } else if (profile.getJobs2().equals(JobUnit.FERMIER)) {
                                            setJobNull2(uuid, player, JobUnit.FERMIER);
                                        } else if (profile.getJobs3().equals(JobUnit.FERMIER)) {
                                            setJobNull3(uuid, player, JobUnit.FERMIER);
                                        }
                                        break;

                                    case "pecheur":
                                        if (profile.getJobs1().equals(JobUnit.PECHEUR)) {
                                            setJobNull1(uuid, player, JobUnit.PECHEUR);
                                        } else if (profile.getJobs2().equals(JobUnit.PECHEUR)) {
                                            setJobNull2(uuid, player, JobUnit.PECHEUR);
                                        } else if (profile.getJobs3().equals(JobUnit.PECHEUR)) {
                                            setJobNull3(uuid, player, JobUnit.PECHEUR);
                                        }
                                        break;

                                    case "chasseur":
                                        if (profile.getJobs1().equals(JobUnit.CHASSEUR)) {
                                            setJobNull1(uuid, player, JobUnit.CHASSEUR);
                                        } else if (profile.getJobs2().equals(JobUnit.CHASSEUR)) {
                                            setJobNull2(uuid, player, JobUnit.CHASSEUR);
                                        } else if (profile.getJobs3().equals(JobUnit.CHASSEUR)) {
                                            setJobNull3(uuid, player, JobUnit.CHASSEUR);
                                        }
                                        break;

                                    case "mineur":
                                        if (profile.getJobs1().equals(JobUnit.MINEUR)) {
                                            setJobNull1(uuid, player, JobUnit.MINEUR);
                                        } else if (profile.getJobs2().equals(JobUnit.MINEUR)) {
                                            setJobNull2(uuid, player, JobUnit.MINEUR);
                                        } else if (profile.getJobs3().equals(JobUnit.MINEUR)) {
                                            setJobNull3(uuid, player, JobUnit.MINEUR);
                                        }
                                        break;

                                    case "forgeron":
                                        if (profile.getJobs1().equals(JobUnit.FORGERON)) {
                                            setJobNull1(uuid, player, JobUnit.FORGERON);
                                        } else if (profile.getJobs2().equals(JobUnit.FORGERON)) {
                                            setJobNull2(uuid, player, JobUnit.FORGERON);
                                        } else if (profile.getJobs3().equals(JobUnit.FORGERON)) {
                                            setJobNull3(uuid, player, JobUnit.FORGERON);
                                        }
                                        break;

                                    case "bucheron":
                                        if (profile.getJobs1().equals(JobUnit.BUCHERON)) {
                                            setJobNull1(uuid, player, JobUnit.BUCHERON);
                                        } else if (profile.getJobs2().equals(JobUnit.BUCHERON)) {
                                            setJobNull2(uuid, player, JobUnit.BUCHERON);
                                        } else if (profile.getJobs3().equals(JobUnit.BUCHERON)) {
                                            setJobNull3(uuid, player, JobUnit.BUCHERON);
                                        }
                                        break;

                                    case "all":
                                        if(!(profile.getJobs1().equals(JobUnit.NONE))) {
                                            setJobNull1(uuid, player, profile.getJobs1());
                                        }
                                        if(!(profile.getJobs2().equals(JobUnit.NONE))) {
                                            setJobNull2(uuid, player, profile.getJobs2());
                                        }
                                        if(!(profile.getJobs3().equals(JobUnit.NONE))) {
                                            setJobNull3(uuid, player, profile.getJobs3());
                                        }
                                        break;

                                    default:
                                        player.sendMessage(ChatColor.RED + "Commande Inconnue");
                                        break;
                                }
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                } else if(args[0].equalsIgnoreCase("list")) {
                    if (args.length == 1) {
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

                                player.sendMessage(ChatColor.DARK_GREEN + "--------------------------------------------------");
                                player.sendMessage(ChatColor.GOLD + "Vos jobs:");
                                player.sendMessage(ChatColor.GRAY + AffichageJob.affJob(jobs1) + " " + AffichageLevel.afflevel(jobs1, uuid, player));
                                player.sendMessage(ChatColor.GRAY + AffichageJob.affJob(jobs2) + " " + AffichageLevel.afflevel(jobs2, uuid, player));
                                player.sendMessage(ChatColor.GRAY + AffichageJob.affJob(jobs3) + " " + AffichageLevel.afflevel(jobs3, uuid, player));
                                player.sendMessage(ChatColor.DARK_GREEN + "--------------------------------------------------");
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Commande Inconnue");
                }
            } else {
                sender.sendMessage("Seul un joueur peut executer la commande !");
            }
        } else {
            sender.sendMessage("Seul un joueur peut executer la commande !");
        }
    return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length == 1) {
            List<String> completionarg1 = new ArrayList<>();
            completionarg1.add("join");
            completionarg1.add("remove");
            completionarg1.add("list");

            return completionarg1;
        }
        if(args[0].equalsIgnoreCase("join")) {
            if(args.length == 2) {
                List<String> completionjoin = new ArrayList<>();
                completionjoin.add("alchimiste");
                completionjoin.add("constructeur");
                completionjoin.add("crafteur");
                completionjoin.add("digger");
                completionjoin.add("enchanteur");
                completionjoin.add("explorateur");
                completionjoin.add("fermier");
                completionjoin.add("pecheur");
                completionjoin.add("chasseur");
                completionjoin.add("mineur");
                completionjoin.add("forgeron");
                completionjoin.add("bucheron");
                return completionjoin;
            }
        } else if(args[0].equalsIgnoreCase("remove")) {
            if(args.length == 2) {
                List<String> completionremove = new ArrayList<>();
                completionremove.add("alchimiste");
                completionremove.add("constructeur");
                completionremove.add("crafteur");
                completionremove.add("digger");
                completionremove.add("enchanteur");
                completionremove.add("explorateur");
                completionremove.add("fermier");
                completionremove.add("pecheur");
                completionremove.add("chasseur");
                completionremove.add("mineur");
                completionremove.add("forgeron");
                completionremove.add("bucheron");
                completionremove.add("all");
                return completionremove;
            }
        } else if(args[0].equalsIgnoreCase("list")) {
            if(args.length == 2) {
                List<String> completionlist = new ArrayList<>();
            }
        }
        return null;
    }
}