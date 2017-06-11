import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ProjFrame3 implements WindowListener,ActionListener,KeyListener
{
 Frame f,f1;
 List lb;
 TextField t;
 Label l1,l2;
 Button b1,b2;
 ProjFrame3(Frame f1)
 {
  f=new Frame();
  this.f1=f1;
  lb=new List();
  t=new TextField();
  l1=new Label("Search:");
  l2=new Label("Results:");
  b1=new Button("Edit");
  b2=new Button("Delete");
  f.setLayout(null);
  l1.setBounds(50,100,70,30);
  l2.setBounds(50,200,70,30);
  t.setBounds(150,100,300,30);
  lb.setBounds(150,200,300,200);
  b1.setBounds(100,450,100,30);
  b2.setBounds(300,450,100,30);
  f.add(l1);
  f.add(l2);
  f.add(t);
  f.add(lb);
  f.add(b1);
  f.add(b2);
  Color c1=new Color(68,151,191);
  Color c2=new Color(11,253,228);
  Color c3=new Color(196,191,157); 
  f.setBackground(c1);
  l1.setBackground(c2);
  l2.setBackground(c2);
  b1.setBackground(c3);
  b2.setBackground(c3);
  f.setTitle("Find Content");
  f.setSize(500,500);
  f.setVisible(true);
  f.addWindowListener(this);
  b1.addActionListener(this);
  b2.addActionListener(this); 
  t.addKeyListener(this);
 }
 public void keyReleased(KeyEvent e)
 {
  try
  {
   lb.removeAll();
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection cn=DriverManager.getConnection("jdbc:odbc:ODBC2");
   String str="select * from contacts where sname like '"+t.getText()+"%'";
   Statement st=cn.createStatement();
   ResultSet rs=st.executeQuery(str);
   while(rs.next())
   {
    lb.add(rs.getString(1));
   }
   cn.close();
  }
  
  catch(Exception e1)
  {
   JOptionPane.showMessageDialog(f,e1.getMessage());
  }
 }
 public void keyTyped(KeyEvent e)
 {
 }
 public void keyPressed(KeyEvent e)
 {
 }
 
 public void actionPerformed(ActionEvent e)
 { 
  String sname;
  sname=lb.getSelectedItem();
  if(sname!=null)
  {
   if(e.getSource()==b1)
   {
    ProjFrame4 pf4=new ProjFrame4(sname);
    
   }
   if(e.getSource()==b2)
   {
    try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection cn=DriverManager.getConnection("jdbc:odbc:ODBC2");
     String str="delete from contacts where sname='"+lb.getSelectedItem()+"'";
     Statement st=cn.createStatement();
     st.executeUpdate(str);
     cn.close();
     JOptionPane.showMessageDialog(f,"1 Row Deleted");
    }
    catch(Exception e1)
    {
     JOptionPane.showMessageDialog(f,e1.getMessage());
    }
    int i=lb.getSelectedIndex();
    lb.remove(i);  
   }
  }
  else
    JOptionPane.showMessageDialog(f,"Select name first");
 }
 
 
 public void windowClosing(WindowEvent e)
 {
  f.removeNotify(); 
  f1.addNotify();
 }
 public void windowOpened(WindowEvent e)
 {
 }
 public void windowClosed(WindowEvent e)
 {
 }
 public void windowIconified(WindowEvent e)
 {
 }
 public void windowDeiconified(WindowEvent e)
 {
 }
 public void windowActivated(WindowEvent e)
 {
  try
  {
   t.setText("");
   lb.removeAll();
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection cn=DriverManager.getConnection("jdbc:odbc:ODBC2");
   String str="select * from contacts";
   Statement st=cn.createStatement();
   ResultSet rs=st.executeQuery(str);
   while(rs.next())
   {
    lb.add(rs.getString(1));
   }
   cn.close();
   
   
  }
  
  catch(Exception e1)
  {
   JOptionPane.showMessageDialog(f,e1.getMessage());
  }
 
 }
 public void windowDeactivated(WindowEvent e)
 {
 }
 
}  