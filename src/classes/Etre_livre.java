package classes;


public class Etre_livre {
    private int id_membre;
    private int id_adresse;

    public Etre_livre() {
    }

    public Etre_livre(int id_membre, int id_adresse) {
        this.id_membre = id_membre;
        this.id_adresse = id_adresse;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    @Override
    public String toString() {
        return "Etre_livre{" + "id_membre=" + id_membre + ", id_adresse=" + id_adresse + '}';
    }
    
    
}
