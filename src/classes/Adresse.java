package classes;

import java.util.List;

public class Adresse implements Comparable<Adresse> {

    private int id_adresse;
    private String rue;
    private String code_postal;
    private String ville;
    private String pays;
    private List<Membre> membresLivres;
    private List<Membre> membresFactures;
    private List<Commande> commandesLivres;
    private List<Commande> commandesFactures;
    

    public Adresse() {

    }

    public Adresse(int id_adresse, String rue, String code_postal, String ville, String pays) {
        this.id_adresse = id_adresse;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.pays = pays;
    }

    public Adresse(String rue, String code_postal, String ville, String pays) {

        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.pays = pays;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Membre> getMembresLivres() {
        return membresLivres;
    }

    public void setMembresLivres(List<Membre> membresLivres) {
        this.membresLivres = membresLivres;
    }

    public List<Membre> getMembresFactures() {
        return membresFactures;
    }

    public void setMembresFactures(List<Membre> membresFactures) {
        this.membresFactures = membresFactures;
    }

    public List<Commande> getCommandesLivres() {
        return commandesLivres;
    }

    public void setCommandesLivres(List<Commande> commandesLivres) {
        this.commandesLivres = commandesLivres;
    }

    public List<Commande> getCommandesFactures() {
        return commandesFactures;
    }

    public void setCommandesFactures(List<Commande> commandesFactures) {
        this.commandesFactures = commandesFactures;
    }
    
    

    @Override
    public String toString() {
        return "Adresse{" + "id_adresse=" + id_adresse + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + ", pays=" + pays + '}';
    }

    @Override
    public int compareTo(Adresse cible) {

        return this.getVille().compareTo(cible.getVille());
    }

}
