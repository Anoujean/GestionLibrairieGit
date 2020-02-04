package classes;


public class Membre extends Personne{
    private int id_membre = 0;
    private int id_statut;
    private String telephone;
    private String email;
    private String password;
    private String adresse_ip;
    private String commentaire;

    public Membre() {
    }

    public Membre(int id_membre, int id_statut,String nom, String prenom, String date_de_naissance, String telephone, String email, String password, String adresse_ip, String commentaire) {
        super(nom, prenom, date_de_naissance);
        this.id_membre = id_membre;
        this.id_statut = id_statut;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Membre(int id_statut, String nom, String prenom, String date_de_naissance, String telephone, String email, String password, String adresse_ip, String commentaire) {
        super(nom, prenom, date_de_naissance);
        this.id_statut = id_statut;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Membre(int id_statut,String nom, String prenom, String date_de_naissance, String telephone, String email, String password, String adresse_ip) {
        super(nom, prenom, date_de_naissance);
        this.id_statut = id_statut;
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

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
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

    @Override
    public String toString() {
        
        String s;
        if(id_membre>0){
           s = super.toString()+ "Membre{" + "id_membre=" + id_membre + ", id_statut=" + id_statut + ", telephone=" + telephone + ", email=" + email + ", password=" + password + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}'; 
        }else{
            return super.toString()+ "Membre{" + ", id_statut=" + id_statut + ", telephone=" + telephone + ", email=" + email + ", password=" + password + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';
        }
        return s;
        
    }
    
    
}
