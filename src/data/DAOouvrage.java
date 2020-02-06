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
public class DAOouvrage extends DAO {

    public DAOouvrage() {
    }

    public List<Ouvrage> select() {
        List<Ouvrage> lesOuvrages = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select o.*, st.LIBELLE as LIBELLE_SOUS_THEME, t.*, s.NOM_STATUT from Ouvrage o , Statut s where o.ID_STATUT = s.id_statut;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leStatut, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("COMMENTAIRE"));
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
            String query = "INSERT INTO Ouvrage(isbn, id_statut, titre, image, sous_titre, resume, stock, tva, poids, prix, dimensions, nombre_page, commentaire) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());
            pstmt.setInt(2, o.getStatut().getId_statut());
            pstmt.setString(3, o.getTitre());
            pstmt.setString(4, o.getImage());
            pstmt.setString(5, o.getSous_titre());
            pstmt.setString(6, o.getResume());
            pstmt.setFloat(7, o.getStock());
            pstmt.setFloat(8, o.getTva());
            pstmt.setFloat(9, o.getPoids());
            pstmt.setFloat(10, o.getPrix());
            pstmt.setString(11, o.getDimensions());
            pstmt.setString(12, o.getNombre_page());
            pstmt.setString(13, o.getCommentaire());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Ouvrage o) {
        try {
            String query = "UPDATE Ouvrage SET isbn = ?, id_statut = ?, titre = ?, image = ?, sous_titre = ?, resume = ?, stock = ?, tva = ?, poids = ?, prix = ?, dimensions = ?, nombre_page = ?, commentaire WHERE isbn = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, o.getStatut().getId_statut());
            pstmt.setString(2, o.getTitre());
            pstmt.setString(3, o.getImage());
            pstmt.setString(4, o.getSous_titre());
            pstmt.setString(5, o.getResume());
            pstmt.setFloat(6, o.getStock());
            pstmt.setFloat(7, o.getTva());
            pstmt.setFloat(8, o.getPoids());
            pstmt.setFloat(9, o.getPrix());
            pstmt.setString(10, o.getDimensions());
            pstmt.setString(11, o.getNombre_page());
            pstmt.setString(12, o.getCommentaire());
            pstmt.setString(13, o.getIsbn());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public List<Auteur> getAuteursByID(Ouvrage o) {
        List<Auteur> lesAuteurs = new ArrayList<>();

        try {
            String query = "select a.* from auteur a, ecrire e, ouvrage o where a.ID_AUTEUR = e.ID_AUTEUR and e.ISBN = o.ISBN and o.ISBN = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());

            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {
                Auteur lAuteur = new Auteur(rs.getInt("ID_AUTEUR"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"), rs.getString("DATE_DE_DECES"));
                lesAuteurs.add(lAuteur);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesAuteurs;
    }

    public List<Mot_clef> getMotClefsByID(Ouvrage o) {
        List<Mot_clef> lesMot_clefs = new ArrayList<>();

        try {
            String query = "select mc.* from mot_clef mc, associer a, ouvrage o where mc.ID_MOT_CLEF = a.ID_MOT_CLEF and a.ISBN = o.ISBN and o.ISBN = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());

            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {
                Mot_clef leMot_clef = new Mot_clef(rs.getInt("ID_MOT_CLEF"), rs.getString("LIBELLE"));
                lesMot_clefs.add(leMot_clef);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesMot_clefs;
    }

    public List<Commentaire> getCommentairesByID(Ouvrage o) { //à faire
        List<Commentaire> lesCommentaires = new ArrayList<>();
        
        try {
            String query = "select mc.* from mot_clef mc, associer a, ouvrage o where mc.ID_MOT_CLEF = a.ID_MOT_CLEF and a.ISBN = o.ISBN and o.ISBN = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());

            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {
                Mot_clef leMot_clef = new Mot_clef(rs.getInt("ID_MOT_CLEF"), rs.getString("LIBELLE"));
                lesMot_clefs.add(leMot_clef);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommentaires;
    }

    public List<Sous_theme> getSousThemeByID(Ouvrage o) {
        List<Sous_theme> lesSous_themes = new ArrayList<>();
        try {
            String query = "select st.*, t.LIBELLE as libelle_theme from sous_theme st, posseder p, ouvrage o, theme t where st.ID_SOUS_THEME = p.ID_SOUS_THEME and p.ISBN = o.ISBN and st.ID_THEME = t.ID_THEME and o.ISBN = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());

            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {
                Theme leTheme = new Theme(rs.getInt("ID_THEME"), rs.getString("LIBELLE_THEME"));
                Sous_theme leSous_theme = new Sous_theme(rs.getInt("ID_SOUS_THEME"), leTheme, rs.getString("LIBELLE"));
                lesSous_themes.add(leSous_theme);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesSous_themes;
    }

    public List<Evenement> getEvenementsByID(Ouvrage o) {
        List<Evenement> lesEvenements = new ArrayList<>();
        
        try {
            String query = "select evt.*, stevt.NOM_STATUT from evenement evt, appartenir app, ouvrage o, statut stevt where evt.ID_EVENEMENT = app.ID_EVENEMENT  and app.ISBN = o.ISBN and evt.ID_STATUT = stevt.ID_STATUT and o.ISBN = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());

            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Evenement lEvenement = new Evenement(rs.getInt("ID_EVENEMENT"), leStatut, rs.getString("LIBELLE"), rs.getString("DATE_DEBUT"), rs.getString("DATE_FIN"), rs.getString("DESCRIPTION"), rs.getString("IMAGE"), rs.getFloat("REMISE"), rs.getString("COMMENTAIRE"));
                
                lesEvenements.add(lEvenement);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
            
        return lesEvenements;
    }

}
