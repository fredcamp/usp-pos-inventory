package Cashier;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class DeleteAnAccount extends JFrame{
  /**
  	 *
  	 */
  private static final long serialVersionUID = 1243543784096688191L;
  private String temp;
private JLabel Username;
private JTextField fname;
private JLabel Password;
private JPasswordField fpass;
private JButton OK;
private JButton Clear;
private JButton Cancel;
private ImageIcon header;
private JLabel hlabel;

public DeleteAnAccount(){
setIconImage(new ImageIcon("Cashier/images//icon.png").getImage());
setSize(1001,330);
setTitle("Delete an account");

ImageIcon login = new ImageIcon("Cashier/images//login2.png");
Font font = new Font("Sans serif",Font.BOLD,12);

Username=new JLabel("Username:");
Username.setFont(font);
fname=new JTextField(20);
Password=new JLabel("Password:");
Password.setFont(font);
fpass=new JPasswordField(20);
fpass.setEchoChar('*');
OK=new JButton("OK");
Clear=new JButton("Clear");
Cancel=new JButton("Cancel");

Container cont=getContentPane();
cont.setLayout(new BorderLayout());

String head= "Cashier/images//header.png";
header=new ImageIcon(head);
hlabel=new JLabel(header);
cont.add(hlabel,"North");

JPanel panel2=new JPanel();
cont.add(panel2,"Center");

GridLayout layout2=new GridLayout(2,2);
panel2.setLayout(layout2);
panel2.setBorder(new EmptyBorder(15,25,10,25));

panel2.add(Username);
panel2.add(fname);
panel2.add(Password);
panel2.add(fpass);

JPanel panel3=new JPanel();
cont.add(panel3,"South");

AddHandler hand2=new AddHandler();
FlowLayout layout3=new FlowLayout();
panel3.setLayout(layout3);

OK.setFont(font);
OK.setVerticalTextPosition(SwingConstants.CENTER);
OK.setHorizontalTextPosition(SwingConstants.CENTER);
OK.setPreferredSize(new Dimension(110,30));
OK.setIcon(login);
panel3.add(OK);
OK.setMnemonic('\n');
OK.addActionListener(hand2);

Clear.setFont(font);
Clear.setVerticalTextPosition(SwingConstants.CENTER);
Clear.setHorizontalTextPosition(SwingConstants.CENTER);
Clear.setPreferredSize(new Dimension(110,30));
Clear.setIcon(login);
panel3.add(Clear);
Clear.addActionListener(hand2);

Cancel.setFont(font);
Cancel.setVerticalTextPosition(SwingConstants.CENTER);
Cancel.setHorizontalTextPosition(SwingConstants.CENTER);
Cancel.setPreferredSize(new Dimension(110,30));
Cancel.setIcon(login);
panel3.add(Cancel);
Cancel.addActionListener(hand2);
}
class AddHandler implements ActionListener{
public void actionPerformed(ActionEvent e){
String actionCommand2=e.getActionCommand();

if(actionCommand2.equals("OK")){
try{
	String line, word1, word2,word3,word4;
	FileReader fr = new FileReader("Cashier/account.txt");
	BufferedReader bw = new BufferedReader(fr);
	StringTokenizer token;
	while((line=bw.readLine())!=null){
	token = new StringTokenizer(line);
	word1=token.nextToken();
	word2=token.nextToken();
	word3=token.nextToken();
	word4=token.nextToken();
  String fpasstemp = new String(fpass.getPassword());
if (fname.getText().equals(word1)&&fpasstemp.equals(word2)){
temp=word1+" "+word2+" "+word3+" "+word4;
}
}
	}
catch(Exception o){ }
File f=new File("Cashier/account.txt");

        FileInputStream fs = null;
        InputStreamReader in = null;
        BufferedReader br = null;

        StringBuffer sb = new StringBuffer();
        String _word1,_word2,_word3,_word4;
        _word1=fname.getText();
        _word2=new String(fpass.getPassword());

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
JOptionPane.showMessageDialog(null,"Account has been successfully deleted!","Account",JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception c){ }
}          
else if(actionCommand2.equals("Clear")){
fname.setText("");
fpass.setText("");
}
else if(actionCommand2.equals("Cancel")){
setVisible(false);
}
}
}
}