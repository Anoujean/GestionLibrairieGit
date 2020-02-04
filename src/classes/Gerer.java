package classes;


public class Gerer {
    private int id_employe;
    private String isbn;

    public Gerer() {
    }

    public Gerer(int id_employe, String isbn) {
        this.id_employe = id_employe;
        this.isbn = isbn;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Gerer{" + "id_employe=" + id_employe + ", isbn=" + isbn + '}';
    }
    
    
}
