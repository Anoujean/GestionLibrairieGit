package classes;

import java.util.List;

public class Theme implements Comparable<Theme> {

    private int id_theme;
    private String libelle;
    private List<Sous_theme> lesSous_themes;

    

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
        return lesSous_themes;
    }

    public void setLeSous_themes(List<Sous_theme> leSous_themes) {
        this.lesSous_themes = leSous_themes;
    }
    
    public void add(Sous_theme st){
        this.lesSous_themes.add(st);
    }

    @Override
    public String toString() {
        return libelle;
    }

    @Override
    public int compareTo(Theme cible) {

        return this.getLibelle().compareTo(cible.getLibelle());
    }

}
