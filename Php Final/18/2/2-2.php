<?php
session_start();
$no=$_SESSION['no'];
$name=$_SESSION['name'];
$addr=$_SESSION['addr'];
$basic=$_REQUEST['basic'];
$da=$_REQUEST['da'];
$hra=$_REQUEST['hra'];
echo "Employee Number is ".$no."<br />";
echo "Employee Name is ".$name."<br />";
echo "Employee Address is ".$addr."<br />";
echo "Employee Basic salary is ".$basic."<br />";
echo "Employee DA is ".$da."<br />";
echo "Employee HRA is ".$hra."<br />";
echo "Total Salary is ".($basic+$da+$hra);
session_destroy();
?>