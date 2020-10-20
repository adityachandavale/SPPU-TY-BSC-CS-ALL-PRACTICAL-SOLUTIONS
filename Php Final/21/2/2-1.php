<?php
setcookie('fstyle',$_GET['fontst'],time()+10);
setcookie('fsize',$_GET['fontsi'],time()+10);
setcookie('fcolor',$_GET['fontco'],time()+10);
setcookie('bcolor',$_GET['backco'],time()+10);
?>
<form action=2-2.php>
FONT STYLE:<?=$_GET['fontst']?> <br />
FONT SIZE:<?php echo $_GET['fontsi'];?> <br />
FONT COLOR:<?php echo $_GET['fontco'];?> <br />
BACKGROUND COLOR:<?php echo $_GET['backco'];?> <br />
<input type="submit" value="confirm" />
</form>