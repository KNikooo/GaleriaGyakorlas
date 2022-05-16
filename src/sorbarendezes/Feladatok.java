package sorbarendezes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Feladatok {

    private List<String> stringkLista;
    private ArrayList<Dal> dalok;

    public Feladatok() {
        beolvas("dalok.txt");
        feltolt();
    }

    public void feladat2_3() {
        /*osztályban rendezve*/
        Collections.sort(dalok); //Comparable
        kiir();
    }

    public void feladat4() {
        /*külső osztállyal rendezve*/
        Collections.sort(dalok, new EloadoComparator()); //Comparator
        kiir();
    }

    public void feladat5() {
        /*az osztályban statikus metodus hívja a külső rendezőt*/
        Collections.sort(dalok, Dal.EloadoRendezo());
        kiir();
    }

    public void feladat7() {
        /*ismétlések nélküli rendezés, hash-equals*/
        Set<Dal> ismNlkRendezetlen = new HashSet<>(dalok);
        for (Dal dal : ismNlkRendezetlen) {
            System.out.println(dal);
        }
    }

    private void beolvas(String fajlNeve) {
        try {
            stringkLista = Files.readAllLines(Paths.get(fajlNeve));
        } catch (IOException ex) {
            Logger.getLogger(Feladatok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void feltolt() {
        dalok = new ArrayList<>();
        for (String sor : stringkLista) {
            dalok.add(new Dal(sor));
        }
    }

    private void kiir() {
        for (Dal dal : dalok) {
            System.out.println(dal);
        }
    }
}
