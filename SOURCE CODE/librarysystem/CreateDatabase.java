/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package librarysystem;

import librarysystem.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HARI
 */
public class CreateDatabase {

   public void create() {
    try {
        DatabaseConnector d = new DatabaseConnector();
    Connection connection=d.connect();
    /*
    ResultSet resultSet = connection.getMetaData().getCatalogs();
    
    
        while (resultSet.next()) {
          
          String databaseName = resultSet.getString(1);
          if(databaseName.equals("library")) {
             
              Statement stmt = connection.createStatement();
              
              String sql = "DROP DATABASE library";
              stmt.executeUpdate(sql);
          }
        }
          Statement stmt = connection.createStatement();
           
          String sql = "CREATE DATABASE LIBRARY"; 
          stmt.executeUpdate(sql); 
          stmt.executeUpdate("USE LIBRARY"); 
         
  
      
          
           
          stmt.executeUpdate("USE LIBRARY"); 
           
           
         
          String sql1 = "CREATE TABLE USERS(UID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,NAME VARCHAR(30), USERNAME VARCHAR(30), PASSWORD VARCHAR(30), MOBILENUMBER VARCHAR(30), ADMIN BOOLEAN)";
          stmt.executeUpdate(sql1);
          
            stmt.executeUpdate("INSERT INTO USERS(NAME, USERNAME, PASSWORD, MOBILENUMBER, ADMIN) VALUES('ADMIN','Admin','Library','9876534528',TRUE),('ROHIT', 'user211091', 'SSN12345*','9837464856', FALSE), ('KARTHIK','user211092', 'SSN023594*','9236272829', FALSE), ('GOPAL','user211093', 'SSN49383*','7847437294', FALSE), ('ANSHUL','user211094', 'SSN49383*', '9932456474' , FALSE), ('TRAVIS' ,'user211095', 'SSN48373*', '8939475234' , FALSE), ('TOM' ,'user211096', 'SSN29383*', '9984632823' , FALSE), ('CHRIS' , 'user211097', 'SSN20823*', '7358438764', FALSE), ('SHANKAR' ,'user211098', 'SSN00923*','8123748473' , FALSE),('LUCY', 'user211099', 'SSN67483*','8844783720' , FALSE), ('MIKE' ,'user211099', 'SSN66803*', '9933628468', FALSE)");// ('user211091', 'SSN12345*', FALSE), ('user211092', 'SSN023594*', FALSE), ('user211093', 'SSN49383*', FALSE), ('user211094', 'SSN49383*', FALSE), ('user211095', 'SSN48373*', FALSE), ('user211096', 'SSN29383*', FALSE), ('user211097', 'SSN20823*', FALSE), ('user211098', 'SSN00923*', FALSE),('user211099', 'SSN67483*', FALSE), ('user211099', 'SSN66803*', FALSE)");
          
          stmt.executeUpdate("CREATE TABLE BOOKS(BID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, BNAME VARCHAR(50), GENRE VARCHAR(20), AUTHOR VARCHAR(30))");
          
          stmt.executeUpdate("CREATE TABLE ISSUED(IID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, UID INT, BID INT, ISSUED_DATE VARCHAR(20), RETURN_DATE VARCHAR(20), PERIOD INT, FINE INT)");
       
              stmt.executeUpdate("INSERT INTO BOOKS(BNAME, GENRE, AUTHOR) VALUES ('War and Peace', 'Mystery', 'Leo Tolstoy'),  ('The Guest Book', 'Fiction', 'Greg'), ('The Perfect Murder','Mystery', 'Andrew Davis'), ('Accidental Presidents', 'Biography', 'Harry'), ('The Wicked King','Fiction', 'Holly black'), ('Nineteen Eighty Four', 'Science Fiction', 'George Orwell'), ('The Time Machine', 'Science Fiction', 'H G Wells'), ('Bird Box', 'Horror', 'Josh Malerman'), ('Java: The Complete Reference', 'Reference Book', 'Herbert Schildt'), ('Let Us C', 'Reference Book', 'Yashwant Kanietkar')");
              resultSet.close();
      */          
    }
     catch (Exception ex) {
         ex.printStackTrace();
}
    
}
}
