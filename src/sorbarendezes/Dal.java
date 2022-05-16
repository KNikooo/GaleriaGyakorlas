package sorbarendezes;

import java.text.Collator;
import java.util.Comparator;
import java.util.Objects;


class EloadoComparator implements Comparator<Dal>{

     @Override
    public int compare(Dal egyik, Dal masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getEloado(), masik.getEloado());
    } 
   
}

public class Dal implements Comparable<Dal>{
    
    private String dalCime, eloado;

    public Dal(String dalCime, String eloado) {
        this(dalCime + " / " + eloado);
    }
    
    public Dal(String sor){
        String[] s = sor.split("/");
        dalCime = s[0].trim();
        eloado = s[1].trim();
    }

    public String getDalCime() { return dalCime; }
    public String getEloado() { return eloado; }
    public static EloadoComparator EloadoRendezo(){ return new EloadoComparator(); }
    
    @Override
    public String toString() {
        return dalCime + "/" + eloado;
    }

    @Override
    public int compareTo(Dal masik) {
        Collator col = Collator.getInstance();
        return col.compare(this.dalCime, masik.dalCime);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.dalCime);
        hash = 29 * hash + Objects.hashCode(this.eloado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dal other = (Dal) obj;
        if (!Objects.equals(this.dalCime, other.dalCime)) {
            return false;
        }
        if (!Objects.equals(this.eloado, other.eloado)) {
            return false;
        }
        return true;
    }  
}
