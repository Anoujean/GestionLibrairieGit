package data;

import classes.Adresse;
import classes.Commande;
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

public class DAOligne_commande extends DAO {

    public DAOligne_commande() {
        super();
    }

    public List<Ligne_commande> select() {
        List<Ligne_commande> lesLigne_commandes = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT \n"
                    + "lc.ID_LIGNE_COMMANDE, lc.ISBN, lc.ID_COMMANDE, lc.QTE, lc.PRIX, lc.TVA, lc.REMISE,\n"
                    + "o.ISBN, o.ID_STATUT as id_statut_ouvrage, so.NOM_STATUT as nom_statut_ouvrage, o.TITRE, o.IMAGE, o.SOUS_TITRE, o.RESUME, o.STOCK, o.TVA, o.POIDS, o.PRIX, o.DIMENSIONS, o.NOMBRE_PAGE, o.COMMENTAIRE,\n"
                    + "c.ID_COMMANDE, c.ID_MEMBRE, c.ID_EMPLOYE, c.ID_PAIEMENT, c.ID_ADRESSE, c.ID_ADRESSE_FACTURE, c.ID_STATUT as id_statut_commande, sc.NOM_STATUT as nom_statut_commande, c.date as date_commande, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP as adresse_ip_commande, c.COMMENTAIRE as commentaire_commande,\n"
                    + "m.ID_MEMBRE, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as nom_statut_membre, m.NOM, m.PRENOM,m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP as adresse_ip_membre, m.COMMENTAIRE as commentaire_membre,\n"
                    + "e.ID_EMPLOYE, e.NOM as nom_employe, e.PRENOM as prenom_employe, e.DATE_DE_NAISSANCE as date_de_naissance_employe, e.LOGIN as login_employe, e.PASSWORD as password_employe,\n"
                    + "p.ID_PAIEMENT, p.ID_ORGANISME_PAIEMENT, op.NOM, p.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as nom_statut_paiement, p.NUMERO_TRANSACTION, p.DATE as date_paiement,\n"
                    + "a.ID_ADRESSE, a.RUE, a.CODE_POSTAL, a.VILLE, a.PAYS,\n"
                    + "af.ID_ADRESSE, af.RUE, af.CODE_POSTAL, af.VILLE, af.PAYS\n"
                    + "\n"
                    + "\n"
                    + "from LIGNE_COMMANDE LC\n"
                    + "\n"
                    + "\n"
                    + "join Ouvrage o on lc.ISBN = o.ISBN\n"
                    + "join STATUT so on so.ID_STATUT = o.ID_STATUT	\n"
                    + "join Commande c on lc.ID_COMMANDE = c.ID_COMMANDE\n"
                    + "join Membre m on m.ID_MEMBRE = c.ID_MEMBRE\n"
                    + "	join Statut sm on sm.ID_STATUT = m.ID_STATUT\n"
                    + "join Employe e on e.ID_EMPLOYE = c.ID_EMPLOYE\n"
                    + "join Paiement p on p.ID_PAIEMENT = c.ID_PAIEMENT\n"
                    + "	join ORGANISME_PAIEMENT op  on op.ID_ORGANISME_PAIEMENT = p.ID_ORGANISME_PAIEMENT\n"
                    + "	join STATUT sp on sp.ID_STATUT = p.ID_STATUT \n"
                    + "join Adresse a on a.ID_ADRESSE = c.ID_ADRESSE \n"
                    + "join Adresse af on af.ID_ADRESSE = c.ID_ADRESSE_FACTURE\n"
                    + "join Statut sc on sc.ID_STATUT = c.ID_STATUT\n"
                    + "\n"
                    + "\n"
                    + " ";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Statut Statuto = new Statut(rs.getInt("id_statut_ouvrage"), rs.getString("nom_statut_ouvrage"));
                Statut Statutm = new Statut(rs.getInt("id_statut_membre"), rs.getString("nom_statut_membre"));
                Statut Statutp = new Statut(rs.getInt("id_statut_paiement"), rs.getString("nom_statut_paiement"));
                Statut Statutc = new Statut(rs.getInt("id_statut_commande"), rs.getString("nom_statut_commande"));
                
                Membre leMembre = new Membre(rs.getInt("ID_MEMBRE"), Statutm, rs.getString("TELEPHONE"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("adresse_ip_membre"), rs.getString("commentaire_membre"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"));
                Employe lEmploye = new Employe(rs.getInt("ID_EMPLOYE"), rs.getString("nom_employe"), rs.getString("prenom_employe"), rs.getString("date_de_naissance_employe"), rs.getString("login_employe"), rs.getString("password_employe"));
                Organisme_Paiement lOrganisme_Paiement = new Organisme_Paiement(rs.getInt("ID_ORGANISME_PAIEMENT"), rs.getString("NOM"));
                Paiement lePaiement = new Paiement(rs.getInt("ID_PAIEMENT"), lOrganisme_Paiement, Statutp, rs.getString("NUMERO_TRANSACTION"), rs.getString("date_paiement"));
                Adresse lAdresse_Livraison = new Adresse(rs.getInt("ID_ADRESSE"), rs.getString("RUE"), rs.getString("CODE_POSTAL"), rs.getString("VILLE"), rs.getString("PAYS"));
                Adresse lAdresse_Facturation = new Adresse(rs.getInt("ID_ADRESSE"), rs.getString("RUE"), rs.getString("CODE_POSTAL"), rs.getString("VILLE"), rs.getString("PAYS"));
                Commande laCommande = new Commande(rs.getInt("ID_COMMANDE"), leMembre, lEmploye, lePaiement, lAdresse_Livraison, lAdresse_Facturation, Statutc, rs.getString("date_commande"), rs.getFloat("FRAIS_DE_PORT"), rs.getString("NUMERO_COMMANDE"), rs.getString("adresse_ip_commande"), rs.getString("commentaire_commande"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), Statuto, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("COMMENTAIRE"));
                Ligne_commande laLigne_commande = new Ligne_commande(rs.getInt("ID_LIGNE_COMMANDE"), lOuvrage, laCommande, rs.getInt("QTE"), rs.getFloat("PRIX"), rs.getFloat("TVA"), rs.getFloat("REMISE"));
                lesLigne_commandes.add(laLigne_commande);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesLigne_commandes;
    }

    public void insert(Ligne_commande lc) {

        try {
            String query = "INSERT INTO ligne_commande(isbn, id_commande, qte, prix, tva, remise) VALUES (?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, lc.getOuvrage().getIsbn());
            pstmt.setInt(2, lc.getCommande().getId_commande());
            pstmt.setInt(3, lc.getQte());
            pstmt.setFloat(4, lc.getPrix());
            pstmt.setFloat(5, lc.getTva());
            pstmt.setFloat(6, lc.getRemise());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Ligne_commande lc) {
        try {
            String query = "UPDATE Commande SET qte = ?, prix =?, tva =?, remise = ? WHERE id_ligne_commande = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, lc.getQte());
            pstmt.setFloat(2, lc.getPrix());
            pstmt.setFloat(3, lc.getTva());
            pstmt.setFloat(4, lc.getRemise());
            pstmt.setInt(5, lc.getId_ligne_commande());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    
    public void delete(Ligne_commande lc) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Ligne_commande where ID_LIGNE_COMMANDE = " + lc.getId_ligne_commande());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
