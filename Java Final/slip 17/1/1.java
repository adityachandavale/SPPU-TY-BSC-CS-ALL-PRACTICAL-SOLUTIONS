import java.io.*;
class Slip17{
	public static void main(String args[]){
		int n,i,ch,nhrs,rate;
		String name,address,dept;
		float salary;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Enter how many staffs:");
			n=Integer.parseInt(br.readLine());
			Staff s[]=new Staff[n];
			for(i=0;i<n;i++){
				System.out.println("Enter name:");
				name=br.readLine();
				System.out.println("Enter address:");
				address=br.readLine();
				System.out.println("1:ParttimeStaff\n2:FullTimeStaff");
				System.out.println("Enter your choice:");
				ch=Integer.parseInt(br.readLine());
				if(ch==1){
					System.out.println("Enter number of hours worked:");
					nhrs=Integer.parseInt(br.readLine());
					System.out.println("Enter rate:");
					rate=Integer.parseInt(br.readLine());
					s[i]=new PartTimeStaff(name,address,nhrs,rate);
				}else if(ch==2){
					System.out.println("Enter department:");
					dept=br.readLine();
					System.out.println("Enter salary:");
					salary=Float.parseFloat(br.readLine());
					s[i]=new FullTimeStaff(name,address,dept,salary);
				}				
			}
			
			System.out.println("All staffs are as follows");
			for(i=0;i<n;i++){
				s[i].display();
			}
		}catch(IOException e){}
	}
}
