<!DOCTYPE html>
<html>
	<head>
		<title>Alta de rubros POO</title>
		<meta charset="utf-8">
	</head>
<body>
	<?php
		
		// me conecto a mysql y ahi directamente a la base de datos correspondiente, no uso el select 
		if (!isset($_REQUEST['descripcion'])) {
			die("Por favor ingrese por medio del formulario");
		}

		$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
		if ($mysqli->connect_errno) {
			die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
		}

		// lo que va en values aunque sea un string se pone entre comillas primero
		$mysqli->query("INSERT INTO rubros (descripcion) VALUES ('$_REQUEST[descripcion]')");
		if ($mysqli->errno) {
			die("Hubo un error en el alta de rubros, el error es " . $mysqli->error);
		}	

		echo "Alta exitosa";
		$mysqli->close();

	?>
</body>
</html>	