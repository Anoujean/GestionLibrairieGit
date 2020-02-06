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
    
    public List<Sous_theme> select(){
        List<Sous_theme> lesSous_themes = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select st.*, t.libelle as LIBELLE_THEME from SOUS_THEME st, THEME t where st.ID_THEME = t.ID_THEME;;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Theme leTheme = new Theme(rs.getInt("ID_THEME"), rs.getString("LIBELLE_THEME"));
                Sous_theme leSous_theme = new Sous_theme(rs.getInt("ID_SOUS_THEME"),leTheme,rs.getString("LIBELLE"));
                lesSous_themes.add(leSous_theme);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesSous_themes;
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
            pstmt.setInt(1, st.getTheme().getId_theme());
            pstmt.setString(2, st.getLibelle());
            pstmt.setInt(3, st.getId_sous_theme());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public List<Ouvrage> getOuvragesByID(Sous_theme st) {
        List<Ouvrage> lesOuvrages = new ArrayList<>();

        try {
            String query = "select o.*, sto.NOM_STATUT from ouvrage o, sous_theme st, posseder p, statut sto where o.ISBN = p.ISBN and p.ID_SOUS_THEME = st.ID_SOUS_THEME and o.ID_STATUT = sto.ID_STATUT and st.ID_SOUS_THEME = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, st.getId_sous_theme());

            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leStatut, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("COMMENTAIRE"));
                lesOuvrages.add(lOuvrage);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesOuvrages;
    }
    
    public void Posseder(Sous_theme st, Ouvrage o){
        
        try {
            String query = "INSERT INTO Associer VALUES (?,?);";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());
            pstmt.setInt(2, st.getId_sous_theme());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
    }
    
    
    
}
