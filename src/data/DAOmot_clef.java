/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.*;
import classes.*;

/**
 *
 * @author cda402
 */
public class DAOmot_clef extends DAO {

    public DAOmot_clef() {
        super();
    }
    
    public List<Mot_clef> select(){
        List<Mot_clef> lesMot_clefs = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM Mot_clef;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Mot_clef leMot_clef = new Mot_clef(rs.getInt("ID_MOT_CLEF"), rs.getString("LIBELLE"));
                lesMot_clefs.add(leMot_clef);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesMot_clefs;
    }

    public void insert(Mot_clef mc) {

        try {
            String query = "INSERT INTO Mot_clef (libelle) VALUES (?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, mc.getLibelle());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Mot_clef mc) {
        
        try {
            String query = "UPDATE Mot_clef SET libelle = ? WHERE id_mot_clef = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, mc.getLibelle());
            pstmt.setInt(2, mc.getId_mot_clef());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }

}
