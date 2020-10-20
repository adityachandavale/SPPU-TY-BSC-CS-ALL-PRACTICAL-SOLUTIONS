<html>
<head>
<script type="text/javascript">
var xmlhttp=false;
function display(){
var n=document.getElementById('no').value;
if(window.XMLHttpRequest)
xmlhttp=new XMLHttpRequest();
xmlhttp.open("GET","2-2.php?no="+n,true);
xmlhttp.send();
xmlhttp.onreadystatechange=function(){
if(xmlhttp.readyState==4 && xmlhttp.status==200){
document.getElementById('res').innerHTML = xmlhttp.responseText;
}
}
}
</script>
<body>
<form>
<input type="text" id="no" name="no" onkeyup="display()"/>
</form>
<div id='res'></div>
</body>
</html>