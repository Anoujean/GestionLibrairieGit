/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.*;
import classes.*;

/**
 *
 * @author cda402
 */
public class DAO {
    
    private Connection connexion;

    public DAO() {
    }
        
    public void open() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:ClassNotFound:" + ex.getMessage());
        }

        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=LibrairieTest;user=sa;password=sa";

            this.connexion = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:" + ex.getMessage());
        }

    }

    public void close() {

        try {
            this.connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:close:" + ex.getMessage());
        }

    }
    
    public Connection getConnection(){
        return this.connexion;
    }
    
}
