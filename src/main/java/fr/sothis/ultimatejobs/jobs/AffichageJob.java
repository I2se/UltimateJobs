package fr.sothis.ultimatejobs.jobs;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AffichageJob {

    public static String affJob(JobUnit job) {
        String affichagejob = job.getName();

        return affichagejob;
    }

    public static void sendActionBar(Player player, double exp, double coins) {
        UUID uuid = player.getUniqueId();
        TextComponent action = new TextComponent();
        action.setText(ChatColor.AQUA + "" + exp  + "exps   " + ChatColor.GOLD + "$" + coins);
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(action));
    }
}
