import java.util.*;
import java.io.*;
class Slip19{
	public static void main(String args[]) throws IOException{
		int no;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		TreeSet ts=new TreeSet();
		System.out.println("Enter how many numbers: ");
		int n=Integer.parseInt(br.readLine());
		System.out.println("Enter "+n+" numbers:");
		for(int i=0;i<n;i++){
			no=Integer.parseInt(br.readLine());
			ts.add(no);
		}
		
		System.out.println("Sorted Numbers are as follows");
		System.out.println(ts);
		
		System.out.println("Enter the number to be searched:");
		no=Integer.parseInt(br.readLine());
		
		if(ts.contains(no)==true)
			System.out.println("Number is found");
		else
			System.out.println("Number is not found");
	}
}