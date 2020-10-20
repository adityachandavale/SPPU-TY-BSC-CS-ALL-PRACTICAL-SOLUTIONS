<?php
abstract class Shape{
abstract function area();
}
class Circle extends Shape{
private $r;
function __construct($r){
$this->r=$r;
}
function area(){
$a=3.14*$this->r*$this->r;
echo "<br>Area of Circle is ".$a;
}
}
class Rectangle extends Shape{
private $a;
private $b;
function __construct($a,$b){
$this->a=$a;
$this->b=$b;
}
function area(){
$area=$this->a*$this->b;
echo "<br>Area of Rectangle is ".$area;
}
}
class Triangle extends Shape{
private $a;
private $b;
function __construct($a,$b){
$this->a=$a;
$this->b=$b;
}
function area(){
$area=3.14*$this->a*$this->b;
echo "<br>Area of Triangle is ".$area;
}
}
$op=$_REQUEST['shape'];
$s=null;
switch($op){
case "circle":$s=new Circle(5.0);
break;
case "rectangle":$s=new Rectangle(5.0,4.0);
break;
case "triangle":$s=new Triangle(5.0,3.5);
break;
}
$s->area();
?>