/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import classes.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cda402
 */
public class DAOpublier extends DAO{

    public DAOpublier() {
        super();
    }
    
    public List<Publier> select(){
        List<Publier> lesPublications = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT o.*, st.LIBELLE as LIBELLE_SOUS_THEME, t.*, s.NOM_STATUT, e.ID_EDITEUR, e.NOM as NOM_EDITEUR, e.EMAIL, e.TELEPHONE, p.POIDS, p.NOMBRE_PAGE, p.PRIX, p.DIMENSIONS\n" +
                            "FROM Ouvrage o, Sous_theme st, Theme t, Statut s, editeur e, publier p \n" +
                            "WHERE o.id_sous_theme = st.id_sous_theme \n" +
                            "AND st.id_theme = t.id_theme \n" +
                            "AND o.ID_STATUT = s.id_statut \n" +
                            "AND o.ISBN = p.ISBN \n" +
                            "AND e.ID_EDITEUR = p.ID_EDITEUR;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Theme leTheme = new Theme(rs.getInt("ID_THEME"), rs.getString("LIBELLE"));
                Sous_theme leSous_theme = new Sous_theme(rs.getInt("ID_SOUS_THEME"),leTheme,rs.getString("LIBELLE_SOUS_THEME"));
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leSous_theme, leStatut, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getString("COMMENTAIRE"));
                Editeur lEditeur = new Editeur(rs.getInt("ID_EDITEUR"), rs.getString("NOM_EDITEUR"), rs.getString("EMAIL"), rs.getString("TELEPHONE"));
                Publier laPublication = new Publier(lOuvrage, lEditeur, rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"));
                lesPublications.add(laPublication);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesPublications;
    }
    
    public void insert(Publier p) {

        try {
            String query = "INSERT INTO Publier (isbn, id_editeur, poids, prix, dimensions, nombre_page) VALUES (?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, p.getOuvrage().getIsbn());
            pstmt.setInt(2, p.getEditeur().getId_editeur());
            pstmt.setFloat(3, p.getPoids());
            pstmt.setFloat(4, p.getPrix());
            pstmt.setString(5, p.getDimensions());
            pstmt.setString(6, p.getNombre_page());
            
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Publier p) {
        
        try {
            String query = "UPDATE Publier SET poids = ?, prix = ?, dimensions = ?, nombre_page = ? WHERE isbn = ?, id_editeur = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setFloat(1, p.getPoids());
            pstmt.setFloat(2, p.getPrix());
            pstmt.setString(3, p.getDimensions());
            pstmt.setString(4, p.getNombre_page());
            pstmt.setString(5, p.getOuvrage().getIsbn());
            pstmt.setInt(6, p.getEditeur().getId_editeur());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    public void Delete(Publier p) {
        
        try {
            String query = "DELETE FROM Associer WHERE isbn = ?, id_editeur = ?;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, p.getOuvrage().getIsbn());
            pstmt.setInt(2, p.getEditeur().getId_editeur());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    
    
}
