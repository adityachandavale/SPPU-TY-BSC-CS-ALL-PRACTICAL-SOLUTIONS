<?php
$eno = $_POST['eno'];
$ename = $_POST['ename'];
$address = $_POST['address'];
$phone = $_POST['phone'];
$salary = $_POST['salary'];
$op = $_POST['empDet'];
$dept_name = $_POST['deptName'];
$dno = $_POST['dno'];
$deptName = $_POST['dept_name'];
$loc = $_POST['loc'];
pg_connect("host=localhost dbname=postgres user=postgres password=password");
switch($op){
case "insert":
$ans1 = pg_query("insert into employee values($eno,'$ename','$address','$phone',$salary)");
$ans2 = pg_query("insert into department values($dno,'$deptName','$loc')");
if($ans1 && $ans2){
echo "<br> Record insert successfully..";
} else {
echo "<br> Record not inserted..";
}
break;
case "employeeDet":
echo "<table border=1>";
$res = pg_query(" select max(salary),min(salary),sum(salary) from employee where eno
in(select eno from emp_dept where dno in(select dno from department where dname='$dept_name
'));");
echo "
<tr>
<td>Maximum Salary</td>
<td>Minimum Salary</td>
<td>Sum Salary</td>
</tr>
<tr>
";
while($row = pg_fetch_array($res)){
echo "
<td>".$row['max']."</td>
<td>".$row['min']."</td>
<td>".$row['sum']."</td>
";
}
echo "</tr>";
echo "</table>";
break;
}
?>