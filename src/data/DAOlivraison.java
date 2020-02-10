package data;

import classes.Adresse;
import classes.Commande;
import classes.Employe;
import classes.Livraison;
import classes.Membre;
import classes.Organisme_Paiement;
import classes.Paiement;
import classes.Statut;
import classes.Transporteur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOlivraison extends DAO {

    public DAOlivraison() {
        super();
    }

    public List<Livraison> select() {
        List<Livraison> lesLivraisons = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "select \n"
                    + "\n"
                    + "l.ID_LIVRAISON, l.ID_TRANSPORTEUR, l.ID_COMMANDE, l.DATE_MOTIF, l.MOTIF, l.COMMENTAIRE as commentaire_livraison,\n"
                    + "t.ID_TRANSPORTEUR, t.ID_STATUT as id_statut_transporteur, st.NOM_STATUT as statut_transporteur, t.LIBELLE as nom_transporteur, t.TEL as tel_transporteur, t.MAIL as mail_transporteur,\n"
                    + "c.ID_COMMANDE, c.ID_MEMBRE , c.ID_EMPLOYE, c.ID_PAIEMENT, c.ID_ADRESSE, c.ID_ADRESSE_FACTURE, c.ID_STATUT as id_statut_commande, sc.NOM_STATUT as nom_statut_commande, c.DATE as date_commande, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP as ip_commande, c.COMMENTAIRE as commentaire_commande,\n"
                    + "mc.ID_MEMBRE, mc.ID_STATUT as id_statut_membre, sm.NOM_STATUT as nom_statut_membre, mc.NOM as nom_membre, mc.PRENOM as prenom_membre, mc.DATE_DE_NAISSANCE as date_naissance_membre, mc.TELEPHONE as tel_membre, mc.EMAIL as email_membre, mc.PASSWORD as password_membre, mc.ADRESSE_IP as ip_membre, mc.COMMENTAIRE as commentaire_membre,\n"
                    + "ec.ID_EMPLOYE, ec.NOM as nom_employe, ec.prenom as prenom_employe, ec.DATE_DE_NAISSANCE as date_naissance_employe, ec.login as login_employe, ec.PASSWORD as password_employe, \n"
                    + "pc.ID_PAIEMENT, pc.ID_ORGANISME_PAIEMENT, op.NOM as nom_org_paiement, pc.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as nom_statut_paiement,  pc.NUMERO_TRANSACTION, pc.DATE as date_paiement,\n"
                    + "acl.ID_ADRESSE as id_adresse_livraison, acl.RUE as rue_livraison, acl.CODE_POSTAL as code_postal_livraison, acl.VILLE as ville_livraison, acl.PAYS as pays_livraison,\n"
                    + "acf.ID_ADRESSE as id_adresse_fact, acf.RUE as rue_fact, acf.CODE_POSTAL as code_postal_fact, acf.VILLE as ville_fact, acf.PAYS as pays_fact\n"
                    + "                    \n"
                    + "from livraison l\n"
                    + "                   \n"
                    + "join TRANSPORTEUR t on l.ID_TRANSPORTEUR = t.ID_TRANSPORTEUR\n"
                    + " join STATUT st on t.ID_STATUT  = st.ID_STATUT\n"
                    + " join commande c on l.ID_COMMANDE = c.ID_COMMANDE\n"
                    + "join Membre mc on c.ID_MEMBRE = mc.ID_MEMBRE\n"
                    + "	join Statut sm on sm.ID_STATUT = mc.ID_STATUT\n"
                    + "join EMPLOYE ec on c.ID_EMPLOYE = ec.ID_EMPLOYE\n"
                    + " join PAIEMENT pc on c.ID_PAIEMENT = pc.ID_PAIEMENT\n"
                    + " join ORGANISME_PAIEMENT op on pc.ID_ORGANISME_PAIEMENT = op.ID_ORGANISME_PAIEMENT\n"
                    + " join Statut sp on sp.ID_STATUT = pc.ID_STATUT\n"
                    + "  join ADRESSE acl on c.ID_ADRESSE = acl.ID_ADRESSE\n"
                    + " join ADRESSE acf on c.ID_ADRESSE_FACTURE = acf.ID_ADRESSE\n"
                    + "join STATUT sc on c.ID_STATUT = sc.ID_STATUT";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Statut Statutt = new Statut(rs.getInt("id_statut_transporteur"), rs.getString("statut_transporteur"));
                Statut Statutm = new Statut(rs.getInt("id_statut_membre"), rs.getString("nom_statut_membre"));
                Statut Statutp = new Statut(rs.getInt("id_statut_paiement"), rs.getString("nom_statut_paiement"));
                Statut Statutc = new Statut(rs.getInt("id_statut_commande"), rs.getString("nom_statut_commande"));
                
                Transporteur leTransporteur = new Transporteur(rs.getInt("ID_TRANSPORTEUR"), Statutt, rs.getString("nom_transporteur"), rs.getString("tel_transporteur"), rs.getString("mail_transporteur"));
                Membre leMembre = new Membre(rs.getInt("ID_MEMBRE"), Statutm, rs.getString("tel_membre"), rs.getString("email_membre"), rs.getString("password_membre"), rs.getString("ip_membre"), rs.getString("commentaire_membre"), rs.getString("nom_membre"), rs.getString("prenom_membre"), rs.getString("date_naissance_membre"));
                Employe lEmploye = new Employe(rs.getInt("ID_EMPLOYE"), rs.getString("nom_employe"), rs.getString("prenom_employe"), rs.getString("date_naissance_employe"), rs.getString("login_employe"), rs.getString("password_employe"));
                Organisme_Paiement lOrganisme_Paiement = new Organisme_Paiement(rs.getInt("ID_ORGANISME_PAIEMENT"), rs.getString("nom_org_paiement"));
                Paiement lePaiement = new Paiement(rs.getInt("ID_PAIEMENT"), lOrganisme_Paiement, Statutp, rs.getString("NUMERO_TRANSACTION"), rs.getString("date_paiement"));
                Adresse lAdresse_Livraison = new Adresse(rs.getInt("id_adresse_livraison"), rs.getString("rue_livraison"), rs.getString("code_postal_livraison"), rs.getString("ville_livraison"), rs.getString("pays_livraison"));
                Adresse lAdresse_Facturation = new Adresse(rs.getInt("id_adresse_fact"), rs.getString("rue_fact"), rs.getString("code_postal_fact"), rs.getString("ville_fact"), rs.getString("pays_fact"));
                Commande laCommande = new Commande(rs.getInt("ID_COMMANDE"), leMembre, lEmploye, lePaiement, lAdresse_Livraison, lAdresse_Facturation, Statutc, rs.getString("date_commande"), rs.getFloat("FRAIS_DE_PORT"), rs.getString("NUMERO_COMMANDE"), rs.getString("ip_commande"), rs.getString("commentaire_commande"));
                Livraison laLivraison = new Livraison(rs.getInt("ID_LIVRAISON"), leTransporteur, laCommande, rs.getString("DATE_MOTIF"), rs.getString("MOTIF"), rs.getString("commentaire_livraison"));

                lesLivraisons.add(laLivraison);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesLivraisons;
    }

    public void insert(Livraison l) {

        try {
            String query = "INSERT INTO livraison(id_transporteur, id_commande, date_motif, motif, commentaire) VALUES (?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, l.getTransporteur().getId_transporteur());
            pstmt.setInt(2, l.getCommande().getId_commande());
            pstmt.setString(3, l.getDate_motif());
            pstmt.setString(4, l.getMotif());
            pstmt.setString(5, l.getCommentaire());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Livraison l) {
        try {
            String query = "UPDATE Livraison SET date_motif = ?, motif =?, commentaire =? WHERE id_livraison = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, l.getDate_motif());
            pstmt.setString(2, l.getMotif());
            pstmt.setString(3, l.getCommentaire());
            pstmt.setInt(4, l.getId_livraison());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void delete(Livraison l) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Livraison where ID_LIVRAISON = " + l.getId_livraison());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
