package classes;


public class Etre_facture {
    private Adresse adresse;
    private Membre membre;

    public Etre_facture() {
    }

    public Etre_facture(Adresse adresse, Membre membre) {
        this.adresse = adresse;
        this.membre = membre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

   

    @Override
    public String toString() {
        return "Etre_facture{" + "adresse=" + adresse + ", membre=" + membre + '}';
    }
    
    
}
