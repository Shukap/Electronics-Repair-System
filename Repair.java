import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.sql.*;
import java.lang.Exception;  
import oracle.jdbc.driver.*;
  
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class CreateLoginForm extends JFrame implements ActionListener  
{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//initialize button, panel, label, and text field  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel,Pdone;  
    final JTextField  textField1, textField2;  
      
    //calling constructor  
    CreateLoginForm()  
    {     
          
        //create label for username   
        userLabel = new JLabel();  
        userLabel.setText("User ID");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);           //set button to panel  
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("Electronics Repair System");         //set title to the login form  
    }  
 
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered pasword from the textField2  
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","somu");
		Statement stmt=con.createStatement();   
		ResultSet rs = stmt.executeQuery("select * from login where ID ='" + userValue + "'");
		rs.next();     
		String a=rs.getString(1);
        if (a.charAt(0)=='T') {    
            TechPage page = new TechPage(userValue);  
            page.setSize(500,300);
            page.setVisible(true);  
            page.getContentPane();  
        }
        else if(a.charAt(0)=='A')
        {
        	Admin A=new Admin(userValue);
        	A.setSize(700,700);
        	A.setVisible(true);
        	A.getContentPane();
        }
        
        else
        {  
          NewPage page = new NewPage(userValue);
          page.setSize(700,150);
          page.setVisible(true);
          page.getContentPane();
        }
            
    }catch(Exception e)  
        {     
        //handle exception   
        JOptionPane.showMessageDialog(null, e.getMessage());  
    }   
}
 }  
public class Repair{
	
	public static void main(String[] args) {
		  try  
	        {  
	            //create instance of the CreateLoginForm  
	            CreateLoginForm form = new CreateLoginForm();  
	            form.setSize(300,100);  //set size of the frame  
	            form.setVisible(true);  //make form visible to the user  
	        }  
	        catch(Exception e)  
	        {     
	            //handle exception   
	            JOptionPane.showMessageDialog(null, e.getMessage());  
	        }  
	}
   }
