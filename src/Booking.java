import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.*;
import javax.swing.*;

public class Booking extends JFrame  implements KeyListener
{
	Choice Bmname,Bmcolor;
	JTextField Bname,Baddr,Bphno,Bamt,Bbokno,Bbokdate,Bdeldate;
	JLabel BnameL,BaddrL,BphnoL,BmnameL,BmcolorL,BamtL,BboknoL,BbokdateL,BdeldateL;
	JButton Badd,Bcancel,Bnew;

	public void keyPressed(KeyEvent kevt)
	{
	}
	public void keyTyped(KeyEvent kevt)
	{}
	public void keyReleased(KeyEvent kevt)
	{
		if(kevt.getSource()==Bphno)
		{
			ValidateData.checkLength(Bphno.getText(),"Phone No");
			ValidateData.checkNumber(Bphno);
			ValidateData.checkPhoneNo(Bphno,"Phone No");
		}
		if(kevt.getSource()==Bamt)
		{
			ValidateData.checkLength(Bamt.getText(),"Amount");
			ValidateData.checkNumber(Bamt);
		}
		if(kevt.getSource()==Bname)
		{
			ValidateData.checkName(Bname);
		}
	}

	public Booking()
	{
		Calendar dt = Calendar.getInstance();
		setTitle("Booking");
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
	 		//Class.forName("oracle.jdbc.driver.OracleDriver");
	 	   	Connection conn = DriverManager.getConnection(data);
	 	   	Statement st = conn.createStatement();
	 	   	ResultSet rec=st.executeQuery("SELECT * FROM Booking order by BookingNo desc");
	 	   	rec.next();
	 	   	newnum = rec.getInt("BookingNo");
	 	   	Bbokno.setText(Integer.toString(newnum));
	 	   	System.out.println("\n");
	 	   	st.close();
	 	 }
	 	 catch(Exception e)
	 	 {
	 	   	//  System.out.println("Error");
         }

		Bname=new JTextField();
		Baddr=new JTextField();
		Bphno=new JTextField();

		//Bmname=new JTextField();
		//Bmcolor=new JTextField();
		Bmname = new Choice();
		Bmname.add("CD-DOWN");
		Bmname.add("CD-DLX");
		Bmname.add("CD-100");
		Bmname.add("SPLENDOR+");
		Bmname.add("PASSION+");
		Bmname.add("SUPER SPL");
		Bmname.add("GLAMOUR");
		Bmname.add("CBZ");
		Bmname.add("KARIZMA");
     	Bmname.add("ACHIEVER");
     	Bmname.add("PLEASURE");

     	Bmcolor = new Choice();
     	Bmcolor.add("Red");
     	Bmcolor.add("Blue");
     	Bmcolor.add("Black");
     	Bmcolor.add("Yellow");
     	Bmcolor.add("Silver");
		Bamt=new JTextField();
		Bbokno=new JTextField();
		Bbokno.setText(Integer.toString(newnum+1));
		Bbokdate=new JTextField();
		Bdeldate=new JTextField();

		BnameL=new JLabel("Name");
		BaddrL=new JLabel("Address");
		BphnoL=new JLabel("Phone no.");
		BmnameL=new JLabel("Model Name");
		BmcolorL=new JLabel("Model Color");
		BamtL=new JLabel("Amount");
		BboknoL=new JLabel("Booking no.");
		BbokdateL=new JLabel("Booking Date");
		BdeldateL=new JLabel("Delivery Date");

		Badd=new JButton("ADD NEW");
		Bcancel=new JButton("CANCEL");
		Bnew=new JButton("NEW");

		Bbokno.setEnabled(false);
		Bbokdate.setEnabled(false);

		add(Bname);    add(BnameL);
		add(Baddr);    add(BaddrL);
		add(Bphno);    add(BphnoL);
		add(Bmname);   add(BmnameL);
		add(Bmcolor);   add(BmcolorL);
		add(Bamt);     add(BamtL);
		add(Bbokno);   add(BboknoL);
		add(Bbokdate); add(BbokdateL);
		add(Bdeldate); add(BdeldateL);
		add(Badd);     add(Bcancel); add(Bnew);

		Badd.addActionListener(new BT());
		Bcancel.addActionListener(new BT());
		Bnew.addActionListener(new BT());
		


		BboknoL.setBounds(30,60,150,20);
		Bbokno.setBounds(200,60,150,20);
		BbokdateL.setBounds(30,90,150,20);
		Bbokdate.setBounds(200,90,150,20);
		BnameL.setBounds(30,120,150,20);
		Bname.setBounds(200,120,150,20);
		BaddrL.setBounds(30,150,150,20);
		Baddr.setBounds(200,150,150,20);
		BphnoL.setBounds(30,180,150,20);
		Bphno.setBounds(200,180,150,20);
		BmnameL.setBounds(30,210,150,20);
		Bmname.setBounds(200,210,150,20);
		BmcolorL.setBounds(30,240,150,20);
		Bmcolor.setBounds(200,240,150,20);
		BamtL.setBounds(30,270,150,20);
		Bamt.setBounds(200,270,150,20);
		BdeldateL.setBounds(30,300,150,20);
		Bdeldate.setBounds(200,300,150,20);

