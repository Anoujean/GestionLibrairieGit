/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import classes.*;
import java.sql.*;

/**
 *
 * @author cda402
 */
public class AppliMain01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAOecrire dao = new DAOecrire();
        dao.open();
        System.out.println(""+dao.select());
        dao.close();
        
    }
    
}
