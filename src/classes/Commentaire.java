package classes;

public class Commentaire {

    private int id_commentaire;
    private int id_membre;
    private int id_ligne_commande;
    private int isbn;
    private int id_statut;
    private int id_employe;
    private String objet;
    private String contenu;
    private int note;
    private String adresse_ip;
    private String commentaire;

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, int id_membre, int id_ligne_commande, int isbn, int id_statut, int id_employe, String objet, String contenu, int note, String adresse_ip, String commentaire) {
        this.id_commentaire = id_commentaire;
        this.id_membre = id_membre;
        this.id_ligne_commande = id_ligne_commande;
        this.isbn = isbn;
        this.id_statut = id_statut;
        this.id_employe = id_employe;
        this.objet = objet;
        this.contenu = contenu;
        this.note = note;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commentaire(int id_membre, int id_ligne_commande, int isbn, int id_statut, int id_employe, String objet, String contenu, int note, String adresse_ip, String commentaire) {
        this.id_membre = id_membre;
        this.id_ligne_commande = id_ligne_commande;
        this.isbn = isbn;
        this.id_statut = id_statut;
        this.id_employe = id_employe;
        this.objet = objet;
        this.contenu = contenu;
        this.note = note;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commentaire(int id_membre, int id_ligne_commande, int isbn, int id_statut, int id_employe, String objet, String contenu, int note, String adresse_ip) {
        this.id_membre = id_membre;
        this.id_ligne_commande = id_ligne_commande;
        this.isbn = isbn;
        this.id_statut = id_statut;
        this.id_employe = id_employe;
        this.objet = objet;
        this.contenu = contenu;
        this.note = note;
        this.adresse_ip = adresse_ip;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public int getId_ligne_commande() {
        return id_ligne_commande;
    }

    public void setId_ligne_commande(int id_ligne_commande) {
        this.id_ligne_commande = id_ligne_commande;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAdresse_ip() {
        return adresse_ip;
    }

    public void setAdresse_ip(String adresse_ip) {
        this.adresse_ip = adresse_ip;
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
        if (id_commentaire == 0) {
            s = "Commentaire{" + ", objet=" + objet + ", contenu=" + contenu + ", note=" + note + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';

        } else {
            s = "Commentaire{" + "id_commentaire=" + id_commentaire + ", id_membre=" + id_membre + ", id_ligne_commande=" + id_ligne_commande + ", isbn=" + isbn + ", id_statut=" + id_statut + ", id_employe=" + id_employe + ", objet=" + objet + ", contenu=" + contenu + ", note=" + note + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';

        }
        return s;
    }

}
