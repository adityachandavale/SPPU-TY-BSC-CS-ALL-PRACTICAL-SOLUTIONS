import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class Slip22 extends JFrame implements ActionListener{
String a="",n="";
int a1=0,n1=0;
JMenuBar jmb;
JMenu jm1,jm2;
JMenuItem jmaccept,jmexit,jmgcd,jmpower;
Slip22(){
setLocation(50,50);
setSize(400,400);
setLayout(new BorderLayout());
jmb=new JMenuBar();
jm1=new JMenu("Operation");
jmaccept=new JMenuItem("Accept");
jmaccept.addActionListener(this);
jmexit=new JMenuItem("Exit");
jmexit.addActionListener(this);
jm1.add(jmaccept);
jm1.add(jmexit);
jm2=new JMenu("Compute");
jmgcd=new JMenuItem("GCD");
jmgcd.addActionListener(this);
jmpower=new JMenuItem("Power");
jmpower.addActionListener(this);
jm2.add(jmgcd);
jm2.add(jmpower);
jmb.add(jm1);
jmb.add(jm2);
setJMenuBar(jmb);
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
int gcd=0,pow=1;
if(ae.getSource()==jmaccept){
a=JOptionPane.showInputDialog(null,"Enter first number");
n=JOptionPane.showInputDialog(null,"Enter second number");
}
if(ae.getSource()==jmgcd){
if(a.equals("") || n.equals(""))
JOptionPane.showMessageDialog(null,"First accept numbers","ERROR",JOptionPane.
ERROR_MESSAGE);
else{
a1=Integer.parseInt(a);
n1=Integer.parseInt(n);
while(a1!=n1){
if(a1>n1)
a1=a1-n1;
else
n1=n1-a1;
}
gcd=a1;
JOptionPane.showMessageDialog(null,"GCD is "+gcd,"GCD",JOptionPane.INFORMATION_MESSAGE);
}
}
if(ae.getSource()==jmpower){
if(a.equals("") || n.equals(""))
JOptionPane.showMessageDialog(null,"First accept numbers","ERROR",JOptionPane.
ERROR_MESSAGE);
else{
a1=Integer.parseInt(a);
n1=Integer.parseInt(n);
while(n1>0){
pow=pow*a1;
n1--;
}
JOptionPane.showMessageDialog(null,"Power is "+pow,"POWER",JOptionPane.PLAIN_MESSAGE);
}
}
if(ae.getSource()==jmexit){
System.exit(0);
}
}
public static void main(String args[]){
Slip22 s1=new Slip22();
}
}