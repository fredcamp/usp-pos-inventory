package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class POS extends JFrame{
	/**
		 *
		 */
	private static final long serialVersionUID = 1153065951121720383L;
	private Double total = 0.00, change = 0.00, change1 = 0.00, amount = 0.00, custom = 0.00, price = 0.00,
			price1 = 0.00, quantity = 1.00;
private String line, word1, word2,word3,word4,fword="",Smoney,Stotal,Sprice;
private ImageIcon header;
private JLabel hlabel;
private JLabel PosCode;
private JTextField fPosCode;
private JLabel PosName;
private JTextField fPosName;
private JLabel PosQuant;
private JTextField fPosQuant;
private JButton OK;
private JButton Clear;
private JButton Cancel;
private JTextArea area;
private JLabel Total;
private JTextField fTotal;
private JLabel Change;
private JTextField fChange;
private JLabel echos;
private JLabel echos1;
private JLabel Money;
private JTextField fMoney;
private String str;
private String proname="",proprice="",proquant="",procode="";

public POS(){
setIconImage(new ImageIcon("Cashier/images/icon.png").getImage());
setSize(670,520);
setTitle("POS");

ImageIcon login = new ImageIcon("Cashier/images/login2.png");
Font font = new Font("Sans serif",Font.BOLD,12);

Money=new JLabel("Enter Customers Money:");
fMoney=new JTextField(20);
PosCode=new JLabel("Product Code:");
PosCode.setFont(font);
fPosCode=new JTextField(20);
PosName=new JLabel("Product Name:");
PosName.setFont(font);
fPosName=new JTextField(20);
PosQuant=new JLabel("Quantity:");
PosQuant.setFont(font);
fPosQuant=new JTextField(3);
fPosQuant.setText("1");
OK=new JButton("OK");
Clear=new JButton("Clear");
Cancel=new JButton("Cancel");
area=new JTextArea(17,25);
area.setText("Name of Product"+"\r\t\t"+"Product Code"+"\r\t\t\t"+"Price");
area.setFont(font);
area.setEditable(false);
Total=new JLabel("TOTAL:");
fTotal=new JTextField(20);
fTotal.setEditable(false);
Change=new JLabel("CHANGE:");
fChange=new JTextField(20);
fChange.setEditable(false);
echos=new JLabel("");
echos1=new JLabel("");

Container ner=getContentPane();
ner.setLayout(new BorderLayout());

JPanel textPanel=new JPanel();

String head= "Cashier/images/logo.png";
header=new ImageIcon(head);
hlabel=new JLabel(header);

JPanel panel=new JPanel();
ner.add(panel,"North");
panel.add(hlabel,"West");

JPanel Ipanel=new JPanel();
BorderLayout bord=new BorderLayout();
panel.add(Ipanel,"Center");
Ipanel.setLayout(bord);
Ipanel.setBorder(new EmptyBorder(15,25,10,25));

PosHandler hand=new PosHandler();
JPanel IIIpanel=new JPanel();
FlowLayout flow=new FlowLayout();
Ipanel.add(IIIpanel,"South");
IIIpanel.setLayout(flow);
OK.setFont(font);
OK.setVerticalTextPosition(SwingConstants.CENTER);
OK.setHorizontalTextPosition(SwingConstants.CENTER);
OK.setPreferredSize(new Dimension(98,25));
OK.setIcon(login);
IIIpanel.add(OK);
OK.setMnemonic('\n');
OK.setToolTipText("Click to add this product");
OK.addActionListener(hand);

Clear.setFont(font);
Clear.setVerticalTextPosition(SwingConstants.CENTER);
Clear.setHorizontalTextPosition(SwingConstants.CENTER);
Clear.setPreferredSize(new Dimension(98,25));
Clear.setIcon(login);
IIIpanel.add(Clear);
Clear.setToolTipText("Clear");
Clear.setMnemonic('\b');
Clear.addActionListener(hand);

Cancel.setFont(font);
Cancel.setVerticalTextPosition(SwingConstants.CENTER);
Cancel.setHorizontalTextPosition(SwingConstants.CENTER);
Cancel.setPreferredSize(new Dimension(98,25));
Cancel.setIcon(login);
IIIpanel.add(Cancel);
Cancel.setToolTipText("Cancel");
Cancel.addActionListener(hand);

JPanel IIpanel=new JPanel();
GridLayout grid=new GridLayout(4,2);
Ipanel.add(IIpanel,"Center");
IIpanel.setLayout(grid);
IIpanel.add(PosName);
IIpanel.add(fPosName);
IIpanel.add(PosCode);
IIpanel.add(fPosCode);
IIpanel.add(PosQuant);
IIpanel.add(fPosQuant);
IIpanel.add(Money);
IIpanel.add(fMoney);

JPanel panel1=new JPanel();
FlowLayout lay=new FlowLayout();
panel1.setLayout(lay);
panel1.setBorder(new MatteBorder(5,5,5,5,Color.CYAN));
ner.add(panel1,"Center");
panel1.add(area);


JPanel nel2=new JPanel();
ner.add(nel2,"South");
GridLayout out3=new GridLayout(2,3);
nel2.setLayout(out3);
nel2.add(echos);
nel2.add(Total);
nel2.add(fTotal);
nel2.add(echos1);
nel2.add(Change);
nel2.add(fChange);

}
class PosHandler implements ActionListener{
public void actionPerformed(ActionEvent v){
String que=v.getActionCommand();
if(que.equals("OK")){
if(fPosName.getText().toString()!=""&&fMoney.getText().toString().equals("")){
try{
	FileReader fr = new FileReader("Cashier/products.txt");
	BufferedReader bw = new BufferedReader(fr);
	StringTokenizer token;
	while((line=bw.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	word3=token.nextToken();
	word4=token.nextToken();
if (fPosName.getText().toLowerCase().equals(word1.toLowerCase())||fPosCode.getText().equals(word4)){
	fPosName.setText(word1);
	fPosCode.setText(word4);
	str=fPosQuant.getText().toString().trim();
	quantity=Double.parseDouble(str);
	price1=Double.parseDouble(word2);
	price+=price1*quantity;
	word2 = price.toString();
	total+=price;
	fTotal.setText(total.toString());
	fPosQuant.setText(quantity.toString());
	area.append("\r\n"+"    "+word1+"x"+Double.toString(quantity)+"\r\t\t\t"+word4+"\r\t\t\t"+word2+"\r");
			fPosCode.setText("");
			fPosName.setText("");
			Smoney="";
			price1=0.00;
			price=0.00;
			change=0.00;	
			change1=0.00;
			quantity=1.00;
			str="";
			fPosQuant.setText("1");
	}else{}
	}
	
	}
catch(Exception o){
}
}
else if(fPosName.getText().toString().equals("")&&fMoney.getText().toString()!=""){
			Smoney=fMoney.getText().toString();
			custom=Double.parseDouble(Smoney);
			change1=custom-total;
			change+=change1;
			fChange.setText(change.toString());
			fPosQuant.setText(quantity.toString());
			
if(change<0){JOptionPane.showMessageDialog(null,"Change is less than 0","Money Error!",JOptionPane.ERROR_MESSAGE);
			fPosCode.setText("");
			fPosName.setText("");
			Smoney="";
			price1=0.00;
			price=0.00;
			change=0.00;	
			change1=0.00;
			quantity=1.00;
			str="";
			fPosQuant.setText("1");
			}
else{
			fPosCode.setText("");
			fPosName.setText("");
			Smoney="";
			price1=0.00;
			price=0.00;
			change=0.00;	
			change1=0.00;
			quantity=1.00;
			str="";
			fPosQuant.setText("1");
	}	
	}
else if(fPosName.getText().toString()!=""&&fMoney.getText().toString()!=""){
try{
	FileReader fr = new FileReader("Cashier/products.txt");
	BufferedReader bw = new BufferedReader(fr);
	StringTokenizer token;
	while((line=bw.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	word3=token.nextToken();
	word4=token.nextToken();
if (fPosName.getText().toLowerCase().equals(word1.toLowerCase())||fPosCode.getText().equals(word4)){
	fPosName.setText(word1);
	fPosCode.setText(word4);
	str=fPosQuant.getText().toString().trim();
	quantity=Double.parseDouble(str);
	price1=Double.parseDouble(word2);
	price+=price1*quantity;
	word2 = price.toString();
	total+=price;
	fTotal.setText(total.toString());
	fPosQuant.setText(quantity.toString());
	area.append("\r\n"+"    "+word1+"x"+Double.toString(quantity)+"\r\t\t\t"+word4+"\r\t\t\t"+word2+"\r");
			Smoney=fMoney.getText().toString();
			custom=Double.parseDouble(Smoney);
			change1=custom-total;
			change+=change1;
			fChange.setText(change.toString());
			
if(change<0){JOptionPane.showMessageDialog(null,"Change is less than 0","Money Error!",JOptionPane.ERROR_MESSAGE);
	price1=0.00;
			fPosCode.setText("");
			fPosName.setText("");
			Smoney="";
			price1=0.00;
			price=0.00;
			change=0.00;	
			change1=0.00;
			quantity=1.00;
			str="";
			fPosQuant.setText("1");
			}
else{
			fPosCode.setText("");
			fPosName.setText("");
			Smoney="";
			price1=0.00;
			price=0.00;
			change=0.00;	
			change1=0.00;
			quantity=1.00;
			str="";
			fPosQuant.setText("1");
	}
	}else{}
	}
	
	}
catch(Exception o){
}

}
else if(fPosCode.getText().toString()!=""&&fMoney.getText().toString()!=""){
try{
	FileReader fr = new FileReader("products.txt");
	BufferedReader bw = new BufferedReader(fr);
	StringTokenizer token;
	while((line=bw.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	word3=token.nextToken();
	word4=token.nextToken();
if (fPosName.getText().toLowerCase().equals(word1.toLowerCase())||fPosCode.getText().equals(word4)){
	fPosName.setText(word1);
	fPosCode.setText(word4);
	str=fPosQuant.getText().toString().trim();
	quantity=Double.parseDouble(str);
	price1=Double.parseDouble(word2);
	price+=price1*quantity;
	word2 = price.toString();
	total+=price;
	fTotal.setText(total.toString());
	fPosQuant.setText(quantity.toString());
	area.append("\r\n"+"    "+word1+"x"+Double.toString(quantity)+"\r\t\t\t"+word4+"\r\t\t\t"+word2+"\r");
			Smoney=fMoney.getText().toString();
			custom=Double.parseDouble(Smoney);
			change1=custom-total;
			change+=change1;
			fChange.setText(change.toString());
			
if(change<0){JOptionPane.showMessageDialog(null,"Change is less than 0","Money Error!",JOptionPane.ERROR_MESSAGE);
	price1=0.00;
			fPosCode.setText("");
			fPosName.setText("");
			Smoney="";
			price1=0.00;
			price=0.00;
			change=0.00;	
			change1=0.00;
			quantity=1.00;
			str="";
			fPosQuant.setText("1");
			}
else{
			fPosCode.setText("");
			fPosName.setText("");
			Smoney="";
			price1=0.00;
			price=0.00;
			change=0.00;	
			change1=0.00;
			quantity=1.00;
			str="";
			fPosQuant.setText("1");
	}
	}else{}
	}
	
	}
catch(Exception o){
}

}
}
else if(que.equals("Clear")){
fMoney.setEnabled(true);
fPosCode.setText("");
fPosName.setText("");
fMoney.setText("");
fTotal.setText("");
fChange.setText("");
fPosQuant.setText("1");
area.setText("Name of Product"+"\r\t\t"+"Product Code"+"\r\t\t\t"+"Price");
total=0.00;change=0.00;change1=0.00;amount=0.00;custom=0.00;price=0.00;price1=0.00;quantity=1.00;
line=""; word1=""; word2="";word3="";word4="";fword="";Smoney="";Stotal="";Sprice="";str="";
}
else if(que.equals("Cancel")){
setVisible(false);
}
}
}
public static void main(String[]args){
	POS pos=new POS();
	pos.setVisible(true);
}
}