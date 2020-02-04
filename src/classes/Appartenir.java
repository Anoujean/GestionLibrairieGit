package classes;


public class Appartenir {
    private String isbn;
    private int id_evenement;

    public Appartenir() {
    }

    public Appartenir(String isbn, int id_evenement) {
        this.isbn = isbn;
        this.id_evenement = id_evenement;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    @Override
    public String toString() {
        return "Appartenir{" + "isbn=" + isbn + ", id_evenement=" + id_evenement + '}';
    }
    
    
    
}
