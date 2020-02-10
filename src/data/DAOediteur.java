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
public class DAOediteur extends DAO{

    public DAOediteur() {
        super();
    }
    
    public List<Editeur> select(){
        List<Editeur> lesEditeurs = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM Editeur;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Editeur lEditeur = new Editeur(rs.getInt("ID_EDITEUR"), rs.getString("NOM"), rs.getString("EMAIL"), rs.getString("TELEPHONE"));
                lesEditeurs.add(lEditeur);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesEditeurs;
    }
    
    public void insert(Editeur e) {

        try {
            String query = "INSERT INTO Editeur (nom, email, telephone) VALUES (?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, e.getNom());
            pstmt.setString(2, e.getEmail());
            pstmt.setString(3, e.getTelephone());
            
            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Editeur e) {
        
        try {
            String query = "UPDATE Editeur SET nom = ? , email = ? , telephone = ? WHERE id_editeur = ?;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, e.getNom());
            pstmt.setString(2, e.getEmail());
            pstmt.setString(3, e.getTelephone());
            pstmt.setInt(4, e.getId_editeur());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    public void delete(Editeur e){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Editeur where id_editeur = " + e.getId_editeur());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public List<Ouvrage> getOuvragesByID(Editeur e) {
        List<Ouvrage> lesOuvrages = new ArrayList<>();

        try {
            String query = "select o.*, st.NOM_STATUT from ouvrage o, editeur edt, publier p, statut st where o.ISBN = p.ISBN and p.ID_EDITEUR = edt.ID_EDITEUR and o.ID_STATUT = st.ID_STATUT and edt.ID_EDITEUR = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_editeur());

            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leStatut, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("COMMENTAIRE"));
                lesOuvrages.add(lOuvrage);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesOuvrages;
    }
    
    public void Publier(Editeur e, Ouvrage o){
        
        try {
            String query = "INSERT INTO Publier VALUES (?,?);";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());
            pstmt.setInt(2, e.getId_editeur());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    public void deletePublier(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Publier where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deletePublier(Editeur e){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Publier where id_editeur = " + e.getId_editeur());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deletePublier(Ouvrage o, Editeur e){
        try {
            String query = "DELETE FROM Publier WHERE id_editeur = ? AND ISBN = ?";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_editeur());
            pstmt.setString(2, o.getIsbn());
            int result = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    
    
}
