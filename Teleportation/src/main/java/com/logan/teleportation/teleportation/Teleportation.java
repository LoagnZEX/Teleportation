package com.logan.teleportation.teleportation;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Teleportation extends JavaPlugin {

    private static File datafile;
    private static YamlConfiguration yaml;

    public static String set;
    public static String to;
    public static String l1;
    public static String l2;
    public static String l3;
    public static String home;
    public static String command;


    @Override
    public void onEnable() {
        command = "t";
        set = "set";
        to = "to";
        l1 = "Location1";
        l2 = "Location2";
        l3 = "Location3";
        home = "home";


        // Plugin startup logic
        getCommand("t").setExecutor(new onCommandTele());
        getCommand("t").setTabCompleter(new tabCompleteTele());
        getServer().getPluginManager().registerEvents(new onPlayerJoinServer(), this);

        new clickableText(command,set,to,l1,l2,l3,home);

        try {
            filesInitialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void filesInitialize() throws IOException {
        //data folder
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        datafile = new File(Bukkit.getServer().getPluginManager().getPlugin("Teleportation").getDataFolder(), "Teleportation.yml");

        if (!datafile.exists()) {
            datafile.createNewFile();
        }

        reload();


    }

    public static YamlConfiguration getYaml() {
        return yaml;
    }

    public static void saveAndReload() throws IOException {
        save();
        reload();
    }

    public static void reload() {
        yaml = YamlConfiguration.loadConfiguration(datafile);
    }

    public static void save() throws IOException {
        yaml.save(datafile);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }


}
