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
    
    public List<Ouvrage> select(){
        List<Ouvrage> lesOuvrages = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select o.*, st.LIBELLE as LIBELLE_SOUS_THEME, t.*, s.NOM_STATUT from Ouvrage o, Sous_theme st, Theme t, Statut s where o.id_sous_theme = st.id_sous_theme and st.id_theme = t.id_theme and o.ID_STATUT = s.id_statut;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Theme leTheme = new Theme(rs.getInt("ID_THEME"), rs.getString("LIBELLE"));
                Sous_theme leSous_theme = new Sous_theme(rs.getInt("ID_SOUS_THEME"),leTheme,rs.getString("LIBELLE_SOUS_THEME"));
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leSous_theme, leStatut, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getString("COMMENTAIRE"));
                lesOuvrages.add(lOuvrage);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesOuvrages;
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
