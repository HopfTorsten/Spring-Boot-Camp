package com.mhp.securitydemo;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
class NewsService {

    private final static String LOREM = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod" +
            " tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
            "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor " +
            "sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt " +
            "ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et " +
            "ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

    public List<News> returnFreeTierNews() {


        return Arrays.asList(new News("Spanischer Tiger spricht italienisch", "Aus aller Welt", null),
                new News("Trump vergisst Twitter-Passwort", "Politik", null),
                new News("Schock: Schnitzel ungesünder als Kohlrabi!", "Essen und Trinken", null));


    }

    public List<News> returnPremiumNews() {


        return Arrays.asList(new News("Spanischer Tiger spricht italienisch", "Aus aller Welt", LOREM),
                new News("Trump vergisst Twitter-Passwort", "Politik", LOREM),
                new News("Schock: Schnitzel ungesünder als Kohlrabi!", "Essen und Trinken", LOREM));


    }


}
