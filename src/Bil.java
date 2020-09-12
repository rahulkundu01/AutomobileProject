import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Bil extends JFrame
{
	Bil()
	{

		resize(800,500);
		setTitle("Bill");
		setBackground(Color.pink);
		setLayout(new GridLayout(25,11));
		JButton C[][]=new JButton[1][11];
		JLabel L[][]=new JLabel[25][11];
		for(int i=0;i<25;i++)
		{
			for(int j=0;j<11;j++)
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
		C[0][0].setLabel("Billno");
		C[0][1].setLabel("EngNo");
		C[0][2].setLabel("ChasisNo");
		C[0][3].setLabel("KeyNo");
		C[0][4].setLabel("BatNo");
		C[0][5].setLabel("Batcomp");
		C[0][6].setLabel("TyFno");
		C[0][7].setLabel("TyFComp");
		C[0][8].setLabel("TyRno");
		C[0][9].setLabel("TyRComp");
		C[0][10].setLabel("Ammount");


		int i=1;
		String data="jdbc:odbc:HONDA";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection(data,"","");
			Statement st = conn.createStatement();
			ResultSet rec = st.executeQuery("SELECT * FROM Billing");

			while(rec.next())
			{

				L[i][0].setText(rec.getString("Billno"));

				L[i][1].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][1].setText(rec.getString("Engineno"));

				L[i][2].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][2].setText(rec.getString("Chasisno"));

				L[i][3].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][3].setText(rec.getString("Keyno"));

				L[i][4].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][4].setText(rec.getString("Batteryno"));

				L[i][5].setText(rec.getString("Batterycomp"));

				L[i][6].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][6].setText(rec.getString("TyerFrno"));

				L[i][7].setText(rec.getString("TyerFrComp"));


				L[i][8].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				L[i][8].setText(rec.getString("TyerRrno"));

				L[i][9].setText(rec.getString("TyerRrComp"));

                L[i][10].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                L[i][10].setText(rec.getString("Ammount"));


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
		Bil B=new Bil();
		B.show();
		B.setBounds(1,30,900,600);
	}
		class MyWindow extends WindowAdapter
	         {
	            Bil menuFrame;
	            public MyWindow(Bil menuFrame)
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
