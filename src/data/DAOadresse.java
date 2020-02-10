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

public class DAOadresse extends DAO {

    public DAOadresse() {
        super();
    }

    public void insert(Adresse a) {

        try {
            String query = "INSERT INTO Adresse(rue, code_postal, ville, pays) VALUES (?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, a.getRue());
            pstmt.setString(2, a.getCode_postal());
            pstmt.setString(3, a.getVille());
            pstmt.setString(4, a.getPays());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Adresse a) {
        try {
            String query = "UPDATE Adresse SET rue = ?, code_postal =?, ville =?, pays = ? WHERE id_Adresse = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, a.getRue());
            pstmt.setString(2, a.getCode_postal());
            pstmt.setString(3, a.getVille());
            pstmt.setString(4, a.getPays());
            pstmt.setInt(5, a.getId_adresse());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public List<Adresse> select() {
        List<Adresse> lesAdresses = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select * from Adresse;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Adresse adresse = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
                lesAdresses.add(adresse);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesAdresses;
    }

    public List<Membre> getMembreLivresByID(Adresse a) {
        List<Membre> lesMembresLivres = new ArrayList<>();

        try {
            String query = "select \n"
                    + "m.id_membre, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre, m.NOM, m.PRENOM, m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP, m.COMMENTAIRE,\n"
                    + "aliv.ID_ADRESSE, aliv.RUE, aliv.CODE_POSTAL, aliv.VILLE, aliv.PAYS\n"
                    + "from etre_livre el\n"
                    + "join membre m on el.id_membre = m.id_membre\n"
                    + "join statut sm on m.ID_STATUT=sm.ID_STATUT\n"
                    + "join adresse aliv on el.ID_ADRESSE=aliv.ID_ADRESSE\n"
                    + "where aliv.ID_ADRESSE = ?";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, a.getId_adresse());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip"), rs.getString("commentaire"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));
//                Adresse adresseLiv = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
//                Etre_livre etre_livre = new Etre_livre(membre, adresseLiv);

                lesMembresLivres.add(membre);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesMembresLivres;
    }

    public List<Membre> getMembrefactureByID(Adresse a) {
        List<Membre> lesMembresfactures = new ArrayList<>();

        try {
            String query = "select \n"
                    + "m.id_membre, smf.ID_STATUT as id_statut_membre, smf.NOM_STATUT as statut_membre, m.NOM, m.PRENOM, m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP, m.COMMENTAIRE,\n"
                    + "afact.ID_ADRESSE, afact.RUE, afact.CODE_POSTAL, afact.VILLE, afact.PAYS\n"
                    + "from etre_facture ef\n"
                    + "join membre m on ef.id_membre = m.id_membre\n"
                    + "join statut smf on m.ID_STATUT=smf.ID_STATUT\n"
                    + "join adresse afact on ef.ID_ADRESSE=afact.ID_ADRESSE\n"
                    + "where afact.ID_ADRESSE = ?";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, a.getId_adresse());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip"), rs.getString("commentaire"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));
//                Adresse adressefact = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
//                Etre_facture etre_facture = new Etre_facture(adressefact, membre);

                lesMembresfactures.add(membre);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesMembresfactures;
    }
    
    public List<Commande> getCommandeLivresByID(Adresse adresseLivraison) {
        List<Commande> lesCommandesLivres = new ArrayList<>();

        try {
            String query = "select el.*,\n" +
"                    c.ID_COMMANDE, c.DATE, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP, c.COMMENTAIRE, s.ID_STATUT as id_statut_commande, s.NOM_STATUT as statut_commande,\n" +
"                    m.ID_MEMBRE, m.NOM as nom_membre, m.PASSWORD as prenom_membre, m.DATE_DE_NAISSANCE as date_de_naissance_membre,m.ADRESSE_IP as adresse_ip_membre, m.TELEPHONE as telephone_membre, m.EMAIL as email_membre, m.PASSWORD as password_membre, m.COMMENTAIRE as commentaire_membre, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre,\n" +
"                    e.ID_EMPLOYE, e.NOM,e.PRENOM, e.DATE_DE_NAISSANCE, e.LOGIN, e.PASSWORD,\n" +
"		     p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,"
                    + "op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement,\n" +
"                    ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n" +
"                    adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation\n" +
"                    \n" +
"                    FROM commande c \n" +
"                    join statut s on s.ID_STATUT=c.ID_STATUT\n" +
"                    join membre m on m.ID_MEMBRE=c.ID_MEMBRE\n" +
"                    join statut sm on m.ID_STATUT = sm.ID_STATUT\n" +
"					JOIN employe e on e.ID_EMPLOYE = c.ID_EMPLOYE\n" +
"                    join PAIEMENT p on c.ID_PAIEMENT= p.ID_PAIEMENT\n" +
"                    join ORGANISME_PAIEMENT op on op.ID_ORGANISME_PAIEMENT=p.ID_ORGANISME_PAIEMENT\n" +
"                    join statut sp on p.ID_STATUT=sp.ID_STATUT\n" +
"                    join adresse ad on c.ID_ADRESSE = ad.ID_ADRESSE\n" +
"                    join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE	\n" +
"					join ETRE_LIVRE el on el.ID_ADRESSE =c.ID_ADRESSE\n" +
"                    \n" +
"                   WHERE el.ID_ADRESSE = ?";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, adresseLivraison.getId_adresse());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone_membre"), rs.getString("email_membre"), rs.getString("password_membre"), rs.getString("adresse_ip_membre"), rs.getString("commentaire_membre"), rs.getString("nom_membre"), rs.getString("prenom_membre"), rs.getString("date_de_naissance_membre"));
                Employe employe = new Employe(rs.getInt("id_employe"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"), rs.getString("login"), rs.getString("password"));
                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom_organisme_paiement"));
                Statut statut_paiement = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                Paiement paiement = new Paiement(rs.getInt("id_paiement"), organisme_paiement, statut_paiement, rs.getString("numero_transaction"), rs.getString("date_paiement"));
                Adresse adresseFacturation = new Adresse(rs.getInt("id_adresse_facturation"), rs.getString("rue_facturation"), rs.getString("code_postal_facturation"), rs.getString("ville_facturation"), rs.getString("pays_facturation"));
                Statut statuCommande = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));
                
                Commande commande = new Commande(rs.getInt("id_commande"), membre, employe, paiement, adresseLivraison, adresseFacturation, statuCommande, rs.getString("date"), rs.getFloat("frais_de_port"), rs.getString("NUMERO_COMMANDE"), rs.getString("ADRESSE_IP"), rs.getString("COMMENTAIRE"));
                
                lesCommandesLivres.add(commande);

            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommandesLivres;
    }

    public List<Commande> getCommandeFacturesByID(Adresse adresseFacturation) {
        List<Commande> lesCommandesfactures = new ArrayList<>();

        try {
            String query = "select ef.*,\n" +
"                    c.ID_COMMANDE, c.DATE, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP, c.COMMENTAIRE, s.ID_STATUT as id_statut_commande, s.NOM_STATUT as statut_commande,\n" +
"                    m.ID_MEMBRE, m.NOM as nom_membre, m.PASSWORD as prenom_membre, m.DATE_DE_NAISSANCE as date_de_naissance_membre,m.ADRESSE_IP as adresse_ip_membre, m.TELEPHONE as telephone_membre, m.EMAIL as email_membre, m.PASSWORD as password_membre, m.COMMENTAIRE as commentaire_membre, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre,\n" +
"                    e.ID_EMPLOYE, e.NOM,e.PRENOM, e.DATE_DE_NAISSANCE, e.LOGIN, e.PASSWORD,\n" +
"					p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement,\n" +
"                    ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n" +
"                    adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation\n" +
"                    \n" +
"                    FROM commande c \n" +
"                    join statut s on s.ID_STATUT=c.ID_STATUT\n" +
"                    join membre m on m.ID_MEMBRE=c.ID_MEMBRE\n" +
"                    join statut sm on m.ID_STATUT = sm.ID_STATUT\n" +
"					JOIN employe e on e.ID_EMPLOYE = c.ID_EMPLOYE\n" +
"                    join PAIEMENT p on c.ID_PAIEMENT= p.ID_PAIEMENT\n" +
"                    join ORGANISME_PAIEMENT op on op.ID_ORGANISME_PAIEMENT=p.ID_ORGANISME_PAIEMENT\n" +
"                    join statut sp on p.ID_STATUT=sp.ID_STATUT\n" +
"                    join adresse ad on c.ID_ADRESSE = ad.ID_ADRESSE\n" +
"                    join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE	\n" +
"					join ETRE_FACTURE ef on ef.ID_ADRESSE =c.ID_ADRESSE\n" +
"                    \n" +
"                   WHERE adrfac.ID_ADRESSE = ?";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, adresseFacturation.getId_adresse());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone_membre"), rs.getString("email_membre"), rs.getString("password_membre"), rs.getString("adresse_ip_membre"), rs.getString("commentaire_membre"), rs.getString("nom_membre"), rs.getString("prenom_membre"), rs.getString("date_de_naissance_membre"));
                Adresse adresseLivraison = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
               
                
                Employe employe = new Employe(rs.getInt("id_employe"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"), rs.getString("login"), rs.getString("password"));
                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom_organisme_paiement"));
                Statut statut_paiement = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                Paiement paiement = new Paiement(rs.getInt("id_paiement"), organisme_paiement, statut_paiement, rs.getString("numero_transaction"), rs.getString("date_paiement"));
                
                Statut statuCommande = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));
                
                Commande commande = new Commande(rs.getInt("id_commande"), membre, employe, paiement, adresseLivraison, adresseFacturation, statuCommande, rs.getString("date"), rs.getFloat("frais_de_port"), rs.getString("NUMERO_COMMANDE"), rs.getString("ADRESSE_IP"), rs.getString("COMMENTAIRE"));
                
                lesCommandesfactures.add(commande);

            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommandesfactures;
    }
     
    public void delete(Adresse a) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM adresse where id_adresse = " + a.getId_adresse());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
      public void deleteAdresseLivraison(Adresse a) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_livre where id_adresse = " + a.getId_adresse());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
      
      public void deleteAdresseFacturation(Adresse a) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_facture where id_adresse = " + a.getId_adresse());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
      
      public void deleteAdresseLivraison(Membre m, Adresse a) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_livre where id_membre = " + m.getId_membre()+ " and id_adresse= " + a.getId_adresse());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
      
      public void deleteAdresseFacturation( Adresse a, Membre m) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_facture where  id_adresse = " + a.getId_adresse()+ " and id_membre= " + m.getId_membre());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
}
