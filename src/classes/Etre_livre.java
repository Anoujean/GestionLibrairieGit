package classes;


public class Etre_livre {
    private Membre membre;
    private Adresse adresse;

    public Etre_livre() {
    }

    public Etre_livre(Membre membre, Adresse adresse) {
        this.membre = membre;
        this.adresse = adresse;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    
    @Override
    public String toString() {
        return "Etre_livre{" + "membre=" + membre + ", adresse=" + adresse + '}';
    }
    
    
}
