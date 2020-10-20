<?php
class Calculator{
private $a;
private $b;
public function __construct($x,$y){
$this->a=$x;
$this->b=$y;
}
public function getsum(){
return ($this->a + $this->b);
}
public function getdifference(){
return ($this->a - $this->b);
}
public function getproduct(){
return ($this->a * $this->b);
}
public function getdiv(){
return ($this->a / $this->b);
}
}
$no1=$_REQUEST['no1'];
$no2=$_REQUEST['no2'];
$op=$_REQUEST['op'];
$ob=new Calculator($no1,$no2);
echo "Sum is ".$ob->getsum()."<br />";
echo "Difference is ".$ob->getdifference()."<br />";
if($op=='mul')
echo "Product is ".$ob->getproduct()."<br />";
else if($op=='div')
echo "Division is ".$ob->getdiv()."<br />";
?>