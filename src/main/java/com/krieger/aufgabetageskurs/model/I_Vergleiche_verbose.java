package com.krieger.aufgabetageskurs.model;

import com.krieger.aufgabetageskurs.data.Tageskurs;

import java.util.Date;

@FunctionalInterface
public interface I_Vergleiche_verbose {
    I_Vergleiche_verbose vergleich = (Tageskurs t1, Tageskurs t2) -> {
        if (t1.getAktienkurs() > t2.getAktienkurs()) {
            return "Aktienkurs von t1 ist höher.";
        } else if (t1.getAktienkurs() < t2.getAktienkurs()) {
            return "Aktienkurs von t1 ist niedriger.";
        } else {
            return "Aktienkurse sind gleich.";
        }
    };
    Tageskurs[] tageskurse = new Tageskurs[] {
            new Tageskurs(
                    new Date(2024 - 1900, 3, 15),
                    100.0,
                    15000.0,
                    0.03,
                    0.05
            ),
            new Tageskurs(
                    new Date(2024 - 1900, 3, 16),
                    105.0,
                    15100.0,
                    0.05,
                    0.0067
            ),
            new Tageskurs(
                    new Date(2024 - 1900, 3, 17),
                    110.0,
                    15200.0,
                    0.476,
                    -0.0132
            )
    };

    static void sortieren1(){
        for (int i = 0; i < tageskurse.length - 1; i++) {
            for (int j = 0; j < tageskurse.length - 1 - i; j++) {
                if (tageskurse[j].getAktienkurs() > tageskurse[j + 1].getAktienkurs()) {
                    Tageskurs temp = tageskurse[j];
                    tageskurse[j] = tageskurse[j + 1];
                    tageskurse[j + 1] = temp;
                }
            }
        }
    }

    String vergleiche(Tageskurs a, Tageskurs b);
}
