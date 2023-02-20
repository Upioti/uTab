package dev.upioti.tab;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TabReload implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender.hasPermission("tablist.reload")) {

            //Reloads config
            Main.getInstance().reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Config succesfully reloaded!");

            //Reloads tab for players
            String Header = (String) Main.getInstance().getConfig().get("Header");
            String Footer = (String) Main.getInstance().getConfig().get("Footer");
            Bukkit.getOnlinePlayers().forEach(player -> player.setPlayerListHeaderFooter("\n" + Header + "\n", "\n" + Footer + "\n"));

        } else {

            //Block reload when no perm
            sender.sendMessage(ChatColor.RED + "You dont have permission :C");

        }

        return false;
    }
}
