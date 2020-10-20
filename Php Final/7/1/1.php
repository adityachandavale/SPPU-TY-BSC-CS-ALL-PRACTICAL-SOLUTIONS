<?php
$a=$_REQUEST['fname'];
$op=$_REQUEST['op'];
switch($op){
case 1: echo "Type of file is ".filetype($a);
break;
case 2: unlink($a);
echo "Deleted Successfully";
break;
}
?>