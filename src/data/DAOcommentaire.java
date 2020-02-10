package data;

import classes.Adresse;
import classes.Commande;
import classes.Commentaire;
import classes.Employe;
import classes.Ligne_commande;
import classes.Membre;
import classes.Organisme_Paiement;
import classes.Ouvrage;
import classes.Paiement;
import classes.Sous_theme;
import classes.Statut;
import classes.Theme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOcommentaire extends DAO {

    public DAOcommentaire() {
        super();
    }

    public List<Commentaire> select() {
        List<Commentaire> lesCommentaires = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "select c.ID_COMMENTAIRE, c.OBJET, c.CONTENU, c.NOTE, c.DATE, c.ADRESSE_IP, c.COMMENTAIRE as commentaire_commentaire, sc.ID_STATUT as id_statut_commentaire, sc.NOM_STATUT as statut_commentaire, "
                    + "m.id_membre, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre, m.NOM, m.PRENOM, m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP, m.COMMENTAIRe, "
                    + "lc.ID_LIGNE_COMMANDE, lc.QTE, lc.PRIX, lc.TVA, lc.REMISE, "
                    + "o.ISBN, so.ID_STATUT as id_statut_ouvrage, so.NOM_STATUT as statut_ouvrage, o.TITRE, o.IMAGE,o.SOUS_TITRE, o.RESUME, o.STOCK,o.TVA, o.poids, o.prix, o.dimensions, o.nombre_page, o.COMMENTAIRE as commentaire_ouvrage, "
                    + "com.id_commande, scom.id_statut as id_statut_commande, scom.nom_statut as statut_commande,com.date as date_commande, com.frais_de_port as frais_de_port_commande, com.numero_commande, com.adresse_ip as adresse_ip_commande, com.commentaire as commentaire_commande, "
                    + "e.id_employe, e.nom as nom_employe, e.prenom as prenom_employe, e.date_de_naissance as date_de_naissance_employe, e.login as login_employe, e.password as password_employe, "
                    + "p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement, "
                    + "ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS, "
                    + "adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation "
                    + "from commentaire c "
                    + "join membre m on c.ID_MEMBRE=m.ID_MEMBRE "
                    + "join statut sm on m.ID_STATUT= sm.ID_STATUT "
                    + "join ligne_commande lc on c.ID_LIGNE_COMMANDE = lc.ID_LIGNE_COMMANDE "
                    + "join ouvrage o on lc.ISBN=o.ISBN "
                    + "join statut so on o.ID_STATUT=so.ID_STATUT "
                    + "join commande com on lc.ID_COMMANDE=com.ID_COMMANDE "
                    + "join statut scom on com.ID_STATUT = scom.ID_STATUT "
                    + "join EMPLOYE e on c.ID_EMPLOYE=e.ID_EMPLOYE "
                    + "join paiement p on com.ID_COMMANDE = p.ID_PAIEMENT "
                    + "join statut sp on p.ID_STATUT=sp.ID_STATUT "
                    + "join ORGANISME_PAIEMENT op on p.ID_ORGANISME_PAIEMENT = op.ID_ORGANISME_PAIEMENT "
                    + "join adresse ad on com.ID_ADRESSE = ad.ID_ADRESSE "
                    + "join adresse adrfac on com.ID_ADRESSE= adrfac.ID_ADRESSE "
                    + "join statut sc on c.ID_STATUT= sc.ID_STATUT";

            ResultSet rs = stmt.executeQuery(query);

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
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommentaires;
    }

    public void insert(Commentaire c) {

        try {
            String query = "INSERT INTO commentaire(id_membre, id_ligne_commande, isbn, id_statut, id_employe, objet, contenu, note, date, adresse_ip, commentaire) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, c.getMembre().getId_membre());
            pstmt.setInt(2, c.getLigne_commande().getId_ligne_commande());
            pstmt.setString(3, c.getOuvrage().getIsbn());
            pstmt.setInt(4, c.getStatut().getId_statut());
            pstmt.setInt(5, c.getEmploye().getId_employe());
            pstmt.setString(6, c.getObjet());
            pstmt.setString(7, c.getContenu());
            pstmt.setInt(8, c.getNote());
            pstmt.setString(9, c.getDate());
            pstmt.setString(10, c.getAdresse_ip());
            pstmt.setString(11, c.getCommentaire());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Commentaire c) {
        try {
            String query = "UPDATE Commande SET objet = ?, contenu =?, note =?, date = ?, adresse_ip = ?, commentaire = ? WHERE id_commentaire= ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, c.getObjet());
            pstmt.setString(2, c.getContenu());
            pstmt.setInt(3, c.getNote());
            pstmt.setString(4, c.getDate());
            pstmt.setString(5, c.getAdresse_ip());
            pstmt.setString(6, c.getCommentaire());
            pstmt.setInt(6, c.getId_commentaire());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void delete(Commentaire c) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Commentaire where ID_COMMENTAIRE = " + c.getId_commentaire());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
