<!DOCTYPE html>
<html>
<head>
	<title>Alta de alumnos</title>

	<style type="text/css">
		
		body {
			background-color: teal;
			font-family: 'Arial';
			width: 750px;
			margin: 0 auto;
			border: 1px solid black;
			padding: 10px;
		}

	</style>
</head>
<body>

	<?php

		/* if (isset($_REQUEST['tabla'])) {
			$param = (integer) $_REQUEST['tabla'];	
		}
		else {
			$param = 1;
		} */

		// el operador corto circuito con || como javascript no funciona bien aca, hay que hacer lo de abajo

		$param = isset($_REQUEST['tabla']) ? $_REQUEST['tabla'] : 6;
		
		for ($i = 1; $i <= 10 ; $i++) { 
			$result = $i * $param;
			echo "<p>$result</p>";
		}


	?>

</body>
</html>