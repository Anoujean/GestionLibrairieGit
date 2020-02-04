package classes;


public class Etre_facture {
    private int id_adresse;
    private int id_membre;

    public Etre_facture() {
    }

    public Etre_facture(int id_adresse, int id_membre) {
        this.id_adresse = id_adresse;
        this.id_membre = id_membre;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    @Override
    public String toString() {
        return "Etre_facture{" + "id_adresse=" + id_adresse + ", id_membre=" + id_membre + '}';
    }
    
    
}
