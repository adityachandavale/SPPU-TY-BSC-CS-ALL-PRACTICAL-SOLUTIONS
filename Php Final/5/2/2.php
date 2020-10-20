<?php
$xml=simplexml_load_file('2.xml') or die("Cannot Loaded");
echo "<table border=1>";
foreach($xml->Employee as $e){
echo "<tr>";
$a=$e->attributes();
foreach($a as $v)
echo "<td>$v</td>";
echo "<td>$e->Designation</td>";
echo "<td>$e->Salary</td>";
echo "</tr>";
}
echo "</table>";
/*
$dom=new DOMDocument();
$dom->load("2.xml");
$allemp=$dom->getElementsByTagName("Employee");
echo "<table border=1>";
foreach($allemp as $emp){
$empno=$emp->getAttribute("Empno");
$empname=$emp->getAttribute("Empname");
$salary=$emp->getElementsByTagName("Salary");
$salaryvalue=$salary->item(0)->nodeValue;
$designation=$emp->getElementsByTagName("Designation");
$designationvalue=$designation->item(0)->nodeValue;
echo "<tr>";
echo "<td>$empno</td>";
echo "<td>$empname</td>";
echo "<td>$designationvalue</td>";
echo "<td>$salaryvalue</td>";
echo "</tr>";
}e
cho "</table>";
*/
?>