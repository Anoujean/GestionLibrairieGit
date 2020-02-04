package classes;

public class Theme implements Comparable<Theme>{

    private int id_theme;
    private String libelle;

    public Theme() {
    }

    public Theme(int id_theme, String libelle) {
        this.id_theme = id_theme;
        this.libelle = libelle;
    }

    public Theme(String libelle) {
        this.libelle = libelle;
    }

    public int getId_theme() {
        return id_theme;
    }

    public void setId_theme(int id_theme) {
        this.id_theme = id_theme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        String s;
        if (id_theme == 0) {
            s = "Theme{" + ", libelle=" + libelle + '}';

        } else {
            s = "Theme{" + "id_theme=" + id_theme + ", libelle=" + libelle + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Theme cible) {
        String ch1, ch2;
        ch1 = this.getLibelle();
        ch2 = cible.getLibelle();
        return ch1.compareTo(ch2);
    }

}
