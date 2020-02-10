/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.*;
import classes.*;

/**
 *
 * @author cda402
 */
public class DAOmot_clef extends DAO {

    public DAOmot_clef() {
        super();
    }
    
    public List<Mot_clef> select(){
        List<Mot_clef> lesMot_clefs = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM Mot_clef;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Mot_clef leMot_clef = new Mot_clef(rs.getInt("ID_MOT_CLEF"), rs.getString("LIBELLE"));
                lesMot_clefs.add(leMot_clef);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesMot_clefs;
    }

    public void insert(Mot_clef mc) {

        try {
            String query = "INSERT INTO Mot_clef (libelle) VALUES (?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, mc.getLibelle());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Mot_clef mc) {
        
        try {
            String query = "UPDATE Mot_clef SET libelle = ? WHERE id_mot_clef = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, mc.getLibelle());
            pstmt.setInt(2, mc.getId_mot_clef());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    public void delete(Mot_clef mc){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Mot_clef where id_mot_clef = " + mc.getId_mot_clef());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public List<Ouvrage> getOuvragesByID(Mot_clef mc) {
        List<Ouvrage> lesOuvrages = new ArrayList<>();

        try {
            String query = "select o.*, sto.NOM_STATUT from ouvrage o, mot_clef mc, associer assoc, statut sto where o.ISBN = assoc.ISBN and assoc.ID_MOT_CLEF = mc.ID_MOT_CLEF and o.ID_STATUT = sto.ID_STATUT and mc.ID_MOT_CLEF = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, mc.getId_mot_clef());

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
    
    public void Associer(Mot_clef mc, Ouvrage o){
        
        try {
            String query = "INSERT INTO Associer VALUES (?,?);";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());
            pstmt.setInt(2, mc.getId_mot_clef());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    public void deleteAssocier(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Associer where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deleteAssocier(Mot_clef mc){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Associer where id_mot_clef = " + mc.getId_mot_clef());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deleteAssocier(Ouvrage o, Mot_clef mc){
        try {
            String query = "DELETE FROM Associer WHERE id_mot_clef = ? AND ISBN = ?";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, mc.getId_mot_clef());
            pstmt.setString(2, o.getIsbn());
            int result = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
