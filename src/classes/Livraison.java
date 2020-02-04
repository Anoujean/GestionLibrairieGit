package classes;

public class Livraison {

    private int id_livraison;
    private int id_transporteur;
    private int id_commande;
    private String date_motif;
    private String motif;

    public Livraison() {
    }

    public Livraison(int id_livraison, int id_transporteur, int id_commande, String date_motif, String motif) {
        this.id_livraison = id_livraison;
        this.id_transporteur = id_transporteur;
        this.id_commande = id_commande;
        this.date_motif = date_motif;
        this.motif = motif;
    }

    public Livraison(String date_motif, String motif) {
        this.date_motif = date_motif;
        this.motif = motif;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public int getId_transporteur() {
        return id_transporteur;
    }

    public void setId_transporteur(int id_transporteur) {
        this.id_transporteur = id_transporteur;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getDate_motif() {
        return date_motif;
    }

    public void setDate_motif(String date_motif) {
        this.date_motif = date_motif;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        String s;
        if (id_livraison == 0) {
            s = "Livraison{" + ", date_motif=" + date_motif + ", motif=" + motif + '}';

        } else {
            s = "Livraison{" + "id_livraison=" + id_livraison + ", id_transporteur=" + id_transporteur + ", id_commande=" + id_commande + ", date_motif=" + date_motif + ", motif=" + motif + '}';

        }
        return s;
    }

}
