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
    
   public void delete(Ouvrage o){
       
       try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Associer where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM Ecrire where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM Poseder where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM gerer where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM Appartenir where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM Publier where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM Ligne_commande where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM Commentaire where ISBN = " + o.getIsbn());
            stm.executeUpdate("DELETE FROM Ouvrage where ISBN = " + o.getIsbn());
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

            ResultSet rs = pstmt.executeQuery();

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

            ResultSet rs = pstmt.executeQuery();

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
            String query = "select c.ID_COMMENTAIRE, c.OBJET, c.CONTENU, c.NOTE, c.DATE, c.ADRESSE_IP, c.COMMENTAIRE as commentaire_commentaire, sc.ID_STATUT as id_statut_commentaire, sc.NOM_STATUT as statut_commentaire, " +
            "m.id_membre, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre, m.NOM, m.PRENOM, m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP, m.COMMENTAIRe, " +
            "lc.ID_LIGNE_COMMANDE, lc.QTE, lc.PRIX, lc.TVA, lc.REMISE, " +
            "o.ISBN, so.ID_STATUT as id_statut_ouvrage, so.NOM_STATUT as statut_ouvrage, o.TITRE, o.IMAGE,o.SOUS_TITRE, o.RESUME, o.STOCK,o.TVA, o.poids, o.prix, o.dimensions, o.nombre_page, o.COMMENTAIRE as commentaire_ouvrage, " +
            "com.id_commande, scom.id_statut as id_statut_commande, scom.nom_statut as statut_commande,com.date as date_commande, com.frais_de_port as frais_de_port_commande, com.numero_commande, com.adresse_ip as adresse_ip_commande, com.commentaire as commentaire_commande, " +
            "e.id_employe, e.nom as nom_employe, e.prenom as prenom_employe, e.date_de_naissance as date_de_naissance_employe, e.login as login_employe, e.password as password_employe, " +
            "p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement, " +
            "ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS, " +
            "adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation " +
            "from commentaire c " +
            "join membre m on c.ID_MEMBRE=m.ID_MEMBRE " +
            "join statut sm on m.ID_STATUT= sm.ID_STATUT " +
            "join ligne_commande lc on c.ID_LIGNE_COMMANDE = lc.ID_LIGNE_COMMANDE " +
            "join ouvrage o on lc.ISBN=o.ISBN " +
            "join statut so on o.ID_STATUT=so.ID_STATUT " +
            "join commande com on lc.ID_COMMANDE=com.ID_COMMANDE " +
            "join statut scom on com.ID_STATUT = scom.ID_STATUT " +
            "join EMPLOYE e on c.ID_EMPLOYE=e.ID_EMPLOYE " +
            "join paiement p on com.ID_COMMANDE = p.ID_PAIEMENT " +
            "join statut sp on p.ID_STATUT=sp.ID_STATUT " +
            "join ORGANISME_PAIEMENT op on p.ID_ORGANISME_PAIEMENT = op.ID_ORGANISME_PAIEMENT " +
            "join adresse ad on com.ID_ADRESSE = ad.ID_ADRESSE " +
            "join adresse adrfac on com.ID_ADRESSE= adrfac.ID_ADRESSE " +
            "join statut sc on c.ID_STATUT= sc.ID_STATUT "+
            "Where o.ISBN = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
		Statut leStatutMembre = new Statut(rs.getInt("id_statut_membre"),rs.getString("statut_membre"));
                Membre leMembre = new Membre(rs.getInt("id_membre"), leStatutMembre, rs.getString("TELEPHONE"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("ADRESSE_IP"), rs.getString("COMMENTAIRE"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"));
                Employe lEmploye = new Employe(rs.getInt("ID_EMPLOYE"), rs.getString("nom_employe"), rs.getString("prenom_employe"), rs.getString("date_de_naissance_employe"), rs.getString("login_employe"), rs.getString("password_employe"));
                Organisme_Paiement lOrganisme_Paiement = new Organisme_Paiement(rs.getInt("ID_ORGANISME_PAIEMENT"), rs.getString("nom_organisme_paiement"));
                Statut leStatutOuvrage = new Statut(rs.getInt("id_statut_ouvrage"), rs.getString("statut_ouvrage"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), leStatutOuvrage, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("COMMENTAIRE"));
                Statut leStatutPaiement = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                Paiement lePaiement = new Paiement(rs.getInt("ID_PAIEMENT"), lOrganisme_Paiement, leStatutPaiement, rs.getString("NUMERO_TRANSACTION"), rs.getString("DATE"));
                Adresse lAdresse_Livraison = new Adresse(rs.getInt("ID_ADRESSE"), rs.getString("RUE"), rs.getString("CODE_POSTAL"), rs.getString("VILLE"), rs.getString("PAYS"));
                Adresse lAdresse_Facturation = new Adresse(rs.getInt("id_adresse_facturation"), rs.getString("rue_facturation"), rs.getString("code_postal_facturation"), rs.getString("ville_facturation"), rs.getString("pays_facturation"));
                Statut leStatutCommande = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));
                Commande laCommande = new Commande(rs.getInt("ID_COMMANDE"), leMembre, lEmploye, lePaiement, lAdresse_Livraison, lAdresse_Facturation, leStatutCommande, rs.getString("date_commande"), rs.getFloat("frais_de_port_commande"), rs.getString("NUMERO_COMMANDE"), rs.getString("adresse_ip_commande"), rs.getString("commentaire_commande"));
                Ligne_commande laLigne_commande = new Ligne_commande(rs.getInt("ID_LIGNE_COMMANDE"), lOuvrage, laCommande, rs.getInt("QTE"), rs.getFloat("PRIX"), rs.getFloat("TVA"), rs.getFloat("REMISE"));
                Statut leStatutCommentaire = new Statut(rs.getInt("id_statut_commentaire"), rs.getString("statut_commentaire"));
                Commentaire leCommentaire = new Commentaire(rs.getInt("ID_COMMENTAIRE"), leMembre, laLigne_commande, lOuvrage, leStatutCommentaire, lEmploye, rs.getString("OBJET"), rs.getString("CONTENU"), rs.getInt("NOTE"), rs.getString("DATE"), rs.getString("ADRESSE_IP"), rs.getString("COMMENTAIRE"));
                lesCommentaires.add(leCommentaire);
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

            ResultSet rs = pstmt.executeQuery();

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

            ResultSet rs = pstmt.executeQuery();

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
    
    public List<Editeur> getEditeursByID(Ouvrage o) {
        List<Editeur> lesEditeurs = new ArrayList<>();
        
        try {
            String query = "select edt.*, stedt.NOM_STATUT from editeur edt, publier p, ouvrage o, statut stedt where edt.ID_EDITEUR = p.ID_EDITEUR  and p.ISBN = o.ISBN and edt.ID_STATUT = stedt.ID_STATUT and o.ISBN = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, o.getIsbn());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Editeur lEditeur = new Editeur(rs.getInt("ID_EDITEUR"), leStatut, rs.getString("NOM"), rs.getString("EMAIL"), rs.getString("TELEPHONE"));
                
                lesEditeurs.add(lEditeur);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
            
        return lesEditeurs;
    }
    
    public void deleteAppartenir(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Appartenir where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deletePublier(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Publier where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deletePosseder(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Posseder where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deleteAssocier(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Associer where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void deleteEcrire(Ouvrage o){
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Ecrire where ISBN = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
