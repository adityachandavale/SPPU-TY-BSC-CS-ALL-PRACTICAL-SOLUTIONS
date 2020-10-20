import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Slip16 extends JFrame implements ActionListener{
	JList jl1;
	JTextField jtfcity,jtfcode,jtfcity1;
	JButton jbadd,jbsearch,jbremove;
	JPanel jp2;
	DefaultListModel dlm;
	JScrollPane jsp;
	Hashtable ht = new Hashtable();
	public Slip16() {
		setLocation(50,50);
		setSize(500,200);
		setLayout(new GridLayout(1,2));
		
		dlm=new DefaultListModel();
		jl1=new JList(dlm);
		jsp=new JScrollPane(jl1);
		add(jsp);		
		
		jp2=new JPanel(new GridLayout(4,2));
		
		jtfcity=new JTextField(20);
		jp2.add(jtfcity);
		
		jtfcode=new JTextField(20);
		jp2.add(jtfcode);
		
		jbadd = new JButton("Add");
		jp2.add(jbadd);
		jbadd.addActionListener(this);
				
		jtfcity1=new JTextField(20);
		jp2.add(jtfcity1);
		
		jbsearch = new JButton("Search");
		jp2.add(jbsearch);
		jbsearch.addActionListener(this);
		
		jbremove= new JButton("Remove");
		jp2.add(jbremove);
		jbremove.addActionListener(this);
		
		add(jp2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	public void actionPerformed(ActionEvent e){
		String city="";
		String code="";
		String city1="";
		String str="";
		int flag=0;
		
		if(e.getSource()==jbadd){
			city=jtfcity.getText();
			code=jtfcode.getText();
			if(city.equals("") && code.equals(""))
				JOptionPane.showMessageDialog(this,"Please Enter city and code");
			else{
				if(ht.containsKey(city)){
					JOptionPane.showMessageDialog(this,"City already exist");
				}else{
				ht.put(city,code);
				//System.out.println(ht);
				dlm.addElement(city+" "+code);						
				}
			}
		}
		if(e.getSource()==jbsearch){
			if(dlm.size()==0){
				JOptionPane.showMessageDialog(null,"No Element to search");
			}
			else{
				city1=jtfcity1.getText();
				/*
				flag=-1;
				for(int i=0;i<dlm.getSize();i++){
					str=(String)dlm.getElementAt(i);						
					if(str.contains(city1)){						
						flag=1;
						break;
					}
				}
				if(flag>=0)
					JOptionPane.showMessageDialog(null,"City found");
				else
					JOptionPane.showMessageDialog(this,"City not found");				
				*/
				boolean ans;
				ans=ht.containsKey(city1);
				if(ans==true)
					JOptionPane.showMessageDialog(null,"City found");
				else
					JOptionPane.showMessageDialog(this,"City not found");				
			}
		}
		
		if(e.getSource()==jbremove){
			int i;
			city1=jtfcity1.getText();
			if(dlm.size()==0)
				JOptionPane.showMessageDialog(null,"No element to remove");
			else{
				/*
				for(i=0;i<dlm.getSize();i++){
					str=(String)dlm.getElementAt(i);
					if(str.contains(city1)){						
						flag=1;
						break;
					}
				}
				
				
				if(flag==1)
					dlm.removeElementAt(i);									
				else
					JOptionPane.showMessageDialog(null,"City not found");
				*/
				boolean ans=ht.containsKey(city1);
				if(ans==true){
					dlm.removeElement(city1+" "+ht.get(city1));					
					ht.remove(city1);		
					//System.out.println(ht);
					JOptionPane.showMessageDialog(null,"City found and deleted");
				}else{
					JOptionPane.showMessageDialog(null,"City not found");
				}				
			}				
		}
		jtfcity.setText("");
		jtfcity1.setText("");
		jtfcode.setText("");
	}
	
	public static void main(String[] args){
		Slip16 s16=new Slip16();
	}	
}