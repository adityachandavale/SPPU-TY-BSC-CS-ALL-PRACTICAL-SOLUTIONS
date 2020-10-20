import java.io.*;
import java.util.*;
class Slip15{
public static void main(String args[]){
String line="";
int flag=0;
String data[]=new String[4];
String name;
Scanner sc=new Scanner(System.in);
int price=0,id=0,qty=0;
int tot=0;
try{
System.out.println("Enter name:");
name=sc.next();
BufferedReader br;
br=new BufferedReader(new FileReader("item.dat"));
while((line=br.readLine())!=null){
data=line.split(" ");
if(data[1].equals(name)){
flag=1;
break;
}
}
if(flag==1){
System.out.println("Id : "+data[0]);
System.out.println("Name : "+data[1]);
System.out.println("Quantity : "+data[2]);
System.out.println("Price : "+data[3]);
}
else
System.out.println("Name not found");
br=new BufferedReader(new FileReader("item.dat"));
while((line=br.readLine())!=null){
data=line.split(" ");
if(Integer.parseInt(data[3])>price){
id=Integer.parseInt(data[0]);
name=data[1];
qty=Integer.parseInt(data[2]);
price=Integer.parseInt(data[3]);
}
}
System.out.println("\n\nThe Costliest Item id is "+id);
System.out.println("The Costliest Item name is "+name);
System.out.println("The Costliest Item quantity is "+qty);
System.out.println("The Costliest Item price is "+price);
System.out.println("\n\nAll Details are as follows\n\n");
br=new BufferedReader(new FileReader("item.dat"));
while((line=br.readLine())!=null){
data=line.split(" ");
System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]);
tot=tot+(Integer.parseInt(data[2])*Integer.parseInt(data[3]));
}
System.out.println("Total Cost is "+tot);
}catch(Exception e){
System.out.println(e);
}
}
}