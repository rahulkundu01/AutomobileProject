import java.awt.event.*;
import java.awt.*;
import java.applet.*;
class Bikes extends Frame
{
	public Bikes()
    {
    	setTitle("Bikes");
    	setSize(700, 600);
      	setBackground(Color.gray); 
      	MyWindow adapter = new MyWindow(this);
        addWindowListener(adapter);
    }

    public static void main(String args[]) 
	{
		Bikes M = new Bikes();
		M.show();
		M.setBounds(40,10,710,550);

	}

	public void paint(Graphics g)
	{
		Image img1 = Toolkit.getDefaultToolkit().getImage("imagesBike/01.jpg");
	    Image img2 = Toolkit.getDefaultToolkit().getImage("imagesBike/02.jpg");
	    Image img3 = Toolkit.getDefaultToolkit().getImage("imagesBike/03.jpg");
	    Image img4 = Toolkit.getDefaultToolkit().getImage("imagesBike/04.jpg");
	    Image img5 = Toolkit.getDefaultToolkit().getImage("imagesBike/05.jpg");
	    Image img6 = Toolkit.getDefaultToolkit().getImage("imagesBike/06.jpg");
	    Image img7 = Toolkit.getDefaultToolkit().getImage("imagesBike/07.jpg");
	    Image img8 = Toolkit.getDefaultToolkit().getImage("imagesBike/08.jpg");
	    Image img9 = Toolkit.getDefaultToolkit().getImage("imagesBike/09.jpg");
	    Image img10 = Toolkit.getDefaultToolkit().getImage("imagesBike/10.jpg");
	    Image img11 = Toolkit.getDefaultToolkit().getImage("imagesBike/011.jpg");
	    g.drawImage(img1, 10, 40, 150, 150, this);
	    g.drawImage(img2, 180, 40, 150,150, this);
	    g.drawImage(img3, 360, 40, 150, 150, this);
	    g.drawImage(img4, 540,40, 150,150, this);
	    g.drawImage(img5, 10, 210, 150, 150, this);
	    g.drawImage(img11, 180, 210, 330, 150, this);
	    g.drawImage(img6, 540,210, 150,150, this);
	    g.drawImage(img7, 10,380, 150,150, this);
	    g.drawImage(img8, 180,380, 150,150, this);
	    g.drawImage(img9, 360,380, 150,150, this);
	    g.drawImage(img10, 540,380, 150,150, this);
	}
	class MyWindow extends WindowAdapter
         {
            Bikes menuFrame;
            public MyWindow(Bikes menuFrame)
             {
                this.menuFrame=menuFrame;
             }
      	    public void windowClosing(WindowEvent we)
       		 {
			   menuFrame.setVisible(false);
	   		 }
	   	 }
}
