import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.*;
import javax.swing.*;

public class StockEntry extends JFrame implements KeyListener 
{
	Choice Mname,Mcolor;
	JTextField Msr,Mavlqty;
	JLabel MsrL,MnameL,McolorL,MavlqtyL;
	JButton Madd,Mcancel,Mnew;

	public void keyPressed(KeyEvent kevt)
	{}
	public void keyTyped(KeyEvent kevt)
	{}
	public void keyReleased(KeyEvent kevt)
	{
		if(kevt.getSource()==Mavlqty)
		{
			ValidateData.checkLength(Mavlqty.getText(),"Quantity");
			ValidateData.checkNumber(Mavlqty);
		}
	}

	public StockEntry()
	{
		setTitle("Stock Entry");
		setLayout(null);
		setBackground(Color.pink);

         int newnum=0;
         /*String msAccessDBName = "F:\\Work Environment\\MyProject\\AutomobileProject\\bin\\HONDA.MDB";
 		String data="jdbc:odbc:Driver="
                 + "{Microsoft Access Driver (*.mdb, *.accdb)};"
                 + "DBQ=" 
 				+ msAccessDBName
 				+ ";DriverID=22;READONLY=true";*/
         String data = "jdbc:ucanaccess://F:\\Work Environment\\MyProject\\AutomobileProject\\HONDA.accdb";
	    try
		{
			//Class.forName("oracle.jdbc.driver.OracleDrive");
			Connection conn = DriverManager.getConnection(data);
			Statement st = conn.createStatement();
			ResultSet rec=st.executeQuery("SELECT * FROM Stock order by Sr desc");
			rec.next();
			newnum = rec.getInt("Sr");
			Msr.setText(Integer.toString(newnum));
			System.out.println("\n");
			st.close();
		}
		catch(Exception e)
		{
			//  System.out.println("Error");
        }

        Msr=new JTextField();
        Msr.setText(Integer.toString(newnum+1)); 
		//Mname=new JTextField();
		Mname=new Choice();
		Mname.add("CD-DOWN");
		Mname.add("CD-DLX");
		Mname.add("CD-100");
		Mname.add("SPLENDOR+");
		Mname.add("PASSION+");
		Mname.add("SUPER SPL");
		Mname.add("GLAMOUR");
		Mname.add("CBZ");
		Mname.add("KARIZMA");
		Mname.add("ACHIEVER");
		Mname.add("PLEASURE");


		//Mcolor=new JTextField();
		Mcolor=new Choice();
		Mcolor.add("Red");
		Mcolor.add("Blue");
		Mcolor.add("Black");
		Mcolor.add("Yellow");
		Mcolor.add("Silver");
		Mavlqty=new JTextField();

		MsrL=new JLabel("Sr.No");
		MnameL=new JLabel("Model Name");
		McolorL=new JLabel("Model Color");
		MavlqtyL=new JLabel("Available Quantity");

		Madd=new JButton("ADD NEW");
		Mcancel=new JButton("CANCEL");
		Mnew=new JButton("NEW");

		add(Mname);     add(MnameL);
		add(Msr);       add(MsrL);
		add(Mcolor);    add(McolorL);
		add(Mavlqty);   add(MavlqtyL);
		add(Madd);      add(Mcancel); add(Mnew);

		Madd.addActionListener(new BT());
		Mcancel.addActionListener(new BT());
		Mnew.addActionListener(new BT());


		MsrL.setBounds(30,60,150,20);
		Msr.setBounds(200,60,150,20);
		MnameL.setBounds(30,90,150,20);
		Mname.setBounds(200,90,150,20);
		McolorL.setBounds(30,120,150,20);
		Mcolor.setBounds(200,120,150,20);
		MavlqtyL.setBounds(30,150,150,20);
		Mavlqty.setBounds(200,150,150,20);

		Mcancel.setBounds(100,250,80,30);
		Madd.setBounds(200,250,80,30);
			Mnew.setBounds(150,300,80,30);
		Mavlqty.addKeyListener(this);
		Msr.setEnabled(false);


		MyWindow adapter = new MyWindow(this);
		        addWindowListener(adapter);

	}
	class MyWindow extends WindowAdapter
         {
            StockEntry menuFrame;
            public MyWindow(StockEntry menuFrame)
             {
                this.menuFrame=menuFrame;
             }
      	    public void windowClosing(WindowEvent we)
       		 {
			   menuFrame.setVisible(false);
	   		 }
	   	 }


	public static void main(String args[])

		{

			StockEntry E;
			E=new StockEntry();
			E.show();
			E.setBounds(200,50,400,400);

	    }



	class BT implements ActionListener
	       {	
	       	int newnum=Integer.parseInt(Msr.getText());
	  		  public void actionPerformed(ActionEvent e)
	  		   {
	  			    String arg = e.getActionCommand();
	  			    if(arg.equals("ADD NEW"))
  			        {

					double Msr1 = Float.parseFloat(Msr.getText());
					String Mname1 = Mname.getSelectedItem();
					String Mcolor1 = Mcolor.getSelectedItem();
					double Mavlqty1 = Float.parseFloat(Mavlqty.getText());

					MsgBox q=new MsgBox("Record Is Saved Successfully");
					q.show();
	    			q.setBounds(200,200,350,150);
	    			/*String msAccessDBName = "F:\\Work Environment\\MyProject\\AutomobileProject\\bin\\HONDA.MDB";
	    	 		String data="jdbc:odbc:Driver="
	    	                 + "{Microsoft Access Driver (*.mdb, *.accdb)};"
	    	                 + "DBQ=" 
	    	 				+ msAccessDBName
	    	 				+ ";DriverID=22;READONLY=true";*/
	    			String data = "jdbc:ucanaccess://F:\\Work Environment\\MyProject\\AutomobileProject\\HONDA.accdb";
				     try
					 {
					 	//Class.forName("oracle.jdbc.driver.OracleDrive");
					  	Connection conn = DriverManager.getConnection(data);
				   	    Statement st = conn.createStatement();
				   	    String ctr = "INSERT INTO Stock VALUES(" + Msr1 + ",'" + Mname1 + "','" + Mcolor1 + "'," + Mavlqty1 + ")";
				   	    st.executeUpdate(ctr);
  				   	    st.close();
  				   	    conn.close();
  	   			     }

	  		         catch(Exception el)
  					 {
  					  	System.out.println("Error");
                     }
	  			      //setVisible(false);
	  			     }
	  			     else if(arg.equals("CANCEL"))
	  			     {
	  					setVisible(false);
	  			     }
	  			     else if(arg.equals("NEW"))
	  			     {
	  			     	Mavlqty.setText(""); 
	  			     	Msr.setText(Integer.toString(newnum+1));
	  			     	//Msr=Msr+1;
	  			     	
	  			     }
  			   repaint();
			}
		}
	}
