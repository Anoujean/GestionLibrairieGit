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
public class DAOauteur extends DAO {

    public DAOauteur() {
        super();
    }

    public List<Auteur> select() {
        this.open();
        List<Auteur> lesAuteurs = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM Auteur;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Auteur lAuteur = new Auteur(rs.getInt("ID_AUTEUR"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"), rs.getString("DATE_DE_DECES"));
                lAuteur.setLesOuvrages(this.getOuvragesByID(lAuteur));
                lesAuteurs.add(lAuteur);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();

        return lesAuteurs;
    }
    
    public List<Auteur> select(String recherche) {
        this.open();
        List<Auteur> lesAuteurs = new ArrayList<>();
        try {

            String query = "SELECT * FROM Auteur WHERE nom like ? or prenom like ?;";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, "%"+recherche+"%");
            pstmt.setString(2, "%"+recherche+"%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Auteur lAuteur = new Auteur(rs.getInt("ID_AUTEUR"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"), rs.getString("DATE_DE_DECES"));
                lAuteur.setLesOuvrages(this.getOuvragesByID(lAuteur));
                lesAuteurs.add(lAuteur);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();

        return lesAuteurs;
    }

    public void insert(Auteur a) {
        this.open();

        try {
            String query = "INSERT INTO Auteur(nom, prenom, date_de_naissance, date_de_deces) VALUES (?,?,?,?);";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, a.getNom());
            pstmt.setString(2, a.getPrenom());
            pstmt.setString(3, a.getDate_de_naissance());
            pstmt.setString(4, a.getDate_de_deces());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();

    }

    public void update(Auteur a) {
        this.open();
        try {
            String query = "UPDATE Auteur SET nom = ? , prenom = ? , date_de_naissance = ? , date_de_deces = ? WHERE id_auteur = ? ;";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, a.getNom());
            pstmt.setString(2, a.getPrenom());
            pstmt.setString(3, a.getDate_de_naissance());
            pstmt.setString(4, a.getDate_de_deces());
            pstmt.setInt(5, a.getId_auteur());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();
    }

    public List<Ouvrage> getOuvragesByID(Auteur a) {
        List<Ouvrage> lesOuvrages = new ArrayList<>();

        try {
            String query = "select o.*, st.NOM_STATUT from ouvrage o, auteur a, ecrire e, statut st where o.ISBN = e.ISBN and e.ID_AUTEUR = a.ID_AUTEUR and o.ID_STATUT = st.ID_STATUT and a.ID_AUTEUR = ? ;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, a.getId_auteur());

            ResultSet rs = pstmt.executeQuery();

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
    
    public void delete(Auteur a){
        this.open();
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Auteur WHERE id_auteur = " + a.getId_auteur());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();
    }
    
    public void Ecrire(Auteur a, Ouvrage o){
        this.open();
        
        try {
            String query = "INSERT INTO Ecrire VALUES (?,?);";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, a.getId_auteur());
            pstmt.setString(2, o.getIsbn());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();
        
    }
    
    public void deleteEcrire(Ouvrage o){
        this.open();
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Ecrire where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();
    }
    
    public void deleteEcrire(Auteur a){
        this.open();
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Ecrire where ID_AUTEUR = " + a.getId_auteur());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();
    }
    
    public void deleteEcrire(Ouvrage o, Auteur a){
        this.open();
        try {
            String query = "DELETE FROM Ecrire WHERE ID_AUTEUR = ? AND ISBN = ?";
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, a.getId_auteur());
            pstmt.setString(2, o.getIsbn());
            int result = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        this.close();
    }
}
