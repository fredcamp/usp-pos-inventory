package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;

public class AddAnAccount extends JFrame {
	/**
		 *
		 */
	private static final long serialVersionUID = -7202764255070326337L;
	private JLabel Username;
private JTextField fname;
private JLabel Password;
private JPasswordField fpass;
private JLabel Finame;
private JTextField fFiname;
private JLabel Laname;
private JTextField fLaname;
private JButton OK;
private JButton Clear;
private JButton Cancel;
private ImageIcon header;
private JLabel hlabel;


public AddAnAccount(){
setIconImage(new ImageIcon("Cashier/images/icon.png").getImage());
setSize(1001,385);
setTitle("Add an account");

ImageIcon login = new ImageIcon("Cashier/images/login2.png");
Font font = new Font("Sans serif",Font.BOLD,12);

Username=new JLabel("Username:");
Username.setFont(font);
fname=new JTextField(20);
Password=new JLabel("Password:");
Password.setFont(font);
fpass=new JPasswordField(20);
fpass.setEchoChar('*');
Finame=new JLabel("First Name:");
Finame.setFont(font);
fFiname=new JTextField(20);
Laname=new JLabel("Last Name:");
Laname.setFont(font);
fLaname=new JTextField(20);
OK=new JButton("OK");
Clear=new JButton("Clear");
Cancel=new JButton("Cancel");

Container cont=getContentPane();
cont.setLayout(new BorderLayout());

String head= "Cashier/images/header.png";
header=new ImageIcon(head);
hlabel=new JLabel(header);
cont.add(hlabel,"North");

JPanel panel=new JPanel();
cont.add(panel,"Center");

GridLayout layout=new GridLayout(4,4);
panel.setLayout(layout);
panel.setBorder(new EmptyBorder(15,25,10,25));

panel.add(Username);
panel.add(fname);
panel.add(Password);
panel.add(fpass);
panel.add(Finame);
panel.add(fFiname);
panel.add(Laname);
panel.add(fLaname);

JPanel panel2=new JPanel();
cont.add(panel2,"South");

AddHandler hand2=new AddHandler();
FlowLayout layout2=new FlowLayout();
panel2.setLayout(layout2);

OK.setFont(font);
OK.setVerticalTextPosition(SwingConstants.CENTER);
OK.setHorizontalTextPosition(SwingConstants.CENTER);
OK.setPreferredSize(new Dimension(110,30));
OK.setIcon(login);
panel2.add(OK);
OK.setMnemonic('\n');
OK.addActionListener(hand2);

Clear.setFont(font);
Clear.setVerticalTextPosition(SwingConstants.CENTER);
Clear.setHorizontalTextPosition(SwingConstants.CENTER);
Clear.setPreferredSize(new Dimension(110,30));
Clear.setIcon(login);
panel2.add(Clear);
Clear.addActionListener(hand2);

Cancel.setFont(font);
Cancel.setVerticalTextPosition(SwingConstants.CENTER);
Cancel.setHorizontalTextPosition(SwingConstants.CENTER);
Cancel.setPreferredSize(new Dimension(110,30));
Cancel.setIcon(login);
panel2.add(Cancel);
Cancel.addActionListener(hand2);
}
class AddHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		String actionCommand2=e.getActionCommand();
			if(actionCommand2.equals("OK"))
{
	String str, str1, str2, str3;
		str = fname.getText();
		str1 = new String(fpass.getPassword());
		str2 = fFiname.getText();
		str3 = fLaname.getText();
	if(str.trim().length() == 0 || str1.trim().length() == 0 || str2.trim().length() == 0){
			JOptionPane.showMessageDialog(null, "Please fill out all the text boxes.");
	}
	else
		
	try{
		
		FileWriter bw = new FileWriter("Cashier/account.txt", true);
		BufferedWriter fw = new BufferedWriter(bw);
			fw.write(str);
			fw.write(" "+str1);
			fw.write(" "+str2);
			fw.write(" "+str3);
			fw.newLine();
			fw.close();
		JOptionPane.showMessageDialog(null,"Account has been successfully added!","Account",JOptionPane.INFORMATION_MESSAGE);
	}
	catch(IOException o){

	}
	catch(Exception p){
	}
	}
else if(actionCommand2.equals("Clear")){
	fname.setText("");
	fpass.setText("");
	fFiname.setText("");
	fLaname.setText("");
}
else if(actionCommand2.equals("Cancel")){
	setVisible(false);
}
}
}
}