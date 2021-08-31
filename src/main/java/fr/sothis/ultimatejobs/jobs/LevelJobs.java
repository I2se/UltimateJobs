package fr.sothis.ultimatejobs.jobs;

import fr.sothis.ultimatejobs.jobs.expsql.*;
import fr.sothis.ultimatejobs.jobs.level.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LevelJobs {

    public static void levelAlchimiste(UUID uuid, Player player) {
        double exp = (double)ExpAlchimiste.getExp(uuid, player);
        double level = (double)LevelAlchimiste.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelAlchimiste.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job d'Alchimiste " + AffichageLevel.afflevel(JobUnit.ALCHIMISTE, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelAlchimiste.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job d'Alchimiste " + AffichageLevel.afflevel(JobUnit.ALCHIMISTE, uuid, player));
                }
            }
        }
    }

    public static void levelConstructeur(UUID uuid, Player player) {
        double exp = (double)ExpConstructeur.getExp(uuid, player);
        double level = (double)LevelConstructeur.getLevel(uuid, player);
        double beforelevel = (double)level - 2;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelConstructeur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Constructeur " + AffichageLevel.afflevel(JobUnit.CONSTRUCTEUR, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelConstructeur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Constructeur " + AffichageLevel.afflevel(JobUnit.CONSTRUCTEUR, uuid, player));
                }
            }
        }
    }

    public static void levelCrafteur(UUID uuid, Player player) {
        double exp = (double)ExpCrafteur.getExp(uuid, player);
        double level = (double)LevelCrafteur.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelCrafteur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Crafteur " + AffichageLevel.afflevel(JobUnit.CRAFTEUR, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelCrafteur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Crafteur " + AffichageLevel.afflevel(JobUnit.CRAFTEUR, uuid, player));
                }
            }
        }
    }

    public static void levelDigger(UUID uuid, Player player) {
        double exp = (double)ExpDigger.getExp(uuid, player);
        double level = (double)LevelDigger.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelDigger.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Digger " + AffichageLevel.afflevel(JobUnit.DIGGER, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelDigger.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Digger " + AffichageLevel.afflevel(JobUnit.DIGGER, uuid, player));
                }
            }
        }
    }

    public static void levelEnchanteur(UUID uuid, Player player) {
        double exp = (double)ExpEnchanteur.getExp(uuid, player);
        double level = (double)LevelEnchanteur.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelEnchanteur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job d'Enchanteur " + AffichageLevel.afflevel(JobUnit.ENCHANTEUR, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelEnchanteur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job d'Enchanteur " + AffichageLevel.afflevel(JobUnit.ENCHANTEUR, uuid, player));
                }
            }
        }
    }

    public static void levelExplorateur(UUID uuid, Player player) {
        double exp = (double)ExpExplorateur.getExp(uuid, player);
        double level = (double)LevelExplorateur.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelExplorateur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job d'Explorateur " + AffichageLevel.afflevel(JobUnit.EXPLORATEUR, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelExplorateur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job d'Explorateur " + AffichageLevel.afflevel(JobUnit.EXPLORATEUR, uuid, player));
                }
            }
        }
    }

    public static void levelFermier(UUID uuid, Player player) {
        double exp = (double)ExpFermier.getExp(uuid, player);
        double level = (double)LevelFermier.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelFermier.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Fermier " + AffichageLevel.afflevel(JobUnit.FERMIER, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelFermier.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Fermier " + AffichageLevel.afflevel(JobUnit.FERMIER, uuid, player));
                }
            }
        }
    }

    public static void levelPecheur(UUID uuid, Player player) {
        double exp = (double)ExpPecheur.getExp(uuid, player);
        double level = (double)LevelPecheur.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelPecheur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Pecheur " + AffichageLevel.afflevel(JobUnit.PECHEUR, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelPecheur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Pecheur " + AffichageLevel.afflevel(JobUnit.PECHEUR, uuid, player));
                }
            }
        }
    }

    public static void levelChasseur(UUID uuid, Player player) {
        double exp = (double)ExpChasseur.getExp(uuid, player);
        double level = (double)LevelChasseur.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelChasseur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Chasseur " + AffichageLevel.afflevel(JobUnit.CHASSEUR, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelChasseur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Chasseur " + AffichageLevel.afflevel(JobUnit.CHASSEUR, uuid, player));
                }
            }
        }
    }

    public static void levelMineur(UUID uuid, Player player) {
        double exp = (double)ExpMineur.getExp(uuid, player);
        double level = (double)LevelMineur.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelMineur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Mineur " + AffichageLevel.afflevel(JobUnit.MINEUR, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelMineur.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Mineur " + AffichageLevel.afflevel(JobUnit.MINEUR, uuid, player));
                }
            }
        }
    }

    public static void levelForgeron(UUID uuid, Player player) {
        double exp = (double)ExpForgeron.getExp(uuid, player);
        double level = (double)LevelForgeron.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelForgeron.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Forgeron " + AffichageLevel.afflevel(JobUnit.FORGERON, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelForgeron.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Forgeron " + AffichageLevel.afflevel(JobUnit.FORGERON, uuid, player));
                }
            }
        }
    }

    public static void levelBucheron(UUID uuid, Player player) {
        double exp = (double)ExpBucheron.getExp(uuid, player);
        double level = (double)LevelBucheron.getLevel(uuid, player);
        double beforelevel = (double)level - 1;
        double equationexp = (level * 50.0) + (beforelevel * (level * 50.0));
        int newlevel = (int)level + 1;

        if(level == 1.0) {
            if(exp >= 100.0) {
                LevelBucheron.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Bucheron " + AffichageLevel.afflevel(JobUnit.BUCHERON, uuid, player));
                }
            }
        } else {
            if(exp >= equationexp) {
                LevelBucheron.setLevel(uuid, player, newlevel);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + players.getDisplayName() + ChatColor.GRAY + " passe son job de Bucheron " + AffichageLevel.afflevel(JobUnit.BUCHERON, uuid, player));
                }
            }
        }
    }
}
