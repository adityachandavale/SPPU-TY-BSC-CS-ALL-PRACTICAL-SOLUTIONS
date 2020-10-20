<?php
session_start();
if(!isset($_SESSION['cnt']))
$_SESSION['cnt']=0;
$usr=$_REQUEST['user'];
$pass=$_REQUEST['pass'];
if($_SESSION['cnt']<3){
if($usr=="nsg" && $pass="nsg"){
echo "valid user";
$_SESSION['cnt']=0;
}else{
$_SESSION['cnt']=$_SESSION['cnt']+1;
echo "invalid user".$_SESSION['cnt'];
}
}else{
echo "you have entered incorrect information more than thrice";
//session_destroy();
}
?>