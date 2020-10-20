package TestSeries;
import series.*;
import java.util.*;
public class Slip7{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number:");
int n=sc.nextInt();
System.out.println("Series of Prime Numbers are \n");
PrimeSeries ps=new PrimeSeries(n);
ps.display();
System.out.println("\nSeries of Square Numbers are \n");
SquareSeries ss=new SquareSeries(n);
ss.display();
}
}

/* Steps to Execute code:
javac -d . Slip7.java
java TestSeries.Slip7
*/