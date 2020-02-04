package classes;


public class Ecrire {
    private Auteur auteur;
    private Ouvrage ouvrage;

    public Ecrire() {
    }

    public Ecrire(Auteur auteur, Ouvrage ouvrage) {
        this.auteur = auteur;
        this.ouvrage = ouvrage;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    @Override
    public String toString() {
        return "Ecrire{" + "auteur=" + auteur + ", ouvrage=" + ouvrage + '}';
    }

    
    
    
}
