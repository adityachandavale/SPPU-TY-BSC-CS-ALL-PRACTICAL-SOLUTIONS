<?php
$state=array("mh"=>"maharashtra","pu"=>"punjab","kn"=>"karnataka");
$op=$_POST['op'];
switch($op){
case 1:
print_r($state);
break;
case 2:
print_r($state);
echo "<br />";
$a=sizeof($state);
print($a);
break;
}
?>