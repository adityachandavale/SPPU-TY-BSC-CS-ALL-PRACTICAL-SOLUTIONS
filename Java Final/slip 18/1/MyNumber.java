public class MyNumber{
private int a;
public MyNumber(){
a=0;
}
public MyNumber(int x){
a=x;
}
public boolean isPositive(){
if(a>0)
return true;
else
return false;
}
public boolean isNegative(){
if(a<0)
return true;
else
return false;
}
public boolean isZero(){
if(a==0)
return true;
else
return false;
}
public boolean isEven(){
if(a%2==0)
return true;
else
return false;
}
public boolean isOdd(){
if(a%2 !=0)
return true;
else
return false;
}
public static void main(String args[]){
int n=args.length;
int no;
if(n==1){
no=Integer.parseInt(args[0]);
MyNumber mn=new MyNumber(no);
if(mn.isNegative())
System.out.println(no+" is a negative number");
if(mn.isPositive())
System.out.println(no+" is a positive number");
if(mn.isZero())
System.out.println(no+" is Zero");
if(mn.isEven())
System.out.println(no+" is an even number");
if(mn.isOdd())
System.out.println(no+" is an odd number");
}else{
System.out.println("Invalid input");
}
}
}