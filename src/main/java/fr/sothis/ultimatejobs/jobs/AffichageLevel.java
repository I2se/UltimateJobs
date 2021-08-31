package fr.sothis.ultimatejobs.jobs;

import fr.sothis.ultimatejobs.jobs.level.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AffichageLevel {

    public static String afflevel(JobUnit job, UUID uuid, Player player) {

        if(job.equals(JobUnit.ALCHIMISTE)) {
            int level = LevelAlchimiste.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        } else if(job.equals(JobUnit.CONSTRUCTEUR)) {
            int level = LevelConstructeur.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.CRAFTEUR)) {
            int level = LevelCrafteur.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.DIGGER)) {
            int level = LevelDigger.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.ENCHANTEUR)) {
            int level = LevelEnchanteur.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.EXPLORATEUR)) {
            int level = LevelExplorateur.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.FERMIER)) {
            int level = LevelFermier.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.PECHEUR)) {
            int level = LevelPecheur.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.CHASSEUR)) {
            int level = LevelChasseur.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.MINEUR)) {
            int level = LevelMineur.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.FORGERON)) {
            int level = LevelForgeron.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }  else if(job.equals(JobUnit.BUCHERON)) {
            int level = LevelBucheron.getLevel(uuid, player);

            if(level <= 4) {
                String name = ChatColor.RESET + "" + ChatColor.GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 9) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GRAY + "[Level " + level + "]";
                return name;
            } else if(level <= 14) {
                String name = ChatColor.RESET + "" + ChatColor.AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 19) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_AQUA + "[Level " + level + "]";
                return name;
            } else if(level <= 24) {
                String name = ChatColor.RESET + "" + ChatColor.BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 29) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_BLUE + "[Level " + level + "]";
                return name;
            } else if(level <= 34) {
                String name = ChatColor.RESET + "" + ChatColor.GREEN+ "[Level " + level + "]";
                return name;
            } else if(level <= 39) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_GREEN + "[Level " + level + "]";
                return name;
            } else if(level <= 44) {
                String name = ChatColor.RESET + "" + ChatColor.YELLOW + "[Level " + level + "]";
                return name;
            } else if(level <= 49) {
                String name = ChatColor.RESET + "" + ChatColor.RED + "[Level " + level + "]";
                return name;
            } else if(level == 50) {
                String name = ChatColor.RESET + "" + ChatColor.DARK_RED + "[Level " + level + "]";
                return name;
            }
        }
        return null;
    }
}
