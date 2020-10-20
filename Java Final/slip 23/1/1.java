import java.util.*;
interface CreditCard{
void viewCredit();
void useCard();
void payCredit();
void increaseLimit();
}
class SilverCard implements CreditCard{
private String name;
private long cardno;
protected int creditamt;
protected int creditlimit;
SilverCard(){
name="aaa";
cardno=1234123412341234L;
creditamt=0;
creditlimit=50000;
}
void accept(){
Scanner sc=new Scanner(System.in);
System.out.println("Enter name:");
name=sc.next();
System.out.println("Enter card number:");
cardno=sc.nextLong();
}
void display(){
System.out.println("Name : "+name);
System.out.println("Card Nuber : "+cardno);
}
public void viewCredit(){
System.out.println("Credit Amount : "+creditamt);
System.out.println("Credit Limit : "+creditlimit);
}
public void useCard(){
Scanner sc=new Scanner(System.in);
int amt;
System.out.println("Enter amount you want to use:");
amt=sc.nextInt();
creditamt=creditamt+amt;
if(creditamt>creditlimit){
creditamt=creditamt-amt;
System.out.println("You cant use this amount");
}
}
public void payCredit(){
Scanner sc=new Scanner(System.in);
int amt;
System.out.println("Enter amount you want to pay:");
amt=sc.nextInt();
creditamt=creditamt-amt;
}
public void increaseLimit(){
System.out.println("You cant increase your credit limit.pls apply for gold card");
}
}
class GoldCard extends SilverCard{
GoldCard(){
creditlimit=100000;
}
public void increaseLimit(){
Scanner sc=new Scanner(System.in);
int amt;
int cnt=0;
if(cnt<3){
System.out.println("Enter amount you want to increase:");
amt=sc.nextInt();
if(amt<=5000){
creditlimit=creditlimit+amt;
cnt++;
}else{
System.out.println("only Rs 5000 can be increased at once");
}
}else{
System.out.println("You have already increased 3 times");
}
}
}
class TestCreditCard{
public static void main(String args[]){
//SilverCard sc=new SilverCard();
GoldCard sc=new GoldCard();
sc.accept();
sc.display();
sc.useCard();
sc.viewCredit();
//sc.useCard();
//sc.useCard();
//sc.viewCredit();
sc.payCredit();
sc.viewCredit();
//sc.payCredit();
sc.increaseLimit();
sc.viewCredit();
}
}