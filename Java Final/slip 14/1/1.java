import java.io.*;
import java.util.*;
class Slip14{
public static void main(String args[]){
String line="";
int flag=0;
String data[]=new String[2];
String name;
long contact;
Scanner sc=new Scanner(System.in);
try{
System.out.println("Enter name:");
name=sc.next();
BufferedReader br=new BufferedReader(new FileReader("contact.dat"));
while((line=br.readLine())!=null){
data=line.split(" ");
//System.out.println("Name : "+data[0]);
//System.out.println("Contact : "+data[1]);
if(data[0].equals(name)){
flag=1;
break;
}
}
if(flag==1)
System.out.println("Contact Number is "+data[1]);
else
System.out.println("Name not found");
System.out.println("Enter new record ");
System.out.println("Enter name:");
name=sc.next();
System.out.println("Enter contact:");
contact=sc.nextLong();
FileWriter fw=new FileWriter("contact.dat",true);
//BufferedWriter fw=new BufferedWriter(new FileWriter("contact.dat"));
fw.write(name+" "+contact+"\n");
fw.close();
}catch(Exception e){
System.out.println(e);
}
}
}