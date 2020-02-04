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
public class DAOpublier extends DAO{

    public DAOpublier() {
        super();
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
