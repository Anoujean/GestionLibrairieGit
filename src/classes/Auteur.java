package classes;

public class Auteur extends Personne{
    private int id_auteur = 0;
    private String date_de_deces;

    public Auteur() {
    }

    public Auteur(int id_auteur, String nom, String prenom, String date_de_naissance, String date_de_deces) {
        super(nom, prenom, date_de_naissance);
        this.id_auteur = id_auteur;
        this.date_de_deces = date_de_deces;
    }

    public Auteur(String nom, String prenom, String date_de_naissance,String date_de_deces) {
        super(nom, prenom, date_de_naissance);
        this.date_de_deces = date_de_deces;
    }

    public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }

    public String getDate_de_deces() {
        return date_de_deces;
    }

    public void setDate_de_deces(String date_de_deces) {
        this.date_de_deces = date_de_deces;
    }

    @Override
    public String toString() {
        
        String s;
        if (id_auteur>0){
            s =  super.toString()+ "Auteur{" + "id_auteur=" + id_auteur + ", date_de_deces=" + date_de_deces + '}';
        }else {
            s =  super.toString()+ "Auteur{" + ", date_de_deces=" + date_de_deces + '}';
        }
        return s;
        
    }
    
    
    
    
}
