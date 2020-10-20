<?php
session_start();
$_SESSION['no']=$_REQUEST['no'];
$_SESSION['name']=$_REQUEST['name'];
$_SESSION['addr']=$_REQUEST['addr'];
?>
<form action="2-2.php">
ENTER BASIC SALARY
<input type="text" name="basic" /><br />
ENTER DA
<input type="text" name="da" /><br />
ENTER HRA
<input type="text" name="hra" /><br />
<input type="submit" />
<input type="reset" />
</form>