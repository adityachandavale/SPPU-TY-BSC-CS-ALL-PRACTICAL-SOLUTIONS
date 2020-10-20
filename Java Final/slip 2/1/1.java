import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
class Slip2 extends JFrame implements ActionListener{
JMenuBar jmb;
JMenu jm1,jm2;
JMenuItem jmopen,jmload,jmsave,jmexit,jmasc,jmdesc;
JPanel jp1;
JTextArea jta;
JScrollPane jsp;
JFileChooser jfc;
int a[]=new int[10];
Slip2(){
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
jm2=new JMenu("Sort");
jmasc=new JMenuItem("Ascending");
jmasc.addActionListener(this);
jmdesc=new JMenuItem("Descending");
jmdesc.addActionListener(this);
jm2.add(jmasc);
jm2.add(jmdesc);
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
String msg2="\n\nAscending order \n\n";
String msg3="\n\nDescending order \n\n";
String msg=" ";
String fname="";
/*
if(ae.getSource()==jmopen){
jfc=new JFileChooser("Open File");
int result;
result=jfc.showOpenDialog(this);
if(result==jfc.APPROVE_OPTION){
fname=jfc.getSelectedFile().getAbsolutePath();
}t
ry{
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
}*/
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
if(ae.getSource()==jmasc){
int t;
jta.setText(msg1);
for(int i=0;i<10;i++)
jta.append(" "+a[i]);
for(int i=0;i<10;i++)
for(int j=i+1;j<10;j++)
if(a[i]>a[j])
{
t=a[i];
a[i]=a[j];
a[j]=t;
}
jta.append(msg2);
for(int i=0;i<10;i++)
jta.append(" "+a[i]);
}
if(ae.getSource()==jmdesc){
int t;
jta.setText(msg1);
for(int i=0;i<10;i++)
jta.append(" "+a[i]);
for(int i=0;i<10;i++)
for(int j=i+1;j<10;j++)
if(a[i]<a[j])
{
t=a[i];
a[i]=a[j];
a[j]=t;
}
jta.append(msg3);
for(int i=0;i<10;i++)
jta.append(" "+a[i]);
}
}
public static void main(String args[]){
Slip2 s2=new Slip2();
}
}