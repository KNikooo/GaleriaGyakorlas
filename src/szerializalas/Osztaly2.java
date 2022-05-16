package szerializalas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Osztaly2 implements Serializable {

    private int szam;
    private String szo;
    private LocalDate ido;
    private boolean igaz;
    private ArrayList<String> arrayLista;
    private String[] lista;

    public Osztaly2() {
        arrayLista = new ArrayList<>();
    }

    public void felvesz(String szo) {
        arrayLista.add(szo);
    }
    public ArrayList<String> getArrayLista() {
        return arrayLista;
    }

    public void kiir() throws IOException {
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("raktar.txt"))) {
            objKi.writeObject(this);
            objKi.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Osztaly2 beolvas(String fajlNev) {
        Osztaly2 arrayLista = new Osztaly2(); // vagy: arrayList = null;
        try (ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajlNev))) {
            arrayLista = (Osztaly2) objBe.readObject();
            return arrayLista;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return arrayLista;
    }

    @Override
    public String toString() {
        return "Osztaly2{" + "szam=" + szam + ", szo=" + szo + '}';
    }

}
