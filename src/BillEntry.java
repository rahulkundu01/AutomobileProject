import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.*;
import javax.swing.*;

public class BillEntry extends JFrame
{
	Choice trcomp,tfcomp,batcom;
	//JComboBox batcomp;
	JTextField name,addr,phno,mname,mcolor,amt,bokno,bokdate,deldate,bno,engno,chasisno,keyno,batno,tfno,trno;
	JLabel nameL,addrL,phnoL,mnameL,mcolorL,amtL,boknoL,bokdateL,deldateL,bnoL,engnoL,chasisnoL,keynoL,batnoL,batcompL,tfnoL,tfcompL,trnoL,trcompL;
	JButton add,cancel,test;

	public BillEntry()
	{
		Calendar dt = Calendar.getInstance();
		setTitle("Bill Entry");
		setLayout(null);
		setBackground(Color.pink);

		int newnum=0;
		
		
		
		//File f = new File("\\\\***\\***\\****\\***.accdb");

		//"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + f.getAbsolutePath();
		
		
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
			ResultSet rec=st.executeQuery("SELECT * FROM Billing order by Billno desc");
			rec.next();
			newnum = rec.getInt("Billno");
			bno.setText(Integer.toString(newnum));
			System.out.println("\n");
			st.close();
		}
		catch(Exception e)
		{
			//  System.out.println("Error");
        }

        bokno   = new JTextField();
		bokdate = new JTextField();
		bokdate.setEditable(false);
		name    = new JTextField();
		name.setEditable(false);
		addr    = new JTextField();
		addr.setEditable(false);
		phno    = new JTextField();
		phno.setEditable(false);
		mname   = new JTextField();
		mname.setEditable(false);
		mcolor  = new JTextField();
		mcolor.setEditable(false);
		amt     = new JTextField();
		amt.setEditable(false);
		deldate = new JTextField();
		deldate.setEditable(false);

		bno     = new JTextField();
		bno.setText(Integer.toString(newnum+1));
		engno   = new JTextField();
		chasisno= new JTextField();
		keyno   = new JTextField();
		batno   = new JTextField();
		
		batcom = new Choice();
		batcom.add("select from list");
		batcom.add("Exide");
		batcom.add("Okaya");
		batcom.add("Microteck");
		//batcomp.setEditable(true);
		/*	try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:honda");
					Statement stat = con.createStatement();
					ResultSet rs = stat.executeQuery("select distinct Batterycomp from billing");
					while(rs.next())
					{
							batcomp.addItem(rs.getString(1));
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}*/


		tfno    = new JTextField();
		//tfcomp  = new JTextField();
		tfcomp  = new Choice();
		tfcomp.add("Denlop");
		tfcomp.add("Mrf");
		tfcomp.add("Tvs");
		trno    = new JTextField();
		//trcomp  = new JTextField();
		trcomp  = new Choice();
		trcomp.add("Denlop");
		trcomp.add("Mrf");
		trcomp.add("Tvs");
		
		/*batcom=new Choice();
		batcom.add("Exide");
		batcom.add("okaya");
		*/


		boknoL   = new JLabel("Booking No");
		bokdateL = new JLabel("Booking Date");
		nameL    = new JLabel("Name");
		addrL    =new JLabel("Address");
		phnoL    =new JLabel("Phone No");
		mnameL   =new JLabel("Model Name");
		mcolorL  =new JLabel("Model Color");
		amtL     =new JLabel("Ammount");
		deldateL =new JLabel("Delivery Date");

		bnoL     =new JLabel("Bill No");
		engnoL   =new JLabel("Engine No");
		chasisnoL=new JLabel("Chasis No");
		keynoL   =new JLabel("Key No");
		batnoL   =new JLabel("Battery No");
		batcompL =new JLabel("Battery Company");
		tfnoL    =new JLabel("Tyer Front No");
		tfcompL  =new JLabel("Tyer Front Comp");
		trnoL    =new JLabel("Tyer Rear No");
		trcompL  =new JLabel("Tyer Rear Comp");

		add   = new JButton("ADD NEW");
		cancel= new JButton("CANCEL");
		test  = new JButton("TEST");

		add(name);    add(nameL);
		add(addr);    add(addrL);
		add(phno);    add(phnoL);
		add(mname);   add(mnameL);
		add(amt);     add(amtL);
		add(bokno);   add(boknoL);
		add(bokdate); add(bokdateL);
		add(deldate); add(deldateL);
		add(mcolor);  add(mcolorL);
		add(bno);     add(bnoL);
		add(engno);   add(engnoL);
		add(chasisno);add(chasisnoL);
		add(keyno);   add(keynoL);
		add(batno);   add(batnoL);
		add(batcom); add(batcompL);
		add(tfno);    add(tfnoL);
		add(tfcomp);  add(tfcompL);
		add(trno);    add(trnoL);
		add(trcomp);  add(trcompL);
		add(add);     add(cancel);   add(test);

		add.addActionListener(new BT());
		cancel.addActionListener(new BT());
		test.addActionListener(new BT());


		boknoL.setBounds(30,60,150,20);
		bokno.setBounds(150,60,75,20);
		bokdateL.setBounds(30,90,150,20);
		bokdate.setBounds(150,90,150,20);
		nameL.setBounds(30,120,150,20);
		name.setBounds(150,120,150,20);
		addrL.setBounds(30,150,150,20);
		addr.setBounds(150,150,150,20);
		phnoL.setBounds(30,180,150,20);
		phno.setBounds(150,180,150,20);
		mnameL.setBounds(30,210,150,20);
		mname.setBounds(150,210,150,20);
		mcolorL.setBounds(30,240,150,20);
		mcolor.setBounds(150,240,150,20);
		amtL.setBounds(30,270,150,20);
		amt.setBounds(150,270,150,20);
		deldateL.setBounds(30,300,150,20);
		deldate.setBounds(150,300,150,20);

