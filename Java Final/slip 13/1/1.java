import java.io.*;
import java.util.*;
class Slip13{
public static void main(String args[]){
String n=args[0];
String ch;
int cnt=0;
File f=new File(n);
Scanner sc=new Scanner(System.in);
if(f.isDirectory()){
System.out.println("It is a directory");
String name[]=f.list();
for(int i=0;i<name.length;i++){
File ff=new File(n+"\\"+name[i]);
if(ff.isFile()){
if(name[i].endsWith("txt")){
System.out.println("File Found : "+name[i]);
System.out.println("Do you want to delete it?(y/n)");
ch=sc.next();
if(ch.charAt(0)=='y' || ch.charAt(0)=='Y'){
ff.delete();
System.out.println("Deleted Successfully");
cnt++;
}
}
}
}
System.out.println("Number of Deleted Text files is "+cnt);
}else if(f.isFile()){
System.out.println("File Name:"+f.getName());
System.out.println("File Path:"+f.getPath());
System.out.println("Absolute Path:"+f.getAbsolutePath());
System.out.println("Length:"+f.length());
System.out.println("Last Modified:"+f.lastModified());
System.out.println("(Readable?):"+f.canRead());
System.out.println("(Writable?):"+f.canWrite());
System.out.println("(Hidden?):"+f.isHidden());
}else{
System.out.println("this file is not available");
}
}
}