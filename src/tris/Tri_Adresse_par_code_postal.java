package tris;

import classes.Adresse;
import java.util.Comparator;

public class Tri_Adresse_par_code_postal implements Comparator<Adresse> {

    @Override
    public int compare(Adresse a1, Adresse a2) {

        return a1.getCode_postal().compareTo(a2.getCode_postal());

    }

}
