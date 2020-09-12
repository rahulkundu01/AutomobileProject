import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.*;
import javax.swing.*;

public class CEnquiry extends JFrame  implements KeyListener 
{
	Choice Cmname;
	JTextField Cname,Caddr,Cphno,Cenqdate,Cenqno;
	JLabel CnameL,CaddrL,CphnoL,CmnameL,CenqdateL,CenqnoL;
	JButton Cadd,Ccancel,Cnew;
	//private static JLabel errorMsg = new JLabel("Invalid input");

	public void keyPressed(KeyEvent kevt)
	{
		
	}
	public void keyTyped(KeyEvent kevt)
	{
		if(kevt.getSource()==Cname)
		{
			ValidateData.checkLength(Cname.getText(), "Enquiry");
		}
		if(kevt.getSource()==Caddr)
		{
			ValidateData.checkLength(Caddr.getText(), "Address");
		}
	}
	public void keyReleased(KeyEvent kevt)
	{
		if(kevt.getSource()==Cphno)
		{
			ValidateData.checkLength(Cphno.getText(),"Phone No");
			ValidateData.checkNumber(Cphno);
			ValidateData.checkPhoneNo(Cphno,"Phone No");
		}
		if(kevt.getSource()==Cname)
		{
			ValidateData.checkName(Cname);
		}
		if(kevt.getSource()==Cname)
		{
			ValidateData.checkLength(Cname.getText(), "Enquiry");
		}
		if(kevt.getSource()==Caddr)
		{
			ValidateData.checkName(Caddr);
		}
		if(kevt.getSource()==Caddr)
		{
			ValidateData.checkLength(Caddr.getText(), "Address");
		}

	}

	public CEnquiry()
	{
	    Calendar dt = Calendar.getInstance();
		setTitle("Customer Enquiry");
		setLayout(null);
		setBackground(Color.pink);

        int newnum=0;
       /* String msAccessDBName = "F:\\Work Environment\\MyProject\\AutomobileProject\\bin\\HONDA.MDB";
		String data="jdbc:odbc:Driver="
                + "{Microsoft Access Driver (*.mdb, *.accdb)};"
                + "DBQ=" 
				+ msAccessDBName
				+ ";DriverID=22;READONLY=true";*/
        String data = "jdbc:ucanaccess://F:\\Work Environment\\MyProject\\AutomobileProject\\HONDA.accdb";
		try
		{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(data);
			Statement st = conn.createStatement();
			ResultSet rec=st.executeQuery("SELECT * FROM CustomerEnquiry order by Cno desc");
			rec.next();
			newnum = rec.getInt("Cno");
			Cenqno.setText(Integer.toString(newnum));
			System.out.println("\n");
			st.close();
		}
		catch(Exception e)
		{
			//  System.out.println("Error");
        }

		Cname=new JTextField();
		Caddr=new JTextField();
		Cphno=new JTextField();
		//Cmname=new JTextField();
		Cmname=new Choice();
		Cmname.add("Select a VehicLe");
		Cmname.add("CD-DOWN");
		Cmname.add("CD-DLX");
		Cmname.add("CD-100");
		Cmname.add("SPLENDOR+");
		Cmname.add("PASSION+");
		Cmname.add("SUPER SPL");
		Cmname.add("GLAMOUR");
		Cmname.add("CBZ");
		Cmname.add("KARIZMA");
     	Cmname.add("ACHIEVER");
     	Cmname.add("PLEASURE");

		Cenqdate=new JTextField();
		Cenqno=new JTextField();
		Cenqno.setText(Integer.toString(newnum+1));

		CnameL=new JLabel("Name");
		CaddrL=new JLabel("Address");
		CphnoL=new JLabel("Phone no.");
		CmnameL=new JLabel("Model Name");
		CenqdateL=new JLabel("Enquiry Date");
		CenqnoL=new JLabel("Enquiry No");

		Cadd=new JButton("ADD NEW");
		Ccancel=new JButton("CANCEL");
		Cnew=new JButton("NEW");

		add(Cname);    add(CnameL);
		add(Caddr);    add(CaddrL);
		add(Cphno);    add(CphnoL);
		add(Cmname);   add(CmnameL);
		add(Cenqdate); add(CenqdateL);
		add(Cenqno);   add(CenqnoL);
		add(Cadd);     add(Ccancel);  add(Cnew);

		Cadd.addActionListener(new BT());
		Ccancel.addActionListener(new BT());
		Cnew.addActionListener(new BT());

		Cenqdate.setEnabled(false); 
		
		CenqnoL.setBounds(30,60,150,20);
		Cenqno.setBounds(200,60,150,20);
		CnameL.setBounds(30,90,150,20);
		Cname.setBounds(200,90,150,20);
		CaddrL.setBounds(30,120,150,20);
		Caddr.setBounds(200,120,150,20);
		CphnoL.setBounds(30,150,150,20);
		Cphno.setBounds(200,150,150,20);
		CmnameL.setBounds(30,180,150,20);
		Cmname.setBounds(200,180,150,20);
		CenqdateL.setBounds(30,210,150,20);
		Cenqdate.setBounds(200,210,150,20);

		Ccancel.setBounds(100,250,80,30);
		Cadd.setBounds(200,250,80,30);
		Cnew.setBounds(150,300,80,30);

	    String pp = Integer.toString(dt.get(Calendar.DATE))+"/"+
		 			Integer.toString(dt.get(Calendar.MONTH)+1)+"/"+
		 			Integer.toString(dt.get(Calendar.YEAR));
	 	Cenqdate.setText(pp);

	 	Cenqno.setEnabled(false);
	 	Cphno.addKeyListener(this);
		Cname.addKeyListener(this);

		MyWindow adapter = new MyWindow(this);
		        addWindowListener(adapter);

	}
	class MyWindow extends WindowAdapter
         {
            CEnquiry menuFrame;
            public MyWindow(CEnquiry menuFrame)
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

