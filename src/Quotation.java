import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Quotation extends JFrame
{
	Quotation()
	{

		resize(600,500);
		setTitle("Quotation");
		setBackground(Color.pink);
		setLayout(new GridLayout(25,6));
		JButton C[][]=new JButton[1][6];
		JLabel L[][]=new JLabel[25][6];
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<6;j++)
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
		C[0][0].setLabel("Model");
		C[0][1].setLabel("Showroom Cost");
		C[0][2].setLabel("Inssurance Tax");
		C[0][3].setLabel("RTO Tax");
		C[0][4].setLabel("Registration Tax");
		//C[0][6].setLabel("Accessories");
		C[0][5].setLabel("Total Cost");


		int i=1;
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
			ResultSet rec = st.executeQuery("SELECT * FROM Quotation");

			while(rec.next())
			{
				L[i][0].setText(rec.getString("Models"));

				L[i][1].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][1].setText(rec.getString("ShowCost"));

				L[i][2].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][2].setText(rec.getString("InsAmt"));

				L[i][3].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][3].setText(rec.getString("RTO"));

				L[i][4].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][4].setText(rec.getString("RegCharg"));

				//L[i][5].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				//L[i][5].setText(rec.getString("Access"));

				L[i][5].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][5].setText(rec.getString("TotalCost"));


				i=i+1;
			}
			st.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}

		show();


		MyWindow adapter = new MyWindow(this);
		        addWindowListener(adapter);

	}
	class MyWindow extends WindowAdapter
         {
            Quotation menuFrame;
            public MyWindow(Quotation menuFrame)
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
		Quotation Q=new Quotation();
		Q.show();
		Q.setBounds(100,100,600,400);
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
