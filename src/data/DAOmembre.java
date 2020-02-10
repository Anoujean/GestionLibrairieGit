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
import classes.Statut;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOmembre extends DAO {

    public DAOmembre() {
        super();
    }

    public void insert(Membre m) {

        try {
            String query = "INSERT INTO Membre(id_statut, nom, prenom, date_de_naissance, telephone, email, password, adresse_ip, commentaire) VALUES (?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, m.getStatut().getId_statut());
            pstmt.setString(2, m.getNom());
            pstmt.setString(3, m.getPrenom());
            pstmt.setString(4, m.getDate_de_naissance());
            pstmt.setString(5, m.getTelephone());
            pstmt.setString(6, m.getEmail());
            pstmt.setString(7, m.getPassword());
            pstmt.setString(8, m.getAdresse_ip());
            pstmt.setString(9, m.getCommentaire());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Membre m) {
        try {
            String query = "UPDATE membre SET nom = ?, prenom =?, date_de_naissance =?, telephone = ?, email = ?, password = ?, adresse_ip = ?, commentaire = ?  WHERE id_membre = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, m.getNom());
            pstmt.setString(2, m.getPrenom());
            pstmt.setString(3, m.getDate_de_naissance());
            pstmt.setString(4, m.getTelephone());
            pstmt.setString(5, m.getEmail());
            pstmt.setString(6, m.getPassword());
            pstmt.setString(7, m.getAdresse_ip());
            pstmt.setString(8, m.getCommentaire());
            pstmt.setInt(9, m.getId_membre());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public List<Membre> select() {
        List<Membre> lesMembres = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "select m.*, s.NOM_STATUT from membre m join Statut s on m.ID_STATUT=s.ID_STATUT";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Statut leStatut = new Statut(rs.getInt("ID_STATUT"), rs.getString("NOM_STATUT"));
                Membre membre = new Membre(rs.getInt("id_membre"), leStatut, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip"), rs.getString("commentaire"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));

                lesMembres.add(membre);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesMembres;
    }
    
    
   

    public List<Commande> getCommandesByID(Membre m) {
        List<Commande> lesCommandes = new ArrayList<>();

        try {
            String query = "  select m.* , sm.id_statut as id_statut_membre, sm.nom_statut as statut_membre,\n"
                    + "                    c.ID_COMMANDE, c.DATE, c.FRAIS_DE_PORT, c.NUMERO_COMMANDE, c.ADRESSE_IP, c.COMMENTAIRE, s.ID_STATUT as id_statut_commande, s.NOM_STATUT as statut_commande,\n"
                    + "                    e.id_employe, e.nom as nom_employe, e.prenom as prenom_employe, e.date_de_naissance as date_de_naissance_employe, e.login as login_employe, e.password as password_employe,\n"
                    + "                    p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement,\n"
                    + "                    ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n"
                    + "                    adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation\n"
                    + "                    \n"
                    + "                    from membre m\n"
                    + "					join Statut sm on m.id_statut = sm.id_statut\n"
                    + "                    join commande c on m.ID_membre = c.ID_membre\n"
                    + "                    join statut s on s.ID_STATUT=c.ID_STATUT\n"
                    + "					join employe e on c.id_employe = e.id_employe\n"
                    + "                    join PAIEMENT p on c.ID_PAIEMENT= p.ID_PAIEMENT\n"
                    + "                    join ORGANISME_PAIEMENT op on op.ID_ORGANISME_PAIEMENT=p.ID_ORGANISME_PAIEMENT\n"
                    + "                    join statut sp on p.ID_STATUT=sp.ID_STATUT\n"
                    + "                    join adresse ad on c.ID_ADRESSE = ad.ID_ADRESSE\n"
                    + "                    join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE\n"
                    + "                    \n"
                    + "                    WHERE m.ID_membre = ? ";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, m.getId_membre());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip"), rs.getString("commentaire"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));
                Employe employe = new Employe(rs.getInt("id_employe"), rs.getString("nom_employe"), rs.getString("prenom_employe"), rs.getString("date_de_naissance_employe"), rs.getString("login_employe"), rs.getString("password_employe"));
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

    public List<Commentaire> getCommentaireByID(Membre m) {
        List<Commentaire> lesCommentaires = new ArrayList<>();

        try {
            String query = "select m.*, sm.id_statut as id_statut_membre, sm.nom_statut as statut_membre,\n"
                    + "                    com.ID_COMMENTAIRE, com.OBJET, com.CONTENU, com.note, com.date as date_commentaire, com.ADRESSE_IP as adresse_ip_commentaire, com.COMMENTAIRE as commentaire_commentaire,scom.ID_STATUT as id_statut_commentaire, scom.NOM_STATUT as statut_commentaire,\n"
                    + "                    e.id_employe, e.nom as nom_employe, e.prenom as prenom_employe, e.date_de_naissance as date_de_naissance_employe, e.login as login_employe, e.password as password_employe,\n"
                    + "                    lc.ID_LIGNE_COMMANDE, lc.QTE, lc.PRIX, lc.TVA, lc.REMISE,\n"
                    + "                    o.ISBN, so.ID_STATUT as id_statut_ouvrage, so.NOM_STATUT as statut_ouvrage, o.TITRE, o.IMAGE,o.SOUS_TITRE, o.RESUME, o.STOCK,o.TVA, o.poids, o.prix, o.dimensions, o.nombre_page, o.COMMENTAIRE as commentaire_ouvrage,\n"
                    + "                    c.id_commande, sc.id_statut as id_statut_commande, sc.nom_statut as statut_commande,c.date as date_commande, c.frais_de_port as frais_de_port_commande, c.numero_commande, c.adresse_ip as adresse_ip_commande, c.commentaire as commentaire_commande,\n"
                    + "                    p.ID_PAIEMENT, p.NUMERO_TRANSACTION, p.DATE as date_paiement,op.ID_ORGANISME_PAIEMENT as id_organisme_paiement, op.NOM as nom_organisme_paiement, sp.ID_STATUT as id_statut_paiement, sp.NOM_STATUT as statut_paiement,\n"
                    + "                    ad.ID_ADRESSE, ad.RUE, ad.CODE_POSTAL, ad.VILLE, ad.PAYS,\n"
                    + "                    adrfac.ID_ADRESSE as id_adresse_facturation, adrfac.RUE as rue_facturation, adrfac.CODE_POSTAL as code_postal_facturation, adrfac.VILLE as ville_facturation, adrfac.PAYS as pays_facturation\n"
                    + "                    \n"
                    + "                    \n"
                    + "                    from  membre m\n"
                    + "                    join commentaire com on m.ID_membre = com.ID_membre\n"
                    + "                    join statut scom on com.ID_STATUT= scom.ID_STATUT\n"
                    + "					join statut sm on m.ID_STATUT=sm.ID_STATUT\n"
                    + "					join employe e on com.id_employe = e.id_employe\n"
                    + "                    \n"
                    + "                    \n"
                    + "                    join ligne_commande lc on com.ID_LIGNE_COMMANDE=lc.ID_LIGNE_COMMANDE\n"
                    + "                    join ouvrage o on com.ISBN = o.ISBN\n"
                    + "                    join statut so on o.ID_STATUT=so.ID_STATUT\n"
                    + "                    join commande c on lc.id_commande = c.id_commande\n"
                    + "                    join statut sc on c.id_statut = sc.id_statut\n"
                    + "                    join PAIEMENT p on c.ID_PAIEMENT= p.ID_PAIEMENT\n"
                    + "                    join ORGANISME_PAIEMENT op on op.ID_ORGANISME_PAIEMENT=p.ID_ORGANISME_PAIEMENT\n"
                    + "                    join statut sp on p.ID_STATUT=sp.ID_STATUT\n"
                    + "                    join adresse ad on c.ID_ADRESSE = ad.ID_ADRESSE\n"
                    + "                    join Adresse adrfac on c.ID_ADRESSE_FACTURE = adrfac.ID_ADRESSE\n"
                    + "                    where m.id_membre = ?";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, m.getId_membre());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip"), rs.getString("commentaire"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));

                Statut Statut_ouvrage = new Statut(rs.getInt("id_statut_ouvrage"), rs.getString("statut_ouvrage"));
                Ouvrage lOuvrage = new Ouvrage(rs.getString("ISBN"), Statut_ouvrage, rs.getString("TITRE"), rs.getString("IMAGE"), rs.getString("SOUS_TITRE"), rs.getString("RESUME"), rs.getFloat("STOCK"), rs.getFloat("TVA"), rs.getFloat("POIDS"), rs.getFloat("PRIX"), rs.getString("DIMENSIONS"), rs.getString("NOMBRE_PAGE"), rs.getString("commentaire_ouvrage"));

                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom_organisme_paiement"));
                Statut statut_paiement = new Statut(rs.getInt("id_statut_paiement"), rs.getString("statut_paiement"));
                Paiement paiement = new Paiement(rs.getInt("id_paiement"), organisme_paiement, statut_paiement, rs.getString("numero_transaction"), rs.getString("date_paiement"));
                Adresse adresse = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
                Adresse adresseFacturation = new Adresse(rs.getInt("id_adresse_facturation"), rs.getString("rue_facturation"), rs.getString("code_postal_facturation"), rs.getString("ville_facturation"), rs.getString("pays_facturation"));
                Statut statut_commande = new Statut(rs.getInt("id_statut_commande"), rs.getString("statut_commande"));
                Employe employe = new Employe(rs.getInt("id_employe"), rs.getString("nom_employe"), rs.getString("prenom_employe"), rs.getString("date_de_naissance_employe"), rs.getString("login_employe"), rs.getString("password_employe"));
                Commande commande = new Commande(rs.getInt("ID_COMMANDE"), membre, employe, paiement, adresse, adresseFacturation, statut_commande, rs.getString("date_commande"), rs.getFloat("frais_de_port_commande"), rs.getString("NUMERO_COMMANDE"), rs.getString("adresse_ip_commande"), rs.getString("commentaire_commande"));

                Ligne_commande ligne_commande = new Ligne_commande(rs.getInt("ID_LIGNE_COMMANDE"), lOuvrage, commande, rs.getInt("qte"), rs.getFloat("prix"), rs.getFloat("tva"), rs.getFloat("remise"));
                Statut statut_commentaire = new Statut(rs.getInt("id_statut_commentaire"), rs.getString("statut_commentaire"));

                Commentaire commentaire = new Commentaire(rs.getInt("id_commentaire"), membre, ligne_commande, lOuvrage, statut_commentaire, employe, rs.getString("objet"), rs.getString("contenu"), rs.getInt("note"), rs.getString("date_commentaire"), rs.getString("adresse_ip_commentaire"), rs.getString("commentaire_commentaire"));

                lesCommentaires.add(commentaire);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesCommentaires;
    }

    public List<Adresse> getAdresseLivreByID(Membre m) {
        List<Adresse> lesAdressesLivres = new ArrayList<>();

        try {
            String query = "select \n"
                    + "m.id_membre, sm.ID_STATUT as id_statut_membre, sm.NOM_STATUT as statut_membre, m.NOM, m.PRENOM, m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP, m.COMMENTAIRE,\n"
                    + "aliv.ID_ADRESSE, aliv.RUE, aliv.CODE_POSTAL, aliv.VILLE, aliv.PAYS\n"
                    + "from etre_livre el\n"
                    + "join membre m on el.id_membre = m.id_membre\n"
                    + "join statut sm on m.ID_STATUT=sm.ID_STATUT\n"
                    + "join adresse aliv on el.ID_ADRESSE=aliv.ID_ADRESSE\n"
                    + "where el.ID_ADRESSE= ? ";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, m.getId_membre());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
//                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
//                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip"), rs.getString("commentaire"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));
                Adresse adresseLiv = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
//                Etre_livre etre_livre = new Etre_livre(membre, adresseLiv);

                lesAdressesLivres.add(adresseLiv);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesAdressesLivres;
    }

    public List<Adresse> getAdressefacturationByID(Membre m) {
        List<Adresse> lesAdressesFacturation = new ArrayList<>();

        try {
            String query = "select \n"
                    + "m.id_membre, smf.ID_STATUT as id_statut_membre, smf.NOM_STATUT as statut_membre, m.NOM, m.PRENOM, m.DATE_DE_NAISSANCE, m.TELEPHONE, m.EMAIL, m.PASSWORD, m.ADRESSE_IP, m.COMMENTAIRE,\n"
                    + "afact.ID_ADRESSE, afact.RUE, afact.CODE_POSTAL, afact.VILLE, afact.PAYS\n"
                    + "from etre_facture ef\n"
                    + "join membre m on ef.id_membre = m.id_membre\n"
                    + "join statut smf on m.ID_STATUT=smf.ID_STATUT\n"
                    + "join adresse afact on ef.ID_ADRESSE=afact.ID_ADRESSE\n"
                    + "where ef.ID_ADRESSE = ? ";

            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setInt(1, m.getId_membre());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
//                Statut statutMembre = new Statut(rs.getInt("id_statut_membre"), rs.getString("statut_membre"));
//                Membre membre = new Membre(rs.getInt("id_membre"), statutMembre, rs.getString("telephone"), rs.getString("email"), rs.getString("password"), rs.getString("adresse_ip"), rs.getString("commentaire"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_de_naissance"));
                Adresse adresseFact = new Adresse(rs.getInt("id_adresse"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("pays"));
//                Etre_facture etre_facture = new Etre_facture(adresseFact, membre);

                lesAdressesFacturation.add(adresseFact);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesAdressesFacturation;
    }
    
     public void delete (Membre m){
        try {
                    Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    stm.executeUpdate("DELETE FROM membre where id_membre = " + m.getId_membre());
                } catch (SQLException ex) {
                    System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
                }
            }
     
      public void deleteMembreLivraison(Membre m) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_livre where id_adresse = " + m.getId_membre());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
      
      public void deleteMembreFacturation(Membre m) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_facture where id_adresse = " + m.getId_membre());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
      
      public void deleteMenbreLivraison(Membre m, Adresse a) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_livre where id_membre = " + m.getId_membre()+ " and id_adresse= " + a.getId_adresse());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
      
      public void deleteMenbreFacturation( Adresse a, Membre m) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM etre_facture where  id_adresse = " + a.getId_adresse()+ " and id_membre= " + m.getId_membre());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
}
