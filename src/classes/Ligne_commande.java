package classes;

import java.util.List;

public class Ligne_commande {

    private int id_ligne_commande;
    private Ouvrage ouvrage;
    private Commande commande;
    private int qte;
    private float prix;
    private float tva;
    private float remise;
    private List<Commentaire> lesCommentaires;

    public Ligne_commande() {
    }

    public Ligne_commande(int id_ligne_commande, Ouvrage ouvrage, Commande commande, int qte, float prix, float tva, float remise) {
        this.id_ligne_commande = id_ligne_commande;
        this.ouvrage = ouvrage;
        this.commande = commande;
        this.qte = qte;
        this.prix = prix;
        this.tva = tva;
        this.remise = remise;
    }

    public Ligne_commande(int qte, float prix, float tva, float remise) {
        this.qte = qte;
        this.prix = prix;
        this.tva = tva;
        this.remise = remise;
    }


    public int getId_ligne_commande() {
        return id_ligne_commande;
    }

    public void setId_ligne_commande(int id_ligne_commande) {
        this.id_ligne_commande = id_ligne_commande;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public List<Commentaire> getLesCommentaires() {
        return lesCommentaires;
    }

    public void setLesCommentaires(List<Commentaire> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }

    @Override
    public String toString() {
        return "Ligne_commande{" + "id_ligne_commande=" + id_ligne_commande + ", ouvrage=" + ouvrage + ", commande=" + commande + ", qte=" + qte + ", prix=" + prix + ", tva=" + tva + ", remise=" + remise + '}';
    }

   
    
}
