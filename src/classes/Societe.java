package classes;


public class Societe implements Comparable<Societe> {
    
    private int id_societe;
    private String champ;
    private String valeur;

    public Societe() {
    }

    public Societe(int id_societe, String champ, String valeur) {
        this.id_societe = id_societe;
        this.champ = champ;
        this.valeur = valeur;
    }

    public Societe(String champ, String valeur) {
        this.champ = champ;
        this.valeur = valeur;
    }

    public int getId_societe() {
        return id_societe;
    }

    public void setId_societe(int id_societe) {
        this.id_societe = id_societe;
    }

    public String getChamp() {
        return champ;
    }

    public void setChamp(String champ) {
        this.champ = champ;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Societe{" + "id_societe=" + id_societe + ", champ=" + champ + ", valeur=" + valeur + '}';
    }

    @Override
    public int compareTo(Societe cible) {
        
        return this.getChamp().compareTo(cible.getChamp());
    }
    
    
    
}
