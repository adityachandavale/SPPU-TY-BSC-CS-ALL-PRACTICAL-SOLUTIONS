class PrintText_Thread extends Thread{
	String msg;
	int n;
	PrintText_Thread(String m,int no){
		msg=m;
		n=no;
	}
	public void run(){
		for(int i=0;i<n;i++)
			System.out.println(msg);
	}
}

class Slip11{
	public static void main(String args[]){
    	PrintText_Thread p1=new PrintText_Thread("I AM IN FY",5);
		PrintText_Thread p2=new PrintText_Thread("I AM IN SY",2);
		PrintText_Thread p3=new PrintText_Thread("I AM IN TY",3);
		
		p1.start();
		p2.start();
		p3.start();
	}
}