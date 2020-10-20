<?php
$state=array('mh'=>'maharashtra','kn'=>'karnataka','pu'=>'punjab','gj'=>'gujrat');
$op=$_POST['op'];
switch($op){
case 1:
$rev=array_flip($state);
print_r($rev);
break;
case 2:
shuffle($state);
print_r($state);
break;
}
?>