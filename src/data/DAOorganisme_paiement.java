package data;


import classes.Organisme_Paiement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOorganisme_paiement extends DAO{

    public DAOorganisme_paiement() {
        super ();
    }

    public void insert(Organisme_Paiement op) {

        try {
            String query = "INSERT INTO Organisme_Paiement(nom) VALUES (?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, op.getNom());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Organisme_Paiement op) {
        try {
            String query = "UPDATE Organisme_Paiement SET nom = ? WHERE id_organisme_paiement = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, op.getNom());
            pstmt.setInt(2, op.getId_organisme_paiement());
            

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
     public List<Organisme_Paiement> select(){
        List<Organisme_Paiement> lesOrganismes_paiement = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select * from Organisme_Paiement;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Organisme_Paiement organisme_paiement = new Organisme_Paiement(rs.getInt("id_organisme_paiement"), rs.getString("nom"));
                lesOrganismes_paiement.add(organisme_paiement);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesOrganismes_paiement;
    }
     
     public void delete(Organisme_Paiement op) {
        try {
            Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.executeUpdate("DELETE FROM Organisme_Paiement where id_Organisme_Paiement = " + op.getId_organisme_paiement());
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
}