		Bcancel.setBounds(150,350,80,30);
		Badd.setBounds(250,350,80,30);
		Bnew.setBounds(50,350,80,30);
		

	    String pp = Integer.toString(dt.get(Calendar.DATE))+"/"+
		 			Integer.toString(dt.get(Calendar.MONTH)+1)+"/"+
		 			Integer.toString(dt.get(Calendar.YEAR));
	    Bbokdate.setText(pp);
	    Bphno.addKeyListener(this);
	    Bamt.addKeyListener(this);
	    Bname.addKeyListener(this);

		MyWindow adapter = new MyWindow(this);
		        addWindowListener(adapter);

	}

	public static void main(String args[])

		{

			Booking B;
			B=new Booking();
			B.show();
				B.setBounds(200,50,400,500);

	    }
	    	class MyWindow extends WindowAdapter
		         {
		            Booking menuFrame;
		            public MyWindow(Booking menuFrame)
		             {
		                this.menuFrame=menuFrame;
		             }
		      	    public void windowClosing(WindowEvent we)
		       		 {
					   menuFrame.setVisible(false);
			   		 }
	   	 }



	class BT implements ActionListener
	       {
	       		int newnum=Integer.parseInt(Bbokno.getText()); 
	  		  public void actionPerformed(ActionEvent e)
	  		   {
	  			    String arg = e.getActionCommand();
	  			    if(arg.equals("ADD NEW"))
  			        {
					String Bname1 = Bname.getText();
					String Baddr1 = Baddr.getText();
					double Bphno1 = Float.parseFloat(Bphno.getText());
					String Bmname1 = Bmname.getSelectedItem();
					String Bmcolor1 = Bmcolor.getSelectedItem();
					double Bamt1 = Float.parseFloat(Bamt.getText());
					double Bbokno1 = Float.parseFloat(Bbokno.getText());
					String Bbokdate1 = Bbokdate.getText();
					String Bdeldate1 = Bdeldate.getText();
					
					

					try
					{
						java.util.Date d = new java.util.Date(Bbokdate1);
					}
					catch(Exception e11)
					{
						JOptionPane.showMessageDialog(null,"Please input Valid Booking Date");
						return;
					}
					finally
					{
						try
						{
							java.util.Date d = new java.util.Date(Bdeldate1);
						}
						catch(Exception e111)
						{
							JOptionPane.showMessageDialog(null,"Please input Valid Delivery Date");
							return;
						}
				    }

					/*String msAccessDBName = "F:\\Work Environment\\MyProject\\AutomobileProject\\bin\\HONDA.MDB";
					String data="jdbc:odbc:Driver="
			                + "{Microsoft Access Driver (*.mdb, *.accdb)};"
			                + "DBQ=" 
							+ msAccessDBName
							+ ";DriverID=22;READONLY=true";*/
							String data = "jdbc:ucanaccess://F:\\Work Environment\\MyProject\\AutomobileProject\\HONDA.accdb";
					
				     try
					 {
					 	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					  	Connection conn = DriverManager.getConnection(data);
				   	    Statement st = conn.createStatement();
				   	    String ctr = "INSERT INTO Booking VALUES(" + Bbokno1 + ",'" + Bbokdate1 + "','" + Bname1 + "','" + Baddr1 + "'," + Bphno1 + ",'" + Bmname1 + "','" + Bmcolor1 + "'," + Bamt1 + ",'"+ Bdeldate1 +"')";
				   	    st.executeUpdate(ctr);

  				   	    st.close();
  				   	    conn.close();
  	   			     }

	  		         catch(Exception el)
  					 {
  					  	JOptionPane.showMessageDialog(null,"Please input Valid Date");
						return;
                     }
                     Badd.setEnabled(false);
                     MsgBox R=new MsgBox("Record Is Saved Successfully");
					 R.show();
	    			 R.setBounds(200,200,350,150);

	  			      //setVisible(false);
	  			     }
	  			     else if(arg.equals("CANCEL"))
	  			     {
	  					setVisible(false);
	  			     }
	  			     else if(arg.equals("NEW"))
	  			     {
	  			     	Bname.setText("");
	  			     	Baddr.setText("");
	  			     	Bphno.setText("");
	  			     	Bamt.setText("");
	  			     	Bdeldate.setText("");
	  			     	Bbokno.setText(Integer.toString(newnum+1));
	  			     	Badd.setEnabled(true); 
	  			     }
  			   repaint();
			}
		}
	}
