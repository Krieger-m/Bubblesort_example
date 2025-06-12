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

    int vergleiche2(Tageskurs a, Tageskurs b);
}
