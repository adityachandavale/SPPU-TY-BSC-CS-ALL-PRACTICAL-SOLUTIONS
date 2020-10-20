<html>
<body>
<table border='1'>
<tr>
<th>RollNo</th>
<th>NAME</th>
<th>Marks1</th>
<th>Marks2</th>
<th>Marks3</th>
<th>Total</th>
<th>Percentage</th>
</tr>
<?php
$file=fopen("Slip24b.dat","r");
while(($line=fgets($file,80))!==false){
$data=explode(" ",$line);
$tot=0.0;
$per=0.0;
echo "<tr>";
echo "<td>".$data[0]."</td>";
echo "<td>".$data[1]."</td>";
echo "<td>".$data[2]."</td>";
echo "<td>".$data[3]."</td>";
echo "<td>".$data[4]."</td>";
$tot+=$data[2]+$data[3]+$data[4];
$per=$tot/3;
echo "<td>".$tot."</td>";
echo "<td>".$per."</td>";
echo "</tr>";
}
?>
</table>
</body>
</html>