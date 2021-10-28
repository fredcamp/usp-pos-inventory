package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.Random;
import java.util.*;
import java.text.*;

public class AddAProduct extends JFrame{
	/**
		 *
		 */
	private static final long serialVersionUID = -3350578686905489941L;
	private JLabel PName;
private JTextField fPName;
private JLabel PPrice;
private JTextField fPPrice;
private JLabel Quantity;
private JTextField fQuantity;
private JButton OK;
private JButton Clear;
private JButton Cancel;
private ImageIcon header;
private JLabel hlabel;
private JLabel PCode;
private JTextField fPCode;

public AddAProduct(){
setIconImage(new ImageIcon("Cashier/images//icon.png").getImage());
setSize(1001,380);
setTitle("Add a product");

ImageIcon login = new ImageIcon("Cashier/images//login2.png");
Font font = new Font("Sans serif",Font.BOLD,12);

PName=new JLabel("Name:");
PName.setFont(font);
fPName=new JTextField(20);
PPrice=new JLabel("Price:");
PPrice.setFont(font);
fPPrice=new JTextField(20);
Quantity=new JLabel("Quantity:");
Quantity.setFont(font);
fQuantity=new JTextField(20);
PCode = new JLabel("Product Code");
PCode.setFont (font);
fPCode = new JTextField(20);
fPCode.setEditable(false);

OK=new JButton("OK");
Clear=new JButton("Clear");
Cancel=new JButton("Cancel");
Container ner1=getContentPane();
ner1.setLayout(new BorderLayout());

String head= "Cashier/images//header.png";
header=new ImageIcon(head);
hlabel=new JLabel(header);
ner1.add(hlabel,"North");

JPanel panl=new JPanel();
ner1.add(panl,"Center");
panl.setBorder(new EmptyBorder(15,25,10,25));

GridLayout lay=new GridLayout(4,2);
panl.setLayout(lay);
panl.add(PName);
panl.add(fPName);
panl.add(PPrice);
panl.add(fPPrice);
panl.add(Quantity);
panl.add(fQuantity);
panl.add(PCode);
panl.add(fPCode);

JPanel panl1=new JPanel();
ner1.add(panl1,"South");

AddHandler2 dler=new AddHandler2();
FlowLayout lay1=new FlowLayout();
panl1.setLayout(lay1);

OK.setFont(font);
OK.setVerticalTextPosition(SwingConstants.CENTER);
OK.setHorizontalTextPosition(SwingConstants.CENTER);
OK.setPreferredSize(new Dimension(110,30));
OK.setIcon(login);
panl1.add(OK);
OK.setMnemonic('\n');
OK.addActionListener(dler);

Clear.setFont(font);
Clear.setVerticalTextPosition(SwingConstants.CENTER);
Clear.setHorizontalTextPosition(SwingConstants.CENTER);
Clear.setPreferredSize(new Dimension(110,30));
Clear.setIcon(login);
panl1.add(Clear);
Clear.addActionListener(dler);

Cancel.setFont(font);
Cancel.setVerticalTextPosition(SwingConstants.CENTER);
Cancel.setHorizontalTextPosition(SwingConstants.CENTER);
Cancel.setPreferredSize(new Dimension(110,30));
Cancel.setIcon(login);
panl1.add(Cancel);
Cancel.addActionListener(dler);

}
class AddHandler2 implements ActionListener{
public void actionPerformed(ActionEvent m){
String cmd=m.getActionCommand();
if(cmd.equals("OK")){

try{
	
		String str, str1, str2, str3;
		str = fPName.getText();
		str1 = fPPrice.getText();
		str2 = fQuantity.getText();
		
		if(str.trim().length() == 0 || str1.trim().length() == 0 || str2.trim().length() == 0){
			JOptionPane.showMessageDialog(null, "Please fill out all the text boxes.");
			
		}
		else{
		

		FileWriter bw = new FileWriter("Cashier/products.txt", true);
		BufferedWriter fw = new BufferedWriter(bw);
			fw.write(str);
			fw.write(" "+str1);
			fw.write(" "+str2 + " ");
		Random randomGenerator = new Random();
		for (int idx = 1; idx <= 11; ++idx){
			int randomInt = randomGenerator.nextInt(9);
			str3 = Integer.toString(randomInt);
			fw.write(str3);
		}

		JOptionPane.showMessageDialog(null,"Product has been successfully registered");
		fw.newLine();
		fw.close();

		}
}
catch (Exception o){
}

try {
		String line, word1, word2, word3, word4;
	
	FileReader fr = new FileReader("Cashier/products.txt");
	BufferedReader br = new BufferedReader(fr);
	StringTokenizer token;
	while((line=br.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	word3=token.nextToken();
	word4=token.nextToken();
	if (fPName.getText().equals(word1)){
			String str8 = word4;
			fPCode.setText(word4);
			
		}
	}
}
catch(Exception p){
}
}
else if(cmd.equals("Clear")){
fPName.setText("");
fPPrice.setText("");
fQuantity.setText("");
fPCode.setText("");
}
else if(cmd.equals("Cancel")){
setVisible(false);
}
}
}
}