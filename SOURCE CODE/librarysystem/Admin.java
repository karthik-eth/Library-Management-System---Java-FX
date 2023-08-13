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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import librarysystem.CreateDatabase;
import librarysystem.DatabaseConnector;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author HARI
 */
public class Admin {
    public static class ex{
        public static int days=0;
            }
    public void admin_menu() {
     
     
    JFrame f=new JFrame("Admin");
     
     
   
     
    JButton view_but=new JButton("View Books");
    view_but.setBounds(20,20,120,25);
    view_but.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
             
            JFrame f = new JFrame("Books Available"); 
            
             
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
                
                 JOptionPane.showMessageDialog(null, e1);
            }               
             
    }
    }
    );
     
    JButton users_but=new JButton("View Users");
    users_but.setBounds(150,20,120,25);
    users_but.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e){
                 
                JFrame f = new JFrame("Users List");
                
                 
                 
                DatabaseConnector d = new DatabaseConnector(); 
                Connection connection = d.connect();
                String sql="select * from users";
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
                    
                     JOptionPane.showMessageDialog(null, e1);
                }       
                 
                 
    }
        }
    );  
     
    JButton issued_but=new JButton("View Issued Books");
    issued_but.setBounds(280,20,160,25); 
    issued_but.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                 
                JFrame f = new JFrame("Users List");
                
                DatabaseConnector d = new DatabaseConnector(); 
                Connection connection = d.connect();
                String sql="select * from issued";
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
                    
                     JOptionPane.showMessageDialog(null, e1);
                }       
                             
    }
        }
    );
     
     
    JButton add_user=new JButton("Add User"); 
    add_user.setBounds(20,60,120,25); 
     
    add_user.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                 
                JFrame g = new JFrame("Enter Details"); 
                
 
                JLabel l0,l1,l2,l3;  
                
                l0=new JLabel("Name");
                l0.setBounds(30,25,100,20);
                
                l1=new JLabel("Username");  
                l1.setBounds(30,55, 100,20); 
                 
                 
                l2=new JLabel("Password"); 
                l2.setBounds(30,85, 100,20); 
                
                l3=new JLabel("Mobile Number");
                l3.setBounds(30,110, 100,20);
                 
                JTextField name = new JTextField();
                name.setBounds(140,25,200,20);
                
                JTextField F_user = new JTextField();
                F_user.setBounds(140, 55, 200, 20);
                 
                
                JPasswordField F_pass=new JPasswordField();
                F_pass.setBounds(140, 85, 200, 20);
                
                JTextField mobile = new JTextField();
                mobile.setBounds(140,110,200,20);
                
                JRadioButton a1 = new JRadioButton("Admin");
                a1.setBounds(100, 165, 200,30);
                
                JRadioButton a2 = new JRadioButton("User");
                a2.setBounds(180, 165, 200,30);
                
                ButtonGroup bg=new ButtonGroup();    
                bg.add(a1);bg.add(a2);  
                 
                                 
                JButton create_but=new JButton("Create");
                create_but.setBounds(200,200,80,25);
                create_but.addActionListener(new ActionListener() {
                     
                    public void actionPerformed(ActionEvent e){
                     
                    String username = F_user.getText();
                    String n=name.getText();
                    
                    String password = F_pass.getText();
                    String no=mobile.getText();
                    Boolean admin = false;
                     
                    if(a1.isSelected()) {
                        admin=true;
                    }
                     //n no
                    DatabaseConnector d = new DatabaseConnector(); 
                    Connection connection = d.connect();
                     
                    try {
                    Statement stmt = connection.createStatement();
                     stmt.executeUpdate("USE LIBRARY");
                     stmt.executeUpdate("INSERT INTO USERS(NAME,USERNAME,PASSWORD,MOBILENUMBER,ADMIN) VALUES ('"+n+"','"+username+"','"+password+"','"+no+"',"+admin+")");
                     JOptionPane.showMessageDialog(null,"User added!");
                     g.dispose();
                      
                    }
                     
                    catch (SQLException e1) {
                        // TODO Auto-generated catch block
                         JOptionPane.showMessageDialog(null, e1);
                    }   
                     
                    }
                     
                });
                     
                 
                    g.add(create_but);
                    g.add(a2);
                    g.add(a1);
                    g.add(l0);
                    g.add(l1);
                    g.add(l2);
                    g.add(l3);
                    g.add(name);
             
                    g.add(F_user);
                    g.add(F_pass);
                    g.add(mobile);
                    g.setSize(550,300);//400 width and 500 height 
                    g.getContentPane().setBackground(Color.ORANGE);
                    g.setLayout(null);//using no layout managers  
                    g.setVisible(true);//making the frame visible 
                    g.setLocationRelativeTo(null);
                 
                 
    }
    });
         
     
    JButton add_book=new JButton("Insert Book");
    add_book.setBounds(150,60,120,25); 
     
    add_book.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
               
                JFrame g = new JFrame("Enter Book Details");
                
                JLabel l1,l2,l3;  
                l1=new JLabel("Book Name");  
                l1.setBounds(30,15, 100,30); 
                 
                 
                l2=new JLabel("Genre");  
                l2.setBounds(30,53, 100,30); 
                 
                l3=new JLabel("Author");  
                l3.setBounds(30,90, 100,30); 
                 
                
                JTextField F_bname = new JTextField();
                F_bname.setBounds(110, 15, 200, 30);
                 
               
                JTextField F_genre=new JTextField();
                F_genre.setBounds(110, 53, 200, 30);
                //set text field for price
                JTextField F_auth=new JTextField();
                F_auth.setBounds(110, 90, 200, 30);
                         
                 
                JButton create_but=new JButton("Submit");
                create_but.setBounds(130,130,80,25);
                create_but.addActionListener(new ActionListener() {
                     
                    public void actionPerformed(ActionEvent e){
                   
                    String bname = F_bname.getText();
                    String genre = F_genre.getText();
                    String auth = F_auth.getText();
                   
                     
                    DatabaseConnector d = new DatabaseConnector(); 
                    Connection connection = d.connect();
                     
                    try {
                    Statement stmt = connection.createStatement();
                     stmt.executeUpdate("USE LIBRARY");
                     stmt.executeUpdate("INSERT INTO BOOKS(BNAME,GENRE,AUTHOR) VALUES ('"+bname+"','"+genre+"','"+auth+"')");
                     JOptionPane.showMessageDialog(null,"Book added!");
                     g.dispose();
                      
                    }
                     
                    catch (SQLException e1) {
                        
                         JOptionPane.showMessageDialog(null, e1);
                    }   
                     
                    }
                     
                });
                                 
                    g.add(l3);
                    g.add(create_but);
                    g.add(l1);
                    g.add(l2);
                    g.add(F_bname);
                    g.add(F_genre);
                    g.add(F_auth);
                    g.setSize(350,200);
                    g.getContentPane().setBackground(Color.ORANGE);
                    g.setLayout(null); 
                    g.setVisible(true);
                    g.setLocationRelativeTo(null);
                             
    }
    });
     
     
    JButton issue_book=new JButton("Issue Book"); 
    issue_book.setBounds(450,20,120,25); 
     
    issue_book.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                
                JFrame g = new JFrame("Enter Details");
                
                JLabel l1,l2,l3,l4;  
                l1=new JLabel("Book ID(BID)");  
                l1.setBounds(30,15, 100,30); 
                 
                 
                l2=new JLabel("User ID(UID)");  
                l2.setBounds(30,53, 100,30); 
                 
                l3=new JLabel("Period(days)");  
                l3.setBounds(30,90, 100,30); 
                 
                l4=new JLabel("Issued Date(DD-MM-YYYY)"); 
                l4.setBounds(30,127, 150,30); 
                 
                JTextField F_bid = new JTextField();
                F_bid.setBounds(110, 15, 200, 30);
                 
                 
                JTextField F_uid=new JTextField();
                F_uid.setBounds(110, 53, 200, 30);
                 
                JTextField F_period=new JTextField();
                F_period.setBounds(110, 90, 200, 30);
                 
                JTextField F_issue=new JTextField();
                F_issue.setBounds(180, 130, 130, 30);   
 
                 
                JButton create_but=new JButton("Submit");  
                create_but.setBounds(130,170,80,25);
                create_but.addActionListener(new ActionListener() {
                     
                    public void actionPerformed(ActionEvent e){
                     
                    String uid = F_uid.getText();
                    String bid = F_bid.getText();
                    String period = F_period.getText();
                    String issued_date = F_issue.getText();
 
                    int period_int = Integer.parseInt(period);
                     
                    DatabaseConnector d = new DatabaseConnector(); 
                    Connection connection = d.connect();
                     
                    try {
                    Statement stmt = connection.createStatement();
                     stmt.executeUpdate("USE LIBRARY");
                     stmt.executeUpdate("INSERT INTO ISSUED(UID,BID,ISSUED_DATE,PERIOD) VALUES ('"+uid+"','"+bid+"','"+issued_date+"',"+period_int+")");
                     JOptionPane.showMessageDialog(null,"Book Issued!");
                     g.dispose();
                      
                    }
                     
                    catch (SQLException e1) {
                        // TODO Auto-generated catch block
                         JOptionPane.showMessageDialog(null, e1);
                    }   
                     
                    }
                     
                });
                     
                 
                    g.add(l3);
                    g.add(l4);
                    g.add(create_but);
                    g.add(l1);
                    g.add(l2);
                    g.add(F_uid);
                    g.add(F_bid);
                    g.add(F_period);
                    g.add(F_issue);
                    g.setSize(350,250);//400 width and 500 height
                    g.getContentPane().setBackground(Color.ORANGE);
                    g.setLayout(null);//using no layout managers  
                    g.setVisible(true);//making the frame visible 
                    g.setLocationRelativeTo(null);
                 
                 
    }
    });
     
     
    JButton return_book=new JButton("Withdraw Book"); //creating instance of JButton to return books
    return_book.setBounds(280,60,160,25); 
     
    return_book.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
                 
                JFrame g = new JFrame("Enter Details");
                
                JLabel l1,l2,l3,l4;  
                l1=new JLabel("Issue ID(IID)");  
                l1.setBounds(30,15, 100,30); 
                
                 
                l4=new JLabel("Return Date(DD-MM-YYYY)");  
                l4.setBounds(30,50, 150,30); 
                 
                JTextField F_iid = new JTextField();
                F_iid.setBounds(110, 15, 200, 30);
                 
                 
                JTextField F_return=new JTextField();
                F_return.setBounds(180, 50, 130, 30);
             
 
                JButton create_but=new JButton("Return");//creating instance of JButton to mention return date and calculcate fine
                create_but.setBounds(130,170,80,25);//x axis, y axis, width, height 
                create_but.addActionListener(new ActionListener() {
                     
                    public void actionPerformed(ActionEvent e){                 
                     
                    String iid = F_iid.getText();
                    String return_date = F_return.getText();
                     
                    DatabaseConnector d = new DatabaseConnector(); 
                    Connection connection = d.connect();
                     
                    try {
                    Statement stmt = connection.createStatement();
                     stmt.executeUpdate("USE LIBRARY");
                     
                     String date1=null;
                     String date2=return_date; 
                     
                     
                     ResultSet rs = stmt.executeQuery("SELECT ISSUED_DATE FROM ISSUED WHERE IID="+iid);
                     while (rs.next()) {
                         date1 = rs.getString(1);
                          
                       }
                      
                     try {
                            
                            Date date_1=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
                            Date date_2=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
                           
                            
                            long diff = date_2.getTime() - date_1.getTime();
                           
                            ex.days=(int)(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                             
                             
                        } catch (ParseException e1) {
                            
                            e1.printStackTrace();
                        }
                      
                     
                     
                     stmt.executeUpdate("UPDATE ISSUED SET RETURN_DATE='"+return_date+"' WHERE IID="+iid);
                     g.dispose();
                      
                    DatabaseConnector d1 = new DatabaseConnector(); 
                    Connection connection1 = d1.connect();
                     Statement stmt1 = connection1.createStatement();
                     stmt1.executeUpdate("USE LIBRARY");                
                    ResultSet rs1 = stmt1.executeQuery("SELECT PERIOD FROM ISSUED WHERE IID="+iid); //set period
                    String diff=null; 
                    while (rs1.next()) {
                         diff = rs1.getString(1);
                          
                       }
                    int diff_int = Integer.parseInt(diff);
                    if(ex.days>diff_int) { 
                         
                        
                        int fine = (ex.days-diff_int)*10; //FINE RS.10
                        
                        stmt1.executeUpdate("UPDATE ISSUED SET FINE="+fine+" WHERE IID="+iid);  
                        String fine_str = ("Fine: Rs. "+fine);
                        JOptionPane.showMessageDialog(null,fine_str);
                         
                    }
 
                     JOptionPane.showMessageDialog(null,"Book Returned!");
                      
                    }
                             
                     
                    catch (SQLException e1) {
                        // TODO Auto-generated catch block
                         JOptionPane.showMessageDialog(null, e1);
                    }   
                     
                    }
                     
                }); 
                    g.add(l4);
                    g.add(create_but);
                    g.add(l1);
                    g.add(F_iid);
                    g.add(F_return);
                    g.setSize(350,250);//400 width and 500 height 
                    g.getContentPane().setBackground(Color.ORANGE);
                    g.setLayout(null);//using no layout managers  
                    g.setVisible(true);//making the frame visible 
                    g.setLocationRelativeTo(null);              
    }
    });
     
  
    f.add(return_book);
    f.add(issue_book);
    f.add(add_book);
    f.add(issued_but);
    f.add(users_but);
    f.add(view_but);
    f.add(add_user);
    f.setSize(600,200);//400 width and 500 height  
    f.getContentPane().setBackground(Color.ORANGE);
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible 
    f.setLocationRelativeTo(null);
     
    }
}
