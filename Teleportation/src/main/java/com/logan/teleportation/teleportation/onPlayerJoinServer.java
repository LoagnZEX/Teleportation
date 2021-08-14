package com.logan.teleportation.teleportation;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class onPlayerJoinServer implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) throws IOException {

        if (!Teleportation.getYaml().contains(e.getPlayer().getUniqueId().toString())){
            Player p = e.getPlayer();
            String us = p.getUniqueId().toString();
            YamlConfiguration y = Teleportation.getYaml();
            y.createSection(us);

            if (!y.getConfigurationSection(us).contains(Teleportation.l1)){
                y.getConfigurationSection(us).createSection(Teleportation.l1);
            }
            if (!y.getConfigurationSection(us).contains(Teleportation.l2)){
                y.getConfigurationSection(us).createSection(Teleportation.l2);
            }
            if (!y.getConfigurationSection(us).contains(Teleportation.l3)){
                y.getConfigurationSection(us).createSection(Teleportation.l3);
            }
            if (!y.getConfigurationSection(us).contains(Teleportation.home)){
                y.getConfigurationSection(us).createSection(Teleportation.home);
            }
        }


        Teleportation.save();
    }


}
