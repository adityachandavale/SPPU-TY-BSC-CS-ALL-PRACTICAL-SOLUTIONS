<?php
$email=$_REQUEST['email'];
$cnt=0;
//Number of @ must be 1
if(substr_count($email,"@")==1);
else
$cnt++;
$split=explode('@',$email);
$part1=$split[0];
$part2=$split[1];
//regular expression for valid emailid without special symbol
// ^ beginning of line
// $ end of line
// \ following character
// - represents all characters between two characters
// + 1 or more occurences
// * 0 or more occurences
// {} number of repetitions
// ? 1 or no occurence of the preceeding character
if(ereg("^[a-zA-Z]+[0-9]*\.?[a-zA-Z0-9]*$",$part1));
else
$cnt++;
if(ereg("^[a-zA-Z]+\.?[a-zA-Z]+\.{1}[a-zA-Z]*$",$part2));
else
$cnt++;
if($cnt==0)
echo "Valid Email";
else
echo "Invalid Email";
?>