package classes;

public class Sous_theme implements Comparable<Sous_theme> {

    private int id_sous_theme;
    private Theme theme;
    private String libelle;

    public Sous_theme() {
    }

    public Sous_theme(int id_sous_theme, Theme theme, String libelle) {
        this.id_sous_theme = id_sous_theme;
        this.theme = theme;
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

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Sous_theme{" + "id_sous_theme=" + id_sous_theme + ", theme=" + theme + ", libelle=" + libelle + '}';
    }

    @Override
    public int compareTo(Sous_theme cible) {

        return this.getLibelle().compareTo(cible.getLibelle());
    }

}
