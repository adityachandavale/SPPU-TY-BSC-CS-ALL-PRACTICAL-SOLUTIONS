import java.util.*;
class InsufficientFundsException extends Exception{
public String toString(){
return "You cant cross minimum balance 500";
}
}
class SavingAccount{
private long actno;
private String name;
private long bal;
public SavingAccount(String n,long ano,long ba){
actno=ano;
name=n;
bal=ba;
}
public void viewBalance(){
System.out.println("Your current balance is "+bal);
}
public void deposit(long amt){
bal=bal+amt;
viewBalance();
}
public void withdraw(long amt){
try{
bal=bal-amt;
if(bal<500){
bal=bal+amt;
throw new InsufficientFundsException();
}
}catch(InsufficientFundsException ife){
System.out.println(ife);
}
viewBalance();
}
public static void main(String args[]){
String name;
long x,y;
Scanner sc=new Scanner(System.in);
System.out.println("Enter name:");
name=sc.next();
System.out.println("Enter Account Number:");
x=sc.nextLong();
System.out.println("Enter initial balance:");
y=sc.nextLong();
SavingAccount sa=new SavingAccount(name,x,y);
sa.viewBalance();
int ch;
do{
System.out.println("1. Deposit\n2.Withdraw\nEnter your choice\n");
ch=sc.nextInt();
if(ch==1){
	System.out.println("Enter amount for deposit:");
	x=sc.nextLong();
	sa.deposit(x);
}
else if(ch==2){
	System.out.println("Enter amount you want to withdraw:");
	x=sc.nextLong();
	sa.withdraw(x);
}
}while(ch<3 && ch>0 && ch!=0);
/*
System.out.println("Enter amount for deposit:");
x=sc.nextLong();
sa.deposit(x);
System.out.println("Enter amount for deposit:");
x=sc.nextLong();
sa.deposit(x);
System.out.println("Enter amount for deposit:");
x=sc.nextLong();
sa.deposit(x);
System.out.println("Enter amount you want to withdraw:");
x=sc.nextLong();
sa.withdraw(x);
System.out.println("Enter amount you want to withdraw:");
x=sc.nextLong();
sa.withdraw(x);*/
}
}