<?php
$a=$_REQUEST['no'];
if($a=="")
$a=0;
$con=pg_connect("host=localhost dbname=postgres user=postgres password=postgres");
$result=pg_query("select * from teacher where tid=$a");
if($result && $a!=0){
echo "<table border=1>";
echo "<tr>";
echo "<th>Number</th>";
echo "<th>Name</th>";
echo "<th>Subject</th>";
echo "<th>ResearchArea</th>";
echo "</tr>";
while($row=pg_fetch_array($result)){
echo "<tr>";
echo "<td>".$row['tid']."</td>";
echo "<td>".$row['tname']."</td>";
echo "<td>".$row['subject']."</td>";
echo "<td>".$row['research']."</td>";
}
echo "</tr>";
echo "</table>";
}
?>