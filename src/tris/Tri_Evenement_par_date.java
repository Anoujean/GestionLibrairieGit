package tris;

import classes.Evenement;
import java.util.Comparator;

public class Tri_Evenement_par_date implements Comparator<Evenement> {

    @Override
    public int compare(Evenement e1, Evenement e2) {

        return e1.getDate_debut().compareTo(e2.getDate_debut());
    }

}
