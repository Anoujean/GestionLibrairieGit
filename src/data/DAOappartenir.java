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
public class DAOappartenir extends DAO{

    public DAOappartenir() {
        super();
    }
    
    public void insert(Appartenir a) {

        try {
            String query = "INSERT INTO Appartenir (isbn, id_evenement) VALUES (?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, a.getOuvrage().getIsbn());
            pstmt.setInt(2, a.getEvenement().getId_evenement());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void Delete(Appartenir a) {
        
        try {
            String query = "DELETE FROM Appartenir WHERE isbn = ? and id_evenement = ?;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, a.getOuvrage().getIsbn());
            pstmt.setInt(2, a.getEvenement().getId_evenement());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    
    
    
}
