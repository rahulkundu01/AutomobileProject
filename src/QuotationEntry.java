import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.*;
import javax.swing.*;

public class QuotationEntry extends JFrame implements KeyListener
{
	JTextField Asrcost,Aia,Artotax,Archarges,Aacc,Atotcost;
	JLabel AmodelL,AsrcostL,AiaL,ArtotaxL,ArchargesL,AaccL,AtotcostL; 
	JButton Aadd,Acancel,Atotal,Anew;
	JComboBox Amodel;

	public void keyPressed(KeyEvent kevt)
	{}
	public void keyTyped(KeyEvent kevt)
	{}
	public void keyReleased(KeyEvent kevt)
	{
		if(kevt.getSource()==Asrcost)
		{
			ValidateData.checkLength(Asrcost.getText(),"ShowRoom Cost");
			ValidateData.checkNumber(Asrcost);
		}
		if(kevt.getSource()==Aia)
		{
			ValidateData.checkLength(Aia.getText(),"Insurance Amount");
			ValidateData.checkNumber(Aia);
		}
		if(kevt.getSource()==Artotax)
		{
			ValidateData.checkLength(Artotax.getText(),"Rto Tax");
			ValidateData.checkNumber(Artotax);
		}
		if(kevt.getSource()==Archarges)
		{
			ValidateData.checkLength(Archarges.getText(),"Reservation Charges");
			ValidateData.checkNumber(Archarges);
		}
		if(kevt.getSource()==Atotcost)
		{
			ValidateData.checkLength(Atotcost.getText(),"Total Cost");
			ValidateData.checkNumber(Atotcost);
		}
	}

	public QuotationEntry()
	{
		setTitle("Quotation Entry");
		setLayout(null);
		setBackground(Color.gray);


		Amodel=new JComboBox();
		Amodel.setEditable(true);
		
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
			Connection con = DriverManager.getConnection(data);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select distinct models from quotation");
			while(rs.next())
			{
					Amodel.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Asrcost=new JTextField();
		Aia=new JTextField();
		Artotax=new JTextField();
		Archarges=new JTextField();
		//Aacc=new JTextField();
		Atotcost=new JTextField();

		AmodelL=new JLabel("Model");
		AsrcostL=new JLabel("Showroom Cost");
		AiaL=new JLabel("Insuarance Ammount");
		ArtotaxL=new JLabel("RTO Tax");
		ArchargesL=new JLabel("Registration Charges");
		//AaccL=new JLabel("Accessories");
		AtotcostL=new JLabel("Total Cost");

		Aadd=new JButton("SAVE");
		Acancel=new JButton("CANCEL");
		Atotal=new JButton("TOTAL");
		Anew=new JButton("NEW");

		add(Amodel);    add(AmodelL);
		add(Asrcost);   add(AsrcostL);
		add(Aia);       add(AiaL);
		add(Artotax);   add(ArtotaxL);
		add(Archarges); add(ArchargesL);
		//add(Aacc);      add(AaccL);
		add(Atotcost);  add(AtotcostL);
		add(Aadd);      add(Acancel);    add(Atotal); add(Anew);


		Aadd.addActionListener(new BT());
		Acancel.addActionListener(new BT());
		Atotal.addActionListener(new BT());
		Anew.addActionListener(new BT());


		AmodelL.setBounds(30,60,150,20);
		Amodel.setBounds(200,60,150,20);
		AsrcostL.setBounds(30,90,150,20);
		Asrcost.setBounds(200,90,150,20);
		AiaL.setBounds(30,120,150,20);
		Aia.setBounds(200,120,150,20);
		ArtotaxL.setBounds(30,150,150,20);
		Artotax.setBounds(200,150,150,20);
		ArchargesL.setBounds(30,180,150,20);
		Archarges.setBounds(200,180,150,20);
		//AaccL.setBounds(30,210,150,20);
		//Aacc.setBounds(200,210,150,20);
		AtotcostL.setBounds(30,210,150,20);
		Atotcost.setBounds(200,210,150,20); 


		Acancel.setBounds(150,300,80,30);
		Aadd.setBounds(250,300,80,30);
		Atotal.setBounds(50,300,80,30);
		Anew.setBounds(150,350,80,30);

		Asrcost.addKeyListener(this);
		Aia.addKeyListener(this);
		Artotax.addKeyListener(this);
		Archarges.addKeyListener(this);
		Atotcost.addKeyListener(this);


		MyWindow adapter = new MyWindow(this);
		        addWindowListener(adapter);

	}
	class MyWindow extends WindowAdapter
         {
            QuotationEntry menuFrame;
            public MyWindow(QuotationEntry menuFrame)
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

			QuotationEntry E;
			E=new QuotationEntry();
			E.show();
			E.setBounds(200,100,400,450);

	    }

	class BT implements ActionListener
	       {
	  		  public void actionPerformed(ActionEvent e)
	  		   {
	  			    String arg = e.getActionCommand();
	  			    if(arg.equals("SAVE"))
  			        {

					String Amodel1 = (String)Amodel.getSelectedItem();
					double Asrcost1 = Float.parseFloat(Asrcost.getText());
					double Aia1 = Float.parseFloat(Aia.getText());
					double Artotax1 = Float.parseFloat(Artotax.getText());
					double Archarges1 = Float.parseFloat(Archarges.getText());
					//double Aacc1 = Float.parseFloat(Aacc.getText());
					double Atotcost1 = Float.parseFloat(Atotcost.getText());

					Atotcost1=Asrcost1+Aia1+Artotax1+Archarges1;
					
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
				   	    String ctr = "INSERT INTO Quotation VALUES('" + Amodel1 + "'," + Asrcost1 + "," + Aia1 + "," + Artotax1 + "," + Archarges1 + "," + Atotcost1 + ")";
				   	    st.executeUpdate(ctr);
  				   	    st.close();
  				   	    
  				   	    conn.close();
  	   			     }

	  		         catch(Exception el)
  					 {
  					  	System.out.println("Error");
                     }
                     Aadd.setEnabled(false);
                     MsgBox T=new MsgBox("Record Is Saved Successfully");
					T.show();
	    			T.setBounds(200,200,350,150);

	  			      //setVisible(false);
	  			     }
	  			     else if(arg.equals("CANCEL"))
	  			     {
	  					setVisible(false);
	  			     }
	  			     else if(arg.equals("TOTAL"))
	  			     {
						 //String Amodel1 = Amodel.getText();
						 double Asrcost1 = Float.parseFloat(Asrcost.getText());
						 double Aia1 = Float.parseFloat(Aia.getText());
						 double Artotax1 = Float.parseFloat(Artotax.getText());
						 double Archarges1 = Float.parseFloat(Archarges.getText());
						 //double Aacc1 = Float.parseFloat(Aacc.getText());
						 //double Atotcost1 = Float.parseFloat(Atotcost.getText());
						 double Atotcost1=Asrcost1+Aia1+Artotax1+Archarges1;
						 Atotcost.setText(Double.toString(Atotcost1));

					}
					else if(arg.equals("NEW"))
					{
						Asrcost.setText("");
						Aia.setText("");
						Artotax.setText("");
						Archarges.setText("");
						//Amodel.setText("");
						Atotcost.setText("");
						Aadd.setEnabled(true);
					}

  			   repaint();
			}
		}
	}
