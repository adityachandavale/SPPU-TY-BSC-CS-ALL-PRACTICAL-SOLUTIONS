<?php
	$con = pg_connect("host=localhost dbname=ty1 port=5432 user=postgres");
	
	$hname=$_POST['hname'];

	$sql = "select doctor.dno,dname,doctor.city,addr from doctor,hospital where doctor.hno=hospital.hno and hname='$hname'";

	$result=pg_query($con, $sql);
?>
<table border=1>
<tr>
	<th>DOCTOR NO</th>
	<th>DOCTOR NAME</th>
	<th>CITY</th>
	<th>ADDRESS</th>
</tr>
<?php
	while($row=pg_fetch_row($result))
 	{
?>
<tr>
	<td><?php echo $row[0]?></td>
	<td><?php echo $row[1]?></td>
	<td><?php echo $row[2]?></td>
	<td><?php echo $row[3]?></td>
</tr>
<?php
	}
?>
</table>
