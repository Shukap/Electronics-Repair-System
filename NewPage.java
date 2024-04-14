
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import java.net.*;
import javax.swing.*;  
import java.sql.PreparedStatement;
import oracle.jdbc.driver.*;
import java.sql.Statement;
  
//create NewPage class to create a new page on which user will navigate  
class NewPage extends JFrame implements ActionListener  
{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    JPanel InfoPan;
    String u;
    JLabel Type,Brand,Prob,noti;
    JButton b2;
    final JTextField F1,F2,F3;
    String te; 
	//constructor  
    NewPage(String userValue )  
    {  this.u=userValue;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        setTitle("Welcome to Electronics Repair System");  
        Type=new JLabel();
        Type.setText("Type of Electronics (e.g. Laptop) :");
        F1=new JTextField(15);
        Brand=new JLabel();
        Brand.setText("Brand with Serialization (e.g. Samsung Galaxy S24) :");
        F2=new JTextField(15);
        Prob=new JLabel();
        Prob.setText("Describe the problem:");
        F3=new JTextField(100);
        b2 = new JButton("SUBMIT");
        InfoPan=new JPanel(new GridLayout(4, 1));
        InfoPan.add(Type);
        InfoPan.add(F1);
        InfoPan.add(Brand);
        InfoPan.add(F2);
        InfoPan.add(Prob);
        InfoPan.add(F3);
        InfoPan.add(b2);
        add(InfoPan);
        b2.addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		String E =F1.getText();
		String P=F2.getText();
		String T=P+E;
		String v= "E"+Math.random();
		String a=" ",b=" ";
		String sql="insert into P_D values(?,?,?,?)";
		String sql1="insert into Prod values(?,?,?)";
		 try 
			(
			Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
			PreparedStatement stmt=con.prepareStatement(sql))
			{
			 stmt.setString(1, te);
			 stmt.setString(2, a);
			 stmt.setString(3, b);
			 stmt.setString(4, v);
			 int rowsAffected = stmt.executeUpdate();
	         if (rowsAffected > 0) {
	             System.out.println("Data inserted successfully!");
	         } else {
	             System.out.println("Failed to insert data.");
	         }
			}
		 catch(Exception g)
			{
				System.out.println("Did not Submit");			
				}
		 try(
				Connection con1=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
				PreparedStatement stmt1=con1.prepareStatement(sql1)
				)
		 { stmt1.setString(1, u);
		 stmt1.setString(2, a);
		 stmt1.setString(3, v);
		 int rowsAffected = stmt1.executeUpdate();
         if (rowsAffected > 0) {
             System.out.println("Data inserted successfully!");
         } else {
             System.out.println("Failed to insert data.");
         }
			}
	catch(Exception g)
	{
		System.out.println("Did not Submit");			
		}
	}
	public static void main(String[] args) {
		  
	}
}


