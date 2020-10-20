import java.applet.*;
import java.awt.event.*;
import java.awt.*;
public class Slip19 extends Applet implements KeyListener{
String msg1="Key Pressed ";
String msg2="Key Typed ";
String msg3="Key Released ";
public void init(){
addKeyListener(this);
}
public void paint(Graphics g){
g.drawString(msg1,100,150);
g.drawString(msg2,100,175);
g.drawString(msg3,100,200);
}
public void keyPressed(KeyEvent ke1){
msg1+=ke1.getKeyChar();
repaint();
}
public void keyReleased(KeyEvent ke2){
msg3+=ke2.getKeyChar();
repaint();
}
public void keyTyped(KeyEvent ke3){
msg2+=ke3.getKeyChar();
repaint();
}
}