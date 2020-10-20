<?php
$input=$_REQUEST['dir'];
$ext=$_REQUEST['ext'];
$dirname=$input;
if(is_dir($dirname)){
echo "directory is available";
$p=opendir($dirname);
while(($file=readdir($p))!=false)
if(strpos($file,$ext)){
$x=$dirname."\\".$file; //for linux use /
echo "<br>$file ".filesize($x);
}
}else{
echo "directory is not available";
}
?>