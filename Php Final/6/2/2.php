<?php
$iname=$_REQUEST['iname'];
$icode=$_REQUEST['icode'];
$unit=$_REQUEST['unit'];
$rate=$_REQUEST['rate'];
$in=explode(" ",$iname);
$ic=explode(" ",$icode);
$u=explode(" ",$unit);
$r=explode(" ",$rate);
$sum=0;
echo "<table border=1>";
echo "<tr>
<td>Name</td>
<td>Code</td>
<td>UnitSold</td>
<td>Rate</td>
<td>Amount</td>
</tr>";
for($i=0;$i<5;$i++){
echo "<tr>";
echo "<td>".$in[$i]."</td>";
echo "<td>".$ic[$i]."</td>";
echo "<td>".$u[$i]."</td>";
echo "<td>".$r[$i]."</td>";
echo "<td>".$u[$i]*$r[$i]."</td>";
echo "<tr>";
$sum+=$u[$i]*$r[$i];
}
echo "<tr><td colspan=4>Net Bill</td><td>".$sum."</td></tr>";
echo "</table>";
?>