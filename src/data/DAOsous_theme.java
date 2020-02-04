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
public class DAOsous_theme extends DAO{
    
    public DAOsous_theme() {
        super();
    }
    
    public void insert(Sous_theme st) {

        try {
            String query = "INSERT INTO sous_theme(id_theme, libelle) VALUES (?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, st.getTheme().getId_theme());
            pstmt.setString(1, st.getLibelle());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Sous_theme st) {
        try {
            String query = "UPDATE sous_theme SET id_theme = ? , libelle = ? WHERE id_sous_theme = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(2, st.getTheme().getId_theme());
            pstmt.setString(1, st.getLibelle());
            pstmt.setInt(3, st.getId_sous_theme());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    
    
}
