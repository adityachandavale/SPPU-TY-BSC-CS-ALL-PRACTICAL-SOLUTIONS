import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
class Slip4 extends JFrame implements ActionListener{
JMenuBar jmb;
JMenu jm1,jm2;
JMenuItem jmopen,jmload,jmsave,jmexit,jmsum,jmavg;
JPanel jp1;
JTextArea jta;
JScrollPane jsp;
JFileChooser jfc;
int a[]=new int[10];
Slip4(){
setLocation(50,50);
setSize(400,400);
setLayout(new BorderLayout());
jmb=new JMenuBar();
jm1=new JMenu("Operation");
jmopen=new JMenuItem("open");
jmopen.addActionListener(this);
jmload=new JMenuItem("Load");
jmload.addActionListener(this);
jmsave=new JMenuItem("Save");
jmsave.addActionListener(this);
jmexit=new JMenuItem("Exit");
jmexit.addActionListener(this);
jm1.add(jmopen);
jm1.add(jmload);
jm1.add(jmsave);
jm1.addSeparator();
jm1.add(jmexit);
jm2=new JMenu("Compute");
jmsum=new JMenuItem("Sum");
jmsum.addActionListener(this);
jmavg=new JMenuItem("Average");
jmavg.addActionListener(this);
jm2.add(jmsum);
jm2.add(jmavg);
jmb.add(jm1);
jmb.add(jm2);
setJMenuBar(jmb);
jp1=new JPanel(new BorderLayout());
jta=new JTextArea(20,40); //height and width
jsp=new JScrollPane(jta);
jp1.add(jsp,BorderLayout.CENTER);
add(jp1,BorderLayout.CENTER);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
//pack();
}
public void actionPerformed(ActionEvent ae){
String msg1="Numbers are as follows \n\n";
String msg2="\n\nTotal is \n\n";
String msg3="\n\nAverage is \n\n";
String msg=" ";
String fname="";
float sum=0.0f;
float avg=0.0f;
if(ae.getSource()==jmopen){
	jfc=new JFileChooser("Open File");
int result;
result=jfc.showOpenDialog(this);
if(result==jfc.APPROVE_OPTION){
fname=jfc.getSelectedFile().getAbsolutePath();
}
try{
FileInputStream fin=new FileInputStream(fname);
int no,i=0;
do
{
no=fin.read();
if(no!=-1)
{
a[i]=no;
i++;
}
}while(no!=-1);
fin.close();
}catch(Exception e){}
jta.setText(msg1);
for(int i=0;i<10;i++)
jta.append(" "+a[i]);
}
if(ae.getSource()==jmexit){
JOptionPane.showMessageDialog(null,"BYE-BYE");
System.exit(0);
}
if(ae.getSource()==jmload){
jta.setText(msg1);
Random r=new Random();
for(int i=0;i<10;i++){
a[i]=r.nextInt(100);
msg=msg+a[i]+" ";
}
jta.append(msg);
}
if(ae.getSource()==jmsave){
try{
PrintWriter pw=new PrintWriter("numbers.txt");
for(int i=0;i<10;i++){
pw.println(a[i]);
}
pw.close();
}catch(Exception e){System.out.println(e);}
}
if(ae.getSource()==jmavg){
jta.setText(msg1);
for(int i=0;i<10;i++){
jta.append(" "+a[i]);
sum=sum+a[i];
}
avg=sum/10;
jta.append(msg3+avg);
}
if(ae.getSource()==jmsum){
jta.setText(msg1);
for(int i=0;i<10;i++){
jta.append(" "+a[i]);
sum=sum+a[i];
}
jta.append(msg2+sum);
}
}
public static void main(String args[]){
Slip4 s1=new Slip4();
	}
}