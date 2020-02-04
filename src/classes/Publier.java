package classes;

public class Publier {
    
    private Ouvrage ouvrage;
    private Editeur editeur;
    private float poids;
    private float prix;
    private String dimensions;
    private String nombre_page;

    public Publier() {
    }

    public Publier(Ouvrage ouvrage, Editeur editeur, float poids, float prix, String dimensions, String nombre_page) {
        this.ouvrage = ouvrage;
        this.editeur = editeur;
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

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
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
        return "Publier{" + "ouvrage=" + ouvrage + ", editeur=" + editeur + ", poids=" + poids + ", prix=" + prix + ", dimensions=" + dimensions + ", nombre_page=" + nombre_page + '}';
    }
    
    

}