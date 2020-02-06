package classes;

import java.util.List;


public class Membre extends Personne {

    private int id_membre;
    private Statut statut;
    private String telephone;
    private String email;
    private String password;
    private String adresse_ip;
    private String commentaire;
    private List<Adresse> lesAdressesLivres;
    private List<Adresse> lesAdressesFactures;
    private List<Commande> lesCommandes;
    private List<Commentaire> lesCommentaires;

    public Membre() {
    }

    public Membre(int id_membre, Statut statut, String telephone, String email, String password, String adresse_ip, String commentaire, String nom, String prenom, String date_de_naissance) {
        super(nom, prenom, date_de_naissance);
        this.id_membre = id_membre;
        this.statut = statut;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Membre(String telephone, String email, String password, String adresse_ip, String commentaire, String nom, String prenom, String date_de_naissance) {
        super(nom, prenom, date_de_naissance);
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Membre(String telephone, String email, String password, String adresse_ip, String nom, String prenom, String date_de_naissance) {
        super(nom, prenom, date_de_naissance);
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.adresse_ip = adresse_ip;
    }

  

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Adresse> getLesAdressesLivres() {
        return lesAdressesLivres;
    }

    public void setLesAdressesLivres(List<Adresse> lesAdressesLivres) {
        this.lesAdressesLivres = lesAdressesLivres;
    }

    public List<Adresse> getLesAdressesFactures() {
        return lesAdressesFactures;
    }

    public void setLesAdressesFactures(List<Adresse> lesAdressesFactures) {
        this.lesAdressesFactures = lesAdressesFactures;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    public List<Commentaire> getLesCommentaires() {
        return lesCommentaires;
    }

    public void setLesCommentaires(List<Commentaire> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }
    
    

    @Override
    public String toString() {
        return "Membre{" + "id_membre=" + id_membre + ", statut=" + statut + ", telephone=" + telephone + ", email=" + email + ", password=" + password + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';
    }

    

}
