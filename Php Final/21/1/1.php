<?php
	function factorial($n)
	{
		$f = 1;
		for($i=1;$i<=$n;$i++)
			$f*=$i;

		return $f;
	}

	$n = $_POST['no'];
	if(is_numeric($n) && $n>=0)
		echo "Factorial of $n is ".factorial($n);
	else
		echo "Invalid input $n";
?>
