package dev.upioti.tab;


import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    public static Main instance;

    public static Main getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Upioti's Tab Enabled!");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        this.getCommand("tabreload").setExecutor(new TabReload());


    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        String Header = (String) getConfig().get("Header");
        String Footer = (String) getConfig().get("Footer");
        e.getPlayer().setPlayerListHeaderFooter("\n" + Header + "\n", "\n" + Footer + "\n");

    }



    @Override
    public void onDisable() {

        getLogger().info("Upioti's tab goes bye :C");

    }
}


//TEC#0001 is sexy
