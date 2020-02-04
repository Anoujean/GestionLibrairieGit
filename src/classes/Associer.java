package classes;


public class Associer {
    private Ouvrage ouvrage;
    private Mot_clef mot_clef;

    public Associer() {
    }

    public Associer(Ouvrage ouvrage, Mot_clef mot_clef) {
        this.ouvrage = ouvrage;
        this.mot_clef = mot_clef;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Mot_clef getMot_clef() {
        return mot_clef;
    }

    public void setMot_clef(Mot_clef mot_clef) {
        this.mot_clef = mot_clef;
    }

    @Override
    public String toString() {
        return "Associer{" + "ouvrage=" + ouvrage + ", mot_clef=" + mot_clef + '}';
    }

    
    
}
