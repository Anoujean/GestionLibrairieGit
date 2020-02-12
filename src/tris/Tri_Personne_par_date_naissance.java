package tris;

import classes.Personne;
import java.util.Comparator;

public class Tri_Personne_par_date_naissance implements Comparator<Personne>{

    @Override
    public int compare(Personne o1, Personne o2) {
          return o1.getDate_de_naissance().compareTo(o2.getDate_de_naissance());
    }
    
    
}
