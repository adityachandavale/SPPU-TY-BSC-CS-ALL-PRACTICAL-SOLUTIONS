import java.awt.event.*;
import java.awt.*;
import java.applet.*;
public class Slip9 extends Applet implements MouseListener,MouseMotionListener{
String msg="Use Mouse";
public void init(){
addMouseListener(this);
addMouseMotionListener(this);
}
public void paint(Graphics g){
g.drawString(msg,100,150);
}
public void mousePressed(MouseEvent me1){
msg="Mouse Pressed at "+me1.getX()+" "+me1.getY();
repaint();
}
public void mouseReleased(MouseEvent me2){
msg="Mouse Released at "+me2.getX()+" "+me2.getY();
repaint();
}
public void mouseClicked(MouseEvent me3){
msg="Mouse Clicked at "+me3.getX()+" "+me3.getY();
repaint();
}
public void mouseEntered(MouseEvent me4){
msg="Mouse Entered at "+me4.getX()+" "+me4.getY();
repaint();
}
public void mouseExited(MouseEvent me5){
msg="Mouse Exited at "+me5.getX()+" "+me5.getY();
repaint();
}
public void mouseMoved(MouseEvent me6){
msg="Mouse Moved at "+me6.getX()+" "+me6.getY();
repaint();
}
public void mouseDragged(MouseEvent me7){
msg="Mouse Dragged at "+me7.getX()+" "+me7.getY();
repaint();
}
}