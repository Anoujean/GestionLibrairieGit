package classes;


public class Associer {
    private String isbn;
    private int id_mot_clef;

    public Associer() {
    }

    public Associer(String isbn, int id_mot_clef) {
        this.isbn = isbn;
        this.id_mot_clef = id_mot_clef;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId_mot_clef() {
        return id_mot_clef;
    }

    public void setId_mot_clef(int id_mot_clef) {
        this.id_mot_clef = id_mot_clef;
    }

    @Override
    public String toString() {
        return "Associer{" + "isbn=" + isbn + ", id_mot_clef=" + id_mot_clef + '}';
    }
    
    
    
}
