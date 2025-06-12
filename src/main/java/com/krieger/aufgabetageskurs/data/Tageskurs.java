package com.krieger.aufgabetageskurs.data;

import com.krieger.aufgabetageskurs.ctrl.Controller;

import java.io.IOException;
import java.util.Date;

import static com.krieger.aufgabetageskurs.model.I_Vergleiche_numeric.*;
import static com.krieger.aufgabetageskurs.model.I_Vergleiche_verbose.*;


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

    public static void main(String[] args) throws IOException {
        
        
        System.out.println("Unsortierte Tageskurse (nach Aktienkurs):");
        for (Tageskurs tk : tageskurse) {
            System.out.println("\t> Datum: " + tk.datum.toLocaleString() + ", Aktienkurs: " + tk.aktienkurs);
        }


        
                 // 1. durchgang mit return dem verbose sorter

        sortieren1();
               
        System.out.println("\n//------------------ 1 ------------------//");
        System.out.println("1. Sortierte Tageskurse (nach Aktienkurs aufsteigend):");
        for (Tageskurs tk : tageskurse) {
            System.out.println("\t> Datum: " + tk.datum.toLocaleString() + ", Aktienkurs: " + tk.aktienkurs);
        }

        System.out.println("\n\t\t*/ 1. - Vergleichsbeispiele:");
        Tageskurs kurs1 = tageskurse[0];
        Tageskurs kurs2 = tageskurse[tageskurse.length - 1];

        System.out.print("\t\t\t/ Vergleich erster mit letztem Tageskurs: "+
                vergleich.vergleiche(kurs1, kurs2));

        System.out.print("\t\t\t/ Vergleich letzter mit erster Tageskurs: "+ vergleich.vergleiche(kurs2, kurs1));

        Tageskurs kursGleich = new Tageskurs(new Date(2024 - 1900, 3, 18), 105.0, 15150.0, 0.01, 0.005);
        System.out.print("\t\t\t/ Vergleich zweiter mit einem gleichen Aktienkurs: "+
                vergleich.vergleiche(tageskurse[1], kursGleich));

                // 2. durchgang mit return 1, 0, -1

        sortieren2();

        System.out.println("\n//------------------ 2 ------------------//");
        System.out.println("2. Sortierte Tageskurse (nach Aktienkurs aufsteigend):");
        for (Tageskurs tk : tageskurse2) {
            System.out.println("\t> Datum: " + tk.datum.toLocaleString() + ", Aktienkurs: " + tk.aktienkurs);
        }

        System.out.println("\n\t\t*/ 2. - Vergleichsbeispiele:");
        Tageskurs kurs1_2 = tageskurse2[0];
        Tageskurs kurs2_2 = tageskurse2[tageskurse2.length - 1];

        System.out.print("\t\t\t/ Vergleich erster mit letztem Tageskurs: "+ String.valueOf(
                vergleich2.vergleiche2(kurs1_2, kurs2_2))
        );

        System.out.print("\t\t\t/ Vergleich letzter mit erster Tageskurs: "+ String.valueOf(
                vergleich2.vergleiche2(kurs2_2, kurs1_2))
        );


        Tageskurs kursGleich_2 = new Tageskurs(new Date(2024 - 1900, 3, 18), 105.0, 15150.0, 0.01, 0.005);
        System.out.print("\t\t\t/ Vergleich zweiter mit einem gleichen Aktienkurs: " + String.valueOf(
                vergleich2.vergleiche2(tageskurse2[1], kursGleich_2))
        );






    }

}