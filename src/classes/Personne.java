package classes;

public class Personne implements Comparable<Personne> {

    private String nom;
    private String prenom;
    private String date_de_naissance;

    public Personne() {
    }

    public Personne(String nom, String prenom, String date_de_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    @Override
    public String toString() {
        return nom + " " + prenom ;
    }

    @Override
    public int compareTo(Personne cible) {

        return this.getNom().compareTo(cible.getNom());
    }

}
