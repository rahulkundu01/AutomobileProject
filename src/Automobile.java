import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class Automobile extends Frame //implements WindowListener, ActionListener
{
    String msg = " ";
    Menu M,E,B,S,ST,D,P,EX;
    MenuItem item11,item12,item13,item14,item15;
    MenuItem item21,item22,item23;
    MenuItem item31,item32,item33;
    MenuItem item41,item42,item43;
    MenuItem item51,item52,item53;
    MenuItem item61, item62,item63,item64,item65,item66,item67;
    MenuItem item71;
    MenuItem item81;

    Automobile()
     {
      setTitle("HERO SHOWROOM");
      MenuBar mbar=new MenuBar();
      setMenuBar(mbar);
      setBackground(Color.white);

      M = new Menu("Models");
      M.add(item11=new MenuItem("Bikes"));
      M.add(item12=new MenuItem("-"));
      M.add(item13=new MenuItem("Quotation"));
      M.add(item14=new MenuItem("-"));
      M.add(item15=new MenuItem("Quotation Entry"));
      mbar.add(M);

      E = new Menu("Enquiry");
      E.add(item21=new MenuItem("Customer Enquiry"));
      E.add(item22=new MenuItem("-"));
      E.add(item23=new MenuItem("Customer Enquiry List"));
      mbar.add(E);

      B = new Menu("Booking");
	  B.add(item31=new MenuItem("Booking"));
	  B.add(item32=new MenuItem("-"));
	  B.add(item33=new MenuItem("BookList"));
      mbar.add(B);

      S = new Menu("Billing");
	  S.add(item41=new MenuItem("Bill Entry"));
	  S.add(item42=new MenuItem("-"));
	  S.add(item43=new MenuItem("Bill"));
      mbar.add(S);

      ST = new Menu("Stock");
	  ST.add(item51=new MenuItem("Stock Entry"));
	  ST.add(item52=new MenuItem("-"));
	  ST.add(item53=new MenuItem("Stock Position"));
      mbar.add(ST);

	  D = new Menu("Report");
  	  D.add(item61=new MenuItem("Daily Report"));
  	  D.add(item62=new MenuItem("-"));
  	  D.add(item63=new MenuItem("Monthely Report"));
  	  D.add(item64=new MenuItem("-"));
  	  D.add(item65=new MenuItem("Yearly Report"));
  	 // D.add(item66=new MenuItem("-"));
  	  //D.add(item67=new MenuItem("Report By Specific Date"));
  	  mbar.add(D);
  	  

  	  P = new Menu("Projectee");
  	  P.add(item71=new MenuItem("About Projectee"));
  	  mbar.add(P);

  	  EX = new Menu("Exit");
  	  EX.add(item81=new MenuItem("Exit"));
  	  mbar.add(EX); 
      
      
	  //item11.setMnemonic('B');
      //item11.setToolTipText("Various Bikes and Showroom");
	
      MyMenuHandler handler=new MyMenuHandler(this);
      item11.addActionListener(handler);
      item13.addActionListener(handler);
      item15.addActionListener(handler);
      item21.addActionListener(handler);
      item23.addActionListener(handler);
      item31.addActionListener(handler);
      item33.addActionListener(handler); 
      item41.addActionListener(handler);
      item43.addActionListener(handler);
      item51.addActionListener(handler);
      item53.addActionListener(handler);
      item61.addActionListener(handler);
      item63.addActionListener(handler);
      item65.addActionListener(handler);
      //item67.addActionListener(handler);
      item71.addActionListener(handler);
      item81.addActionListener(handler);

      MyWindow adapter = new MyWindow(this);
      addWindowListener(adapter);
      }

    public static void main(String arg[])
     {
		 Automobile A = new Automobile();
		 A.show();
		 A.setBounds(1,1,800,600);
	  }

    public void paint(Graphics g)
	  		{

	  			Image img1 = Toolkit.getDefaultToolkit().getImage("imagesBike/image1.png"); 
	  			g.drawImage(img1, 0, 42, 800, 600, this);
	  			//Image img2 = Toolkit.getDefaultToolkit().getImage("011.jpg");
	  			//g.drawImage(img2, 0, 400, 150, 200, this);


	   		}


    class MyWindow extends WindowAdapter
         {
            Automobile menuFrame;
            public MyWindow(Automobile menuFrame)
             {
                this.menuFrame=menuFrame;
             }
      	    public void windowClosing(WindowEvent we)
       		 {
			   menuFrame.setVisible(false);
	   		 }
	   	 }

      class MyMenuHandler implements ActionListener,ItemListener
        {
                Automobile menuFrame;
                public MyMenuHandler(Automobile menuFrame)
                 {
                   this.menuFrame=menuFrame;
                 }

                 public void actionPerformed(ActionEvent ae)
                 {
                   String arg=(String)ae.getActionCommand();
                   if(arg.equals("Quotation"))
                     {
						 	Quotation Q = new Quotation();
				 		 	Q.show();
				 		 	Q.setTitle("Quotation");
		 				 	Q.setBounds(100,100,600,450);
					 }
				   else if(arg.equals("Bikes"))
					 {
						 	Bikes M = new Bikes();
						 	M.show();
						 	M.setBounds(45,10,710,550);
					 }
			       else if(arg.equals("Quotation Entry"))
			         {

					 		QuotationEntry E;
					 		E=new QuotationEntry();
					 		E.show();
					 		E.setBounds(200,100,400,450);

	                 }
	                else if(arg.equals("Booking"))
	                 {

					 		Booking B;
					 		B=new Booking();
					 		B.show();
					 		B.setBounds(200,50,400,450);

			         }
			        else if(arg.equals("BookList"))
			         {
			         		BookList L=new BookList();
					 		L.show();
							L.setBounds(25,50,750,500);
                     }
                    else if(arg.equals("Customer Enquiry"))
                     {

					 		CEnquiry E;
					 		E=new CEnquiry();
					 		E.show();
					 		E.setBounds(200,50,400,450);

	                 }
	                else if(arg.equals("Customer Enquiry List"))
	                 {

					 		CEnqList L=new CEnqList();
					 		L.show();
					 		L.setBounds(100,100,600,400);

	                 }
	                else if(arg.equals("Bill Entry"))
	                 {

					 		BillEntry B;
					 		B=new BillEntry();
					 		B.show();
					 		B.setBounds(50,50,700,500);

	                 }
	                else if(arg.equals("Bill"))
	                 {
					 		Bill B=new Bill();
					 		B.show();
					 		B.setBounds(1,1,800,600);
					 		Bil T=new Bil();
							T.show();
							T.setBounds(1,30,800,600);
					 }
	                else if(arg.equals("Stock Entry"))
	                 {

					 		StockEntry E;
					 		E=new StockEntry();
					 		E.show();
					 		E.setBounds(200,50,400,400);

	                 }
	                else if(arg.equals("Stock Position"))
	                 {
					 		StockPosition P=new StockPosition(); 
					 		P.show();
					 		P.setBounds(100,100,600,450);
	                 }
	                else if(arg.equals("About Projectee")) 
	                 {
					 	    Projectee P = new Projectee();
					 		P.show();
					 		P.setBounds(200,300,550,400);
	 				 }
					else if(arg.equals("Daily Report"))
	                 	{
	 				 		dayReport T = new dayReport();
					 	    T.show();
	    					T.setBounds(10,10,900,700);
				 		}
				 	else if(arg.equals("Monthely Report"))
	                 	{
	 				 		monthReport MR = new monthReport();
					 	    MR.show();
	    					MR.setBounds(10,10,900,700);
				 		}
				 /*	else if(arg.equals("Report By Specific Date"))
	                 	{
	 				 		Master MT = new Master();
					 	    MT.show();
	    					MT.setBounds(100,50,300,300);
				 		}*/
				 	else if(arg.equals("Yearly Report"))
	                 	{
	 				 		yearReport YR = new yearReport();
					 	    YR.show();
	    					YR.setBounds(10,10,900,700);
				 		}
	 				else if(arg.equals("Exit"))
				     {
				       System.exit(1);
					 }
                   menuFrame.msg=msg;
                   menuFrame.repaint();
        }
    public void itemStateChanged(ItemEvent ie)
      {
       menuFrame.repaint();
      }
    }
}
