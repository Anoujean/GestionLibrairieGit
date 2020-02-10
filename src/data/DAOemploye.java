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
import classes.Personne;
import classes.Statut;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOemploye extends DAO {

    public DAOemploye() {
        super();
    }

    public void insert(Employe e) {

        try {
            String query = "INSERT INTO Employe(nom, prenom, date_de_naissance, login, password) VALUES (?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, e.getNom());
            pstmt.setString(2, e.getPrenom());
            pstmt.setString(3, e.getDate_de_naissance());
            pstmt.setString(4, e.getLogin());
            pstmt.setString(5, e.getPassword());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Employe e) {
        try {
            String query = "UPDATE Employe SET nom = ?, prenom =?, date_de_naissance =?, login = ?, password = ? WHERE id_Employe = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, e.getNom());
            pstmt.setString(2, e.getPrenom());
            pstmt.setString(3, e.getDate_de_naissance());
            pstmt.setString(4, e.getLogin());
            pstmt.setString(5, e.getPassword());
            pstmt.setInt(6, e.getId_employe());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public List<Employe> select() {
        List<Employe> lesEmployes = new ArrayList<>();

        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select * from Employe;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Employe employe = new Employe(rs.getInt("id_employe"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"), rs.getString("login"), rs.getString("password"));
                lesEmployes.add(employe);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesEmployes;
    }

    public List<Ouvrage> getOuvragesByID(Employe e) {
        List<Ouvrage> lesOuvrages = new ArrayList<>();

        try {
            String query = "select e.* ,o.ISBN, o.TITRE, o.IMAGE, o.SOUS_TITRE, o.RESUME, o.STOCK, o.TVA, o.PRIX, o.POIDS, o.ISBN, o.dimensions, o.nombre_page, o.commentaire as commentaire_ouvrage, so.ID_STATUT, so.NOM_STATUT\n"
                    + "from employe e \n"
                    + "join gerer g on g.ID_EMPLOYE = e.ID_EMPLOYE\n"
                    + "join ouvrage o on g.ISBN = o.ISBN   \n"
                    + "join statut so on o.ID_STATUT = so.ID_STATUT\n"
                    + "where e.ID_EMPLOYE = ?  ";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_employe());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut Statut_employe = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), Statut_employe, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("commentaire_ouvrage"));
                lesOuvrages.add(lOuvrage);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesOuvrages;
    }

    public List<Commande> getCommandeByID(Employe e) {
        List<Commande> lesCommandes = new ArrayList<>();

        try {
            String query = "select e.* ,\n"
                    + "c.ID_COMMANDE, c.DATE, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP, c.COMMENTAIRE, s.ID_STATUT as id_statut_commande, s.NOM_STATUT as statut_commande,\n"
                    + "m.ID_MEMBRE, m.NOM as nom_membre, m.PASSWORD as prenom_membre, m.DATE_DE_NAISSANCE as date_de_naissance_membre,m.ADRESSE_IP as adresse_ip_membre, m.TELEPHONE as telephone_membre, m.EMAIL as email_membre, m.PASSWORD as password_membre, m.COMMENTAIRE as commentaire_membre, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre,\n"
                    + "p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement,\n"
                    + "ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n"
                    + "adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation\n"
                    + "\n"
                    + "from employe e\n"
                    + "join commande c on e.ID_EMPLOYE = c.ID_EMPLOYE\n"
                    + "join statut s on s.ID_STATUT=c.ID_STATUT\n"
                    + "join membre m on m.ID_MEMBRE=c.ID_MEMBRE\n"
                    + "join statut sm on m.ID_STATUT = sm.ID_STATUT\n"
                    + "join PAIEMENT p on c.ID_PAIEMENT= p.ID_PAIEMENT\n"
                    + "join ORGANISME_PAIEMENT op on op.ID_ORGANISME_PAIEMENT=p.ID_ORGANISME_PAIEMENT\n"
                    + "join statut sp on p.ID_STATUT=sp.ID_STATUT\n"
                    + "join adresse ad on c.ID_ADRESSE = ad.ID_ADRESSE\n"
                    + "join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE\n"
                    + "\n"
                    + "WHERE E.ID_EMPLOYE = ?";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_employe());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone_membre"), rs.getString("email_membre"), rs.getString("password_membre"), rs.getString("adresse_ip_membre"), rs.getString("commentaire_membre"), rs.getString("nom_membre"), rs.getString("prenom_membre"), rs.getString("date_de_naissance_membre"));
                Employe employe = new Employe(rs.getInt("id_employe"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"), rs.getString("login"), rs.getString("password"));
                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom_organisme_paiement"));
                Statut statut_paiement = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                Paiement paiement = new Paiement(rs.getInt("id_paiement"), organisme_paiement, statut_paiement, rs.getString("numero_transaction"), rs.getString("date_paiement"));
                Adresse adresse = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
                Adresse adresseFacturation = new Adresse(rs.getInt("id_adresse_facturation"), rs.getString("rue_facturation"), rs.getString("code_postal_facturation"), rs.getString("ville_facturation"), rs.getString("pays_facturation"));
                Statut statuCommande = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));

                Commande commande = new Commande(rs.getInt("ID_COMMANDE"), membre, employe, paiement, adresse, adresseFacturation, statuCommande, rs.getString("DATE"), rs.getFloat("FRAIS_DE_PORT"), rs.getString("NUMERO_COMMANDE"), rs.getString("ADRESSE_IP"), rs.getString("COMMENTAIRE"));
                lesCommandes.add(commande);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommandes;
    }

    public List<Commentaire> getCommentaireByID(Employe e) {
        List<Commentaire> lesCommentaires = new ArrayList<>();

        try {
            String query = "select e.* ,\n"
                    + "com.ID_COMMENTAIRE, com.OBJET, com.CONTENU, com.note, com.date as date_commentaire, com.ADRESSE_IP as adresse_ip_commentaire, com.COMMENTAIRE as commentaire_commentaire,scom.ID_STATUT as id_statut_commentaire, scom.NOM_STATUT as statut_commentaire,\n"
                    + "m.ID_MEMBRE, sm.ID_STATUT as id_statut_membre, sm.ID_STATUT as statut_membre, m.NOM as nom_membre, m.PRENOM as prenom_membre, m.DATE_DE_NAISSANCE as date_de_naissance_membre, m.TELEPHONE as telephone_membre, m.EMAIL as email_membre, m.PASSWORD as password_membre, m.ADRESSE_IP as adresse_ip_membre, m.COMMENTAIRE as commentaire_membre,\n"
                    + "lc.ID_LIGNE_COMMANDE, lc.QTE, lc.PRIX, lc.TVA, lc.REMISE,\n"
                    + "o.ISBN, so.ID_STATUT as id_statut_ouvrage, so.NOM_STATUT as statut_ouvrage, o.TITRE, o.IMAGE,o.SOUS_TITRE, o.RESUME, o.STOCK,o.TVA, o.poids, o.prix, o.dimensions, o.nombre_page, o.COMMENTAIRE as commentaire_ouvrage,\n"
                    + "c.id_commande, sc.id_statut as id_statut_commande, sc.nom_statut as statut_commande,c.date as date_commande, c.frais_de_port as frais_de_port_commande, c.numero_commande, c.adresse_ip as adresse_ip_commande, c.commentaire as commentaire_commande,\n"
                    + "p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement,\n"
                    + "ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n"
                    + "adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation\n"
                    + "                    \n"
                    + "\n"
                    + "from  EMPLOYE e\n"
                    + "join commentaire com on e.ID_EMPLOYE=com.ID_EMPLOYE\n"
                    + "join statut scom on com.ID_STATUT= scom.ID_STATUT\n"
                    + "join membre m on com.ID_MEMBRE=m.ID_MEMBRE\n"
                    + "join statut sm on m.ID_STATUT=sm.ID_STATUT\n"
                    + "join ligne_commande lc on com.ID_LIGNE_COMMANDE=lc.ID_LIGNE_COMMANDE\n"
                    + "join ouvrage o on com.ISBN = o.ISBN\n"
                    + "join statut so on o.ID_STATUT=so.ID_STATUT\n"
                    + "join commande c on lc.id_commande = c.id_commande\n"
                    + "join statut sc on c.id_statut = sc.id_statut\n"
                    + "join PAIEMENT p on c.ID_PAIEMENT= p.ID_PAIEMENT\n"
                    + "join ORGANISME_PAIEMENT op on op.ID_ORGANISME_PAIEMENT=p.ID_ORGANISME_PAIEMENT\n"
                    + "join statut sp on p.ID_STATUT=sp.ID_STATUT\n"
                    + "join adresse ad on c.ID_ADRESSE = ad.ID_ADRESSE\n"
                    + "join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE\n"
                    + "WHERE E.ID_EMPLOYE = ?";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_employe());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone_membre"), rs.getString("email_membre"), rs.getString("password_membre"), rs.getString("adresse_ip_membre"), rs.getString("commentaire_membre"), rs.getString("nom_membre"), rs.getString("prenom_membre"), rs.getString("date_de_naissance_membre"));

                Statut Statut_ouvrage = new Statut(rs.getInt("id_statut_ouvrage"), rs.getString("statut_ouvrage"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), Statut_ouvrage, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("commentaire_ouvrage"));

                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom_organisme_paiement"));
                Statut statut_paiement = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                Paiement paiement = new Paiement(rs.getInt("id_paiement"), organisme_paiement, statut_paiement, rs.getString("numero_transaction"), rs.getString("date_paiement"));
                Adresse adresse = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
                Adresse adresseFacturation = new Adresse(rs.getInt("id_adresse_facturation"), rs.getString("rue_facturation"), rs.getString("code_postal_facturation"), rs.getString("ville_facturation"), rs.getString("pays_facturation"));
                Statut statut_commande = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));
                Commande commande = new Commande(rs.getInt("ID_COMMANDE"), membre, e, paiement, adresse, adresseFacturation, statut_commande, rs.getString("date_commande"), rs.getFloat("frais_de_port_commande"), rs.getString("NUMERO_COMMANDE"), rs.getString("adresse_ip_commande"), rs.getString("commentaire_commande"));

                Ligne_commande ligne_commande = new Ligne_commande(rs.getInt("ID_LIGNE_COMMANDE"), lOuvrage, commande, rs.getInt("qte"), rs.getFloat("prix"), rs.getFloat("tva"), rs.getFloat("remise"));
                Statut statut_commentaire = new Statut(rs.getInt("id_statut_commentaire"), rs.getString("statut_commentaire"));

                Commentaire commentaire = new Commentaire(rs.getInt("id_commentaire"), membre, ligne_commande, lOuvrage, statut_commentaire, e, rs.getString("objet"), rs.getString("contenu"), rs.getInt("note"), rs.getString("date_commentaire"), rs.getString("adresse_ip_commentaire"), rs.getString("commentaire_commentaire"));

                lesCommentaires.add(commentaire);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommentaires;
    }

    public void delete(Employe e) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM employe where id_employe = " + e.getId_employe());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public void Gerer(Employe e, Ouvrage o) {
        try {
            String query = "INSERT INTO gerer(id_employe, isbn) VALUES (?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, e.getId_employe());
            pstmt.setString(2, o.getIsbn());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public void deleteGerer(Employe e) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM gerer where id_employe = " + e.getId_employe());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public void deleteGerer(Ouvrage o) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM gerer where isbn = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public void deleteGerer(Employe e, Ouvrage o) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM gerer where id_employe = " + e.getId_employe() + " and isbn = " + o.getIsbn());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

}
