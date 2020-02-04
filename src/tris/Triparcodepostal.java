package tris;

import classes.Adresse;
import java.util.Comparator;

public class Triparcodepostal implements Comparator<Adresse> {

    @Override
    public int compare(Adresse a1, Adresse a2) {

        String ch1, ch2;
        ch1 = a1.getCode_postal();
        ch2 = a2.getCode_postal();
        return ch1.compareTo(ch2);

    }

}
