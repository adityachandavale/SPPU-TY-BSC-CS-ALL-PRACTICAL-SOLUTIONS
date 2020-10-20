<?php
$str=$_POST['t1'];
$op=$_POST['op'];
if($op=="count")
v_count($str);
else if($op=="occur")
v_occur($str);
function v_occur($s){
$a=0;$e=0;$i=0;$o=0;$u=0;
for($k=0;$k<strlen($s);$k++){
if($s[$k]=='a'){
$a++;
}else if($s[$k]=="e"){
$e++;
}else if($s[$k]=='i'){
$i++;
}else if($s[$k]=="o"){
$o++;
}else if($s[$k]=="u"){
$u++;
}
}
echo"No of a = ".$a."<br/>";
echo"No of e = ".$e."<br/>";
echo"No of i = ".$i."<br/>";
echo"No of o = ".$o."<br/>";
echo"No of u = ".$u."<br/>";
}
function v_count($str){
$cnt=0;
for($i=0;$i<strlen($str);$i++){
switch($str[$i]){
case 'a':
case 'e':
case 'i':
case 'o':
case 'u': $cnt++;
}
}
echo "Total numeber of vowels is ".$cnt;
}
?>