<?php
$ls=$_REQUEST['ls'];
$ss=$_REQUEST['ss'];
$rs=$_REQUEST['rs'];
$op=$_REQUEST['op'];
switch($op){
case 1:
if(ereg("^$ss",$ls))
echo "Small string appears at the start of large string";
else
echo "Small string doesn't appear at the start of large string";
break;
case 2:
$temp=ereg_replace($ss,$rs,$ls);
echo "New String is $temp";
break;
}
?>