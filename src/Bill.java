import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Bill extends JFrame
{
	Bill()
	{

		resize(800,500);
		setTitle("Bill");
		setBackground(Color.pink);
		setLayout(new GridLayout(25,7));
		JButton C[][]=new JButton[1][7];
		JLabel L[][]=new JLabel[25][7];
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(i==0)
				{
					C[i][j]=new JButton();
					add(C[i][j]);
					C[i][j].addActionListener(new BT());
				}
				else
				{
					L[i][j]=new JLabel();
					add(L[i][j]);
				}
			}
		}
		C[0][0].setLabel("Name");
		C[0][1].setLabel("Address");
		C[0][2].setLabel("PhoneNo");
		C[0][3].setLabel("BokDate");
		C[0][4].setLabel("DelDate");
		C[0][5].setLabel("ModelName");
		C[0][6].setLabel("Color");

		int i=1;
		String msAccessDBName = "F:\\Work Environment\\MyProject\\AutomobileProject\\bin\\HONDA.MDB";
		/*String data="jdbc:odbc:Driver="
                + "{Microsoft Access Driver (*.mdb, *.accdb)};"
                + "DBQ=" 
				+ msAccessDBName
				+ ";DriverID=22;READONLY=true";*/
		String data = "jdbc:ucanaccess://F:\\Work Environment\\MyProject\\AutomobileProject\\HONDA.accdb";
		try
		{
			//Class.forName("jdbc:ucanaccess:HONDA");
			Connection conn = DriverManager.getConnection(data);
			Statement st = conn.createStatement();
			ResultSet rec = st.executeQuery("SELECT * FROM Billing");

			while(rec.next())
			{

				L[i][0].setText(rec.getString("Name"));
				L[i][1].setText(rec.getString("Address"));

				L[i][2].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][2].setText(rec.getString("Phone"));

				L[i][3].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][3].setText(rec.getString("BokDate"));

				L[i][4].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][4].setText(rec.getString("DelDate"));

				L[i][5].setText(rec.getString("ModelName"));
				L[i][6].setText(rec.getString("ModelColour"));


				i=i+1;
			}
			st.close();
		}
		catch(Exception e)
		{
			//System.out.println("ERROR");
		}

		show();

		MyWindow adapter = new MyWindow(this);
		        addWindowListener(adapter);

	}

	public static void main(String args[])
	{
		Bill B=new Bill();
		B.show();
		B.setBounds(1,1,800,600);
	}
		class MyWindow extends WindowAdapter
	         {
	            Bill menuFrame;
	            public MyWindow(Bill menuFrame)
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
		public void actionPerformed(ActionEvent ae)
		{
			setVisible(false);
			repaint();
		}
	}
}
