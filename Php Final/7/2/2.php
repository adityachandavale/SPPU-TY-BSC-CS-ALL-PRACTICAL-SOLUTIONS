<?php
$doc = "<?xml version='1.0' ?>";
$doc .= "<BookStore>";
$doc .= "<Books>";
$doc .= "<Php>";
$doc .= "<Title>";
$doc .= "Programming in PHP";
$doc .= "</Title>";
$doc .= "<publication>";
$doc .= "oRelly";
$doc .= "</publication>";
$doc .= "</Php>";
$doc .= "<Php>";
$doc .= "<Title>";
$doc .= "Beginners PHP";
$doc .= "</Title>";
$doc .= "<publication>";
$doc .= "WROX";
$doc .= "</publication>";
$doc .= "</Php>";
$doc .= "</Books>";
$doc .= "</BookStore>";
$fp = fopen('Slip7b.xml','w');
fwrite($fp,$doc);
echo "File successfully created";
?>