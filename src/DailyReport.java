import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class DailyReport extends JFrame
{
	String str11;
	DailyReport(String str)
	{
		str11 = str;
		resize(750,500);
		setTitle("Booking List");
		setBackground(Color.pink);
		setLayout(new GridLayout(25,9));
		JButton C[][]=new JButton[1][9];
		JLabel L[][]=new JLabel[25][9];
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<9;j++)
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
		C[0][0].setLabel("BookingNo");
		C[0][1].setLabel("Book_Date");
		C[0][2].setLabel("Name");
		C[0][3].setLabel("Address");
		C[0][4].setLabel("PhoneNo");
		C[0][5].setLabel("ModelName");
		C[0][6].setLabel("Color");
		C[0][7].setLabel("Amount");
		C[0][8].setLabel("Delever");

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
			ResultSet rec = st.executeQuery("SELECT * FROM Booking");
			while(rec.next())
			{
				String ddtt = rec.getString("BookingDate");
				if(ddtt.equals(str11))
				 {
			  	  L[i][0].setText(rec.getString("BookingNo"));
				  L[i][1].setText(ddtt);
				  L[i][2].setText(rec.getString("Name"));
				  L[i][3].setText(rec.getString("Address"));
				  L[i][4].setText(rec.getString("PhoneNo"));
				  L[i][5].setText(rec.getString("ModelName"));
				  L[i][6].setText(rec.getString("ModelColour"));
				  L[i][7].setText(rec.getString("Amt"));
				  L[i][8].setText(rec.getString("DeliveryDate"));
				  i=i+1;
			   }
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
            DailyReport menuFrame;
            public MyWindow(DailyReport menuFrame)
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
		DailyReport L11=new DailyReport("");
		L11.show();
		L11.setBounds(25,50,750,500);
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
