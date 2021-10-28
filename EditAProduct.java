package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class EditAProduct extends JFrame{
  /**
  	 *
  	 */
  private static final long serialVersionUID = -1304575172374932105L;
  private JLabel PName;
private JTextField fPName;
private JLabel PPrice;
private JTextField fPPrice;
private JLabel Quantity;
private JTextField fQuantity;
private JButton OK;
private JButton Clear;
private JButton Cancel;
private JButton Save;
private ImageIcon header;
private JLabel hlabel;
private JLabel PCode;
private JTextField fPCode;
private String temp;

public EditAProduct(){
setIconImage(new ImageIcon("Cashier/images/icon.png").getImage());
setSize(1001,380);
setTitle("Edit a product");

ImageIcon login = new ImageIcon("Cashier/images/login2.png");
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
PCode.setFont(font);
fPCode = new JTextField(20);
OK=new JButton("OK");
Clear=new JButton("Clear");
Cancel=new JButton("Cancel");
Save=new JButton("Save");
Save.setEnabled(false);
fPPrice.setEditable(false);
fQuantity.setEditable(false);
Container ner1=getContentPane();
ner1.setLayout(new BorderLayout());

String head= "Cashier/images/header.png";
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
panl.add(PCode);
panl.add(fPCode);
panl.add(PPrice);
panl.add(fPPrice);
panl.add(Quantity);
panl.add(fQuantity);

JPanel panl1=new JPanel();
ner1.add(panl1,"South");

AddHandler2 dler=new AddHandler2();
FlowLayout lay1=new FlowLayout();
panl1.setLayout(lay1);

Save.setFont(font);
Save.setVerticalTextPosition(SwingConstants.CENTER);
Save.setHorizontalTextPosition(SwingConstants.CENTER);
Save.setPreferredSize(new Dimension(110,30));
Save.setIcon(login);
panl1.add(Save);
Save.addActionListener(dler);

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
if(cmd.equals("Save")){
File f=new File("Cashier/products.txt");

        FileInputStream fs = null;
        InputStreamReader in = null;
        BufferedReader br = null;

        StringBuffer sb = new StringBuffer();
        String _word1,_word2,_word3,_word4,_word;
        _word1=fPName.getText();
        _word2=fPPrice.getText();
        _word3=fQuantity.getText();
        _word4=fPCode.getText();
        _word=_word1+" "+_word2+" "+_word3+" "+_word4;
        

        try {
             fs = new FileInputStream(f);
             in = new InputStreamReader(fs);
             br = new BufferedReader(in);

            
                String textinLine=br.readLine();
                while(textinLine!=null) {
             
                sb.append(textinLine+"\r\n");
                textinLine=br.readLine();
            }
              String textToEdit=temp;
              int cnt=sb.indexOf(textToEdit);
              while(cnt!=-1){
              sb.replace(cnt,cnt+textToEdit.length(),_word);
              cnt=sb.indexOf(textToEdit);
              }
             
              br.close();
              in.close();
              fs.close();
            } catch (IOException j) {
            }

            try{
                FileWriter fstream = new FileWriter(f);
                BufferedWriter outobj = new BufferedWriter(fstream);
              	
                outobj.write(sb.toString());
                outobj.close();
JOptionPane.showMessageDialog(null,"Account has been successfully edited!","Account",JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception c){ }

}
if(cmd.equals("OK")){
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
	if (fPName.getText().equals(word1)|| fPCode.getText().equals(word4)){
			OK.setEnabled(false);
			fQuantity.setEditable(true);
			fPPrice.setEditable(true);
			Save.setEnabled(true);
			fPName.setText(word1);
			fPCode.setText(word4);
			fPCode.setEditable(false);
			fPPrice.setText(word2);
			fQuantity.setText(word3);
			temp=word1+" "+word2+" "+word3+" "+word4;
		}
}
	}
catch(Exception o){
}



}
if(cmd.equals("Clear")){
fPName.setText("");
fPPrice.setText("");
fQuantity.setText("");
}
if(cmd.equals("Cancel")){
setVisible(false);
}
}
}
public static void main(String[]args){
new EditAProduct().setVisible(true);
}
}