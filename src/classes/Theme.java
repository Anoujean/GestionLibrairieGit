package classes;

import java.util.List;

public class Theme implements Comparable<Theme> {

    private int id_theme;
    private String libelle;
    private List<Sous_theme> leSous_themes;

    

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
    
    public List<Sous_theme> getLeSous_themes() {
        return leSous_themes;
    }

    public void setLeSous_themes(List<Sous_theme> leSous_themes) {
        this.leSous_themes = leSous_themes;
    }

    @Override
    public String toString() {
        return "Theme{" + "id_theme=" + id_theme + ", libelle=" + libelle + '}';
    }

    @Override
    public int compareTo(Theme cible) {

        return this.getLibelle().compareTo(cible.getLibelle());
    }

}
