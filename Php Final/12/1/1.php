<?php
session_start();
if(isset($_SESSION['count'])){
$_SESSION['count']=$_SESSION['count']+1;
echo "Visitor No ".$_SESSION['count'];
}else{
$_SESSION['count']=1;
echo "this is your first time";
}
?>