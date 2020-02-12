package tris;

import classes.Membre;

import java.util.Comparator;

public class Tri_Membre_par_statut implements Comparator<Membre> {

    @Override
    public int compare(Membre m1, Membre m2) {
        return m1.getStatut().getNom_statut().compareTo(m2.getStatut().getNom_statut());

    }

}
