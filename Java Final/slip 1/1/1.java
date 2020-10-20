abstract class Shape{
abstract void area();
abstract void volume();
}
class Sphere extends Shape{
float v;
float r;
float a;
Sphere(){
r=1.0f;
}
Sphere(float r){
this.r=r;
}
void area(){
a=4*3.14f*r*r;
System.out.println("Area of Circle is "+a);
}
void volume(){
v=(4/3)*3.14f*r*r*r;
System.out.println("Volume of Circle is "+v);
}
}
class Cylinder extends Shape{
float a;
float v;
float r;
float h;
Cylinder(){
r=1.0f;
h=2.0f;
}
Cylinder(float r,float h){
this.r=r;
this.h=h;
}
void area(){
a=(2*3.14f*r*r)+(2*3.14f*r*h);
System.out.println("area of rectangle is "+a);
}
void volume(){
v=3.14f*r*r*h;
System.out.println("volume of rectangle is "+v);
}
}
class Cone extends Shape{
float a;
float v;
float l;
float r;
float h;
Cone(){
l=1.0f;
r=1.0f;
h=2.0f;
}
Cone(float l,float r,float h){
this.l=l;
this.r=r;
this.h=h;
}
void area(){
a=3.14f*r*(l*r);
System.out.println("area of rectangle is "+a);
}
void volume(){
v=(1/3)*(3.14f*r*r*h);
System.out.println("volume of rectangle is "+v);
}
}
class Slip1{
public static void main(String args[]){
Shape s;
s=new Sphere(3.5f);
s.area();
s.volume();
s=new Cylinder(2.5f,3.5f);
s.area();
s.volume();
s=new Cone(1.5f,2.5f,3.5f);
s.area();
s.volume();
}
}