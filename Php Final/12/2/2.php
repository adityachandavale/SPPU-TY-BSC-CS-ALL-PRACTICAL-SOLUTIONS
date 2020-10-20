<?php
$op=$_REQUEST['op'];
$city=array("pune","mumbai","nashik");
switch($op){
case 1:
echo "Before Inserting<br>";
print_r($city);
array_push($city,"nagpur");
echo "<br>After Inserting<br>";
print_r($city);
break;
case 2:
echo "Before Deleting<br>";
print_r($city);
$c=array_pop($city);
echo "<br>Element Popped is $c<br>";
echo "After Deleting<br>";
print_r($city);
break;
}
?>