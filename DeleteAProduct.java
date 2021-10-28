package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class DeleteAProduct extends JFrame{
  /**
  	 *
  	 */
  private static final long serialVersionUID = -5454551948648936275L;
  private JLabel PName;
private JTextField fPName;
private JLabel PCode;
private JTextField fPCode;
private JButton OK;
private JButton Clear;
private JButton Cancel;
private ImageIcon header;
private JLabel hlabel;
private String temp;

public DeleteAProduct(){
setIconImage(new ImageIcon("Cashier/images/icon.png").getImage());
setSize(1001,330);
setTitle("Delete a product");	

ImageIcon login = new ImageIcon("Cashier/images/login2.png");
Font font = new Font("Sans serif",Font.BOLD,12);

PName=new JLabel("Name:");
PName.setFont(font);
fPName=new JTextField(20);
PCode=new JLabel("Code:");
PCode.setFont(font);
fPCode=new JTextField(20);
OK=new JButton("OK");
Clear=new JButton("Clear");
Cancel=new JButton("Cancel");

Container ner=getContentPane();
ner.setLayout(new BorderLayout());

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

OK.setFont(font);
OK.setVerticalTextPosition(SwingConstants.CENTER);
OK.setHorizontalTextPosition(SwingConstants.CENTER);
OK.setPreferredSize(new Dimension(110,30));
OK.setIcon(login);
panel2.add(OK);
OK.setMnemonic('\n');
OK.addActionListener(dler);

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
if(cmd2.equals("OK")){
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
temp=word1+" "+word2+" "+word3+" "+word4;
}
}
	}
catch(Exception o){ }
File f=new File("Cashier/products.txt");

        FileInputStream fs = null;
        InputStreamReader in = null;
        BufferedReader br = null;

        StringBuffer sb = new StringBuffer();
        String _word1,_word2,_word3,_word4;
        _word1=fPName.getText();
        _word2=fPCode.getText();

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
              sb.replace(cnt,cnt+textToEdit.length(),"---- ---- ---- ----");
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
JOptionPane.showMessageDialog(null,"Product has been successfully deleted!","Account",JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception c){ }
}          


if(cmd2.equals("Clear")){
fPName.setText("");
fPCode.setText("");
}
if(cmd2.equals("Cancel")){
setVisible(false);
}
}
}
}