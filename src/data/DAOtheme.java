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
public class DAOtheme extends DAO{
    
    public DAOtheme() {
        super();
    }
    
    public List<Theme> select(){
        List<Theme> lesThemes = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM Theme;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Theme leTheme = new Theme(rs.getInt("ID_THEME"), rs.getString("LIBELLE"));
                lesThemes.add(leTheme);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesThemes;
    }
    
    public void insert(Theme t) {

        try {
            String query = "INSERT INTO Theme(libelle) VALUES (?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, t.getLibelle());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Theme t) {
        try {
            String query = "UPDATE Theme SET libelle = ? WHERE id_theme = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, t.getLibelle());
            pstmt.setInt(2, t.getId_theme());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void delete(Theme t){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Theme where id_sous_theme = " + t.getId_theme());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public List<Sous_theme> getSousThemeByID(Theme t) {
        List<Sous_theme> lesSous_themes = new ArrayList<>();
        try {
            String query = "select st.*, t.LIBELLE as LIBELLE_THEME from sous_theme st, theme t where st.ID_THEME = t.ID_THEME and t.ID_THEME = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, t.getId_theme());

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
    
}
