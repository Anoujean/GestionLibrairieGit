package classes;

import java.util.List;

public class Transporteur implements Comparable<Transporteur> {

    private int id_transporteur;
    private Statut statut;
    private String libelle;
    private String tel;
    private String mail;
    private List<Livraison> lesLivraisons;

    public Transporteur() {
    }

    public Transporteur(int id_transporteur, Statut statut, String libelle, String tel, String mail) {
        this.id_transporteur = id_transporteur;
        this.statut = statut;
        this.libelle = libelle;
        this.tel = tel;
        this.mail = mail;
    }

    public Transporteur(String libelle, String tel, String mail) {
        this.libelle = libelle;
        this.tel = tel;
        this.mail = mail;
    }

   

    public int getId_transporteur() {
        return id_transporteur;
    }

    public void setId_transporteur(int id_transporteur) {
        this.id_transporteur = id_transporteur;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Livraison> getLesLivraisons() {
        return lesLivraisons;
    }

    public void setLesLivraisons(List<Livraison> lesLivraisons) {
        this.lesLivraisons = lesLivraisons;
    }

    @Override
    public String toString() {
        return "Transporteur{" + "id_transporteur=" + id_transporteur + ", statut=" + statut + ", libelle=" + libelle + ", tel=" + tel + ", mail=" + mail + '}';
    }

    

    @Override
    public int compareTo(Transporteur cible) {

        return this.getLibelle().compareTo(cible.getLibelle());
    }

}
