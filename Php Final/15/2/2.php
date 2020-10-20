<?php
	define('PI',3.14);

	interface area_volume
	{
		function area();
		function volume();
	}

	class cylinder implements area_volume
	{
		private $r;
		private $h;

		function __construct($r,$h)
		{
			$this->r = $r;
			$this->h = $h;
		}

		function area()
		{
			return 2*PI*$this->r*($this->r+$this->h);
		}

		function volume()
		{
			return PI*$this->r*$this->r*$this->h;
		}
	}


	$obj = new cylinder(4,5);
	
	printf("Area of cylinder = %f<br>Volume of cylinder = %f",
				$obj->area(),$obj->volume());
?>
