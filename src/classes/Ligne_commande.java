package classes;

public class Ligne_commande {

    private int id_ligne_commande = 0;
    private String isbn;
    private int id_commande;
    private int qte;
    private float prix;
    private float tva;
    private float remise;

    public Ligne_commande() {
    }

    public Ligne_commande(int id_ligne_commande, String isbn, int id_commande, int qte, float prix, float tva, float remise) {
        this.id_ligne_commande = id_ligne_commande;
        this.isbn = isbn;
        this.id_commande = id_commande;
        this.qte = qte;
        this.prix = prix;
        this.tva = tva;
        this.remise = remise;
    }

    public Ligne_commande(int id_commande, int qte, float prix, float tva, float remise) {
        this.id_commande = id_commande;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
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

    @Override
    public String toString() {
        String s;
        if (id_ligne_commande == 0) {
            s = "Ligne_commande{" + ", qte=" + qte + ", prix=" + prix + ", tva=" + tva + ", remise=" + remise + '}';

        } else {
            s = "Ligne_commande{" + "id_ligne_commande=" + id_ligne_commande + ", isbn=" + isbn + ", id_commande=" + id_commande + ", qte=" + qte + ", prix=" + prix + ", tva=" + tva + ", remise=" + remise + '}';

        }
        return s;
    }

}
