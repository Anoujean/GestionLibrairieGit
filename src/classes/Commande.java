package classes;

import java.util.List;

public class Commande implements Comparable<Commande> {

    private int id_commande;
    private Membre membre;
    private Employe employe;
    private Paiement paiement;
    private Adresse adresse;
    private Adresse adresse_facture;
    private Statut statut;
    private String date;
    private float frais_de_port;
    private String numero_commande;
    private String adresse_ip;
    private String commentaire;
    private List<Ligne_commande> lesLigne_commandes;

    public Commande() {
    }

    public Commande(int id_commande, Membre membre, Employe employe, Paiement paiement, Adresse adresse, Adresse adresse_facture, Statut statut, String date, float frais_de_port, String numero_commande, String adresse_ip, String commentaire) {
        this.id_commande = id_commande;
        this.membre = membre;
        this.employe = employe;
        this.paiement = paiement;
        this.adresse = adresse;
        this.adresse_facture = adresse_facture;
        this.statut = statut;
        this.date = date;
        this.frais_de_port = frais_de_port;
        this.numero_commande = numero_commande;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commande(Adresse adresse, Adresse adresse_facture, Statut statut, String date, float frais_de_port, String numero_commande, String adresse_ip, String commentaire) {
        this.adresse = adresse;
        this.adresse_facture = adresse_facture;
        this.statut = statut;
        this.date = date;
        this.frais_de_port = frais_de_port;
        this.numero_commande = numero_commande;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commande(Adresse adresse, Adresse adresse_facture, Statut statut, String date, float frais_de_port, String numero_commande, String adresse_ip) {
        this.adresse = adresse;
        this.adresse_facture = adresse_facture;
        this.statut = statut;
        this.date = date;
        this.frais_de_port = frais_de_port;
        this.numero_commande = numero_commande;
        this.adresse_ip = adresse_ip;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Adresse getAdresse_facture() {
        return adresse_facture;
    }

    public void setAdresse_facture(Adresse adresse_facture) {
        this.adresse_facture = adresse_facture;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getFrais_de_port() {
        return frais_de_port;
    }

    public void setFrais_de_port(float frais_de_port) {
        this.frais_de_port = frais_de_port;
    }

    public String getNumero_commande() {
        return numero_commande;
    }

    public void setNumero_commande(String numero_commande) {
        this.numero_commande = numero_commande;
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

    public List<Ligne_commande> getLesLigne_commandes() {
        return lesLigne_commandes;
    }

    public void setLesLigne_commandes(List<Ligne_commande> lesLigne_commandes) {
        this.lesLigne_commandes = lesLigne_commandes;
    }
    
    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", membre=" + membre + ", employe=" + employe + ", paiement=" + paiement + ", adresse=" + adresse + ", adresse_facture=" + adresse_facture + ", statut=" + statut + ", date=" + date + ", frais_de_port=" + frais_de_port + ", numero_commande=" + numero_commande + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';
    }

    @Override
    public int compareTo(Commande cible) {

        return this.getNumero_commande().compareTo(cible.getNumero_commande());
    }

}
