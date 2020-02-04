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
public class DAOassocier extends DAO{

    public DAOassocier() {
        super();
    }
    
    public void insert(Associer a) {

        try {
            String query = "INSERT INTO Associer (isbn, id_mot_clef) VALUES (?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, a.getOuvrage().getIsbn());
            pstmt.setInt(2, a.getMot_clef().getId_mot_clef());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void Delete(Associer a) {
        
        try {
            String query = "DELETE FROM Associer WHERE isbn = ? and id_mot_clef = ?;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, a.getOuvrage().getIsbn());
            pstmt.setInt(2, a.getMot_clef().getId_mot_clef());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    
}
