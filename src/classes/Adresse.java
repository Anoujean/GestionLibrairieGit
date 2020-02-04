package classes;

public class Adresse implements Comparable<Adresse> {

    private int id_adresse;
    private String rue;
    private String code_postal;
    private String ville;
    private String pays;

    public Adresse() {
    }

    public Adresse(int id_adresse, String rue, String code_postal, String ville, String pays) {
        this.id_adresse = id_adresse;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.pays = pays;
    }

    public Adresse(String rue, String code_postal, String ville, String pays) {
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.pays = pays;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        String s;
        if (id_adresse == 0) {
            s = "Adresse{" + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + ", pays=" + pays + '}';

        } else {
            s = "Adresse{" + "id_adresse=" + id_adresse + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + ", pays=" + pays + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Adresse cible) {
        String ch1, ch2;
        ch1 = this.getVille();
        ch2 = cible.getVille();
        return ch1.compareTo(ch2);
    }

    
    
}
