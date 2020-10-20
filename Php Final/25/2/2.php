<?php
	$con = pg_connect("host=localhost dbname=ty1 port=5432 user=postgres");

	$an = $_GET['an'];

	$sql= "select movie.mno,mname,release_year from movie,actor where aname='$an' and
movie.mno = actor.mno;";

	$result = pg_query($con,$sql);

	$row = pg_fetch_row($result);

	echo "Movie No:$row[0]<br>Movie Name:$row[1]<br>Release Year:$row[2]";
?>

