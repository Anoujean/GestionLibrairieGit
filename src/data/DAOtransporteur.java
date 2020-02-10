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

public class DAOtransporteur extends DAO {

    public DAOtransporteur() {
        super();
    }

    public void insert(Transporteur t) {

        try {
            String query = "INSERT INTO transporteur(id_statut, libelle, tel, mail) VALUES (?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, t.getStatut().getId_statut());
            pstmt.setString(2, t.getLibelle());
            pstmt.setString(3, t.getTel());
            pstmt.setString(4, t.getMail());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Transporteur t) {
        try {
            String query = "UPDATE membre SET libelle = ?, tel =?, mail =? WHERE id_transporteur = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, t.getLibelle());
            pstmt.setString(2, t.getTel());
            pstmt.setString(3, t.getMail());
            pstmt.setInt(4, t.getId_transporteur());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public List<Transporteur> select() {
        List<Transporteur> lesTransporteurs = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "select t.*, s.NOM_STATUT from TRANSPORTEUR t join Statut s on t.ID_STATUT=s.ID_STATUT";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Transporteur transporteur = new Transporteur(rs.getInt("id_transporteur"), leStatut, rs.getString("libelle"), rs.getString("tel"), rs.getString("mail"));

                lesTransporteurs.add(transporteur);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesTransporteurs;
    }

    public void delete(Transporteur t) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM transporteur where id_transporteur = " + t.getId_transporteur());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public List<Livraison> getLivraisonsByID(Transporteur t) {
        List<Livraison> lesLivraisons = new ArrayList<>();

        try {
            String query = "select t.*,s.ID_STATUT as id_statut_transporteur, s.NOM_STATUT as statut_transporteur, \n"
                    + "l.ID_LIVRAISON, l.DATE_MOTIF, l.MOTIF, l.COMMENTAIRE as commentaire_livraison,\n"
                    + "c.ID_COMMANDE,c.date as date_commande, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP as adresse_ip_commande, c.COMMENTAIRE as commentaire_commande,\n"
                    + "m.ID_MEMBRE, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre, m.NOM, m.PRENOM,m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP as adresse_ip_membre, m.COMMENTAIRE as commentaire_membre, \n"
                    + "e.ID_EMPLOYE, e.NOM as nom_employe, e.PRENOM as prenom_employe, e.DATE_DE_NAISSANCE as date_de_naissance_employe, e.LOGIN as login_employe, e.PASSWORD as password_employe,\n"
                    + "p.ID_PAIEMENT,ss.ID_STATUT as id_statut_paiement, ss.NOM_STATUT as statut_paiement, p.NUMERO_TRANSACTION, p.DATE as date_paiement,\n"
                    + "op.ID_ORGANISME_PAIEMENT, op.NOM as nom_organisme_paiement,\n"
                    + "\n"
                    + "ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n"
                    + "adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation,\n"
                    + "sc.ID_STATUT as id_statut_commande,sc.NOM_STATUT as statut_commande\n"
                    + "\n"
                    + "from TRANSPORTEUR t join Statut s on t.ID_STATUT= s.ID_STATUT\n"
                    + "join LIVRAISON l on l.ID_TRANSPORTEUR = t.ID_TRANSPORTEUR\n"
                    + "join Commande c on c.ID_COMMANDE = l.ID_COMMANDE\n"
                    + "join Membre m on c.ID_MEMBRE = m.ID_MEMBRE\n"
                    + "join statut sm on m.ID_STATUT = sm.ID_STATUT\n"
                    + "join Adresse a on c.ID_ADRESSE = a.ID_ADRESSE\n"
                    + "join EMPLOYE e on c.ID_EMPLOYE = e.ID_EMPLOYE\n"
                    + "join paiement p on c.ID_PAIEMENT = p.ID_PAIEMENT\n"
                    + "join organisme_paiement op on p.ID_ORGANISME_PAIEMENT = op.ID_ORGANISME_PAIEMENT\n"
                    + "join statut ss on p.ID_STATUT=ss.ID_STATUT\n"
                    + "join ADRESSE ad on c.ID_ADRESSE = ad.ID_ADRESSE\n"
                    + "join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE\n"
                    + "join Statut sc on c.ID_STATUT=sc.ID_STATUT\n"
                    + "where t.ID_TRANSPORTEUR = ?;";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, t.getId_transporteur());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statut_transporteur = new Statut(rs.getInt("id_statut_transporteur"), rs.getString("statut_transporteur"));
                Transporteur transporteur = new Transporteur(rs.getInt("id_transporteur"), statut_transporteur, rs.getString("libelle"), rs.getString("tel"), rs.getString("mail"));
                Statut statutmembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutmembre, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip_membre"), rs.getString("commentaire_membre"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));
                Employe employe = new Employe(rs.getInt("id_employe"), rs.getString("nom_employe"), rs.getString("prenom_employe"), rs.getString("date_de_naissance_employe"), rs.getString("login_employe"), rs.getString("password_employe"));
                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom_organisme_paiement"));
                Statut statut_paiement = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                Paiement paiement = new Paiement(rs.getInt("id_paiement"), organisme_paiement, statut_paiement, rs.getString("numero_transaction"), rs.getString("date_paiement"));
                Adresse adresse = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
                Adresse adresseFacturation = new Adresse(rs.getInt("id_adresse_facturation"), rs.getString("rue_facturation"), rs.getString("code_postal_facturation"), rs.getString("ville_facturation"), rs.getString("pays_facturation"));
                Statut statut_commande = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));
                Commande commande = new Commande(rs.getInt("id_commande"), membre, employe, paiement, adresse, adresseFacturation, statut_commande, rs.getString("date_commande"), rs.getFloat("FRAIS_DE_PORT"), rs.getString("NUMERO_COMMANDE"), rs.getString("adresse_ip_commande"), rs.getString("commentaire_commande"));

                Livraison livraison = new Livraison(rs.getInt("id_livraison"), transporteur, commande, rs.getString("date_MOTIF"), rs.getString("MOTIF"), rs.getString("commentaire_livraison"));

                lesLivraisons.add(livraison);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesLivraisons;
    }
}
