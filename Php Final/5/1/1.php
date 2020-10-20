<?php
echo "Host : ".$_SERVER['REMOTE_ADDR']."<br />";
echo "Scheme : ".$_SERVER['HTTP_USER_AGENT']."<br />";
if(isset($_SERVER['HTTPS']))
echo "request is sent by HTTPS";
else{
echo "request is sent by HTTP";
}
?>