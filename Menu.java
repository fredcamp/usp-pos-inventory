package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Menu extends JFrame{
    /**
    	 *
    	 */
    private static final long serialVersionUID = -2877992316458537954L;
    private GridBagConstraints constraints;
private JButton Account;
private JButton Product;
private JButton POS;
private JButton query;
private JButton Exit;
private ImageIcon header1;
private JLabel hlabel1;
private JComboBox c1;
private JComboBox c2;
private ComboHandler combo;
private ButtonHandler button;

public Menu(){
Cashier1 a =new Cashier1();
setIconImage(new ImageIcon("Cashier/images/icon.png").getImage());
setSize(1001,385);
setTitle("Cashbook");
constraints=new GridBagConstraints();
Account=new JButton("Account");
Product=new JButton("Product");
POS=new JButton("POS");
query=new JButton("Query");
Exit=new JButton("Exit");

Container ner=getContentPane();
ner.setLayout(new BorderLayout());
String head= "Cashier/images/header.png";
combo=new ComboHandler();
String s[]={"Select Here","Add an account","Delete an account","Edit an account"};
String s1[]={"Select Here","Add a product","Delete a product","Edit a product"};
c1=new JComboBox(s);
c1.setPreferredSize(new Dimension(110,30));
c1.addActionListener(combo);

c2=new JComboBox(s1);
c2.setPreferredSize(new Dimension(110,30));
c2.addActionListener(combo);

header1=new ImageIcon(head);
hlabel1=new JLabel(header1);
ner.add(hlabel1,"North");

JPanel nel2=new JPanel();
ner.add(nel2,"Center");
	
GridBagLayout gridbag=new GridBagLayout();
nel2.setLayout(gridbag);
nel2.setBorder(new EmptyBorder(0,25,0,25));
ImageIcon login1 = new ImageIcon("Cashier/images/login2.png");
Font font1 = new Font("Sans serif",Font.BOLD,12);

button=new ButtonHandler();

Account.setFont(font1);
Account.setVerticalTextPosition(SwingConstants.CENTER);
Account.setHorizontalTextPosition(SwingConstants.CENTER);
Account.setPreferredSize(new Dimension(110,30));
Account.setIcon(login1);
constraints.gridy=0;
constraints.gridx=0;
constraints.gridheight=2;
constraints.insets=new Insets(10,10,0,10);
gridbag.setConstraints(Account,constraints);
nel2.add(Account);

Product.setFont(font1);
Product.setVerticalTextPosition(SwingConstants.CENTER);
Product.setHorizontalTextPosition(SwingConstants.CENTER);
Product.setPreferredSize(new Dimension(110,30));
Product.setIcon(login1);
constraints.gridy=0;
constraints.gridx=1;
constraints.gridheight=2;
constraints.insets=new Insets(10,10,0,10);
gridbag.setConstraints(Product,constraints);
nel2.add(Product);

POS.setFont(font1);
POS.setVerticalTextPosition(SwingConstants.CENTER);
POS.setHorizontalTextPosition(SwingConstants.CENTER);
POS.setPreferredSize(new Dimension(110,30));
POS.setIcon(login1);
constraints.gridy=0;
constraints.gridx=2;
constraints.gridheight=2;
constraints.insets=new Insets(10,10,0,10);
gridbag.setConstraints(POS,constraints);
nel2.add(POS);
POS.addActionListener(button);

query.setFont(font1);
query.setVerticalTextPosition(SwingConstants.CENTER);
query.setHorizontalTextPosition(SwingConstants.CENTER);
query.setPreferredSize(new Dimension(110,30));
query.setIcon(login1);
constraints.gridy=0;
constraints.gridx=3;
constraints.gridheight=2;
constraints.insets=new Insets(10,10,0,10);
gridbag.setConstraints(query,constraints);
nel2.add(query);
query.addActionListener(button);

Exit.setFont(font1);
Exit.setVerticalTextPosition(SwingConstants.CENTER);
Exit.setHorizontalTextPosition(SwingConstants.CENTER);
Exit.setPreferredSize(new Dimension(110,30));
Exit.setIcon(login1);
constraints.gridy=0;
constraints.gridx=4;
constraints.gridheight=2;
constraints.insets=new Insets(10,10,0,10);
gridbag.setConstraints(Exit,constraints);
nel2.add(Exit);
Exit.addActionListener(button);

c1.setPreferredSize(new Dimension(110,30));
constraints.gridy=2;
constraints.gridx=0;
constraints.gridheight=2;
constraints.insets=new Insets(0,10,10,10);
gridbag.setConstraints(c1,constraints);
nel2.add(c1);

c2.setPreferredSize(new Dimension(110,30));
constraints.gridy=2;
constraints.gridx=1;
constraints.gridheight=2;
constraints.insets=new Insets(0,10,10,10);
gridbag.setConstraints(c2,constraints);
nel2.add(c2);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
class ComboHandler implements ActionListener{
public void actionPerformed(ActionEvent f){
JComboBox source = (JComboBox) f.getSource();
String item = (String) source.getSelectedItem();
if(item=="Add an account"){
AddAnAccount add=new AddAnAccount();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = add.getSize().width;
int h = add.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
add.setBounds(x, y, w, h );
add.setResizable(false); 
add.setVisible(true);
}
else if(item=="Delete an account"){
DeleteAnAccount del=new DeleteAnAccount();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = del.getSize().width;
int h = del.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
del.setBounds(x, y, w, h ); 
del.setResizable(false);
del.setVisible(true);
}
else if(item=="Edit an account"){
EditAnAccount edit=new EditAnAccount();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = edit.getSize().width;
int h = edit.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
edit.setBounds(x, y, w, h ); 
edit.setResizable(false);
edit.setVisible(true);
}
else if(item=="Add a product"){
AddAProduct add1=new AddAProduct();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = add1.getSize().width;
int h = add1.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
add1.setBounds(x, y, w, h ); 
add1.setResizable(false);
add1.setVisible(true);
}
else if(item=="Delete a product"){
DeleteAProduct del1=new DeleteAProduct();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = del1.getSize().width;
int h = del1.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
del1.setBounds(x, y, w, h ); 
del1.setResizable(false);
del1.setVisible(true);
}
else if(item=="Edit a product"){
EditAProduct edit1=new EditAProduct();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = edit1.getSize().width;
int h = edit1.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
edit1.setBounds(x, y, w, h ); 
edit1.setResizable(false);
edit1.setVisible(true);
}
}
}
class ButtonHandler implements ActionListener{
public void actionPerformed(ActionEvent j){
String item2=j.getActionCommand();
if(item2.equals("POS")){
POS pos=new POS();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = pos.getSize().width;
int h = pos.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
pos.setBounds(x, y, w, h ); 
pos.setResizable(false);
pos.setVisible(true);
}
else if(item2.equals("Query")){
Query1 query=new Query1();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = query.getSize().width;
int h = query.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
query.setBounds(x, y, w, h ); 
query.setResizable(false);
query.setVisible(true);
}
else if(item2.equals("Exit")){
System.exit(0);
}
}
}
}