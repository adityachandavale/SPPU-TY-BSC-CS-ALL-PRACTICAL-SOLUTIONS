import java.io.*;
class Employee{
private int id;
private String name;
private String dept;
private float sal;
Employee(){
id=1;
name="abc";
dept="comp";
sal=5000.00f;
}
Employee(int id,String name,String dept,float sal){
this.id=id;
this.name=name;
this.dept=dept;
this.sal=sal;
}
void accept(){
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
try{
System.out.println("Enter id:");
id=Integer.parseInt(br.readLine());
System.out.println("Enter name:");
name=br.readLine();
System.out.println("Enter department:");
dept=br.readLine();
System.out.println("Enter salary:");
sal=Float.parseFloat(br.readLine());
}catch(Exception e){
System.out.println(e);
}
}
void display(){
System.out.println("Id : "+id);
System.out.println("Department : "+dept);
System.out.println("Name : "+name);
System.out.println("Salary : "+sal);
}
float getSalary(){
return sal;
}
}
class Manager extends Employee{
private float bonus;
private float tot;
Manager(){
this.bonus=50.00f;
tot=getSalary()+bonus;
}
Manager(int id,String name,String dept,float sal,float bonus){
super(id,name,dept,sal);
this.bonus=bonus;
tot=getSalary()+bonus;
}
void accept(){
super.accept();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
try{
System.out.println("Enter bonus:");
bonus=Float.parseFloat(br.readLine());
}catch(Exception e){
System.out.println(e);
}
tot=getSalary()+bonus;
}
void display(){
super.display();
System.out.println("Bonus : "+bonus);
System.out.println("Total Salary : "+tot);
}
//Number of employees from command line
public static void main(String args[]){
int n=args.length;
int i,no=0;
Manager m[]=new Manager[100];
if(n==1){
no=Integer.parseInt(args[0]);
for(i=0;i<no;i++){
m[i]=new Manager();
m[i].accept();
m[i].display();
}
}else{
System.out.println("Invalid input");
}
Manager max=new Manager();
max=m[0];
for(i=0;i<no;i++){
if(m[i].tot>max.tot)
max=m[i];
}
max.display();
}
}