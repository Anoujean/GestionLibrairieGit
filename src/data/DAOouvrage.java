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
public class DAOouvrage extends DAO{


    public DAOouvrage() {
    }


    public void insert(Ouvrage o) {

        try {
            String query = "INSERT INTO Ouvrage(isbn,id_sous_theme,id_statut,titre,image,sous_titre,resume,stock,TVA,commentaire) VALUES (?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());
            pstmt.setInt(2, o.getSous_theme().getId_sous_theme());
            pstmt.setInt(3, o.getStatut().getId_statut());
            pstmt.setString(4, o.getTitre());
            pstmt.setString(5, o.getImage());
            pstmt.setString(6, o.getSous_titre());
            pstmt.setString(7, o.getResume());
            pstmt.setFloat(8, o.getStock());
            pstmt.setFloat(9, o.getTva());
            pstmt.setString(10, o.getCommentaire());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Ouvrage o) {
        try {
            String query = "UPDATE Ouvrage SET id_sous_theme = ?, id_statut = ?, titre = ?, image = ?, sous_titre = ?, resume = ?, stock = ?, TVA = ?, commentaire = ? WHERE isbn = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, o.getSous_theme().getId_sous_theme());
            pstmt.setInt(2, o.getStatut().getId_statut());
            pstmt.setString(3, o.getTitre());
            pstmt.setString(4, o.getImage());
            pstmt.setString(5, o.getSous_titre());
            pstmt.setString(6, o.getResume());
            pstmt.setFloat(7, o.getStock());
            pstmt.setFloat(8, o.getTva());
            pstmt.setString(9, o.getCommentaire());
            pstmt.setString(10, o.getIsbn());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
