package classes;


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
        String s;
        if (id_organisme_paiement == 0) {
            s = "Organisme_Paiement{" + "id_organisme_paiement=" + id_organisme_paiement + ", nom=" + nom + '}';

        } else {
            s = "Organisme_Paiement{" + "id_organisme_paiement=" + id_organisme_paiement + ", nom=" + nom + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Organisme_Paiement cible) {
        String ch1, ch2;
        ch1 = this.getNom();
        ch2 = cible.getNom();
        return ch1.compareTo(ch2);
    }

}
