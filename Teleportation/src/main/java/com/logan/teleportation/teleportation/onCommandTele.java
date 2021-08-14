package com.logan.teleportation.teleportation;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class onCommandTele implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equals("t") && sender instanceof Player) {

            Player p = (Player) sender;
            Location l = p.getLocation();
            String u = p.getUniqueId().toString();
            YamlConfiguration y = Teleportation.getYaml();

            p.sendMessage("tele working");
            
            if(args.length == 0){
                for (int i = 0; i < clickableText.getTextComponent().size(); i++) {
                    p.sendMessage(clickableText.getTextComponent().get(i));
                }
            }

            //set
            if (args.length > 0) {
                if (args[0].equals(Teleportation.set)) {

                    if (args[1].equals(Teleportation.l1)) {
                        setSectionLocation(l, u, y, Teleportation.l1);
                        p.sendMessage("HOME!");
                    }
                    if (args[1].equals(Teleportation.l2)) {
                        setSectionLocation(l, u, y, Teleportation.l2);
                        p.sendMessage("HOME!");
                    }
                    if (args[1].equals(Teleportation.l3)) {
                        setSectionLocation(l, u, y, Teleportation.l3);
                        p.sendMessage("HOME!");
                    }
                    if (args[1].equals(Teleportation.home)) {
                        setSectionLocation(l, u, y, Teleportation.home);
                        p.sendMessage("HOME!");
                    }

                } else if (args[0].equals(Teleportation.to)) {

                    if (args[1].equals(Teleportation.l1)) {
                        if (getSectionLocation(l, u, y, Teleportation.l1) != null) {
                            p.teleport(getSectionLocation(l, u, y, Teleportation.l1));
                            p.sendMessage("WORKING");
                        } else {
                            p.sendMessage("WORKING worng");
                            p.sendMessage("you must set a location first");
                        }
                    } else if (args[1].equals(Teleportation.l2)) {
                        if (getSectionLocation(l, u, y, Teleportation.l2) != null) {
                            p.teleport(getSectionLocation(l, u, y, Teleportation.l2));
                        } else {
                            p.sendMessage("you must set a location first");
                        }
                    } else if (args[1].equals(Teleportation.l3)) {
                        if (getSectionLocation(l, u, y, Teleportation.l3) != null) {
                            p.teleport(getSectionLocation(l, u, y, Teleportation.l3));
                        } else {
                            p.sendMessage("you must set a location first");
                        }
                    } else if (args[1].equals(Teleportation.home)) {
                        if (getSectionLocation(l, u, y, Teleportation.home) != null) {
                            p.teleport(getSectionLocation(l, u, y, Teleportation.home));
                        } else {
                            p.sendMessage("you must set a location first");
                        }
                    } else {
                        p.sendMessage("usage wrong");
                    }

                } else {
                    p.sendMessage("usage wrong");
                }
            }
            //save
            try {
                Teleportation.saveAndReload();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            sender.sendMessage("only player can execute this command!");

        }

        return false;
    }

    private void setSectionLocation(Location l, String u, YamlConfiguration y, String sectionName) {
        y.getConfigurationSection(u).set(sectionName, l);
        System.out.println(ChatColor.RED + sectionName + " SET");
    }

    private Location getSectionLocation(Location l, String u, YamlConfiguration y, String sectionName) {
//        if (y.getConfigurationSection(u).get(sectionName) != null) {
//
//            System.out.println(ChatColor.RED + sectionName + " GET");
        return y.getConfigurationSection(u).getLocation(sectionName);
//        } else {
//            return null;
//        }
    }


}
