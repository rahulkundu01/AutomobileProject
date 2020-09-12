import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.sql.*;

public class Projectee extends Frame
 {
  Label NameL,NameM,ClassL,Collage,Collage2,Collage3,Guide;
  public Projectee()
   {
     setVisible(true);
     setTitle("About Projectee");
     setLayout(null);
     addWindowListener(new WindowHandler());
     //Color c1 = new Color(70,90,247);
     //setBackground(c1);
     setBackground(Color.GRAY);
     Font f1=new Font("Times new roman",Font.PLAIN,18);

     NameL    = new Label(" Name 	= RAHUL KUNDU");
     ClassL   = new Label(" Class 	= MCA-II , SEM - II ");
     Collage  = new Label(" Collage = S.P. COLLEGE");
     Collage2  = new Label("  GUNJ WARD,");
     Collage3  = new Label("  CHANDRAPUR.");
     Guide     = new Label(" Guide 	= Prof. P.B. DHUMNAE");

	 add(NameL);
     add(ClassL);
     add(Collage); add(Guide);
	 add(Collage2);add(Collage3);

	 NameL.setBounds  (250,80,250,20);
	 
	 ClassL.setBounds (250,130,250,20);
	 Collage.setBounds(250,150,250,20);
	 Collage2.setBounds(320,170,270,20);
	 Collage3.setBounds(320,190,240,20);
	 Guide.setBounds(250,221,270,20);

	 NameL.setFont(f1);
	
	 ClassL.setFont(f1);
	 Collage.setFont(f1);
	 Collage2.setFont(f1);
	 Collage3.setFont(f1);
	 Guide.setFont(f1);

	}
 
	public static void main(String arg[])
     {
	     Projectee P = new Projectee();
		 P.show();
		 P.setBounds(200,300,550,400);
		// pack();

	 }

	public void paint(Graphics g)
	    {
	     Image img1 = Toolkit.getDefaultToolkit().getImage("ZMR.jpg");
	     g.drawImage(img1, 0, 20, 250, 370, this);
	     
	     //Image img2 = Toolkit.getDefaultToolkit().getImage("4.jpg");
	     //g.drawImage(img2, 0, 0, 20, 30, this);
	    
	    }
	class WindowHandler extends WindowAdapter
    {
	    public void windowClosing(WindowEvent e)
	     {
			  setVisible(false);
	     }
    }


}