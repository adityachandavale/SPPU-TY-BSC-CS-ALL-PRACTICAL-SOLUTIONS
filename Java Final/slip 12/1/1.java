import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Slip12 extends JFrame implements ActionListener,ItemListener,KeyListener{
JPanel jp1,jp2,jp3;
JLabel jl1,jl2,jl3;
JTextField jtf1,jtf2;
JRadioButton jrb1,jrb2,jrb3;
ButtonGroup bg;
JCheckBox jcb1,jcb2,jcb3;
String msg1="Name",msg2=",Class",msg3=",Hobbies";
String t1="",t2="",t3="";
Slip12(){
setLocation(50,50);
setSize(370,200);
setLayout(new BorderLayout());
jp1=new JPanel();
jp1.setLayout(new GridLayout(1,2));
jl1=new JLabel("Your Name");
jp1.add(jl1);
jtf1=new JTextField(10);
jtf1.addKeyListener(this);
jp1.add(jtf1);
add(jp1,BorderLayout.NORTH);
jp2=new JPanel();
jp2.setLayout(new GridLayout(4,2));
jl2=new JLabel("Your Class");
jp2.add(jl2);
jl3=new JLabel("Your Hobbies");
jp2.add(jl3);
bg=new ButtonGroup();
jrb1=new JRadioButton("FY",false);
bg.add(jrb1);
jp2.add(jrb1);
jcb1=new JCheckBox("Music");
jp2.add(jcb1);
jrb2=new JRadioButton("SY",false);
bg.add(jrb2);
jp2.add(jrb2);
jcb2=new JCheckBox("Dance");
jp2.add(jcb2);
jrb3=new JRadioButton("TY",false);
bg.add(jrb3);
jp2.add(jrb3);
jcb3=new JCheckBox("Sports");
jp2.add(jcb3);
jcb1.addItemListener(this);
jcb2.addItemListener(this);
jcb3.addItemListener(this);
jrb1.addActionListener(this);
jrb2.addActionListener(this);
jrb3.addActionListener(this);
add(jp2,BorderLayout.CENTER);
jp3=new JPanel();
jp3.setLayout(new GridLayout(1,1));
jtf2=new JTextField(msg1+"---"+msg2+"---"+msg3,30);
jp3.add(jtf2);
add(jp3,BorderLayout.SOUTH);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae){
t3="";
if(jrb1.isSelected())
t3=jrb1.getText();
if(jrb2.isSelected())
t3=jrb2.getText();
if(jrb3.isSelected())
t3=t3+jrb3.getText();
jtf2.setText(msg1+jtf1.getText()+msg2+t3+msg3+t2);
}
public void itemStateChanged(ItemEvent ie){
t2="";
if(jcb1.isSelected())
t2=t2+jcb1.getText();
if(jcb2.isSelected())
t2=t2+jcb2.getText();
if(jcb3.isSelected())
t2=t2+jcb3.getText();
jtf2.setText(msg1+jtf1.getText()+msg2+t3+msg3+t2);
}
public void keyPressed(KeyEvent ke1){
}
public void keyReleased(KeyEvent ke2){
jtf2.setText(msg1+jtf1.getText()+msg2+t3+msg3+t2);
}
public void keyTyped(KeyEvent ke3){
}
public static void main(String args[]){
Slip12new s12=new Slip12new();
}
}