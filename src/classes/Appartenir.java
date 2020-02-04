package classes;


public class Appartenir {
    private Ouvrage ouvrage;
    private Evenement evenement;

    public Appartenir() {
    }

    public Appartenir(Ouvrage ouvrage, Evenement evenement) {
        this.ouvrage = ouvrage;
        this.evenement = evenement;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    @Override
    public String toString() {
        return "Appartenir{" + "ouvrage=" + ouvrage + ", evenement=" + evenement + '}';
    }

    
    
    
}
