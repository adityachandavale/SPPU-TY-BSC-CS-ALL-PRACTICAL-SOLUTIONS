<?php
$srcfile=$_REQUEST['first'];
$destfile=$_REQUEST['second'];
$src=fopen($srcfile,"r+");
$dest=fopen($destfile,"a");
while(!feof($src)){
$line=fgets($src);
fwrite($dest,$line);
}
fclose($src);
fclose($dest);
?>
JAVA