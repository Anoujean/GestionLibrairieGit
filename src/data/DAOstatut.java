package data;


import classes.Statut;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOstatut extends DAO {

    public DAOstatut() {
        super();
    }
    
     public void insert(Statut s) {

        try {
            String query = "INSERT INTO statut(nom_statut) VALUES (?);";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1,s.getNom_statut()) ;
            
            
            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }

    }

    public void update(Statut s) {
        try {
            String query = "UPDATE statut SET nom_statut = ? WHERE id_statut = ? ;";
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, s.getNom_statut());
            pstmt.setInt(4, s.getId_statut());

            int result = pstmt.executeUpdate();

            System.out.println("resultat:" + result);

            pstmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
    }
    
     public List<Statut> select(){
        List<Statut> lesStatuts = new ArrayList<>();
        try {
            Statement stmt = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "Select * from Statut;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Statut statut = new Statut(rs.getInt("id_statut"), rs.getString("nom_statut"));
                lesStatuts.add(statut);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
        }
        
        return lesStatuts;
    }
     
     public void delete (Statut s){
        try {
                    Statement stm = this.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    stm.executeUpdate("DELETE FROM Statut where id_statut = " + s.getId_statut());
                } catch (SQLException ex) {
                    System.err.println("Oops:SQL:" + ex.getErrorCode() + "/" + ex.getMessage());
                }
            }

    
}
