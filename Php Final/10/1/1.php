<?php
$email=$_POST['email'];
$cnt1=substr_count($email,"@");
$cnt2=substr_count($email,".");
echo "Number of @ is ".$cnt1;
echo "Number of . is ".$cnt2;
?>