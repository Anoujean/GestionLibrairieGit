package classes;

import java.util.List;

public class Employe extends Personne {

    private int id_employe;
    private String login;
    private String password;
    private List<Ouvrage> lesOuvrages;
    private List<Commentaire> lesCommentaires;
    private List<Commande> lesCommandes;

    public Employe() {
        super();
    }

    public Employe(int id_employe, String nom, String prenom, String date_de_naissance, String login, String password) {
        super(nom, prenom, date_de_naissance);
        this.id_employe = id_employe;
        this.login = login;
        this.password = password;
    }

    public Employe(String nom, String prenom, String date_de_naissance, String login, String password) {
        super(nom, prenom, date_de_naissance);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public List<Ouvrage> getLesOuvrages() {
        return lesOuvrages;
    }

    public void setLesOuvrages(List<Ouvrage> lesOuvrages) {
        this.lesOuvrages = lesOuvrages;
    }

    public List<Commentaire> getLesCommentaires() {
        return lesCommentaires;
    }

    public void setLesCommentaires(List<Commentaire> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }
    
    @Override
    public String toString() {
        return super.toString()+ "Employe{" + "id_employe=" + id_employe + ", login=" + login + ", password=" + password + '}';
    }

}
