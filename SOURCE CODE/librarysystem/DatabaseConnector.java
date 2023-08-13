/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package librarysystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HARI
 */
public class DatabaseConnector {

    public Connection connect()
{
try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=root123");
        
        return con;
 } 
 catch (Exception ex) {
        ex.printStackTrace();
 }
return null;
}
}
