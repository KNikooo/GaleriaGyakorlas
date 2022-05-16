package kivetel_kezeles;

import java.time.LocalDate;
import java.util.ArrayList;

public class Osztaly1 {

    private int szam;
    private String szo;
    private LocalDate ido;
    private boolean igaz;
    private ArrayList<String> arrayLista;
    private String[] lista;

    /*alt + insert*/
 /*constructor*/
    public Osztaly1(int szam, String szo) {
        this.szam = szam;
        /*
        kivétel kezelés: 
            -elágazás létrehozása
            -try catch
            -kivétel kezelő osztály
        */
        if (szo.length() < 3) {
            try {
                new KivetelIO("A szó túl rövid");
            } catch (Exception e) {
                System.out.println("Valami hiba van");
            }
        }else{
            this.szo = szo;
        }
    }

    /*toString()*/
    @Override
    public String toString() {
        return "Osztaly1{" + "szam=" + szam + ", szo=" + szo + '}';
    }

}