		bnoL.setBounds(380,60,150,20);
		bno.setBounds(500,60,150,20);
		engnoL.setBounds(380,90,150,20);
		engno.setBounds(500,90,150,20);
		chasisnoL.setBounds(380,120,150,20);
		chasisno.setBounds(500,120,150,20);
		keynoL.setBounds(380,150,150,20);
		keyno.setBounds(500,150,150,20);
		batnoL.setBounds(380,180,150,20);
		batno.setBounds(500,180,150,20);
		batcompL.setBounds(380,210,150,20);
		batcom.setBounds(500,210,150,20);
		tfnoL.setBounds(380,240,150,20);
		tfno.setBounds(500,240,150,20);
		tfcompL.setBounds(380,270,150,20);
		tfcomp.setBounds(500,270,150,20);
		trnoL.setBounds(380,300,150,20);
		trno.setBounds(500,300,150,20);
		trcompL.setBounds(380,330,150,20);
		trcomp.setBounds(500,330,150,20);

		cancel.setBounds(220,400,80,30);
		add.setBounds(380,400,80,30);
		test.setBounds(250,60,80,25);

		bno.setEnabled(false);


MyWindow adapter = new MyWindow(this);
        addWindowListener(adapter);

	}
	class MyWindow extends WindowAdapter
         {
            BillEntry menuFrame;
            public MyWindow(BillEntry menuFrame)
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

			BillEntry B;
			B=new BillEntry();
			B.show();
			B.setBounds(50,50,700,500);

	    }


	class BT implements ActionListener
	       {
	  		  public void actionPerformed(ActionEvent e)
	  		   {
	  			    String arg = e.getActionCommand();
	  			    if(arg.equals("ADD NEW"))
  			        { 

					String name1 = name.getText();
					String addr1 = addr.getText();
					double phno1 = Float.parseFloat(phno.getText());
					String mname1 = mname.getText();
					String mcolor1 = mcolor.getText();
					double amt1 = Float.parseFloat(amt.getText());
					double bokno1 = Float.parseFloat(bokno.getText());
					String bokdate1 = bokdate.getText();
					String deldate1 = deldate.getText();
					double bno1 = Float.parseFloat(bno.getText());
					double engno1 = Float.parseFloat(engno.getText());
					double chasisno1 = Float.parseFloat(chasisno.getText());
					double keyno1 = Float.parseFloat(keyno.getText());
					double batno1 = Float.parseFloat(batno.getText());
					String batcomp1 = batcom.getSelectedItem();
					double tfno1 = Float.parseFloat(tfno.getText());
                    String tfcomp1 = tfcomp.getSelectedItem();
					double trno1 = Float.parseFloat(trno.getText());
                    String trcomp1 = trcomp.getSelectedItem();

                    String ptt = mname.getText();
					String tpp = mcolor.getText();
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

				   	    String ctr = "INSERT INTO Billing VALUES('" + name1 + "','" + addr1 + "'," + phno1 + ",'" + bokdate1 + "','" + deldate1 + "'," + bno1 + ",'" + mname1 + "','" + mcolor1 + "'," + engno1 + "," + chasisno1 + "," + keyno1 + "," + batno1 + ",'" + batcomp1 + "'," + tfno1 + ",'" + tfcomp1 + "'," + trno1 + ",'" + trcomp1 + "'," + amt1 + ")";
				   	    st.executeUpdate(ctr);

						String ptr = "UPDATE Stock SET AvailQty = AvailQty - 1 Where ModelName = '" + ptt + "' and Colour = '" + tpp + "'";
						st.executeUpdate(ptr);
  				   	    st.close();
  				   	    conn.close();
  	   			     }
 
	  		         catch(Exception el)
  					 {
  					  	System.out.println("Error");
                     }
                     setVisible(false);
	  			     }
	  			     else if(arg.equals("CANCEL"))
	  			     {
	  					setVisible(false);
	  			     }
	  			     else if(arg.equals("TEST"))
					 {



					 	int num = Integer.parseInt(bokno.getText());

					 	String data = "jdbc:odbc:HONDA";
					 	try
				        {
					 		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					 		Connection conn = DriverManager.getConnection(data,"","");
					 		Statement st = conn.createStatement();
					 	    ResultSet rec=st.executeQuery("SELECT * FROM Booking where BookingNo = " + num);
					 	    rec.next();
					 	    bokdate.setText(rec.getString("BookingDate"));
					 	    name.setText(rec.getString("Name"));
					 		addr.setText(rec.getString("Address"));
					 		//phno.setText(Integer.toString(rec.getInt("PhoneNo")));
					 		phno.setText(rec.getString("PhoneNo")); 
					 		mname.setText(rec.getString("ModelName"));
					 		mcolor.setText(rec.getString("ModelColour"));
                            amt.setText(rec.getString("Amt"));
                            deldate.setText(rec.getString("DeliveryDate"));
					 		st.close();
					 		//llb.setText("Wel-Come");
					 	}
					 	catch(Exception et)
					 	{
					 		JOptionPane.showMessageDialog(null,"Record Not Found...");
					 		bokdate.setText("");
					 		name.setText("");
					 		addr.setText("");
					 		phno.setText("");
					 		mname.setText("");
					 		mcolor.setText("");
					 		amt.setText("");
					 		deldate.setText("");
					 		bokno.setText("");
					 	}
					 }

  			   repaint();
			}
		}
	}
