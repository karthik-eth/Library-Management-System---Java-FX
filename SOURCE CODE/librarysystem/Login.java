/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package librarysystem;
import java.awt.Color;
import java.awt.FlowLayout;
import librarysystem.DatabaseConnector;
import librarysystem.Admin;
import librarysystem.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HARI
 */
public class Login {
    public void login() {
   

    
   
    
    JFrame f=new JFrame("Login"); 
    
    JLabel l0,l1,l2;  
    
    l0=new JLabel("LIBRARY!");
    l0.setBounds(200,10,100,30);
    
    l1=new JLabel("Username"); 
    l1.setBounds(50,45, 100,30); 
     
    l2=new JLabel("Password");  
    l2.setBounds(50,80, 100,30);    
     
    JTextField F_user = new JTextField();
    F_user.setBounds(140, 45, 200, 30);
         
    JPasswordField F_pass=new JPasswordField(); 
    F_pass.setBounds(140, 80, 200, 30);
       
    JButton login_but=new JButton("Login");
    login_but.setBounds(200,120,80,25);
    login_but.addActionListener(new ActionListener() {  
         
        public void actionPerformed(ActionEvent e){ 
 
        String username = F_user.getText(); 
        String password = F_pass.getText(); 
         
        if(username.equals("")) 
        {
            JOptionPane.showMessageDialog(null,"Please enter username"); 
        } 
        else if(password.equals("")) 
        {
            JOptionPane.showMessageDialog(null,"Please enter password"); 
        }
        else { 
            DatabaseConnector d= new DatabaseConnector();
            Connection connection=d.connect();  
            try
            {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
              stmt.executeUpdate("USE LIBRARY");
              String st = ("SELECT * FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'"); 
              ResultSet rs = stmt.executeQuery(st); 
              if(rs.next()==false) { 
                  System.out.print("No user");  
                  JOptionPane.showMessageDialog(null,"Wrong Username/Password!"); 
 
              }
              else {
                  f.dispose();
                rs.beforeFirst();  
                while(rs.next())
                {
                  String admin = rs.getString("ADMIN"); 
                  //System.out.println(admin);
                  String UID = rs.getString("UID"); 
                  if(admin.equals("1")) { 
                      Admin a = new Admin();
                      a.admin_menu(); 
                  }
                  else{
                      User u = new User();
                      u.user_menu(UID); 
                  }
              }
              }
            }
            catch (Exception ex) {
                 ex.printStackTrace();
        }
        }
    }               
    });
 
    //f.add(bgi);
    f.add(F_pass); 
    f.add(login_but);
    f.add(F_user); 
    f.add(l1);  
    f.add(l2); 
    f.add(l0);
    
    f.setSize(500,250);
    f.getContentPane().setBackground(Color.ORANGE);
    
    f.setLayout(null);
    f.setVisible(true);
    f.setLocationRelativeTo(null);
    System.gc();
}
    
}
