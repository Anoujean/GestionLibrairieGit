package tris;

import classes.Commande;
import java.util.Comparator;

public class Tri_Commande_par_date implements Comparator<Commande> {

    @Override
    public int compare(Commande c1, Commande c2) {

        return c1.getDate().compareTo(c2.getDate());
    }

}
