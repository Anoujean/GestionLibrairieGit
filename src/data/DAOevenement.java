/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import classes.*;
import java.sql.*;

/**
 *
 * @author cda402
 */
public class DAOevenement extends DAO{

    public DAOevenement() {
        super();
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
    
    
}
