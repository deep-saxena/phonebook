import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ProjFrame2 implements WindowListener,ActionListener
{
 Frame f,f1;
 Label l1,l2,l3,l4;
 TextField t1,t2,t3;
 TextArea ta;
 Button b;
 ProjFrame2(Frame f1)
 {
  f=new Frame("Add Content");
  this.f1=f1;
  t1=new TextField();
  t2=new TextField();
  t3=new TextField();
  ta=new TextArea();
  l1=new Label("Name:");
  l2=new Label("Address:");
  l3=new Label("Phone Number:");
  l4=new Label("E-mail id:");
  b=new Button("Add");
  f.setLayout(null);
  l1.setBounds(50,50,150,30);
  l2.setBounds(50,130,150,30);
  l3.setBounds(50,240,150,30);
  l4.setBounds(50,300,150,30);
  t1.setBounds(250,50,200,30);
  ta.setBounds(250,130,200,100);
  t2.setBounds(250,240,200,30);
  t3.setBounds(250,300,200,30);
  b.setBounds(235,400,60,30);
  f.add(l1);
  f.add(l2);
  f.add(l3);
  f.add(l4);
  f.add(t1);
  f.add(ta);
  f.add(t2);
  f.add(t3);
  f.add(b);
  Color c1=new Color(68,151,191);
  Color c2=new Color(11,253,228);
  Color c3=new Color(196,191,157); 
  f.setBackground(c1);
  l1.setBackground(c2);
  l2.setBackground(c2);
  l3.setBackground(c2);
  l4.setBackground(c2);
  b.setBackground(c3);
  f.setSize(500,500);
  f.setVisible(true);
  f.addWindowListener(this);
  b.addActionListener(this);
 }
  
 public void actionPerformed(ActionEvent e)
 {
  if(t1.getText()!=null && ta.getText()!=null && t2.getText()!=null && t3.getText()!=null)
  {
   try
   {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection cn=DriverManager.getConnection("jdbc:odbc:ODBC2");
    String sname,add,email,phno;
    sname=t1.getText();
    add=ta.getText();
    phno=t2.getText();
    email=t3.getText();
    String str="insert into contacts values('"+sname+"','"+add+"','"+phno+"','"+email+"')";
    Statement st=cn.createStatement();
    st.executeUpdate(str);
    cn.close();
   }
   catch(Exception e1)
   {
    JOptionPane.showMessageDialog(f,e1.getMessage());
   }
   f.removeNotify(); 
   f1.addNotify();
  }
  else
  {
  JOptionPane.showMessageDialog(f,"Fill all entries");
  }
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
 }
 public void windowDeactivated(WindowEvent e)
 {
 }
 
}