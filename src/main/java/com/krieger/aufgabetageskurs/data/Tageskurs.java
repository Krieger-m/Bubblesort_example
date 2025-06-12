package com.krieger.aufgabetageskurs.data;

import com.krieger.aufgabetageskurs.model.I_Vergleiche_numeric;
import com.krieger.aufgabetageskurs.model.I_Vergleiche_verbose;

import java.util.Date;


public class Tageskurs {

    private final Date datum;
    private final double aktienkurs;
    private final double daxWert;
    private final double prozAktie;
    private final double prozDAX;

    public double getAktienkurs() {
        return aktienkurs;
    }

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
        I_Vergleiche_verbose.vergleich.vergleiche(kurs1, kurs2);

        System.out.print("\t\t\t/ Vergleich letzter mit erster Tageskurs: ");
        I_Vergleiche_verbose.vergleich.vergleiche(kurs2, kurs1);

        Tageskurs kursGleich = new Tageskurs(new Date(2024 - 1900, 3, 18), 105.0, 15150.0, 0.01, 0.005);
        System.out.print("\t\t\t/ Vergleich zweiter mit einem gleichen Aktienkurs: ");
        I_Vergleiche_verbose.vergleich.vergleiche(tageskurse[1], kursGleich);

                // 2. durchgang mit return 1, 0, -1


        for (int i = 0; i < I_Vergleiche_numeric.tageskurse2.length - 1; i++) {
            for (int j = 0; j < I_Vergleiche_numeric.tageskurse2.length - 1 - i; j++) {
                if (I_Vergleiche_numeric.vergleich2.vergleiche2(I_Vergleiche_numeric.tageskurse2[j], I_Vergleiche_numeric.tageskurse2[j + 1])> 0) {
                    Tageskurs temp = I_Vergleiche_numeric.tageskurse2[j];
                    I_Vergleiche_numeric.tageskurse2[j] = I_Vergleiche_numeric.tageskurse2[j + 1];
                    I_Vergleiche_numeric.tageskurse2[j + 1] = temp;
                }
            }
        }
        System.out.println("\n//------------------ 2 ------------------//");
        System.out.println("2. Sortierte Tageskurse (nach Aktienkurs aufsteigend):");
        for (Tageskurs tk : I_Vergleiche_numeric.tageskurse2) {
            System.out.println("\t> Datum: " + tk.datum.toLocaleString() + ", Aktienkurs: " + tk.aktienkurs);
        }

        System.out.println("\n\t\t*/ 2. - Vergleichsbeispiele:");
        Tageskurs kurs1_2 = I_Vergleiche_numeric.tageskurse2[0];
        Tageskurs kurs2_2 = I_Vergleiche_numeric.tageskurse2[I_Vergleiche_numeric.tageskurse2.length - 1];

        System.out.print("\t\t\t/ Vergleich erster mit letztem Tageskurs: "+ String.valueOf(
                I_Vergleiche_numeric.vergleich2.vergleiche2(kurs1_2, kurs2_2)));

        System.out.print("\t\t\t/ Vergleich letzter mit erster Tageskurs: "+ String.valueOf(
                I_Vergleiche_numeric.vergleich2.vergleiche2(kurs2_2, kurs1_2)));

        Tageskurs kursGleich_2 = new Tageskurs(new Date(2024 - 1900, 3, 18), 105.0, 15150.0, 0.01, 0.005);
        System.out.print("\t\t\t/ Vergleich zweiter mit einem gleichen Aktienkurs: " + String.valueOf(
                I_Vergleiche_numeric.vergleich2.vergleiche2(I_Vergleiche_numeric.tageskurse2[1], kursGleich_2)));
    }


}