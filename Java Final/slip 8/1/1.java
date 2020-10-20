import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Slip8 extends JFrame implements ItemListener{
JPanel jp1,jp2,jp3,jp4;
JTextField jtf;
JLabel jl1,jl2,jl3;
JComboBox jcmb1,jcmb2;
JCheckBox jcb1,jcb2;
String fonts[];
Slip8(){
setLocation(50,50);
setSize(400,300);
setLayout(new BorderLayout());
jp1=new JPanel(new GridLayout(1,2));
jp3=new JPanel(new GridLayout(4,1));
jl1=new JLabel("Font");
jp3.add(jl1);
jcmb1=new JComboBox();
fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
for(int i=0;i<fonts.length;i++)
jcmb1.addItem(fonts[i]);
jcmb1.addItemListener(this);
jp3.add(jcmb1);
jl2=new JLabel("Size");
jp3.add(jl2);
jcmb2=new JComboBox();
jcmb2.addItem("10");
jcmb2.addItem("12");
jcmb2.addItem("14");
jcmb2.addItem("16");
jcmb2.addItemListener(this);
jp3.add(jcmb2);
jp4=new JPanel(new GridLayout(3,1));
jl3=new JLabel("Style");
jp4.add(jl3);
jcb1=new JCheckBox("Bold");
jcb1.addItemListener(this);
jp4.add(jcb1);
jcb2=new JCheckBox("Italic");
jcb2.addItemListener(this);
jp4.add(jcb2);
jp1.add(jp3);
jp1.add(jp4);
jp2=new JPanel();
jtf=new JTextField("This is a Swing Code",20);
jp2.add(jtf);
add(jp1,BorderLayout.CENTER);
add(jp2,BorderLayout.SOUTH);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
//pack();
}
public void itemStateChanged(ItemEvent ic){
String fontname=(String)jcmb1.getSelectedItem();
int fontsize=Integer.parseInt((String)jcmb2.getSelectedItem());
Font f;
f=new Font(fontname,Font.PLAIN,fontsize);
if(jcb1.isSelected())
f=new Font(fontname,Font.BOLD,fontsize);
if(jcb2.isSelected())
f=new Font(fontname,Font.ITALIC,fontsize);
if(jcb1.isSelected() && jcb2.isSelected())
f=new Font(fontname,Font.BOLD|Font.ITALIC,fontsize);
jtf.setFont(f);
}
public static void main(String args[]){
Slip8 s8=new Slip8();
}
}