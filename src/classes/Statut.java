package classes;

public class Statut {

    private int id_statut;
    private String nom_statut;

    public Statut() {
    }

    public Statut(int id_statut, String nom_statut) {
        this.id_statut = id_statut;
        this.nom_statut = nom_statut;
    }

    public Statut(String nom_statut) {
        this.nom_statut = nom_statut;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }

    public String getNom_statut() {
        return nom_statut;
    }

    public void setNom_statut(String nom_statut) {
        this.nom_statut = nom_statut;
    }

    @Override
    public String toString() {
        return "Statut{" + "id_statut=" + id_statut + ", nom_statut=" + nom_statut + '}';
    }

 
  
 
    

}
