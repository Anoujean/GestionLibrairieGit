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
public class DAOauteur extends DAO{

    public DAOauteur() {
        super();
    }
    
    public void insert(Auteur a) {

        try {
            String query = "INSERT INTO Auteur(nom, prenom, date_de_naissance, date_de_deces) VALUES (?,?,?,?);";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, a.getNom());
            pstmt.setString(2, a.getPrenom());
            pstmt.setString(3, a.getDate_de_naissance());
            pstmt.setString(4, a.getDate_de_deces());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Auteur a) {
        try {
            String query = "UPDATE Auteur SET nom = ? , prenom = ? , date_de_naissance = ? , date_de_deces = ? WHERE id_auteur = ? ;";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, a.getNom());
            pstmt.setString(2, a.getPrenom());
            pstmt.setString(3, a.getDate_de_naissance());
            pstmt.setString(4, a.getDate_de_deces());
            pstmt.setInt(5, a.getId_auteur());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
}
