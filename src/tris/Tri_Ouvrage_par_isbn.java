package tris;


import classes.Ouvrage;
import java.util.Comparator;

public class Tri_Ouvrage_par_isbn implements Comparator<Ouvrage> {

    @Override
    public int compare(Ouvrage o1, Ouvrage o2) {
         return o1.getIsbn().compareTo(o2.getIsbn());
    }

}
