/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package librarysystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import librarysystem.DatabaseConnector;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author HARI
 */
public class User {

    public void user_menu(String UID) {
     
     
    JFrame f=new JFrame("User"); 
    JButton view_but=new JButton("View Books");  
    view_but.setBounds(20,20,120,25); 
    view_but.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e){
             
            JFrame f = new JFrame("Available Books");
           
             
            DatabaseConnector d = new DatabaseConnector();
            Connection connection = d.connect();
            String sql="select * from BOOKS"; 
            try {
                Statement stmt = connection.createStatement(); 
                 stmt.executeUpdate("USE LIBRARY");
                stmt=connection.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                JTable book_list= new JTable(); 
                book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
                  
                JScrollPane scrollPane = new JScrollPane(book_list); 
 
                f.add(scrollPane); 
                f.setSize(800, 400); 
                f.getContentPane().setBackground(Color.ORANGE);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                 JOptionPane.showMessageDialog(null, e1);
            }               
             
    }
    }
    );
     
    JButton my_book=new JButton("Books Taken");  
    my_book.setBounds(150,20,120,25); 
    my_book.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e){
             
               
            JFrame f = new JFrame("Books Taken"); 
            int UID_int = Integer.parseInt(UID); 
            DatabaseConnector d = new DatabaseConnector();
            Connection connection = d.connect();
            
            String sql="select distinct issued.*,books.bname,books.genre,books.author from issued,books " + "where ((issued.uid=" + UID_int + ") and (books.bid in (select bid from issued where issued.uid="+UID_int+"))) group by iid";
            String sql1 = "select bid from issued where uid="+UID_int;
            try {
                Statement stmt = connection.createStatement();
                
                 stmt.executeUpdate("USE LIBRARY");
                stmt=connection.createStatement();
                
                ArrayList books_list = new ArrayList();
  
                
                 
                ResultSet rs=stmt.executeQuery(sql);
                JTable book_list= new JTable(); 
                book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
                //enable scroll bar
                JScrollPane scrollPane = new JScrollPane(book_list);
 
                f.add(scrollPane);
                f.setSize(800, 400); 
                f.getContentPane().setBackground(Color.ORANGE);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            } catch (SQLException e1) {
                
                 JOptionPane.showMessageDialog(null, e1);
                 
            }               
                 
    }
    }
    );
     
     
     
    f.add(my_book); 
    f.add(view_but); 
    f.setSize(300,100);
    f.getContentPane().setBackground(Color.ORANGE);
    f.setLayout(null);
    f.setVisible(true);
    f.setLocationRelativeTo(null);
    
    }
}
