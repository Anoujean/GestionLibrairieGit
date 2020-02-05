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
public class DAOauteur extends DAO{

    public DAOauteur() {
        super();
    }
    
    public List<Auteur> select(){
        List<Auteur> lesAuteurs = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM Auteur;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Auteur lAuteur = new Auteur(rs.getInt("ID_AUTEUR"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"), rs.getString("DATE_DE_DECES"));
                lesAuteurs.add(lAuteur);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesAuteurs;
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
