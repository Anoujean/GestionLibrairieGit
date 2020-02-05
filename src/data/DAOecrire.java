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
public class DAOecrire extends DAO{

    public DAOecrire() {
        super();
    }
    
    public List<Ecrire> select(){
        List<Ecrire> lesEcrits = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select o.*, st.LIBELLE as LIBELLE_SOUS_THEME, t.*, s.NOM_STATUT, a.* " +
                            "from Ouvrage o, Sous_theme st, Theme t, Statut s, Auteur a, ecrire e " +
                            "where o.id_sous_theme = st.id_sous_theme " +
                            "and st.id_theme = t.id_theme " +
                            "and o.ID_STATUT = s.id_statut " +
                            "and o.ISBN = e.ISBN " +
                            "and e.ID_AUTEUR = a.ID_AUTEUR;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Theme leTheme = new Theme(rs.getInt("ID_THEME"), rs.getString("LIBELLE"));
                Sous_theme leSous_theme = new Sous_theme(rs.getInt("ID_SOUS_THEME"),leTheme,rs.getString("LIBELLE_SOUS_THEME"));
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leSous_theme, leStatut, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getString("COMMENTAIRE"));
                Auteur lAuteur = new Auteur(rs.getInt("ID_AUTEUR"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"), rs.getString("DATE_DE_DECES"));
                Ecrire lEcrit = new Ecrire(lAuteur, lOuvrage);
                lesEcrits.add(lEcrit);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesEcrits;
    }
    
    public void insert(Ecrire e) {

        try {
            String query = "INSERT INTO Ecrire (id_auteur, isbn) VALUES (?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getAuteur().getId_auteur());
            pstmt.setString(2, e.getOuvrage().getIsbn());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void Delete(Ecrire e) {
        
        try {
            String query = "DELETE FROM Ecrire WHERE id_auteur = ? and isbn = ?;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getAuteur().getId_auteur());
            pstmt.setString(2, e.getOuvrage().getIsbn());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    
    
}
