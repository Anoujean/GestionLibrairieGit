package classes;

public class Commentaire implements Comparable<Commentaire> {

    private int id_commentaire;
    private Membre membre;
    private Ligne_commande ligne_commande;
    private Ouvrage ouvrage;
    private Statut statut;
    private Employe employe;
    private String objet;
    private String contenu;
    private int note;
    private String date;
    private String adresse_ip;
    private String commentaire;

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, Membre membre, Ligne_commande ligne_commande, Ouvrage ouvrage, Statut statut, Employe employe, String objet, String contenu, int note, String date, String adresse_ip, String commentaire) {
        this.id_commentaire = id_commentaire;
        this.membre = membre;
        this.ligne_commande = ligne_commande;
        this.ouvrage = ouvrage;
        this.statut = statut;
        this.employe = employe;
        this.objet = objet;
        this.contenu = contenu;
        this.note = note;
        this.date = date;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commentaire(String objet, String contenu, int note, String date, String adresse_ip, String commentaire) {
        this.objet = objet;
        this.contenu = contenu;
        this.note = note;
        this.date = date;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commentaire(String objet, String contenu, int note, String date, String adresse_ip) {
        this.objet = objet;
        this.contenu = contenu;
        this.note = note;
        this.date = date;
        this.adresse_ip = adresse_ip;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Ligne_commande getLigne_commande() {
        return ligne_commande;
    }

    public void setLigne_commande(Ligne_commande ligne_commande) {
        this.ligne_commande = ligne_commande;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return "Commentaire{" + "id_commentaire=" + id_commentaire + ", membre=" + membre + ", ligne_commande=" + ligne_commande + ", ouvrage=" + ouvrage + ", statut=" + statut + ", employe=" + employe + ", objet=" + objet + ", contenu=" + contenu + ", note=" + note + ", date=" + date + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';
    }

  

    @Override
    public int compareTo(Commentaire cible) {
        return this.getNote() - cible.getNote();
    }

}
