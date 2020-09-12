import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MsgBox extends Frame
 {
  JLabel msg;
  JButton Ok,pic;
  public MsgBox(String str)
   {
     setVisible(true);
     setTitle("My Message Box");
     setLayout(null);
     //setBackground(Color.gray);
      Font F = new Font("Arial",Font.BOLD,30);
      setFont(F);

     msg = new JLabel(str);
     Ok  = new JButton("OK");
     ImageIcon IG = new ImageIcon("Help.jpg");
	 pic  = new JButton(IG);
	 add(msg);  add(pic);  add(Ok);
	 Ok.addActionListener(new BT());
	 pic.setBounds(30,40,60,60);
	 msg.setBounds(100,40,300,30);
	 Ok.setBounds(150,110,100,30);
   }


 public static void main(String arg[])
   {
	    MsgBox T = new MsgBox("Record Saved Successfully");
	    T.show();
	    T.setBounds(200,200,350,150);
   }

    class BT implements ActionListener
     {
		  public void actionPerformed(ActionEvent e)
		   {
			    String arg = e.getActionCommand();
			    if(arg.equals("OK"))
			     {
					setVisible(false);
			      }
	 	   }
	  }

}