<?php
$comp=$_REQUEST['comp'];
pg_connect("host=localhost dbname=phpslip9 user=postgres password=postgres");
//mysql_connect("localhost","root","root");
//mysql_select_db("nsg");
$result=pg_query("select student.stud_id,name,class
from student,competition,studentcompetition
where student.stud_id=studentcompetition.stud_id
and competition.c_no=studentcompetition.c_no
and rank='1' and c_name='$comp'");
while(($row=pg_fetch_array($result))!=null){
echo "Student id is ".$row['stud_id']."<br />";
echo "Name id is ".$row['name']."<br />";
echo "Class is ".$row['class']."<br />";
}
?>