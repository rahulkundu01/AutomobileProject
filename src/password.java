import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.applet.*;
import java.sql.*;
import javax.swing.*;

public class password extends Frame
 {
  public  int num;
  TextField pass,name;
  Label passL,nameL,wrong,title; 
  Button Cancel,Test;

  public password()
   {
     //setVisible(false); 
     setTitle("AUTHANTICATION");
     setLayout(null);
     Color c1=new Color(80,190,247);
     setBackground(Color.gray);
     Font f=new Font("dialog",Font.BOLD,20);

     nameL = new Label("User Name");
     name = new TextField();
     passL = new Label("Password");
     pass = new TextField();
     Test = new Button("START");
	 Cancel = new Button("CANCEL");
	 wrong   = new Label("YOU  HAVE  ENTERED  WRONG  PASSWORD");
	 title  = new Label("AUTHANTICATION");

	 add(nameL);    add(name);
	 add(passL);    add(pass);
	 add(Test);     add(Cancel);
	 add(wrong);    add(title);

	 Test.addActionListener(new BT());
	 Cancel.addActionListener(new BT());

	 nameL.setBounds(30, 100, 100, 30);
	 name.setBounds(150,100,150,30);
	 passL.setBounds(30,140,100,30);
	 pass.setBounds(150,140,150,30);

	 Test.setBounds(80,200,80,30);
	 Cancel.setBounds(190,200,80,30);
	 pass.setEchoChar('*');
	 title.setBounds(35,50,200,30);
	 title.setFont(f);
	 MyWindow adapter = new MyWindow(this);
     addWindowListener(adapter);
     

   }
   
	public void paint(Graphics g)
	  		{

	  			Image img1 = Toolkit.getDefaultToolkit().getImage("sh.jpg"); 
	  			g.drawImage(img1, 310, 4, 300, 290, this);
	  			//Image img2 = Toolkit.getDefaultToolkit().getImage("011.jpg");
	  			//g.drawImage(img2, 0, 400, 150, 200, this);


	   		}
     class BT implements ActionListener
	     {
		 public void actionPerformed(ActionEvent e)
		   {
			    String arg = e.getActionCommand();
			    if(arg.equals("CANCEL"))
			     {
					setVisible(false);
			      }
			    else if(arg.equals("START"))
			      {
				   String a;
				   a=pass.getText();

				   if((pass.getText()).equals("HONDA")) 
				   {
					   Automobile T=new Automobile();
					   T.show();
					   T.setBounds(1,1,800,600);
				   }
				   else
				   {

					   wrong.setBounds(40,250,275,30);   

				   }
			     }

		  repaint();
		  setVisible(false);
		 }
	}
 public static void main(String arg[])
     {
		password T = new password();
		 T.show();
		 T.setBounds(200,150,600,300);
	  }
	  class MyWindow extends WindowAdapter
	           {
	              password menuFrame;
	              public MyWindow(password menuFrame)
	               {
	                  this.menuFrame=menuFrame;
	               }
	               public void windowClosing(WindowEvent we)
	               {
	  				 menuFrame.setVisible(false);
	  			 }

           }
}


