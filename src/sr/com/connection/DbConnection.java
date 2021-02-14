/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DbConnection {
    private static Connection instance;
    
    public static Connection getInstance(){
        
        try{
            instance=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_1", "root", "1234");
            System.out.println("Database Connected");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
        
    }
    
}
