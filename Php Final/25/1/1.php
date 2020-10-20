<?php
$data=$_REQUEST['data'];
$element=$_REQUEST['element'];
$op=$_REQUEST['op'];
$state=array("mh"=>array('pune','mumbai','nashik'),"gj"=>array('rajkot','gandhinagar','ahmedabad'));
switch($op){
case 1:
echo "{$state[$data][$element]}";
break;
case 2:
unset($state[$data][$element]);
print_r($state);
break;
}
?>