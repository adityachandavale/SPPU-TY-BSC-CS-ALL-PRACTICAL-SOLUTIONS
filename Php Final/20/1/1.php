<?php
$str=$_REQUEST['str'];
$op=$_REQUEST['op'];
switch($op){
case 1: echo strtoupper($str);
break;
case 2:echo ucfirst($str);
break;
}
?>