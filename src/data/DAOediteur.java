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
public class DAOediteur extends DAO{

    public DAOediteur() {
        super();
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
    
    
    
}
