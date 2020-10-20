<html>
<body>
<table border='1'>
<tr>
<th>SRNO.</th>
<th>NAME</th>
<th>RESIDENCE NO</th>
<th>MOBILE NO</th>
<th>Relation</th>
</tr>
<?php
$file=fopen("2.dat","r");
while(($line=fgets($file,80))!==false){
$data=explode(" ",$line);
echo "<tr>";
echo "<td>".$data[0]."</td>";
echo "<td>".$data[1]."</td>";
echo "<td>".$data[2]."</td>";
echo "<td>".$data[3]."</td>";
echo "<td>".$data[4]."</td>";
echo "</tr>";
}
?>
</table>
</body>
</html>