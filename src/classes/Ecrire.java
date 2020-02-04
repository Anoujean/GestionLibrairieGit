package classes;


public class Ecrire {
    private int id_auteur;
    private String isbn;

    public Ecrire() {
    }

    public Ecrire(int id_auteur, String isbn) {
        this.id_auteur = id_auteur;
        this.isbn = isbn;
    }

    public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Ecrire{" + "id_auteur=" + id_auteur + ", isbn=" + isbn + '}';
    }
    
    
}
