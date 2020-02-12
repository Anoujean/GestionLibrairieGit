package classes;

import java.util.List;

public class Evenement implements Comparable<Evenement> {

    private int id_evenement;
    private Statut statut;
    private String libelle;
    private String date_debut;
    private String date_fin;
    private String description;
    private String image;
    private float remise;
    private String commentaire;
    private List<Ouvrage> lesOuvrages;

    public Evenement() {

    }

    public Evenement(int id_evenement, Statut statut, String libelle, String date_debut, String date_fin, String description, String image, float remise, String commentaire) {
        this.id_evenement = id_evenement;
        this.statut = statut;
        this.libelle = libelle;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.image = image;
        this.remise = remise;
        this.commentaire = commentaire;
    }

    public Evenement(String libelle, String date_debut, String date_fin, String description, String image, float remise, String commentaire) {

        this.libelle = libelle;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.image = image;
        this.remise = remise;
        this.commentaire = commentaire;
    }

    public Evenement(String libelle, String date_debut, String date_fin, String description, String image, float remise) {

        this.libelle = libelle;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.image = image;
        this.remise = remise;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
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

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public List<Ouvrage> getLesOuvrages() {
        return lesOuvrages;
    }

    public void setLesOuvrages(List<Ouvrage> lesOuvrages) {
        this.lesOuvrages = lesOuvrages;
    }

    @Override
    public String toString() {
        return libelle ;
    }

    @Override
    public int compareTo(Evenement cible) {

        return this.getLibelle().compareTo(cible.getLibelle());
    }

}
