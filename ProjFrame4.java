import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ProjFrame4 extends MouseAdapter implements WindowListener,ActionListener,KeyListener
{
 Frame f;
 Label l1,l2,l3,l4,l5;
 TextField t2,t3;
 TextArea ta;
 Button b1;
 Color c3;
 String x;
 ProjFrame4(String a)
 {
  f=new Frame("Update Contents");
  ta=new TextArea();
  t2=new TextField();
  t3=new TextField();
  x=a;
  l1=new Label("Name:");
  l2=new Label("Address:");
  l3=new Label("Phone Number:");
  l4=new Label("E-mail id:");
  l5=new Label(x);
  b1=new Button("Update");
  f.setLayout(null);
  l1.setBounds(50,50,150,30);
  l2.setBounds(50,130,150,30);
  l3.setBounds(50,240,150,30);
  l4.setBounds(50,300,150,30);
  l5.setBounds(250,50,200,30);
  ta.setBounds(250,130,200,100);
  t2.setBounds(250,240,200,30);
  t3.setBounds(250,300,200,30);
  b1.setBounds(235,400,60,30);
  f.add(l1);
  f.add(l2);
  f.add(l3);
  f.add(l4);
  f.add(l5);
  f.add(ta);
  f.add(t2);
  f.add(t3);
  f.add(b1);
  Color c1=new Color(68,151,191);
  Color c2=new Color(11,253,228);
  c3=new Color(196,191,157); 
  f.setBackground(c1);
  l1.setBackground(c2);
  l2.setBackground(c2);
  l3.setBackground(c2);
  l4.setBackground(c2);
  l5.setBackground(Color.white);
  b1.setBackground(c3);
  update();
  f.setSize(500,500);
  f.setVisible(true);
  f.addWindowListener(this);
  b1.addActionListener(this);
 }
  
 public void actionPerformed(ActionEvent e)
 {
  
  try
  {
   ta.setForeground(c3);
   t2.setForeground(c3);
   t3.setForeground(c3);
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection cn=DriverManager.getConnection("jdbc:odbc:ODBC2");
   String add,email,phno;
   add=ta.getText();
   phno=t2.getText();
   email=t3.getText();
   String str="update contacts set add='"+add+"',phno='"+phno+"',email='"+email+"' where sname='"+x+"'";
   Statement st=cn.createStatement();
   st.executeUpdate(str);
   cn.close();
   JOptionPane.showMessageDialog(f,"1 Row Updated");
  }
  catch(Exception e1)
  {
   JOptionPane.showMessageDialog(f,e1.getMessage());
  }
  f.removeNotify(); 
  
 }
 
 public void windowClosing(WindowEvent e)
 {
  
  f.removeNotify(); 
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
 public void update()
 {
  try
  {
   ta.setForeground(c3);
   t2.setForeground(c3);
   t3.setForeground(c3);
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection cn=DriverManager.getConnection("jdbc:odbc:ODBC2");
   
   
   String str="select * from contacts where sname='"+x+"'";
    Statement st=cn.createStatement();
    ResultSet rs=st.executeQuery(str);
   while(rs.next())
   { 
    ta.setText(rs.getString(2));
    t2.setText(rs.getString(3));
    t3.setText(rs.getString(4));
   }
  }
  catch(Exception e1)
  {
   JOptionPane.showMessageDialog(f,e1.getMessage());
  }
  ta.addMouseListener(this);
  t2.addMouseListener(this);
  t3.addMouseListener(this);
  ta.addKeyListener(this);
  t2.addKeyListener(this);
  t3.addKeyListener(this);
 }
 public void mouseClicked(MouseEvent e)
 {
  if(e.getSource()==ta)
  ta.setForeground(Color.black);
  if(e.getSource()==t2)  
  t2.setForeground(Color.black);
  if(e.getSource()==t3)
  t3.setForeground(Color.black);
  
 }
 public void keyReleased(KeyEvent e)
 {
  if(e.getSource()==ta)
  ta.setForeground(Color.black);
  if(e.getSource()==t2)  
  t2.setForeground(Color.black);
  if(e.getSource()==t3)
  t3.setForeground(Color.black);
}
public void keyTyped(KeyEvent e)
 {
 }
 public void keyPressed(KeyEvent e)
 {
 }
}