			CEnquiry E;
			E=new CEnquiry();
			E.show();
			E.setBounds(200,50,400,450);

	    }

	class BT implements ActionListener
	       {
	       		int newnum= Integer.parseInt(Cenqno.getText());
	  		  public void actionPerformed(ActionEvent e)
	  		   {
	  			    String arg = e.getActionCommand();
	  			    if(arg.equals("ADD NEW"))
  			        {

					String Cname1 = Cname.getText();
					String Caddr1 = Caddr.getText();
					double Cphno1 = Float.parseFloat(Cphno.getText());
					String Cmname1 = Cmname.getSelectedItem();
					double Cenqno1 = Float.parseFloat(Cenqno.getText());
					String Cenqdate1 = Cenqdate.getText();
					
					MsgBox T=new MsgBox("Record Is Saved Successfully");
					T.show();
	    			T.setBounds(200,200,350,150);
	    			
	    		
	    			
					/*try
					{
						java.util.Date d = new java.util.Date(Cenqdate1);
					}
					catch(Exception e11)
					{
						JOptionPane.showMessageDialog(null,"Please input Valid Enquairy Date");
						return;
					}*/


	    			/*String msAccessDBName = "F:\\Work Environment\\MyProject\\AutomobileProject\\bin\\HONDA.MDB";
	    			String data="jdbc:odbc:Driver="
	    	                + "{Microsoft Access Driver (*.mdb, *.accdb)};"
	    	                + "DBQ=" 
	    					+ msAccessDBName
	    					+ ";DriverID=22;READONLY=true";*/
					String data = "jdbc:ucanaccess://F:\\Work Environment\\MyProject\\AutomobileProject\\HONDA.accdb";
				     try
					 {
					 	//Class.forName("oracle.jdbc.driver.OracleDriver");
					  	Connection conn = DriverManager.getConnection(data);
				   	    Statement st = conn.createStatement();
				   	    String ctr = "INSERT INTO CustomerEnquiry VALUES(" + Cenqno1 + ",'" + Cname1 + "','" + Caddr1 + "'," + Cphno1 + ",'" + Cmname1 + "','" + Cenqdate1 + "')";
				   	    st.executeUpdate(ctr);
  				   	    st.close();
  				   	    conn.close();
  	   			     }
  	   			     catch(Exception el)
  					 {
  					  	System.out.println("Error");
                     }

	  		         /*catch(Exception el)
  					 {
  					  	JOptionPane.showMessageDialog(null,"Please input Valid Date");
						//return;
                     }*/
	  			      //setVisible(false);
	  			     }
	  			     else if(arg.equals("CANCEL"))
	  			     {
	  					setVisible(false);
	  			     }
	  			     else if(arg.equals("NEW"))
	  			     {
	  			     	Cname.setText("");
	  			     	Caddr.setText("");
	  			     	Cphno.setText(""); 
	  			     	Cenqno.setText(Integer.toString(newnum+1));
	  			     }
  			   repaint();
			}
		}
	}
