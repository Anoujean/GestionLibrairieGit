package classes;

import java.util.List;

public class Mot_clef implements Comparable<Mot_clef> {

    private int id_mot_clef;
    private String libelle;
    private List<Ouvrage> lesOuvrages;

    public Mot_clef() {
    }

    public Mot_clef(int id_mot_clef, String libelle) {
        this.id_mot_clef = id_mot_clef;
        this.libelle = libelle;
    }

    public Mot_clef(String libelle) {
        this.libelle = libelle;
    }

    public int getId_mot_clef() {
        return id_mot_clef;
    }

    public void setId_mot_clef(int id_mot_clef) {
        this.id_mot_clef = id_mot_clef;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Ouvrage> getLesOuvrages() {
        return lesOuvrages;
    }

    public void setLesOuvrages(List<Ouvrage> lesOuvrages) {
        this.lesOuvrages = lesOuvrages;
    }
    
    

    @Override
    public String toString() {
        return "Mot_clef{" + "id_mot_clef=" + id_mot_clef + ", libelle=" + libelle + '}';
    }

    @Override
    public int compareTo(Mot_clef cible) {

        return this.getLibelle().compareTo(cible.getLibelle());
    }

}
