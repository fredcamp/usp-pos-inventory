package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class Cashier1 extends JFrame{
	/**
		 *
		 */
	private static final long serialVersionUID = -9204190981417201327L;
	private JButton LogIn;
private JButton Quit;
private JLabel Username;
private JLabel Password;
private JTextField fname;
private JPasswordField fpass;
private ImageIcon header;
private JLabel hlabel;
private static final int w = 100, l = 25;

public Cashier1(){
	setIconImage(new ImageIcon("Cashier/images/icon.png").getImage());
	setSize(1001,700);
	LogIn=new JButton("Log-in");
	Quit=new JButton("Quit");
	Username=new JLabel("Username:");
	Password=new JLabel("Password:");
	fname=new JTextField(20);
	fpass=new JPasswordField(20);
	fpass.setEchoChar('*');
	
	Container cont=getContentPane();
	cont.setLayout(new BorderLayout());
	setTitle("Welcome to CashBook");
	JPanel panel=new JPanel();
	panel.setLayout(new BorderLayout());
	cont.add(panel,"East");
	panel.setBorder(new EmptyBorder(15,25,10,25));

	
	FlowLayout layout=new FlowLayout();
	JPanel pane3 = new JPanel();
	JPanel pane4 = new JPanel();
	panel.add(pane3, "North");
	pane3.setLayout(layout);
	pane4.setLayout(layout);
	pane3.add(Username);
	panel.add(pane4, "Center");
	Username.setBounds(5, 5, 100, 100);
	Username.setPreferredSize(new Dimension(w, l));
	pane3.add(fname);
	pane4.add(Password);
	Password.setBounds(5, 5, 100, 100);
	Password.setPreferredSize(new Dimension(w, l));
	pane4.add(fpass);
	
	JPanel panel2=new JPanel();
	panel.add(panel2,"South");
	
	FlowLayout layout2=new FlowLayout();
	panel2.setLayout(layout2);
	ButtonHandler hand=new ButtonHandler();
	ImageIcon login = new ImageIcon("Cashier/images//login.png");
	Font font = new Font("Sans serif",Font.BOLD,12);
	LogIn.setFont(font);
	LogIn.setVerticalTextPosition(SwingConstants.CENTER);
	LogIn.setHorizontalTextPosition(SwingConstants.CENTER);
	LogIn.setMargin(new Insets(0,0,0,0));
	LogIn.setPreferredSize(new Dimension(93,22));
	LogIn.setIcon(login);
	panel2.add(LogIn);
	LogIn.setMnemonic('\n');
	LogIn.addActionListener(hand);
	Quit.setFont(font);
	Quit.setVerticalTextPosition(SwingConstants.CENTER);
	Quit.setHorizontalTextPosition(SwingConstants.CENTER);
	Quit.setMargin(new Insets(20,20,20,20));
	Quit.setPreferredSize(new Dimension(93,22));
	Quit.setIcon(login);
	panel2.add(Quit);
	Quit.addActionListener(hand);
	
	String imgstr = "Cashier/images//header.png";

	header = new ImageIcon(imgstr);
	hlabel = new JLabel(header);
	cont.add(hlabel, "North");
	
	JPanel g = new JPanel();
	g.setBorder(new EmptyBorder(15,25,10,25));
	g.setLayout(new BorderLayout());
	cont.add(g, "Center");
	ImageIcon logo = new ImageIcon("Cashier/images//book.png");
	JLabel logolabel = new JLabel(logo);
	g.add(logolabel, "Center");
	JLabel h = new JLabel("  CashBook helps you calculate and record sales transactions.");
	h.setFont(new Font("Sans Serif", Font.BOLD, 18));
	h.setPreferredSize(new Dimension(100, 25));
	g.add(h,"North");

}
class ButtonHandler implements ActionListener{
public void actionPerformed(ActionEvent f){
String source = f.getActionCommand();

if(source.equals("Log-in")){
	
try{
	
	String line, word1, word2;
	
	FileReader fr = new FileReader("Cashier/account.txt");
	BufferedReader bw = new BufferedReader(fr);
	StringTokenizer token;
	while((line=bw.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	String fpasstemp = new String(fpass.getPassword());
	if (fname.getText().equals(word1)&&fpasstemp.equals(word2)){
			setVisible(false);
			Menu menu=new Menu();
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int w = menu.getSize().width;
			int h = menu.getSize().height;
			int x = (dim.width-w)/2;
			int y = (dim.height-h)/2;
			menu.setBounds(x, y, w, h ); 
			menu.setResizable(false);
			menu.setVisible(true);
		}
		
	}
	}
	


catch(Exception o){
}
}
else if(source.equals("Quit")){
System.exit(0);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
}
public static void main(String[]args){
Cashier1 fred=new Cashier1();
fred.pack();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = fred.getSize().width;
int h = fred.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
fred.setBounds(x, y, w, h ); 
fred.setResizable(false);
fred.setVisible(true);
}
}