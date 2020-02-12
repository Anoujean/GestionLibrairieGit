package tris;

import classes.Paiement;
import java.util.Comparator;

public class Tri_Paiement_par_date implements Comparator<Paiement> {

    @Override
    public int compare(Paiement o1, Paiement o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
