import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.sql.*;

public class Slip13 extends JFrame{
	int no,cnt,i;	
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	JTable table;
	DefaultTableModel t1=new DefaultTableModel();
	
	Slip13(){
		setLayout(new BorderLayout());
		setSize(300,300);
		setLocation(50,50);
			
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			/*
			ps=con.prepareStatement("insert into student values(?,?,?)");
			
			System.out.println("Enter no of Students: ");
			no=Integer.parseInt(br.readLine());
			for(i=0;i<no;i++){
				System.out.println("Enter Roll Number:");
				ps.setInt(1,Integer.parseInt(br.readLine()));
				System.out.println("Enter Name:");
				ps.setString(2,br.readLine());
				System.out.println("Enter Percentage:");
				ps.setFloat(3,Float.parseFloat(br.readLine()));
				ps.executeUpdate();
			}			
			*/
			
			rs=stmt.executeQuery("select count(stid) from student");
			rs.first();
			cnt=rs.getInt(1);//for row count
			
			rs=stmt.executeQuery("select * from student");
			
			t1.setColumnIdentifiers(new Object[]{"RollNo","Name","Percentage"});
			/*
			t1.addColumn("RollNO");
			t1.addColumn("Name");
			t1.addColumn("Percentage");
			*/
			Object rec[][] = new Object[cnt][3];
			
			i=0;
			while(rs.next()){
				rec[i][0]=""+rs.getInt(1);
				rec[i][1]=rs.getString(2);
				rec[i][2]=""+rs.getFloat(3);
				t1.addRow(rec[i]);
				i++;
			}

			table = new JTable(t1);
			add(table,BorderLayout.CENTER);
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);										
		}
		catch(Exception e){
			System.out.println(e);
		}		
	}

	public static void main(String[] args){		
		Slip13 s13=new Slip13();
	}
}
