import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.*;
public class monthReport extends Frame implements WindowListener,ActionListener
{
	 Button bexit;
	Panel p1,p2;

	GridBagLayout gbl;
	GridBagConstraints gbc;


	Connection con;
	PreparedStatement stat,stat1,s;
	Statement st;
	ResultSet rs;
static public JTable PackObj;
	static DefaultTableModel defTabModel;
JTextField tf1;
	public monthReport( )
		{
			super("ITEMS MONTHELY REPORT" );
			setBackground(Color.gray);
			 tf1=new JTextField(20);
			 





			String[] colnms={"Booking No","BookingDate","Name","Address","PhoneNo","Model","Color","Amount","DelivryDate"};
			Object [][] rowData={
					};
		defTabModel = new DefaultTableModel(rowData,colnms);
		PackObj = new JTable(defTabModel);
PackObj.setEnabled(false);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane sp=new JScrollPane(PackObj,v,h);
			sp.setPreferredSize(new Dimension(800,500));

			gbc=new GridBagConstraints();
			gbl=new GridBagLayout();
		    setLayout(gbl);
			gbc.gridx=0;
			gbc.gridy=1;
			gbl.setConstraints(tf1,gbc);
			add(tf1);
			tf1.addActionListener(this);
			gbc.gridx=0;
			gbc.gridy=2;
			gbl.setConstraints(sp,gbc);
			add(sp);




			bexit=new Button("Exit");
			gbc.gridx=0;
			gbc.gridy=3;
			gbl.setConstraints(bexit,gbc);
			add(bexit);
		 	addWindowListener(this);
			bexit.addActionListener(this);

			setVisible(true);
			setSize(900,700);
/*
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:vehicle");
				Statement s1=con.createStatement();
				ResultSet rs=s1.executeQuery("select * from vehicle");
				while(rs.next())
				{

					 		String str1=rs.getString(1);
							String str2=rs.getString(2);
							String str3=rs.getString(3);
							String str4=rs.getString(4);
							String str5=rs.getString(5);
							String str6=rs.getString(6);
							String str7=rs.getString(7);

 						Object	[] rowData1={ str1,str2,str3,str4,str5,str6,str7 };

							defTabModel.addRow(rowData1);
				}

			}catch(Exception e){System.out.println(e);}

*/


		}

		public void windowClosing(WindowEvent e)
		{
		 	setVisible(false);
		}
		public void windowOpened(WindowEvent e){ }
		public void windowClosed(WindowEvent e){ }
		public void windowActivated(WindowEvent e){ }
		public void windowDeactivated(WindowEvent e){ }
		public void windowIconified(WindowEvent e){ }
		public void windowDeiconified(WindowEvent e){ }
 
		public static void main(String args[])
		{
			new monthReport( );
		}
 
      	public void actionPerformed(ActionEvent ev)
		{
			if(ev.getSource()==tf1) 
			{
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
				Connection con=DriverManager.getConnection(data);
				Statement s1=con.createStatement();
				ResultSet rs=s1.executeQuery("select * from Booking where month(BookingDate) =  " + tf1.getText());
				while(rs.next())
				{

					 		String str1=rs.getString(1);
							String str2=rs.getString(2);
							String str3=rs.getString(3);
							String str4=rs.getString(4);
							String str5=rs.getString(5);
							String str6=rs.getString(6);
							String str7=rs.getString(7);
							String str8=rs.getString(8);
							String str9=rs.getString(9);
			

 						Object	[] rowData1={ str1,str2,str3,str4,str5,str6,str7,str8,str9 };

							defTabModel.addRow(rowData1);
				}

			}catch(Exception e){System.out.println(e);}
		
			}
	 		  if(ev.getSource()==bexit)
	 	 	{
	 			setVisible(false);
	 		//	new Automobile();
	 		}

	 }
}