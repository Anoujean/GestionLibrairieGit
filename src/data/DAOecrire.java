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
public class DAOecrire extends DAO{

    public DAOecrire() {
        super();
    }
    
    public void insert(Ecrire e) {

        try {
            String query = "INSERT INTO Ecrire (id_auteur, isbn) VALUES (?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getAuteur().getId_auteur());
            pstmt.setString(2, e.getOuvrage().getIsbn());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void Delete(Ecrire e) {
        
        try {
            String query = "DELETE FROM Ecrire WHERE id_auteur = ? and isbn = ?;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getAuteur().getId_auteur());
            pstmt.setString(2, e.getOuvrage().getIsbn());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    
    
}
