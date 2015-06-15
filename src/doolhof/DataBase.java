/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Marnix
 */


public class DataBase {
    
    private static Connection databaseConnectie;
    
    public static Connection getConnection() {

        if (databaseConnectie == null) {

            String connectString = "jdbc:mysql://meru.hhs.nl:3306/13098381";

            try {
                databaseConnectie =
                        DriverManager.getConnection(connectString, "13098381", "oNguunayoo");

            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(java.util.logging.Level.SEVERE, "SQL Fout", ex);
            }
        }
        return databaseConnectie;
    }     
}
