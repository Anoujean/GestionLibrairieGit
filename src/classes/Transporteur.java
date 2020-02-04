
package classes;


public class Transporteur implements Comparable<Transporteur>{
    private int id_transporteur = 0;
    private Statut statut;
    private String libelle;
    private String tel;
    private String mail;

    public Transporteur() {
    }

    public Transporteur(int id_transporteur, Statut statut, String libelle, String tel, String mail) {
        this.id_transporteur = id_transporteur;
        this.statut = statut;
        this.libelle = libelle;
        this.tel = tel;
        this.mail = mail;
    }

    public Transporteur(Statut statut, String libelle, String tel, String mail) {
        this.statut = statut;
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
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
             s= super.toString() + "Transporteur{" + "id_transporteur=" + id_transporteur + ", statut=" + statut + ", libelle=" + libelle + ", tel=" + tel + ", mail=" + mail + '}';
        }else{
             s= super.toString() + "Transporteur{" + ", statut=" + statut + ", libelle=" + libelle + ", tel=" + tel + ", mail=" + mail + '}';
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
