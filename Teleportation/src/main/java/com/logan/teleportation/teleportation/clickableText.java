package com.logan.teleportation.teleportation;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.ArrayList;

public class clickableText {

    private static ArrayList<TextComponent> tc;
    private final TextComponent spacer = new TextComponent("  |  ");
    private final String homeText = "HOME";
    private final String location1Text = "Location1";
    private final String location2Text = "Location2";
    private final String location3Text = "Location3";

    public clickableText(String c, String s, String t, String l1, String l2, String l3, String h) {
        tc = new ArrayList<TextComponent>();

        TextComponent r1 = new TextComponent("----------------------");
        tc.add(r1);

        TextComponent r2 = new TextComponent("click or hover");
        r2.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.google.com"));
        r2.setBold(true);
        r2.setColor(ChatColor.GOLD);
        tc.add(r2);

        TextComponent r3 = new TextComponent("-------------------------");
        tc.add(r3);


        //-----------------------
        tc.add(new TextComponent(""));
        //-------------set
        //SET:  Location1  |  Location2  |  Location3  |  HOME
        TextComponent r4 = new TextComponent("SET:  ");
        r4.addExtra(TCBuilder(location1Text,c,s,l1));
        addLineSpacer(r4);
        r4.addExtra(TCBuilder(location2Text,c,s,l2));
        addLineSpacer(r4);
        r4.addExtra(TCBuilder(location3Text,c,s,l3));
        addLineSpacer(r4);
        r4.addExtra(TCBuilder(homeText,c,s,h));
        tc.add(r4);
        //space
        tc.add(new TextComponent(""));

        //---------------to
        //TO:  Location1  |  Location2  |  Location3  |  HOME
        TextComponent r5 = new TextComponent("TO:  ");
        r5.addExtra(TCBuilder(location1Text,c,t,l1));
        addLineSpacer(r5);
        r5.addExtra(TCBuilder(location2Text,c,t,l2));
        addLineSpacer(r5);
        r5.addExtra(TCBuilder(location3Text,c,t,l3));
        addLineSpacer(r5);
        r5.addExtra(TCBuilder(homeText,c,t,h));
        tc.add(r5);

        //-----------------
        tc.add(new TextComponent("----------------------"));

    }


    public static ArrayList<TextComponent> getTextComponent() {
        return tc;
    }

    private TextComponent TCBuilder(String Content, String command, String arg1, String arg2) {
        //commandBuilder
        TextComponent TC = new TextComponent(Content);
        TC.setColor(ChatColor.BLUE);
        TC.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/" + command + " " + arg1 + " " + arg2));
        return TC;
    }

    private void addLineSpacer(TextComponent t){
        t.addExtra(spacer);
    }
}
