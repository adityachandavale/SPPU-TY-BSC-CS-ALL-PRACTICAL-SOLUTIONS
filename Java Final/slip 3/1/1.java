import java.util.*;
class MyDateException extends Exception{
int d;
int m;
int y;
MyDateException(int d,int m,int y){
this.d=d;
this.m=m;
this.y=y;
}
public String toString(){
return "Invalid Date";
}
}
class MyDate{
private int dd;
private int mm;
private int yyyy;
public boolean validate(){
boolean flag=false;
if(mm==1 || mm==3 || mm==5 || mm==7 || mm==8 || mm==10 || mm==12){
if(dd>=1 && dd<=31)
flag=true;
}else if(mm==4 || mm==6 || mm==9 || mm==11){
if(dd>=1 && dd<=30)
flag=true;
}else if(mm==2){
if(dd>=1 && dd<=28)
flag=true;
}
return flag;
}
public void accept(){
Scanner sc = new Scanner(System.in);
boolean ans;
System.out.println("Enter day:");
dd=sc.nextInt();
System.out.println("Enter month:");
mm=sc.nextInt();
System.out.println("Enter year:");
yyyy=sc.nextInt();
try{
ans=validate();
if(ans==false)
throw new MyDateException(dd,mm,yyyy);
else
display();
}catch(MyDateException mde){
System.out.println(mde); //mde.toString();
}
}
public void display(){
System.out.println(dd+"-"+mm+"-"+yyyy);
}
}
class Slip3{
public static void main(String args[]){
MyDate md = new MyDate();
md.accept();
}
}