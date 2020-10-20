<?php
$no=$_REQUEST['no'];
$a=array(5,9,11,17,12,19);
search($no,$a);
function search($no,$a){
$flag=0;
foreach($a as $v){
if($no==$v){
$flag=1;
break;
}
}
if($flag==1)
echo $no." is found ";
else
echo $no." is not found";
}
?>