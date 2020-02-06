package classes;

public class Paiement implements Comparable<Paiement> {

    private int id_paiement;
    private Organisme_Paiement organisme_paiement;
    private Statut statut;
    private String numero_transaction;
    private String date;

    public Paiement() {
    }

    public Paiement(int id_paiement, Organisme_Paiement organisme_paiement, Statut statut, String numero_transaction, String date) {
        this.id_paiement = id_paiement;
        this.organisme_paiement = organisme_paiement;
        this.statut = statut;
        this.numero_transaction = numero_transaction;
        this.date = date;
    }

    public Paiement(String numero_transaction, String date) {
        this.numero_transaction = numero_transaction;
        this.date = date;
    }

    public int getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public Organisme_Paiement getOrganisme_paiement() {
        return organisme_paiement;
    }

    public void setOrganisme_paiement(Organisme_Paiement organisme_paiement) {
        this.organisme_paiement = organisme_paiement;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getNumero_transaction() {
        return numero_transaction;
    }

    public void setNumero_transaction(String numero_transaction) {
        this.numero_transaction = numero_transaction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Paiement{" + "id_paiement=" + id_paiement + ", organisme_paiement=" + organisme_paiement + ", statut=" + statut + ", numero_transaction=" + numero_transaction + ", date=" + date + '}';
    }

 
    @Override
    public int compareTo(Paiement cible) {

        return this.getNumero_transaction().compareTo(cible.getNumero_transaction());
    }

}
