package classes;

public class Paiement implements Comparable<Paiement>{

    private int id_paiement;
    private int id_organisme_paiement;
    private int id_statut;
    private String numero_transaction;
    private String date;

    public Paiement() {
    }

    public Paiement(int id_paiement, int id_organisme_paiement, int id_statut, String numero_transaction, String date) {
        this.id_paiement = id_paiement;
        this.id_organisme_paiement = id_organisme_paiement;
        this.id_statut = id_statut;
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

    public int getId_organisme_paiement() {
        return id_organisme_paiement;
    }

    public void setId_organisme_paiement(int id_organisme_paiement) {
        this.id_organisme_paiement = id_organisme_paiement;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
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
        String s;
        if (id_paiement == 0) {
            s = "Paiement{" + ", numero_transaction=" + numero_transaction + ", date=" + date + '}';

        } else {
            s = "Paiement{" + "id_paiement=" + id_paiement + ", id_organisme_paiement=" + id_organisme_paiement + ", id_statut=" + id_statut + ", numero_transaction=" + numero_transaction + ", date=" + date + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Paiement cible) {
       String ch1, ch2;
        ch1 = this.getNumero_transaction();
        ch2 = cible.getNumero_transaction();
        return ch1.compareTo(ch2);
    }

}
