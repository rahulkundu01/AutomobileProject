import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Master extends JFrame
 {
  TextField T1;
  JButton QCancel,QAdd;
  Label L7,L8;
  public Master()
   {
     setVisible(true);
     setTitle("Master Entry");
     setLayout(null);

     T1 = new TextField();
     L7 = new Label("Display the Record for the Given Date");
     L8 = new Label("Enter Date dd/mm/yy");
	 add(T1);  add(L7); add(L8);
	 L7.setBounds(30,60,260,25);
	 T1.setBounds(150,100,100,25);
	 L8.setBounds(30,100,150,25);

	 QCancel = new JButton("CANCEL");
	 QAdd = new JButton("OK");
	 add(QCancel); add(QAdd);
	 QCancel.setBounds(60,150,80,30);
	 QAdd.setBounds(160,150,80,30);
	 QAdd.addActionListener(new BT());
	 QCancel.addActionListener(new BT());


	 MyWindow adapter = new MyWindow(this);
	         addWindowListener(adapter);

}
	class MyWindow extends WindowAdapter
         {
            Master menuFrame;
            public MyWindow(Master menuFrame)
             {
                this.menuFrame=menuFrame;
             }
      	    public void windowClosing(WindowEvent we)
       		 {
			   menuFrame.setVisible(false);
	   		 }
	   	 }

 public static void main(String arg[])
   {
	    Master T = new Master();
	    T.show();
	    T.setBounds(100,50,300,300);
   }

   class BT implements ActionListener
     {
		  public void actionPerformed(ActionEvent e)
		   {
		     String arg = e.getActionCommand();
		     if(arg.equals("OK"))
		      {
			       	setVisible(false);
				  	String str = T1.getText();
				  	DailyReport L=new DailyReport(str);
			  		L.show();
					L.setBounds(25,50,750,500);
			   }
		   else if(arg.equals("CANCEL"))
		     {
				setVisible(false);
		      }
		   repaint();
		 }
	}
}

