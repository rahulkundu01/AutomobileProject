import javax.swing.*;
import java.awt.*;
class  ValidateData
{
	public static void checkNumber(JTextField t1)
	{
		try
		{
			double n1 = Double.parseDouble(t1.getText());

			if(n1 < 0)
			{
						JOptionPane.showMessageDialog(null,"The Value can't be less than 0","User Information Window",JOptionPane.INFORMATION_MESSAGE);
						t1.setText("");
						return;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Please Enter Only Numbers ","User Information Window",JOptionPane.INFORMATION_MESSAGE);
			t1.setText("");
			return;
		}
	}

	public static void checkLength(String str,String control)
	{
		if(str.length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Enter "+ control,"User Information Window",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	public static void checkPhoneNo(JTextField t1,String control)
	{
		String str = t1.getText();
		if(str.length()>10)
		{
			JOptionPane.showMessageDialog(null,"Please Enter Valid "+ control,"User Information Window",JOptionPane.INFORMATION_MESSAGE);
			t1.setText("");
			return;
		}
	}

	public static void checkName(JTextField t1)
	{
		String str = t1.getText();

		char num[]={'0','1','2','3','4','5','6','7','8','9'};

		for(int i=0; i<10;i++)
		{
			if(str.indexOf(num[i]) != -1)
			{
				JOptionPane.showMessageDialog(null,"Please Enter Only Characters ","User Information Window",JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
				break;
			}
		}
	}
}