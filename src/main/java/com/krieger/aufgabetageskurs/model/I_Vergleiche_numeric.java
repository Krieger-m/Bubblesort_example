package com.krieger.aufgabetageskurs.model;

import com.krieger.aufgabetageskurs.data.Tageskurs;

import java.util.Date;

@FunctionalInterface
public interface I_Vergleiche_numeric {
    I_Vergleiche_numeric vergleich2 = (Tageskurs t1, Tageskurs t2) -> {
        if (t1.getAktienkurs() > t2.getAktienkurs()) {
            return 1;
        } else if (t1.getAktienkurs() < t2.getAktienkurs()) {
            return -1;
        } else {
            return 0;
        }
    };
    Tageskurs[] tageskurse2 = new Tageskurs[] {
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

    static void sortieren2() {
        for (int i = 0; i < tageskurse2.length - 1; i++) {
            for (int j = 0; j < tageskurse2.length - 1 - i; j++) {
                if (vergleich2.vergleiche2(tageskurse2[j], tageskurse2[j + 1]) > 0) {
                    Tageskurs temp = tageskurse2[j];
                    tageskurse2[j] = tageskurse2[j + 1];
                    tageskurse2[j + 1] = temp;
                }
            }
        }
    }

    int vergleiche2(Tageskurs a, Tageskurs b);
}
