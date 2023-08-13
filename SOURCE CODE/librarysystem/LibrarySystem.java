/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystem;
import librarysystem.Login;
import librarysystem.CreateDatabase;


public class LibrarySystem {

    
    public static void main(String[] args) {
        CreateDatabase c = new CreateDatabase();
        Login l = new Login();
        l.login();
        c.create();
        
    }
    
    
}
