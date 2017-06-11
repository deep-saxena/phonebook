import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ProjFrame1 implements ActionListener,WindowListener
{
 Frame f;
 Button b1,b2;
 ProjFrame1()
 {
  f=new Frame();
  b1=new Button("Add Contents");
  b2=new Button("Find Contents");
  f.setLayout(null);
  b1.setBounds(125,110,250,100);
  b2.setBounds(125,310,250,100);
  f.add(b1);
  f.add(b2);
  Color c1=new Color(68,151,191);
  Color c2=new Color(196,191,157);
   
  f.setBackground(c1);
  b1.setBackground(c2);
  b2.setBackground(c2);
  
  f.setTitle("Choose an option");
  f.setSize(500,500);
  f.setVisible(true);
  b1.addActionListener(this);
  b2.addActionListener(this);
  f.addWindowListener(this);
 }
  

 public void actionPerformed(ActionEvent e)
 {
  f.removeNotify();
  if(e.getSource()==b1)
  {
   ProjFrame2 pf2=new ProjFrame2(f);
  }
  if(e.getSource()==b2)
  {
   ProjFrame3 pf3=new ProjFrame3(f);
  }
 }
 
 
 public void windowClosing(WindowEvent e)
 {
  int a=JOptionPane.showConfirmDialog(f,"Are you sure?");
  if(a==0)
  System.exit(0);
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

 public static  void main(String ar[])
 {
  ProjFrame1 pf1=new ProjFrame1();
 }
} 