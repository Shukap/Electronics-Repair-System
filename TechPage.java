import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 
import java.sql.*;
class TechPage  extends JFrame implements ActionListener
{  
	JButton submit;
	String userValue;
	JPanel TPan;
	JLabel w,t,n,sub;
	JTextField f;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 TechPage(String userValue)
	   { TPan=new JPanel(new GridLayout(7, 1));
		 this.userValue=userValue;
		 setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		 setTitle("Electronics Repair System");
		 w=new JLabel();
		 w.setText("Welcome To Technician Home Page "+userValue);
		 try{
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
			Statement stmt=con.createStatement();   
			ResultSet rs = stmt.executeQuery("select p_id,name,s,end from prod,p_d where prod.prod_id=p_d.p_id and tech_id ='" + userValue + "'");
			while(rs.next()) 
			{  
			n=new JLabel();
			String a=rs.getString(1),b=rs.getString(2),c=rs.getString(3),d1=rs.getString(4);
			  n.setText(a+" "+b+" "+c+" "+d1+"\n");
			  TPan.add(n);
		 }
			sub = new JLabel("Product Finish Repairing:");
			f=new JTextField(30);
			submit=new JButton("Submit");
			TPan.add(sub);
			TPan.add(f);
			TPan.add(submit);
			add(TPan);
			 submit.addActionListener(this);
			}
		 catch(Exception e1)  
	        {     
	        //handle exception   
	        JOptionPane.showMessageDialog(null, e1.getMessage());  
	    }   
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s=f.getText(); 
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
			Statement stmt=con.createStatement();   
			ResultSet rs = stmt.executeQuery("delete p_id from P_D where name ='" + f + "'");
			con.commit();
			rs.next();
		}catch(Exception g)
		{
			
		}	 
		
	}
	
	}

