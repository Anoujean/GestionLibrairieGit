package classes;

public class Livraison {

    private int id_livraison;
    private Transporteur transporteur;
    private Commande commande;
    private String date_motif;
    private String motif;

    public Livraison() {
    }

    public Livraison(int id_livraison, Transporteur transporteur, Commande commande, String date_motif, String motif) {
        this.id_livraison = id_livraison;
        this.transporteur = transporteur;
        this.commande = commande;
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

    public Transporteur getTransporteur() {
        return transporteur;
    }

    public void setTransporteur(Transporteur transporteur) {
        this.transporteur = transporteur;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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
            s = "Livraison{" + "id_livraison=" + id_livraison + ", transporteur=" + transporteur + ", commande=" + commande + ", date_motif=" + date_motif + ", motif=" + motif + '}';

        }
        return s;
    }

}
