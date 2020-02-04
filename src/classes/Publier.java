package classes;

public class Publier {
    
    private String isbn;
    private int id_editeur;
    private float poids;
    private float prix;
    private String dimensions;
    private String nombre_page;

    public Publier() {
    }

    public Publier(String isbn, int id_editeur, float poids, float prix, String dimensions, String nombre_page) {
        this.isbn = isbn;
        this.id_editeur = id_editeur;
        this.poids = poids;
        this.prix = prix;
        this.dimensions = dimensions;
        this.nombre_page = nombre_page;
    }

    public Publier(float poids, float prix, String dimensions, String nombre_page) {
        this.poids = poids;
        this.prix = prix;
        this.dimensions = dimensions;
        this.nombre_page = nombre_page;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId_editeur() {
        return id_editeur;
    }

    public void setId_editeur(int id_editeur) {
        this.id_editeur = id_editeur;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getNombre_page() {
        return nombre_page;
    }

    public void setNombre_page(String nombre_page) {
        this.nombre_page = nombre_page;
    }

    @Override
    public String toString() {
        return "Publier{" + "isbn=" + isbn + ", id_editeur=" + id_editeur + ", poids=" + poids + ", prix=" + prix + ", dimensions=" + dimensions + ", nombre_page=" + nombre_page + '}';
    }


    
}
