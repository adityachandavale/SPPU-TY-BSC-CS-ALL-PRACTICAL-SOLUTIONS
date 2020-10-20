import java.util.*;
import java.io.*;
class Slip15{
	public static void main(String args[])throws IOException{
		/*
		Hashtable ht = new Hashtable;
		ht.put("abcd",55);
		ht.put("xyzw",66);
		ht.put("mnop",77);
		ht.put("pqrs",88);
		ht.put("aaaa",99);
		
		System.out.println(ht);
		
		if(ht.containsKey("pqrs"))
			System.out.println(ht.get("pqrs"));
		else
			System.out.println("pqrs not found");
		*/
	
	
		int n,i;
		String name;
		Double per;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Hashtable ht=new Hashtable();
		
		System.out.println("Enter how many students");
		n=Integer.parseInt(br.readLine());

		System.out.println("Enter Details of students");
		for(i=0;i<n;i++){
			System.out.println("Student "+(i+1));
			System.out.println("Enter Name : ");
			name=br.readLine();
			System.out.println("Enter Percentage : ");
			per=Double.parseDouble(br.readLine());
			ht.put(name,per);

			}
		
		System.out.println("All Students are");
		Enumeration e1=ht.keys();
		while(e1.hasMoreElements()){
			name=(String)e1.nextElement();
			per=(Double)ht.get(name);
			System.out.println(name+" "+per);
		}
		/*
		Enumeration e1=ht.elements();
		while(e1.hasMoreElements()){
			System.out.println(e1.nextElement());
		}*/
		
		System.out.println("Enter name to be searched:");
		name=br.readLine();
		Enumeration e2=ht.keys();
		int flag=0;
		while(e2.hasMoreElements()){			
			if(name.equals((String)e2.nextElement())){
				flag=1;
				break;
			}
		}
		if(flag==1){
			per=(Double)ht.get(name);
			System.out.println(name+" "+per);				
		}else{
			System.out.println("student not found");
		}		
	}	
};
