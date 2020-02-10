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
public class DAOevenement extends DAO{

    public DAOevenement() {
        super();
    }
    
    public List<Evenement> select(){
        List<Evenement> lesEvenements = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "select e.*, s.nom_statut from evenement e, statut s where e.ID_STATUT = s.ID_STATUT;;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Evenement lEvenement = new Evenement(rs.getInt("ID_EVENEMENT"), leStatut, rs.getString("LIBELLE"), rs.getString("DATE_DEBUT"), rs.getString("DATE_FIN"), rs.getString("DESCRIPTION"), rs.getString("IMAGE"), rs.getFloat("REMISE"), rs.getString("COMMENTAIRE"));
                lesEvenements.add(lEvenement);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesEvenements;
    }
    
    public void insert(Evenement e) {

        try {
            String query = "INSERT INTO Evenement (id_statut, libelle, date_debut, date_fin, description, image, remise, commentaire) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getStatut().getId_statut());
            pstmt.setString(2, e.getLibelle());
            pstmt.setString(3, e.getDate_debut());
            pstmt.setString(4, e.getDate_fin());
            pstmt.setString(5, e.getDescription());
            pstmt.setString(6, e.getImage());
            pstmt.setFloat(7, e.getRemise());
            pstmt.setString(8, e.getCommentaire());
            
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Evenement e) {
        
        try {
            String query = "UPDATE Evenement SET id_statut = ?, libelle = ?, date_debut = ?, date_fin = ?, description = ?, image = ?, remise = ?, commentaire = ? WHERE id_evenement = ?;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getStatut().getId_statut());
            pstmt.setString(2, e.getLibelle());
            pstmt.setString(3, e.getDate_debut());
            pstmt.setString(4, e.getDate_fin());
            pstmt.setString(5, e.getDescription());
            pstmt.setString(6, e.getImage());
            pstmt.setFloat(7, e.getRemise());
            pstmt.setString(8, e.getCommentaire());
            pstmt.setInt(9, e.getId_evenement());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    public void delete(Evenement e){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Evenement where id_evenement = " + e.getId_evenement());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public List<Ouvrage> getOuvragesByID(Evenement e) {
        List<Ouvrage> lesOuvrages = new ArrayList<>();

        try {
            String query = "select o.*, sto.NOM_STATUT from ouvrage o, evenement evt, appartenir app, statut sto where o.ISBN = app.ISBN and app.ID_EVENEMENT = evt.ID_EVENEMENT and o.ID_STATUT = sto.ID_STATUT and evt.ID_EVENEMENT = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_evenement());

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
    
    public void Appartenir(Evenement e, Ouvrage o){
        
        try {
            String query = "INSERT INTO Appartenir VALUES (?,?);";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());
            pstmt.setInt(2, e.getId_evenement());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    public void deleteAppartenir(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Appartenir where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deleteAppartenir(Evenement e){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Appartenir where id_evenement = " + e.getId_evenement());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deleteAppartenir(Ouvrage o, Evenement e){
        try {
            String query = "DELETE FROM Evenement WHERE id_evenement = ? AND ISBN = ?";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_evenement());
            pstmt.setString(2, o.getIsbn());
            int result = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    
}
