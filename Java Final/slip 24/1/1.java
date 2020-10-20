import java.util.*;
class Vehicle{
private String company;
private double price;
Vehicle(){
company="aaa";
price=1.5;
}
Vehicle(String company,double price){
this.company=company;
this.price=price;
}
void accept(){
Scanner sc=new Scanner(System.in);
System.out.println("Enter company name:");
company=sc.next();
System.out.println("Enter price in lacs:");
price=sc.nextDouble();
}
void display(){
System.out.println("Company Name : "+company);
System.out.println("Price : "+price);
}
}
class LMV extends Vehicle{
private float mileage;
LMV(){
mileage=0.0f;
}
LMV(float mileage){
this.mileage=mileage;
}
void accept(){
super.accept();
Scanner sc=new Scanner(System.in);
System.out.println("Enter Mileage:");
mileage=sc.nextFloat();
}
void display(){
super.display();
System.out.println("Mileage : "+mileage);
}
}
class HMV extends Vehicle{
private double capacity;
HMV(){
capacity=0.0;
}
HMV(double capacity ){
this.capacity=capacity;
}
void accept(){
super.accept();
Scanner sc=new Scanner(System.in);
System.out.println("Enter Capacity in tons:");
capacity=sc.nextDouble();
}
void display(){
super.display();
System.out.println("Capacity : "+capacity);
}
}
class TestVehicle{
public static void main(String args[]){
int n,i,ch;
LMV l[]=new LMV[100];
HMV h[]=new HMV[100];
Scanner sc=new Scanner(System.in);
System.out.println("Enter number of vehicle:");
n=sc.nextInt();
System.out.println("1:Light Motor Vehicle");
System.out.println("2:Heavy Motor Vehicle");
for(i=0;i<n;i++){
System.out.println("Enter choice:");
ch=sc.nextInt();
switch(ch){
case 1:l[i]=new LMV();
l[i].accept();
l[i].display();
break;
case 2:h[i]=new HMV();
h[i].accept();
h[i].display();
break;
default: i--;
System.out.println("Invalid choice");
}
}
}
}