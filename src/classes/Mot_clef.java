package classes;

public class Mot_clef implements Comparable<Mot_clef>{

    private int id_mot_clef;
    private String libelle;

    public Mot_clef() {
    }

    public Mot_clef(int id_mot_clef, String libelle) {
        this.id_mot_clef = id_mot_clef;
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

    @Override
    public String toString() {
        String s;
        if (id_mot_clef == 0) {
            s = "Mot_clef{" + ", libelle=" + libelle + '}';

        } else {
            s = "Mot_clef{" + "id_mot_clef=" + id_mot_clef + ", libelle=" + libelle + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Mot_clef cible) {
        String ch1, ch2;
        ch1 = this.getLibelle();
        ch2 = cible.getLibelle();
        return ch1.compareTo(ch2);
    }

}
