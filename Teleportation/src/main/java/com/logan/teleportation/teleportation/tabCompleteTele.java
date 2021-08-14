package com.logan.teleportation.teleportation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class tabCompleteTele implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
                                                @NotNull String alias, @NotNull String[] args) {
        List<String> l = new ArrayList();

        if (args.length == 1) {
            l.add(Teleportation.to);
            l.add(Teleportation.set);
        }else if (args.length == 2) {
            l.add(Teleportation.l1);
            l.add(Teleportation.l2);
            l.add(Teleportation.l3);
            l.add(Teleportation.home);

        }
        return l;
    }
}
