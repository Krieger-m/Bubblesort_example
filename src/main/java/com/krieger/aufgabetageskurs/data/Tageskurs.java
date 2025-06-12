package com.krieger.aufgabetageskurs.data;

import java.util.Date;

@FunctionalInterface
interface I_Vergleiche_verbose {
    void vergleiche(Tageskurs a, Tageskurs b);
}

@FunctionalInterface
interface I_Vergleiche_numeric {
    int vergleiche2(Tageskurs a, Tageskurs b);
}


public class Tageskurs {

    private final Date datum;
    private final double aktienkurs;
    private final double daxWert;
    private final double prozAktie;
    private final double prozDAX;

    private static final I_Vergleiche_verbose vergleich = (Tageskurs t1, Tageskurs t2) -> {
        if (t1.aktienkurs > t2.aktienkurs) {
            System.out.println("Aktienkurs von t1 ist höher.");
        } else if (t1.aktienkurs < t2.aktienkurs) {
            System.out.println("Aktienkurs von t1 ist niedriger.");
        } else {
            System.out.println("Aktienkurse sind gleich.");
        }
    };

    private static final I_Vergleiche_numeric vergleich2 = (Tageskurs t1, Tageskurs t2) -> {
        if (t1.aktienkurs > t2.aktienkurs) {
            return 1;
        } else if (t1.aktienkurs < t2.aktienkurs) {
            return -1;
        } else {
            return 0;
        }
    };

    public Tageskurs(Date date, double a_kurs, double d_wert, double p_aktie, double p_DAX) {
        this.datum = date;
        this.aktienkurs = a_kurs;
        this.daxWert = d_wert;
        this.prozAktie = p_aktie;
        this.prozDAX = p_DAX;
    }

    static Tageskurs[] tageskurse = new Tageskurs[] {
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

    static Tageskurs[] tageskurse2 = new Tageskurs[] {
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

    public static void main(String[] args) {
        
        
        System.out.println("Unsortierte Tageskurse (nach Aktienkurs):");
        for (Tageskurs tk : tageskurse) {
            System.out.println("\t> Datum: " + tk.datum.toLocaleString() + ", Aktienkurs: " + tk.aktienkurs);
        }
        
                 // 1. durchgang mit return dem verbose sorter
        for (int i = 0; i < tageskurse.length - 1; i++) {
            for (int j = 0; j < tageskurse.length - 1 - i; j++) {
                if (tageskurse[j].aktienkurs > tageskurse[j + 1].aktienkurs) {
                    Tageskurs temp = tageskurse[j];
                    tageskurse[j] = tageskurse[j + 1];
                    tageskurse[j + 1] = temp;
                }
            }
        }



               
        System.out.println("\n//------------------ 1 ------------------//");
        System.out.println("1. Sortierte Tageskurse (nach Aktienkurs aufsteigend):");
        for (Tageskurs tk : tageskurse) {
            System.out.println("\t> Datum: " + tk.datum.toLocaleString() + ", Aktienkurs: " + tk.aktienkurs);
        }

        System.out.println("\n\t\t*/ 1. - Vergleichsbeispiele:");
        Tageskurs kurs1 = tageskurse[0];
        Tageskurs kurs2 = tageskurse[tageskurse.length - 1];

        System.out.print("\t\t\t/ Vergleich erster mit letztem Tageskurs: ");
        vergleich.vergleiche(kurs1, kurs2);

        System.out.print("\t\t\t/ Vergleich letzter mit erster Tageskurs: ");
        vergleich.vergleiche(kurs2, kurs1);

        Tageskurs kursGleich = new Tageskurs(new Date(2024 - 1900, 3, 18), 105.0, 15150.0, 0.01, 0.005);
        System.out.print("\t\t\t/ Vergleich zweiter mit einem gleichen Aktienkurs: ");
        vergleich.vergleiche(tageskurse[1], kursGleich);

                // 2. durchgang mit return 1, 0, -1


        for (int i = 0; i < tageskurse2.length - 1; i++) {
            for (int j = 0; j < tageskurse2.length - 1 - i; j++) {
                if (vergleich2.vergleiche2(tageskurse2[j], tageskurse2[j + 1])> 0) {
                    Tageskurs temp = tageskurse2[j];
                    tageskurse2[j] = tageskurse2[j + 1];
                    tageskurse2[j + 1] = temp;
                }
            }
        }
        System.out.println("\n//------------------ 2 ------------------//");
        System.out.println("2. Sortierte Tageskurse (nach Aktienkurs aufsteigend):");
        for (Tageskurs tk : tageskurse2) {
            System.out.println("\t> Datum: " + tk.datum.toLocaleString() + ", Aktienkurs: " + tk.aktienkurs);
        }

        System.out.println("\n\t\t*/ 2. - Vergleichsbeispiele:");
        Tageskurs kurs1_2 = tageskurse2[0];
        Tageskurs kurs2_2 = tageskurse2[tageskurse2.length - 1];

        System.out.println("\t\t\t/ Vergleich erster mit letztem Tageskurs: "+ String.valueOf(vergleich2.vergleiche2(kurs1_2, kurs2_2)));

        System.out.println("\t\t\t/ Vergleich letzter mit erster Tageskurs: "+ String.valueOf(vergleich2.vergleiche2(kurs2_2, kurs1_2)));

        Tageskurs kursGleich_2 = new Tageskurs(new Date(2024 - 1900, 3, 18), 105.0, 15150.0, 0.01, 0.005);
        System.out.println("\t\t\t/ Vergleich zweiter mit einem gleichen Aktienkurs: " + String.valueOf(vergleich2.vergleiche2(tageskurse2[1], kursGleich_2)));
    }


}