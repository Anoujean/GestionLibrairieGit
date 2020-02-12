package tris;

import classes.Adresse;
import java.util.Comparator;

public class Tri_Adresse_par_pays implements Comparator<Adresse> {

    @Override
    public int compare(Adresse a1, Adresse a2) {

        return a1.getPays().compareTo(a2.getPays());

    }

}
