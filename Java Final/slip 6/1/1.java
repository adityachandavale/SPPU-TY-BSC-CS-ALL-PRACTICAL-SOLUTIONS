import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Slip6 extends JFrame implements ActionListener{
JPanel jp1,jp2;
JButton jb1;
JLabel jl1,jl2,jl3,jl4;
JTextField jtf1,jtf2,jtf3,jtf4;
Slip6(){
setLocation(50,50);
setSize(400,300);
setLayout(new BorderLayout());
jp1=new JPanel(new GridLayout(4,2));
//jp1.setBackground(Color.cyan);
jl1=new JLabel("Decimal Number");
jp1.add(jl1);
jtf1=new JTextField(20);
jp1.add(jtf1);
jl2=new JLabel("Binary Number");
jp1.add(jl2);
jtf2=new JTextField(20);
jp1.add(jtf2);
jl3=new JLabel("Octal Number");
jp1.add(jl3);
jtf3=new JTextField(20);
jp1.add(jtf3);
jl4=new JLabel("HexaDecimal Number");
jp1.add(jl4);
jtf4=new JTextField(20);
jp1.add(jtf4);
jp2=new JPanel();
jp2.setBackground(Color.gray);
jb1=new JButton("Calculate");
jb1.addActionListener(this);
jp2.add(jb1);
add(jp1,BorderLayout.CENTER);
add(jp2,BorderLayout.SOUTH);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
//pack();
}
public void actionPerformed(ActionEvent ae){
String no1=jtf1.getText();
if(no1.equals("")){
JOptionPane.showMessageDialog(null,"Please Enter decimal number");
}
int no=Integer.parseInt(no1);
/*
jtf2.setText(Integer.toBinaryString(no));
jtf3.setText(Integer.toOctalString(no));
jtf4.setText(Integer.toHexString(no));
*/
char bin[]={'0','1'};
char oct[]={'0','1','2','3','4','5','6','7'};
char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
String b="",o="",h="";
int temp,t;
temp=no;
while(temp>0){
t=temp%2;
b=bin[t]+b;
temp=temp/2;
}
temp=no;
while(temp>0){
t=temp%8;
o=oct[t]+o;
temp=temp/8;
}
temp=no;
while(temp>0){
t=temp%16;
h=hex[t]+h;
temp=temp/16;
}
jtf2.setText(b);
jtf3.setText(o);
jtf4.setText(h);
}
public static void main(String args[]){
Slip6 s6=new Slip6();
}
}