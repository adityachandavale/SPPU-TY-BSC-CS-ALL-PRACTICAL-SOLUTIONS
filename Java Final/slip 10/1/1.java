import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Slip10 extends JFrame implements ActionListener{
JTextField jtf;
JPanel p1,p2,p3,p4,p5,p6;
JButton jb[]=new JButton[16];
int i;
Slip10(){
setLocation(50,50);
setSize(300,300);
setLayout(new GridLayout(5,4));
p1=new JPanel();
p2=new JPanel();
p3=new JPanel();
p4=new JPanel();
p5=new JPanel();
p6=new JPanel();
jtf=new JTextField(10);
p1.add(jtf);
add(p1);
jb[0]=new JButton("1");
jb[1]=new JButton("2");
jb[2]=new JButton("3");
jb[3]=new JButton("+");
p2.add(jb[0]);
p2.add(jb[1]);
p2.add(jb[2]);
p2.add(jb[3]);
jb[4]=new JButton("4");
jb[5]=new JButton("5");
jb[6]=new JButton("6");
jb[7]=new JButton("-");
p3.add(jb[4]);
p3.add(jb[5]);
p3.add(jb[6]);
p3.add(jb[7]);
jb[8]=new JButton("7");
jb[9]=new JButton("8");
jb[10]=new JButton("9");
jb[11]=new JButton("*");
p4.add(jb[8]);
p4.add(jb[9]);
p4.add(jb[10]);
p4.add(jb[11]);
jb[12]=new JButton("0");
jb[13]=new JButton(".");
jb[14]=new JButton("=");
jb[15]=new JButton("/");
p5.add(jb[12]);
p5.add(jb[13]);
p5.add(jb[14]);
p5.add(jb[15]);
add(p2);
add(p3);
add(p4);
add(p5);
for(int i=0;i<16;i++){
jb[i].addActionListener(this);
}
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae){
if(ae.getActionCommand().equals("0")){
jtf.setText(jtf.getText()+"0");
}
if(ae.getActionCommand().equals("1")){
jtf.setText(jtf.getText()+"1");
}
if(ae.getActionCommand().equals("2")){
jtf.setText(jtf.getText()+"2");
}
if(ae.getActionCommand().equals("3")){
jtf.setText(jtf.getText()+"3");
}
if(ae.getActionCommand().equals("4")){
jtf.setText(jtf.getText()+"4");
}
if(ae.getActionCommand().equals("5")){
jtf.setText(jtf.getText()+"5");
}
if(ae.getActionCommand().equals("6")){
jtf.setText(jtf.getText()+"6");
}
if(ae.getActionCommand().equals("7")){
jtf.setText(jtf.getText()+"7");
}
if(ae.getActionCommand().equals("8")){
jtf.setText(jtf.getText()+"8");
}
if(ae.getActionCommand().equals("9")){
jtf.setText(jtf.getText()+"9");
}
if(ae.getActionCommand().equals("+")){
jtf.setText(jtf.getText()+"+");
}
if(ae.getActionCommand().equals("-")){
jtf.setText(jtf.getText()+"-");
}
if(ae.getActionCommand().equals("*")){
jtf.setText(jtf.getText()+"*");
}
if(ae.getActionCommand().equals("/")){
jtf.setText(jtf.getText()+"/");
}
if(ae.getActionCommand().equals(".")){
jtf.setText(jtf.getText()+".");
}
if(ae.getActionCommand().equals("=")){
String cno[]=jtf.getText().split("[^0-9\\.]");
float no[]=new float[cno.length];
for(int i=0;i<cno.length;i++){
no[i]=Float.parseFloat(cno[i]);
}
String t=jtf.getText();
char op[]=new char[4];
int j=0;
for(int i=0;i<t.length();i++){
if(jtf.getText().charAt(i)=='+' || jtf.getText().charAt(i)=='-' || jtf.getText().charAt
(i)=='*' || jtf.getText().charAt(i)=='/'){
op[j]=jtf.getText().charAt(i);
j++;
break;
}
}
float ans=0;
int flag=0;
for(int i=0;i<no.length;i++){
if(op[i]=='+'){
if(flag!=0){
ans=ans+no[i+1];
}
if(flag==0){
ans=no[i]+no[i+1];
flag=1;
}
}
if(op[i]=='-'){
if(flag!=0){
ans=ans-no[i+1];
}
if(flag==0){
ans=no[i]-no[i+1];
flag=1;
}
}
if(op[i]=='*'){
if(flag!=0){
ans=ans*no[i+1];
}
if(flag==0){
ans=no[i]*no[i+1];
flag=1;
}
}
if(op[i]=='/'){
if(flag!=0){
ans=ans/no[i+1];
}
if(flag==0){
ans=no[i]/no[i+1];
flag=1;
}
}
}
jtf.setText(""+ans);
}
}
public static void main(String[] args){
Slip10 s10=new Slip10();
}
}