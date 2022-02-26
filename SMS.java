package com.example;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SMS extends JFrame implements ActionListener
{
	JFrame f1;                                     
	JPanel p1;
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2,b3,b4,b5,b6;
	

	SMS()
	{
		f1 = new JFrame("STUDENT MANAGEMENT SYSTEM");                          
		p1 = new JPanel();
		l1 = new JLabel("Username :"); 
		l1.setForeground(Color.blue);
		l2 = new JLabel("Password :"); 
		l2.setForeground(Color.blue);
		t1 = new JTextField("",10); 
		t2 = new JTextField("",10);
		b1 = new JButton("Profile");
		b1.setForeground(Color.black);
		b2 = new JButton("Result");
		b2.setForeground(Color.black);
		b3= new JButton("Placement Details");
		b3.setForeground(Color.black);
		b4= new JButton("Add");
		b4.setForeground(Color.black);
		b5=new JButton("Update");
		b5.setForeground(Color.black);
		b6=new JButton("Delete");
		b6.setForeground(Color.black);
		
		
		p1.add(l1); p1.add(t1); p1.add(l2); p1.add(t2);
		p1.add(b1);p1.add(b2); p1.add(b3);p1.add(b4);p1.add(b5);p1.add(b6);
		f1.add(p1); 
		
				
	    f1.setSize(250,250);                                     
	    f1.setVisible(true);
	    
	    b1.addActionListener(new ActionListener()
	    		{

			public void actionPerformed(ActionEvent e)
				{
					try
					{
						String s1 = t1.getText();
						String s2 = t2.getText();
						
						if(s1.equals("111") && s2.equals("aaa"))
						{
							try
							{
							    Class.forName("com.mysql.cj.jdbc.Driver"); 
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","12345");
								Statement st = con.createStatement();
								ResultSet rs = st.executeQuery("select * from student_data");
								System.out.println("\n YOUR PROFILE IS: \n  ");
						       	while(rs.next())
								{
								   	 System.out.println("\n ID : "+rs.getInt(1)+"\n NAME  : "+rs.getString(2)
								   	 +"\n DEPARTMENT : "+rs.getString(3)+"\n ADDRESS : "+rs.getString(4)
								   	 +"\n CONTACT : "+rs.getLong(5)+"\n EMAIL : "+rs.getString(6));						    	 
								}
							}catch(Exception ex)
							{
								ex.printStackTrace();
							}
							
						}
						else
						{
							System.out.println("Incorrect ID/Password!!");
						}
												
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
						
				}
	    	
	    		});
	
		 b2.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent e)            
		{
			String n1 = t1.getText();
			String n2 = t2.getText();
			
			if(n1.equals("111") && n2.equals("aaa"))
			{
				try 
				{
				     Class.forName("com.mysql.cj.jdbc.Driver");
				     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","12345");
					 Statement st = con.createStatement();
					 ResultSet rs =  st.executeQuery("select * from results");
					 System.out.println("\n RESULT OF ALL SEMESTERS : \n ");
				     while(rs.next())
				     {
				    	 System.out.println("\n SEM - I : "+rs.getDouble(1)
				    	 +" \n SEM - II : "+rs.getDouble(2)
				    	 +"\n SEM - III : "+rs.getDouble(3)
				    	 +"\n SEM - IV : "+rs.getDouble(4)
				    	 +"\n SEM - V : "+rs.getDouble(5)
				    	 +"\n SEM - VI : "+rs.getDouble(6)
				    	 +"\n SEM - VII : "+rs.getDouble(7)
				    	 +"\n SEM - VIII : "+rs.getDouble(8));						    	 
				     }
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else
			{
			     System.out.println("Incorrect ID/Password!!");	
			}
		}	   
	   });
		 
		   b3.addActionListener(new ActionListener()
		   {
			public void actionPerformed(ActionEvent e)            
			{
				String n1 = t1.getText();
				String n2 = t2.getText();
				
				if(n1.equals("111") && n2.equals("aaa"))
				{
					try 
					{
					     Class.forName("com.mysql.cj.jdbc.Driver");
					     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","12345");
						 Statement st = con.createStatement();
						 ResultSet rs =  st.executeQuery("select * from placement");
						 System.out.println("\n PLACEMENT DETAILS : \n ");
					     while(rs.next())
					     {
					    	 System.out.println("\n COMPANY NAME  : "+rs.getString(1)+"\n JOB CATEGORY : "+rs.getString(2)+"\n JOB TITLE : "+rs.getString(3)+
					    			 "\n DATE PLACED : "+rs.getString(4)+"\n SALARY PACKAGE : "+rs.getInt(5));						    	 
					     }
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				else
				{
				     System.out.println("Incorrect ID/Password!!");	
				}
				
			}	   
		   });

	  b4.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent e)            
		{
			String n1 = t1.getText();
			String n2 = t2.getText();
			
			if(n1.equals("111") && n2.equals("aaa"))
			{
				try 
			
				{
				    Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","12345");
					Statement st = con.createStatement();
					boolean result=st.execute("insert into student_data(id,name,dept,address,contact,email)"+"values(02,'Mansi','Civil','Kolkata',9988776655,'mansicivil@gmail.com')");					
				  
					if(result!=true) 
						System.out.println("\n Record Inserted!!");
					else
						System.out.println("\n Record Not Inserted!!");
						
					}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else
			{
			     System.out.println("\n Incorrect ID/Password!!");	
			}
			
		}	   
	   });
	  b5.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent e)            
		{
			String n1 = t1.getText();
			String n2 = t2.getText();
			
			if(n1.equals("111") && n2.equals("aaa"))
			{
				try
				{
				    Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","12345");
					Statement st = con.createStatement();
				    int result=st.executeUpdate("update student_data set name='Karan' where id=01");
					
				  
					if(result!=0) 
						System.out.println("\n Record Updated!!");
					else
						System.out.println("\n Record Not Updated!!");
						
					}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else
			{
			     System.out.println("\n Incorrect ID/Password!!");	
			}
			
		}	   
	   });
	  b6.addActionListener(new ActionListener()
	   {
		public void actionPerformed(ActionEvent e)            
		{
			String n1 = t1.getText();
			String n2 = t2.getText();
			
			if(n1.equals("111") && n2.equals("aaa"))
			{
				try
				{
				    Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","12345");
					Statement st = con.createStatement();
				    int result=st.executeUpdate("delete from  student_data where id=02");
					
				  
					if(result!=0) 
						System.out.println("\n Record Deleted!!");
					else
						System.out.println("\n Record Not Deleted!!");
						
					}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else
			{
			     System.out.println("\n Incorrect ID/Password!!");	
			}
			
		}	   
	   });

	}
	
	
	public static void main(String args[])
	{
		new SMS();
		
	}


	public void actionPerformed(ActionEvent e) 
	{	
		
	}
}
