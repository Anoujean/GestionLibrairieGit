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
public class DAOediteur extends DAO{

    public DAOediteur() {
        super();
    }
    
    public List<Editeur> select(){
        List<Editeur> lesEditeurs = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM Editeur;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Editeur lEditeur = new Editeur(rs.getInt("ID_EDITEUR"), rs.getString("NOM"), rs.getString("EMAIL"), rs.getString("TELEPHONE"));
                lesEditeurs.add(lEditeur);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesEditeurs;
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
