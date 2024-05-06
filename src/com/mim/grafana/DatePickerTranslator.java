package com.mim.grafana;

import java.util.HashMap;
import java.util.Map;

public class DatePickerTranslator {

    private static Map<String,String> translateMap;
    
    static{
        translateMap = new HashMap<>();
        translateMap.put("Last 5 minutes", "Les 5 dernières minutes");
        translateMap.put("Last 15 minutes", "Les 15 dernières minutes");
        translateMap.put("Last 30 minutes", "Les 30 dernières minutes");
        translateMap.put("Last 1 hour", "La dernière heure");
        translateMap.put("Last 3 hours", "Les 3 dernières heures");
        translateMap.put("Last 6 hours", "Les 6 dernières heures");
        translateMap.put("Last 12 hours", "Les 12 dernières heures");
        translateMap.put("Last 24 hours", "Les 24 dernières heures");
        translateMap.put("Last 2 days", "Les 2 derniers jours");
        translateMap.put("Last 7 days", "Les 7 derniers jours");
        translateMap.put("Last 30 days", "Les 30 derniers jours");
        translateMap.put("Last 90 days", "Les 90 derniers jours");
        translateMap.put("Last 6 months", "Les 6 derniers mois");
        translateMap.put("Last 1 year", "La dernières année");
        translateMap.put("Last 2 years", "Les 2 dernières années");
        translateMap.put("Last 5 years", "Les 5 dernières années");
        translateMap.put("Yesterday", "Hier");
        translateMap.put("Day before yesterday", "Avant-hier");
        translateMap.put("This day last week", "Ce jour la semaine dernière");
        translateMap.put("Previous week", "La semaine dernière");
        translateMap.put("Previous month", "Le mois dernier");
        translateMap.put("Previous fiscal quarter", "Le dernier trimestre fiscal");
        translateMap.put("Previous year", "L'année dernière");
        translateMap.put("Previous fiscal year", "La dernière année fiscale");
        translateMap.put("Today", "Aujourd'hui");
        translateMap.put("Today so far", "Aujourd'hui jusqu'à présent");
        translateMap.put("This week", "Cette semaine");
        translateMap.put("This week so far", "Cette semaine jusqu'à présent");
        translateMap.put("This month", "Ce mois");
        translateMap.put("This month so far", "Ce mois jusqu'à présent");
        translateMap.put("This year", "Cette année");
        translateMap.put("This year so far", "Cette année jusqu'à présent");
        translateMap.put("This fiscal quarter", "Ce trimestre fiscal");
        translateMap.put("This fiscal quarter so far", "Ce trimestre fiscal jusqu'à présent");
        translateMap.put("This fiscal year", "Cette année fiscal");
        translateMap.put("This fiscal year so far", "Cette année fiscal jusqu'à présent");
    }

    public static void main(String[] args) {
        Finder finder = new Finder(args[0]);
        finder.filterByExtension(".js");
        finder.filterByContent("Last 30 minutes");

        finder.translateAll(translateMap);

        finder.printFiles();
        System.out.println("=> FIN");
    }
}
