package classes;

public class Ouvrage implements Comparable<Ouvrage>{

    private String isbn;
    private int id_sous_theme;
    private int id_statut;
    private String titre;
    private String image;
    private String sous_titre;
    private String resume;
    private float stock;
    private float tva;
    private String commentaire;

    public Ouvrage() {
    }

    public Ouvrage(String isbn, int id_sous_theme, int id_statut, String titre, String image, String sous_titre, String resume, float stock, float tva, String commentaire) {
        this.isbn = isbn;
        this.id_sous_theme = id_sous_theme;
        this.id_statut = id_statut;
        this.titre = titre;
        this.image = image;
        this.sous_titre = sous_titre;
        this.resume = resume;
        this.stock = stock;
        this.tva = tva;
        this.commentaire = commentaire;
    }

    public Ouvrage(String titre, String image, String sous_titre, String resume, float stock, float tva, String commentaire) {
        this.titre = titre;
        this.image = image;
        this.sous_titre = sous_titre;
        this.resume = resume;
        this.stock = stock;
        this.tva = tva;
        this.commentaire = commentaire;
    }

    public Ouvrage(String titre, String image, String sous_titre, String resume, float stock, float tva) {
        this.titre = titre;
        this.image = image;
        this.sous_titre = sous_titre;
        this.resume = resume;
        this.stock = stock;
        this.tva = tva;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId_sous_theme() {
        return id_sous_theme;
    }

    public void setId_sous_theme(int id_sous_theme) {
        this.id_sous_theme = id_sous_theme;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    

    @Override
    public String toString() {
        String s;
        if (isbn == "") {
            s = "Ouvrage{" + ", titre=" + titre + ", image=" + image + ", sous_titre=" + sous_titre + ", resume=" + resume + ", stock=" + stock + ", tva=" + tva + ", commentaire=" + commentaire + '}';

        } else {
            s = "Ouvrage{" + "isbn=" + isbn + ", id_sous_theme=" + id_sous_theme + ", id_statut=" + id_statut + ", titre=" + titre + ", image=" + image + ", sous_titre=" + sous_titre + ", resume=" + resume + ", stock=" + stock + ", tva=" + tva + ", commentaire=" + commentaire + '}';

        }
        return s;
    }

    @Override
    public int compareTo(Ouvrage cible) {
        String ch1, ch2;
        ch1 = this.getTitre();
        ch2 = cible.getTitre();
        return ch1.compareTo(ch2);
    }

}
