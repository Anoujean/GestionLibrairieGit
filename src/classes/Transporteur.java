
package classes;


public class Transporteur implements Comparable<Transporteur>{
    private int id_transporteur = 0;
    private int id_statut;
    private String libelle;
    private String tel;
    private String mail;

    public Transporteur() {
    }

    public Transporteur(int id_transporteur, int id_statut, String libelle, String tel, String mail) {
        this.id_transporteur = id_transporteur;
        this.id_statut = id_statut;
        this.libelle = libelle;
        this.tel = tel;
        this.mail = mail;
    }

    public Transporteur(int id_statut, String libelle, String tel, String mail) {
        this.id_statut = id_statut;
        this.libelle = libelle;
        this.tel = tel;
        this.mail = mail;
    }

    public int getId_transporteur() {
        return id_transporteur;
    }

    public void setId_transporteur(int id_transporteur) {
        this.id_transporteur = id_transporteur;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        String s;
        if(id_transporteur>0){
             s= super.toString() + "Transporteur{" + "id_transporteur=" + id_transporteur + ", id_statut=" + id_statut + ", libelle=" + libelle + ", tel=" + tel + ", mail=" + mail + '}';
        }else{
             s= super.toString() + "Transporteur{" + ", id_statut=" + id_statut + ", libelle=" + libelle + ", tel=" + tel + ", mail=" + mail + '}';
        }
        return s;
       
    }

    @Override
    public int compareTo(Transporteur cible) {
        String ch1, ch2;
        ch1 = this.getLibelle();
        ch2 = cible.getLibelle();
        return ch1.compareTo(ch2);
    }
    
    
    
}
