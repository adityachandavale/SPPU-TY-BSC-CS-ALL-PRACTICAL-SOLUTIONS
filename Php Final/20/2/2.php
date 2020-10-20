<?php
// Array with names
$a[] = "Megha";
$a[] = "Neha";
$a[] = "Devika";
$a[] = "Chinmay";
$a[] = "Akash";
$a[] = "Rohit";
$a[] = "Sudhir";
$a[] = "Manoj";
$a[] = "Ajay";
$a[] = "Tejas";
$a[] = "Shaunak";
$a[] = "Antima";
$a[] = "Divya";
$a[] = "Meenakshi";
$a[] = "Revti";
$a[] = "Pooja";
$a[] = "Sayali";
$a[] = "Minal";
$a[] = "Ayesha";
$a[] = "Priyanka";
$a[] = "Ketki";
$a[] = "Harshada";
$a[] = "Namrata";
$a[] = "Akshata";
$a[] = "Akshay";
$a[] = "Anagha";
$a[] = "Diksha";
$a[] = "Prajakta";
$a[] = "Pranali";
$a[] = "Prasad";
$a[] = "Priya";
$a[] = "Radhika";
$a[] = "Sampat";
$a[] = "Saudamini";
$a[] = "Sharmila";
$a[] = "Shivani";
$a[] = "Shubham";
$a[] = "Shweta";
$a[] = "Sneha";
$a[] = "Suvarna";
$a[] = "Mayur";
// get the q parameter from URL
$q = $_REQUEST["q"];
$hint = array();
if ($q !== "") {
$q = strtolower($q);
$len=strlen($q);
$i=0;
foreach($a as $name){
if (stristr($q, substr($name, 0, $len))) {
$hint[$i]=$name;
$i++;
}
}
}
print_r($hint);
?>