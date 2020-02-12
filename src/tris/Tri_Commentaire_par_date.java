package tris;

import classes.Commentaire;
import java.util.Comparator;

public class Tri_Commentaire_par_date implements Comparator<Commentaire> {

    @Override
    public int compare(Commentaire o1, Commentaire o2) {
        
        return o1.getDate().compareTo(o2.getDate());
    }

}
