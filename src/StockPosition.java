import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class StockPosition extends JFrame
{
	StockPosition()
	{
		resize(600,500);
		setTitle("Stock Position");
		setBackground(Color.pink);
		setLayout(new GridLayout(25,4));
		JButton C[][]=new JButton[1][4];
		JLabel L[][]=new JLabel[25][4];
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<4;j++)
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
		C[0][0].setLabel("Sr.No");
		C[0][1].setLabel("Name");
		C[0][2].setLabel("Color");
		C[0][3].setLabel("Avl.Qty");


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
			//Class.forName("oracle.jdbc.driver.OracleDrive");
			Connection conn = DriverManager.getConnection(data);
			Statement st = conn.createStatement();
			ResultSet rec = st.executeQuery("SELECT * FROM Stock");

			while(rec.next())
			{
				L[i][0].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][0].setText(rec.getString("Sr"));

				L[i][1].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][1].setText(rec.getString("ModelName"));

				L[i][2].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][2].setText(rec.getString("Colour"));

				L[i][3].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][3].setText(rec.getString("AvailQty"));


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
            StockPosition menuFrame;
            public MyWindow(StockPosition menuFrame)
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
		StockPosition P=new StockPosition();
		P.show();
		P.setBounds(100,100,600,400);
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
