package classes;

import java.util.List;

public class Editeur implements Comparable<Editeur> {

    private int id_editeur;
    private String nom;
    private String email;
    private String telephone;
    private List<Ouvrage> lesOuvrages;

    public Editeur() {
    }

    public Editeur(String nom, String email, String telephone) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    public Editeur(int id_editeur, String nom, String email, String telephone) {
        this.id_editeur = id_editeur;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    public int getId_editeur() {
        return id_editeur;
    }

    public void setId_editeur(int id_editeur) {
        this.id_editeur = id_editeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Ouvrage> getLesOuvrages() {
        return lesOuvrages;
    }

    public void setLesOuvrages(List<Ouvrage> lesOuvrages) {
        this.lesOuvrages = lesOuvrages;
    }
  
    @Override
    public String toString() {
        return "Editeur{" + "id_editeur=" + id_editeur + ", nom=" + nom + ", email=" + email + ", telephone=" + telephone + '}';
    }

    @Override
    public int compareTo(Editeur cible) {

        return this.getNom().compareTo(cible.getNom());
    }

}
