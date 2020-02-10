package data;

import classes.Organisme_Paiement;
import classes.Paiement;
import classes.Statut;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOpaiement extends DAO {

    public DAOpaiement() {
        super();
    }

    public void insert(Paiement p) {

        try {
            String query = "INSERT INTO Paiement(id_organisme_paiement, id_statut, numero_transaction, date) VALUES (?,?,?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, p.getOrganisme_paiement().getId_organisme_paiement());
            pstmt.setInt(2, p.getStatut().getId_statut());
            pstmt.setString(3, p.getNumero_transaction());
            pstmt.setString(4, p.getDate());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Paiement p) {
        try {
            String query = "UPDATE Paiement SET id_organisme_paiement = ?, id_statut = ?, numero_transaction = ?, date = ? WHERE id_paiement = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, p.getOrganisme_paiement().getId_organisme_paiement());
            pstmt.setInt(2, p.getStatut().getId_statut());
            pstmt.setString(3, p.getNumero_transaction());
            pstmt.setString(4, p.getDate());
            pstmt.setInt(5, p.getId_paiement());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }

    public List<Paiement> select() {
        List<Paiement> lesPaiements = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select p.*, op.NOM, s.NOM_STATUT from paiement p join organisme_paiement op on p.ID_ORGANISME_PAIEMENT = op.ID_ORGANISME_PAIEMENT join Statut s on p.ID_STATUT=s.ID_STATUT;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom"));
                Statut statut = new Statut(rs.getInt("id_statut"), rs.getString("nom_statut"));
                Paiement paiement = new Paiement(rs.getInt("id_paiement"), organisme_paiement, statut, rs.getString("numero_transaction"), rs.getString("date"));
                lesPaiements.add(paiement);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

        return lesPaiements;
    }

    public void delete(Paiement p) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Paiement where id_Paiement = " + p.getId_paiement());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
}
