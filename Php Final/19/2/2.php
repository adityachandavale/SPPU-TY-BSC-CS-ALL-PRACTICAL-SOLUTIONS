<?php
	function add($x=0,$y=0)
	{
		return $x+$y;
	}

	function sub($x=0,$y=0)
	{
		return $x-$y;
	}

	function mult($x=0,$y=0)
	{
		return $x*$y;
	}

	function div($x=0,$y=1)
	{
		return $x/$y;
	}

	if(isset($_POST['n1'])) $n1=$_POST['n1'];
	if(isset($_POST['n2'])) $n2=$_POST['n2'];
	$op=$_POST['op'];

	switch($op)
	{
	case '+':
		if(!is_null($n1) && !is_null($n2))
		{
			echo add($n1,$n2);	
		}	
		else if(!is_null($n2) && is_null($n2))
		{
			echo add($n1);
		}
		else if(is_null($n1) && !is_null($n2))
        	{
        		echo "Please enter first no.";
        	}
		else
		{
			echo add();
		}
		break;
	case '-':
		if(!is_null($n1) && !is_null($n2))
		{
			echo sub($n1,$n2);	
		}	
		else if(!is_null($n2) && is_null($n2))
		{
			echo sub($n1);
		}
		else if(is_null($n1) && !is_null($n2))
        	{
        		echo "Please enter first no.";
        	}
		else
		{
			echo sub();
		}
		break;
	case '*':
		if(!is_null($n1) && !is_null($n2))
		{
			echo mult($n1,$n2);	
		}	
		else if(!is_null($n2) && is_null($n2))
		{
			echo mult($n1);
		}
		else if(is_null($n1) && !is_null($n2))
        	{
        		echo "Please enter first no.";
        	}
		else
		{
			echo mult();
		}
		break;
	case '/':
		if(!is_null($n1) && !is_null($n2))
		{
			echo div($n1,$n2);	
		}	
		else if(!is_null($n2) && is_null($n2))
		{
			echo div($n1);
		}
		else if(is_null($n1) && !is_null($n2))
        	{
        		echo "Please enter first no.";
        	}
		else
		{
			echo div();
		}
	}
?>

