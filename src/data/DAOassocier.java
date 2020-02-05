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
public class DAOassocier extends DAO{

    public DAOassocier() {
        super();
    }
    
    public List<Associer> select(){
        List<Associer> lesAssociations = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select o.*, st.LIBELLE as LIBELLE_SOUS_THEME, t.*, s.NOM_STATUT,  mc.ID_MOT_CLEF, mc.LIBELLE as LIBELLE_MOT_CLEF " +
                            "from Ouvrage o, Sous_theme st, Theme t, Statut s, Mot_clef mc, Associer a " +
                            "where o.id_sous_theme = st.id_sous_theme " +
                            "and st.id_theme = t.id_theme " +
                            "and o.ID_STATUT = s.id_statut " +
                            "and o.ISBN = a.ISBN " +
                            "and a.ID_MOT_CLEF = mc.ID_MOT_CLEF;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Theme leTheme = new Theme(rs.getInt("ID_THEME"), rs.getString("LIBELLE"));
                Sous_theme leSous_theme = new Sous_theme(rs.getInt("ID_SOUS_THEME"),leTheme,rs.getString("LIBELLE_SOUS_THEME"));
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leSous_theme, leStatut, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getString("COMMENTAIRE"));
                Mot_clef leMot_clef = new Mot_clef(rs.getInt("ID_MOT_CLEF"), rs.getString("LIBELLE_MOT_CLEF"));
                Associer lAssociation = new Associer(lOuvrage, leMot_clef);
                lesAssociations.add(lAssociation);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesAssociations;
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
