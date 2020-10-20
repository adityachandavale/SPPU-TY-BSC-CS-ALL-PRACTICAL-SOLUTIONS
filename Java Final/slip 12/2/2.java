import java.util.*;
class SumThread extends Thread{
	private int no[];
	private int b,e;
	private int sum;
	SumThread(int a[],int m,int n){
		no=a;
		b=m;
		e=n;
		sum=0;
	}
	public void run(){
		for(int i=b;i<=e;i++)
			sum=sum+no[i];
	}
	public int getsum(){
		return sum;
	}
}
class Slip12{
	public static void main(String args[]){
		int a[]=new int[1000];
		int i=0,x=100;
		float tot=0.0f,avg;
		
		Random r=new Random();
		SumThread s[]=new SumThread[10];
		
		for(i=0;i<1000;i++)
			a[i]=r.nextInt(100);			
		try{
			for(i=0;i<10;i++){
				s[i]=new SumThread(a,x*i,(x*i)+99);
				s[i].start();
				s[i].join();
			}
		}catch(InterruptedException e2){}
		
		for(i=0;i<10;i++)
			tot=tot+s[i].getsum();
		
		avg=tot/1000;
		System.out.println("Average is "+avg);
	}
}