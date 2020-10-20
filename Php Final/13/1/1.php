<?php
if(isset($_COOKIE['count'])){
$cnt=$_COOKIE['count'];
echo "Visitor No ".$_COOKIE['count'];
}else{
$cnt=1;
echo "this is your first time";
}
$cnt++;
setcookie('count',$cnt);
?>