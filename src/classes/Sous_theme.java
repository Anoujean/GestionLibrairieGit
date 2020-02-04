package classes;

public class Sous_theme implements Comparable<Sous_theme> {

    private int id_sous_theme;
    private int id_theme;
    private String libelle;

    public Sous_theme() {
    }

    public Sous_theme(int id_sous_theme, int id_theme, String libelle) {
        this.id_sous_theme = id_sous_theme;
        this.id_theme = id_theme;
        this.libelle = libelle;
    }

    public Sous_theme(String libelle) {
        this.libelle = libelle;
    }

    public int getId_sous_theme() {
        return id_sous_theme;
    }

    public void setId_sous_theme(int id_sous_theme) {
        this.id_sous_theme = id_sous_theme;
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
        if (id_sous_theme == 0) {
            s = "Sous_theme{" + ", libelle=" + libelle + '}';

        } else {
            s = "Sous_theme{" + "id_sous_theme=" + id_sous_theme + ", id_theme=" + id_theme + ", libelle=" + libelle + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Sous_theme cible) {
       String ch1, ch2;
        ch1 = this.getLibelle();
        ch2 = cible.getLibelle();
        return ch1.compareTo(ch2);
    }

}
