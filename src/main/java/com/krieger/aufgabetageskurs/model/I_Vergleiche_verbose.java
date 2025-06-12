package com.krieger.aufgabetageskurs.model;

import com.krieger.aufgabetageskurs.data.Tageskurs;

@FunctionalInterface
public interface I_Vergleiche_verbose {
    I_Vergleiche_verbose vergleich = (Tageskurs t1, Tageskurs t2) -> {
        if (t1.getAktienkurs() > t2.getAktienkurs()) {
            System.out.println("Aktienkurs von t1 ist höher.");
        } else if (t1.getAktienkurs() < t2.getAktienkurs()) {
            System.out.println("Aktienkurs von t1 ist niedriger.");
        } else {
            System.out.println("Aktienkurse sind gleich.");
        }
    };

    void vergleiche(Tageskurs a, Tageskurs b);
}
