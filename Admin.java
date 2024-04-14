import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.sql.*;
import java.lang.Exception; 
public class Admin extends JFrame implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   JPanel Am;
   JButton Prod,Empl,Cust,Sub;
   JLabel assign,task,noti,up,n,r,q;
   JTextField p,t; 
   String s,te,u,v;
	Admin(String userValue)
	{  this.s=userValue;
		Prod=new JButton("Products");
		Empl=new JButton("Employees");
		Cust=new JButton("Customers");
		Am=new JPanel(new GridLayout(15,1));
		Am.add(Prod);
		Am.add(Empl);
		Am.add(Cust);
		Prod.addActionListener(this);
		Empl.addActionListener(this);
		Cust.addActionListener(this);
		task = new JLabel();
		task.setText("Product:");
		p=new JTextField(20);
		assign=new JLabel();
		assign.setText("Technician:");
		t=new JTextField(20);
		Sub =new JButton("Submit");
		Am.add(task);
		Am.add(p);
		Am.add(assign);
		Am.add(t);
		add(Am);
		Prod.addActionListener(this);
		Empl.addActionListener(this);
		Cust.addActionListener(this);
		Sub.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Prod)
		{
			try 
			{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
				con.setAutoCommit(true);
				Statement stmt=con.createStatement();   
				ResultSet rs = stmt.executeQuery("select * from P_D");
				while(rs.next()) 
				{  
				n=new JLabel();
				String a=rs.getString(1),b=rs.getString(2),c=rs.getString(3),d1=rs.getString(4);
				  n.setText(a+" "+b+" "+c+" "+d1+"\n");
				  Am.add(n);
			 }
				add(Am);
			}catch(Exception g)
			{
				
			}	 
		}
		else if(e.getSource()==Empl)
		{  try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
			Statement stmt=con.createStatement();   
			ResultSet rs = stmt.executeQuery("select * from Emp");
			while(rs.next()) 
			{  
			n=new JLabel();
			String a=rs.getString(1),b=rs.getString(2),c=rs.getString(3),d1=rs.getString(4),d2=rs.getString(5),d3=rs.getString(6);
			  n.setText(a+" "+b+" "+c+" "+d1+" "+d2+" "+d3+"\n");
			  Am.add(n);
		 }
			add(Am);
		}catch(Exception f)
		{
			
		}
		}
		else if(e.getSource()==Cust)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
				Statement stmt=con.createStatement();   
				ResultSet rs = stmt.executeQuery("select c_id,pass,name,prod_id,cust_id from Cust,Prod where Cust.c_id=Prod.cust_id");
				while(rs.next()) 
				{  
				n=new JLabel();
				String a=rs.getString(1),b=rs.getString(2),c=rs.getString(3),d1=rs.getString(4),d2=rs.getString(5);
				  n.setText(a+" "+b+" "+c+" "+d1+" "+d2+"\n");
				  Am.add(n);
			 }
				add(Am);
			}catch(Exception f)
			{
				
			}
		}
		else if(e.getSource()==Sub)
		{ String a= t.getText();
		  String b=p.getText();
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
					Statement stmt=con.createStatement();
					stmt.executeUpdate("update Prod set tech_id='"+a+"' where prod_id='"+b+"')");
					con.commit();
				}catch(Exception g)
				{
					
				}	 
		}
		else
		{
			
		}
		
		
	}
}
