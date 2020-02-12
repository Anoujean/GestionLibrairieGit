package classes;

import java.util.List;

public class Ouvrage implements Comparable<Ouvrage> {

    private String isbn;
    private Statut statut;
    private String titre;
    private String image;
    private String sous_titre;
    private String resume;
    private float stock;
    private float tva;
    private float poids;
    private float prix;
    private String dimensions;
    private String nombre_page;
    private String commentaire;
    private List<Commentaire> lesCommentaires;
    private List<Evenement> lesEvenements;
    private List<Mot_clef> lesMot_clefs;
    private List<Sous_theme> lesSous_themes;
    private List<Auteur> lesAuteurs;

    public Ouvrage() {
    }

    public Ouvrage(String isbn, Statut statut, String titre, String image, String sous_titre, String resume, float stock, float tva, float poids, float prix, String dimensions, String nombre_page, String commentaire) {
        this.isbn = isbn;
        this.statut = statut;
        this.titre = titre;
        this.image = image;
        this.sous_titre = sous_titre;
        this.resume = resume;
        this.stock = stock;
        this.tva = tva;
        this.poids = poids;
        this.prix = prix;
        this.dimensions = dimensions;
        this.nombre_page = nombre_page;
        this.commentaire = commentaire;
    }

    public Ouvrage(Statut statut, String titre, String image, String sous_titre, String resume, float stock, float tva, float poids, float prix, String dimensions, String nombre_page, String commentaire) {
        this.statut = statut;
        this.titre = titre;
        this.image = image;
        this.sous_titre = sous_titre;
        this.resume = resume;
        this.stock = stock;
        this.tva = tva;
        this.poids = poids;
        this.prix = prix;
        this.dimensions = dimensions;
        this.nombre_page = nombre_page;
        this.commentaire = commentaire;
    }

    public Ouvrage(Statut statut, String titre, String image, String sous_titre, String resume, float stock, float tva, float poids, float prix, String dimensions, String nombre_page) {
        this.statut = statut;
        this.titre = titre;
        this.image = image;
        this.sous_titre = sous_titre;
        this.resume = resume;
        this.stock = stock;
        this.tva = tva;
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSous_titre() {
        return sous_titre;
    }

    public void setSous_titre(String sous_titre) {
        this.sous_titre = sous_titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
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
    
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public List<Commentaire> getLesCommentaires() {
        return lesCommentaires;
    }

    public void setLesCommentaires(List<Commentaire> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }

    public List<Evenement> getLesEvenements() {
        return lesEvenements;
    }

    public void setLesEvenements(List<Evenement> lesEvenements) {
        this.lesEvenements = lesEvenements;
    }

    public List<Mot_clef> getLesMot_clefs() {
        return lesMot_clefs;
    }

    public void setLesMot_clefs(List<Mot_clef> lesMot_clefs) {
        this.lesMot_clefs = lesMot_clefs;
    }

    public List<Sous_theme> getLesSous_themes() {
        return lesSous_themes;
    }

    public void setLesSous_themes(List<Sous_theme> lesSous_themes) {
        this.lesSous_themes = lesSous_themes;
    }

    public List<Auteur> getLesAuteurs() {
        return lesAuteurs;
    }

    public void setLesAuteurs(List<Auteur> lesAuteurs) {
        this.lesAuteurs = lesAuteurs;
    }
    
    @Override
    public String toString() {
        return  titre +" "+ sous_titre ;
    }

    @Override
    public int compareTo(Ouvrage cible) {

        return this.getTitre().compareTo(cible.getTitre());
    }

}
