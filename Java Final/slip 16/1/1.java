import java.io.*;
class CricketPlayer{
	private String name;
	private int innings;
	private int notout;
	private int runs;
	private float average;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	
	public void accept(){
		try{
			System.out.println("Enter name:");
			name=br.readLine();
			System.out.println("Enter number of innings:");
			innings=Integer.parseInt(br.readLine());
			System.out.println("Enter number of notout:");
			notout=Integer.parseInt(br.readLine());
			System.out.println("Enter total runs:");
			runs=Integer.parseInt(br.readLine());
			
		}catch(Exception e){System.out.println(e);}
	}
	public void display(){
		System.out.println("Name : "+name);
		System.out.println("Innings : "+innings);
		System.out.println("Notout : "+notout);
		System.out.println("Total Runs : "+runs);
		System.out.println("Average : "+average);	
	}
	public static void sort(CricketPlayer cp[],int n){
		CricketPlayer t;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(cp[i].average>cp[j].average){
					t=cp[i];
					cp[i]=cp[j];
					cp[j]=t;
				}
			}
		}		
	}
	public static void avg(CricketPlayer cp[],int n){
		try{
			for(int i=0;i<n;i++){
				cp[i].average=cp[i].runs/(cp[i].innings-cp[i].notout);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
class Slip16{
	public static void main(String args[]){
		int n,i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CricketPlayer cp[];
		try{
			System.out.println("Enter how many players:");
			n=Integer.parseInt(br.readLine());
			cp=new CricketPlayer[n]; //array of references
			for(i=0;i<n;i++){
				cp[i]=new CricketPlayer();
				cp[i].accept();				
			}
				
			CricketPlayer.avg(cp,n);
			
			System.out.println("Before Sorting");
			for(i=0;i<n;i++)
				cp[i].display();									
			
			CricketPlayer.sort(cp,n);
			System.out.println("Sorted Players are as follows");
			for(i=0;i<n;i++){
				cp[i].display();
			}
			
		}catch(Exception e){System.out.println(e);}
	}
}
