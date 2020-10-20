import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Slip20 extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton jb1,jb2,jb3,jb4;
	ResultSet rs;
	Statement stmt;
	Connection con;
	public Slip20(){		
		setBounds(400,400,310,300);
		setLayout(new GridLayout(4,3));
		l1=new JLabel("NAME");
		l2=new JLabel("ADDRESS");
		l3=new JLabel("PHONE");
		l4=new JLabel("EMAIL");
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		
		jb1=new JButton("ADD");
		jb2=new JButton("DELETE");		
		jb3=new JButton("NEXT");		
		jb4=new JButton("PREVIOUS");
		
		add(l1);
		add(t1);
		add(jb1);
		add(l2);
		add(t2);
		add(jb2);
		add(l3);
		add(t3);
		add(jb3);
		add(l4);
		add(t4);
		add(jb4);		
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost/ty2016","postgres","");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("select * from phonebook");
		}catch(Exception e){
			System.out.println(e);
		}
		setVisible(true);
		pack();
	}
	public void actionPerformed(ActionEvent ae){
		try{			
		if(ae.getSource() == jb1){
			rs.moveToInsertRow();
			
			rs.updateString(1,t1.getText());
			rs.updateString(2,t2.getText());
			rs.updateInt(3,Integer.parseInt(t3.getText()));
			rs.updateString(4,t4.getText());
			
			rs.insertRow();
			
			rs.moveToCurrentRow();
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");			
		}
		if(ae.getSource() == jb2){
			rs.deleteRow();
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			jb2.setEnabled(false);
		}		
		if(ae.getSource() == jb3){
			if(rs.next()){
			t1.setText(rs.getString("name"));
			t2.setText(rs.getString("address"));
			t3.setText(rs.getString("phone"));
			t4.setText(rs.getString("email"));			
			jb4.setEnabled(true);
			jb2.setEnabled(true);
			}
			else if(rs.isAfterLast() == true){
				jb3.setEnabled(false);				
				jb2.setEnabled(false);
			}
		}
		if(ae.getSource() == jb4){
			if(rs.previous()){
			t1.setText(rs.getString("name"));
			t2.setText(rs.getString("address"));
			t3.setText(rs.getString("phone"));
			t4.setText(rs.getString("email"));
			jb3.setEnabled(true);
			jb2.setEnabled(true);
			}
			else if(rs.isBeforeFirst() == true){
				jb4.setEnabled(false);				
				jb2.setEnabled(false);
			}
		}				
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static void main(String args[]){
		Slip20 ss = new Slip20();
	}
}