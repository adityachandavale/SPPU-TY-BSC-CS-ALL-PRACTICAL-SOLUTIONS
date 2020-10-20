package Slip20;
import sy.*;
import ty.*;
import java.io.*;
class Student{
private int roll;
private String name;
private SyMarks sm;
private TyMarks tm;
private int tot;
public void setStudent(int r,String n,SyMarks ss,TyMarks tt){
roll=r;
name=n;
sm=ss;
tm=tt;
}
public void display(){
System.out.println("Roll Number : "+roll);
System.out.println("Name : "+name);
System.out.println("Comp Marks : "+sm.getCompMarks());
System.out.println("Maths Marks : "+sm.getMathsMarks());
System.out.println("Elect Marks : "+sm.getElectMarks());
System.out.println("Theory Marks : "+tm.getTheoryMarks());
System.out.println("Practical Marks : "+tm.getPracticalMarks());
}
public static void main(String args[]){
int no;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int r1,c1,m1,e1,t1,p1;
String n1;
SyMarks sss;
TyMarks ttt;
try{
Student st[]=new Student[100];
System.out.println("Enter how many students:");
no=Integer.parseInt(br.readLine());
for(int i=0;i<no;i++){
st[i]=new Student();
System.out.println("Enter roll number");
r1=Integer.parseInt(br.readLine());
System.out.println("Enter name:");
n1=br.readLine();
System.out.println("Enter sy marks:");
c1=Integer.parseInt(br.readLine());
m1=Integer.parseInt(br.readLine());
e1=Integer.parseInt(br.readLine());
sss=new SyMarks();
sss.setSyMarks(c1,m1,e1);
System.out.println("Enter ty marks:");
t1=Integer.parseInt(br.readLine());
p1=Integer.parseInt(br.readLine());
ttt=new TyMarks();
ttt.setTyMarks(t1,p1);
st[i].setStudent(r1,n1,sss,ttt);
st[i].display();
}
}catch(Exception e){
System.out.println(e);
}
}
}