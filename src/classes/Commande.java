package classes;

public class Commande implements Comparable<Commande>{

    private int id_commande;
    private int id_membre;
    private int id_employe;
    private int id_paiment;
    private int id_adresse;
    private int id_adresse_facture;
    private int id_statut;
    private String date;
    private float frais_de_port;
    private String numero_commande;
    private String adresse_ip;
    private String commentaire;

    public Commande() {
    }

    public Commande(int id_commande, int id_membre, int id_employe, int id_paiment, int id_adresse, int id_adresse_facture, int id_statut, String date, float frais_de_port, String numero_commande, String adresse_ip, String commentaire) {
        this.id_commande = id_commande;
        this.id_membre = id_membre;
        this.id_employe = id_employe;
        this.id_paiment = id_paiment;
        this.id_adresse = id_adresse;
        this.id_adresse_facture = id_adresse_facture;
        this.id_statut = id_statut;
        this.date = date;
        this.frais_de_port = frais_de_port;
        this.numero_commande = numero_commande;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commande(String date, float frais_de_port, String numero_commande, String adresse_ip, String commentaire) {
        this.date = date;
        this.frais_de_port = frais_de_port;
        this.numero_commande = numero_commande;
        this.adresse_ip = adresse_ip;
        this.commentaire = commentaire;
    }

    public Commande(String date, float frais_de_port, String numero_commande, String adresse_ip) {
        this.date = date;
        this.frais_de_port = frais_de_port;
        this.numero_commande = numero_commande;
        this.adresse_ip = adresse_ip;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commannde(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public int getId_paiment() {
        return id_paiment;
    }

    public void setId_paiment(int id_paiment) {
        this.id_paiment = id_paiment;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public int getId_adresse_facture() {
        return id_adresse_facture;
    }

    public void setId_adresse_facture(int id_adresse_facture) {
        this.id_adresse_facture = id_adresse_facture;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
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

    @Override
    public String toString() {
        String s;
        if (id_commande == 0) {
            s = "Commande{" + ", date=" + date + ", frais_de_port=" + frais_de_port + ", numero_commande=" + numero_commande + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';

        } else {
            s = "Commande{" + "id_commande=" + id_commande + ", id_membre=" + id_membre + ", id_employe=" + id_employe + ", id_paiment=" + id_paiment + ", id_adresse=" + id_adresse + ", id_adresse_facture=" + id_adresse_facture + ", id_statut=" + id_statut + ", date=" + date + ", frais_de_port=" + frais_de_port + ", numero_commande=" + numero_commande + ", adresse_ip=" + adresse_ip + ", commentaire=" + commentaire + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Commande cible) {
        String ch1, ch2;
        ch1 = this.getNumero_commande();
        ch2 = cible.getNumero_commande();
        return ch1.compareTo(ch2);
    }

}
