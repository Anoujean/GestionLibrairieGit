package classes;

public class Evenement implements Comparable<Evenement>{

    private int id_evenement = 0;
    private int id_statut;
    private String libelle;
    private String date_debut;
    private String date_fin;
    private String description;
    private String image;
    private float remise;
    private String commentaire;

    public Evenement() {
    }

    public Evenement(int id_evenement, int id_statut, String libelle, String date_debut, String date_fin, String description, String image, float remise, String commentaire) {
        this.id_evenement = id_evenement;
        this.id_statut = id_statut;
        this.libelle = libelle;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.image = image;
        this.remise = remise;
        this.commentaire = commentaire;
    }

    public Evenement(int id_statut, String libelle, String date_debut, String date_fin, String description, String image, float remise, String commentaire) {
        this.id_statut = id_statut;
        this.libelle = libelle;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.image = image;
        this.remise = remise;
        this.commentaire = commentaire;
    }

    public Evenement(int id_statut, String libelle, String date_debut, String date_fin, String description, String image, float remise) {
        this.id_statut = id_statut;
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

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
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

    @Override
    public String toString() {
        String s;
        if (id_evenement == 0) {
            s = "Evenement{" + ", libelle=" + libelle + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", description=" + description + ", image=" + image + ", remise=" + remise + ", commentaire=" + commentaire + '}';

        } else {
            s = "Evenement{" + "id_evenement=" + id_evenement + ", id_statut=" + id_statut + ", libelle=" + libelle + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", description=" + description + ", image=" + image + ", remise=" + remise + ", commentaire=" + commentaire + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Evenement cible) {
        String ch1, ch2;
        ch1 = this.getLibelle();
        ch2 = cible.getLibelle();
        return ch1.compareTo(ch2);
    }

}
