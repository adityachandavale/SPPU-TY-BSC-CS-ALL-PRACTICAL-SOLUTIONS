import java.sql.*;
import java.io.*;

class Slip7{
	public static void main(String args[]){
		try{
			Connection con;
			Statement stmt;
			PreparedStatement psinsert,psdelete,psupdate1,psupdate2;
			ResultSet rs;
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int ch,ch1;
			int roll,ans=0;
			String name;
			float mks;
			
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost/tymorning17","postgres","");
			stmt=con.createStatement();
			
			psinsert=con.prepareStatement("insert into student values(?,?,?)");
			psupdate1=con.prepareStatement("update student set stname=? where stid=?");
			psupdate2=con.prepareStatement("update student set stmks=? where stid=?");
			psdelete=con.prepareStatement("delete from student where stid=?");
			
			do{
				System.out.println("1:insert\n2:Update\n3:Delete\n4:Search\n5:ViewAll\n6:Exit");
				System.out.print("Enter your choice:");
				ch=Integer.parseInt(br.readLine());
				switch(ch){
					case 1: System.out.println("Enter roll number:"); 
							roll=Integer.parseInt(br.readLine());
							System.out.println("Enter name:");
							name=br.readLine();
							System.out.println("Enter marks:");
							mks=Float.parseFloat(br.readLine());
							try{
								psinsert.setInt(1,roll);  //placeholder no 1
								psinsert.setString(2,name);
								psinsert.setFloat(3,mks);
								psinsert.executeUpdate();
								
								System.out.println("inserted successfully");
							}catch(SQLException e1){
								System.out.println("roll number already exist");
							}
							break;
					case 2: System.out.println("Enter roll number you want to update:");
							roll=Integer.parseInt(br.readLine());
							
							System.out.println("1:Update name\n2:Update mks");
							System.out.println("Enter your choice:");
							ch1=Integer.parseInt(br.readLine());
							
							if(ch1==1){
								System.out.println("Enter new name:");
								name=br.readLine();
								psupdate1.setString(1,name);
								psupdate1.setInt(2,roll);
								ans=psupdate1.executeUpdate();
							}else{
								System.out.println("Enter marks:");
								mks=Float.parseFloat(br.readLine());
								psupdate2.setFloat(1,mks);
								psupdate2.setInt(2,roll);
								ans=psupdate2.executeUpdate();
							}
							
							if(ans==1)
								System.out.println("Updated Successfully");
							else
								System.out.println("Roll number not found");
							break;
					case 3: System.out.println("Enter roll number you want to delete:");
							roll=Integer.parseInt(br.readLine());
							
							psdelete.setInt(1,roll);
							ans=psdelete.executeUpdate();
							
							if(ans==1)
								System.out.println("Deleted Successfully");
							else
								System.out.println("Roll number not found");
							break;
					case 4: System.out.println("Enter roll number you want to search:");
							roll=Integer.parseInt(br.readLine());
							
							rs=stmt.executeQuery("select * from student where stid="+roll);
							
							if(!rs.isBeforeFirst())
								System.out.println("roll number not found");
							else{
								rs.next();
								System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
							}	
							break;
					case 5: rs=stmt.executeQuery("select * from student");
							while(rs.next()){
								System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
							}
							break;
				}
			}while(ch!=6);
		
		}catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}catch(SQLException sqle){
			System.out.println(sqle);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}