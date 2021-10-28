package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class Query1 extends JFrame{
	/**
		 *
		 */
	private static final long serialVersionUID = -3432542454746782245L;
	private JLabel PName;
private JTextField fPName;
private JLabel PCode;
private JTextField fPCode;
private JButton Search;
private JButton Clear;
private JButton Cancel;
private JButton DisplayAll;
private ImageIcon header;
private JLabel hlabel;
private JTextArea all;

public Query1(){
setIconImage(new ImageIcon("Cashier/images/icon.png").getImage());
setSize(1001,330);
setTitle("Query");	

ImageIcon login = new ImageIcon("Cashier/images/login2.png");
Font font = new Font("Sans serif",Font.BOLD,12);

PName=new JLabel("Name:");
PName.setFont(font);
fPName=new JTextField(20);
PCode=new JLabel("Code:");
PCode.setFont(font);
fPCode=new JTextField(20);
Search=new JButton("Search");
Clear=new JButton("Clear");
Cancel=new JButton("Cancel");
DisplayAll=new JButton("Display All");
all=new JTextArea(1000,32);

Container ner=getContentPane();
ner.setLayout(new BorderLayout());

JPanel textPanel=new JPanel();
JScrollPane scroll=new JScrollPane(textPanel);
textPanel.add(all);
scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

String head= "Cashier/images/header.png";
header=new ImageIcon(head);
hlabel=new JLabel(header);
ner.add(hlabel,"North");

JPanel panel=new JPanel();
ner.add(panel,"Center");
panel.setBorder(new EmptyBorder(15,25,10,25));

GridLayout lay=new GridLayout(2,2);
panel.setLayout(lay);
panel.add(PName);
panel.add(fPName);
panel.add(PCode);
panel.add(fPCode);

JPanel panel2=new JPanel();
ner.add(panel2,"South");

DelHandler dler=new DelHandler();
FlowLayout lay4=new FlowLayout();
panel2.setLayout(lay4);

Search.setFont(font);
Search.setVerticalTextPosition(SwingConstants.CENTER);
Search.setHorizontalTextPosition(SwingConstants.CENTER);
Search.setPreferredSize(new Dimension(110,30));
Search.setIcon(login);
panel2.add(Search);
Search.setMnemonic('\n');
Search.addActionListener(dler);

DisplayAll.setFont(font);
DisplayAll.setVerticalTextPosition(SwingConstants.CENTER);
DisplayAll.setHorizontalTextPosition(SwingConstants.CENTER);
DisplayAll.setPreferredSize(new Dimension(110,30));
DisplayAll.setIcon(login);
panel2.add(DisplayAll);
DisplayAll.addActionListener(dler);

Clear.setFont(font);
Clear.setVerticalTextPosition(SwingConstants.CENTER);
Clear.setHorizontalTextPosition(SwingConstants.CENTER);
Clear.setPreferredSize(new Dimension(110,30));
Clear.setIcon(login);
panel2.add(Clear);
Clear.addActionListener(dler);

Cancel.setFont(font);
Cancel.setVerticalTextPosition(SwingConstants.CENTER);
Cancel.setHorizontalTextPosition(SwingConstants.CENTER);
Cancel.setPreferredSize(new Dimension(110,30));
Cancel.setIcon(login);
panel2.add(Cancel);
Cancel.addActionListener(dler);

}
class DelHandler implements ActionListener{
public void actionPerformed(ActionEvent n){
String cmd2=n.getActionCommand();
if(cmd2.equals("Search")){

try{
	
	String line, word1, word2,word3,word4;
	
	FileReader fr = new FileReader("Cashier/products.txt");
	BufferedReader bw = new BufferedReader(fr);
	StringTokenizer token;
	while((line=bw.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	word3=token.nextToken();
	word4=token.nextToken();
	if (fPName.getText().equals(word1)||fPCode.getText().equals(word4)){
	JOptionPane.showMessageDialog(null,"Product Name"+"        "+"Price"+"        "+"Quantity"+"        "+"Product Code"+"\n"+word1+"                         "+word2+"                 "+word3+"               "+word4);
		} 	
	}
	}
	
catch(Exception o){
}
}
else if(cmd2.equals("Clear")){
fPName.setText("");
fPCode.setText("");
}
else if(cmd2.equals("Cancel")){
setVisible(false);
}
else if(cmd2.equals("Display All")){

try{
	
	String line, word="",word1="",word2="",word3="",word4="";
	
	FileReader fr = new FileReader("Cashier/products.txt");
	BufferedReader bw = new BufferedReader(fr);
	StringTokenizer token;
	while((line=bw.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	word3=token.nextToken();
	word4=token.nextToken();
	word+=word1+"\r\t\t"+word2+"\r\t\t"+word3+"\r\t\t"+word4+"\r\n";
	}
	all.setText("Product Name"+"\r\t\t"+"Price"+"\r\t\t"+"Quantity"+"\r\t\t"+"Product Code"+"\r\n");
	all.append(word);
	JOptionPane.showMessageDialog(null,all,"Display All",JOptionPane.PLAIN_MESSAGE);
	}
	
catch(Exception o){
}

}
}
}
}