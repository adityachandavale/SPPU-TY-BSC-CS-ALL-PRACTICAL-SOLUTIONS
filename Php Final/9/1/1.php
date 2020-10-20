<?php
$email=$_POST['email'];
$part=explode("@",$email);
$no=count($part)-1;
echo "Number of @ is ".$no;
if($no!=1)
echo "<br>@ in email id should be one only";
?>