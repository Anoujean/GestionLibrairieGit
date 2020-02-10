package data;

import classes.Adresse;
import classes.Commande;
import classes.Employe;
import classes.Membre;
import classes.Organisme_Paiement;
import classes.Paiement;
import classes.Statut;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOcommande extends DAO {

    public DAOcommande() {
        super();
    }

    public List<Commande> select() {
        List<Commande> lesCommandes = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "select \n"
                    + "\n"
                    + "\n"
                    + "c.ID_COMMANDE,c.date as date_commande, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP as adresse_ip_commande, c.COMMENTAIRE as commentaire_commande,\n"
                    + "m.ID_MEMBRE, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as nom_statut_membre, m.NOM, m.PRENOM,m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP as adresse_ip_membre, m.COMMENTAIRE as commentaire_membre, \n"
                    + "e.ID_EMPLOYE, e.NOM as nom_employe, e.PRENOM as prenom_employe, e.DATE_DE_NAISSANCE as date_de_naissance_employe, e.LOGIN as login_employe, e.PASSWORD as password_employe,\n"
                    + "p.ID_PAIEMENT,ss.ID_STATUT as id_statut_paiement, ss.NOM_STATUT as statut_paiement, p.NUMERO_TRANSACTION, p.DATE as date_paiement,\n"
                    + "op.ID_ORGANISME_PAIEMENT, op.NOM as nom_organisme_paiement,\n"
                    + "ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n"
                    + "adrfac.ID_ADRESSE, adrfac.RUE, adrfac.CODE_POSTAL, adrfac.VILLE, adrfac.PAYS,\n"
                    + "sc.ID_STATUT as id_statut_commande,sc.NOM_STATUT as statut_commande\n"
                    + "\n"
                    + "from Commande c\n"
                    + "\n"
                    + "join Membre m on c.ID_MEMBRE = m.ID_MEMBRE\n"
                    + "join statut sm on m.ID_STATUT = sm.ID_STATUT\n"
                    + "join Adresse a on c.ID_ADRESSE = a.ID_ADRESSE\n"
                    + "join EMPLOYE e on c.ID_EMPLOYE = e.ID_EMPLOYE\n"
                    + "join paiement p on c.ID_PAIEMENT = p.ID_PAIEMENT\n"
                    + "join organisme_paiement op on p.ID_ORGANISME_PAIEMENT = op.ID_ORGANISME_PAIEMENT\n"
                    + "join statut ss on p.ID_STATUT=ss.ID_STATUT\n"
                    + "join ADRESSE ad on c.ID_ADRESSE = ad.ID_ADRESSE\n"
                    + "join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE\n"
                    + "join Statut sc on c.ID_STATUT=sc.ID_STATUT";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Statut Statutcom = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));
                Statut Statutm = new Statut(rs.getInt("id_statut_membre"), rs.getString("nom_statut_membre"));
                Statut Statutp = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                
                Membre leMembre = new Membre(rs.getInt("ID_MEMBRE"), Statutm, rs.getString("TELEPHONE"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("adresse_ip_membre"), rs.getString("commentaire_membre"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("DATE_DE_NAISSANCE"));
                Employe lEmploye = new Employe(rs.getInt("ID_EMPLOYE"), rs.getString("nom_employe"), rs.getString("prenom_employe"), rs.getString("date_de_naissance_employe"), rs.getString("login_employe"), rs.getString("password_employe"));
                Organisme_Paiement lOrganisme_Paiement = new Organisme_Paiement(rs.getInt("ID_ORGANISME_PAIEMENT"), rs.getString("nom_organisme_paiement"));
                Paiement lePaiement = new Paiement(rs.getInt("ID_PAIEMENT"), lOrganisme_Paiement, Statutp, rs.getString("NUMERO_TRANSACTION"), rs.getString("date_paiement"));
                Adresse lAdresse_Livraison = new Adresse(rs.getInt("ID_ADRESSE"), rs.getString("RUE"), rs.getString("CODE_POSTAL"), rs.getString("VILLE"), rs.getString("PAYS"));
                Adresse lAdresse_Facturation = new Adresse(rs.getInt("ID_ADRESSE"), rs.getString("RUE"), rs.getString("CODE_POSTAL"), rs.getString("VILLE"), rs.getString("PAYS"));
                Commande laCommande = new Commande(rs.getInt("ID_COMMANDE"), leMembre, lEmploye, lePaiement, lAdresse_Livraison, lAdresse_Facturation, Statutcom, rs.getString("date_commande"), rs.getFloat("FRAIS_DE_PORT"), rs.getString("NUMERO_COMMANDE"), rs.getString("adresse_ip_commande"), rs.getString("commentaire_commande"));

                lesCommandes.add(laCommande);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommandes;
    }

    public void insert(Commande c) {

        try {
            String query = "INSERT INTO commande(id_membre, id_employe, id_paiement, id_adresse, id_adresse_facture, id_statut, date, frais_de_port, numero_commande, adresse_ip, commentaire) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, c.getMembre().getId_membre());
            pstmt.setInt(2, c.getEmploye().getId_employe());
            pstmt.setInt(3, c.getPaiement().getId_paiement());
            pstmt.setInt(4, c.getAdresse().getId_adresse());
            pstmt.setInt(5, c.getAdresse_facture().getId_adresse());
            pstmt.setInt(6, c.getStatut().getId_statut());
            pstmt.setString(7, c.getDate());
            pstmt.setFloat(8, c.getFrais_de_port());
            pstmt.setString(9, c.getNumero_commande());
            pstmt.setString(10, c.getAdresse_ip());
            pstmt.setString(11, c.getCommentaire());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Commande c) {
        try {
            String query = "UPDATE Commande SET date = ?, frais_de_port =?, numero_commande =?, adresse_ip = ?, commentaire = ? WHERE id_commande = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, c.getDate());
            pstmt.setFloat(2, c.getFrais_de_port());
            pstmt.setString(3, c.getNumero_commande());
            pstmt.setString(4, c.getAdresse_ip());
            pstmt.setString(5, c.getCommentaire());
            pstmt.setInt(6, c.getId_commande());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
    public void delete(Commande c) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Commande where ID_COMMANDE = " + c.getId_commande());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
