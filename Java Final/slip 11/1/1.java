import java.io.*;
class Slip11{
public static void main(String args[]){
String n=args[0];
int cnt=0;
File f=new File(n);
if(f.isDirectory()){
System.out.println("It is a directory");
String name[]=f.list();
for(int i=0;i<name.length;i++){
File ff=new File(n+"\\"+name[i]);
if(ff.isFile()){
cnt++;
System.out.println("File:"+ff.getName());
}
}
System.out.println("Number of files is "+cnt);
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