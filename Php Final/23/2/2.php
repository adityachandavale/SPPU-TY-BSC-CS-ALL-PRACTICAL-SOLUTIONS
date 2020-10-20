<?php
$to=$_REQUEST['to'];
$subject=$_REQUEST['subject'];
$msg=$_REQUEST['msg'];
$mail=mail($to,$subject,$msg);
if($mail==true){
echo 'Message sent Successfully';
}else{
echo 'Message not sent Successfully';
}
?>