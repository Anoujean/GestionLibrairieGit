package classes;

import java.util.List;

public class Organisme_Paiement implements Comparable<Organisme_Paiement> {

    private int id_organisme_paiement;
    private String nom;

    public Organisme_Paiement(int id_organisme_paiement, String nom) {
        this.id_organisme_paiement = id_organisme_paiement;
        this.nom = nom;
    }

    public Organisme_Paiement(String nom) {
        this.nom = nom;
    }

    public int getId_organisme_paiement() {
        return id_organisme_paiement;
    }

    public void setId_organisme_paiement(int id_organisme_paiement) {
        this.id_organisme_paiement = id_organisme_paiement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
  

    @Override
    public String toString() {
        return "Organisme_Paiement{" + "id_organisme_paiement=" + id_organisme_paiement + ", nom=" + nom + '}';
    }

    @Override
    public int compareTo(Organisme_Paiement cible) {

        return this.getNom().compareTo(cible.getNom());
    }

}
