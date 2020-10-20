<html>
<head>
<script type="text/javascript">
var xmlhttp=false;
function display(){
if(window.XMLHttpRequest)
xmlhttp=new XMLHttpRequest();
xmlhttp.open("GET","2.php",true);
xmlhttp.send(null);
xmlhttp.onreadystatechange=function(){
if(xmlhttp.readyState==4 && xmlhttp.status==200){
document.getElementById('contact').innerHTML = xmlhttp.responseText;
}
}
}
</script>
<body>
<form method="POST">
<input type="button" value="Print" onclick="display()">
</form>
<div id='contact'></div>
</body>
</html>