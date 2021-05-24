<!DOCTYPE html>
<html>
<head>
	<title>Alta de articulos</title>
	<meta charset="utf-8">
</head>
<style type="text/css">
	
	body {
		font-size: 14px;
		font-family: 'Arial';
		background-color: darkkhaki;
		width: 800px;
		margin: 30px auto;
		border: 1px solid darkgray;
		padding: 10px;
	}	

	input, select {
		display: block;
	}

	.btn {
		margin-top: 20px;
	}

	/* El legend es la etiqueta de titulo del formulario. Las lineas INTERNAS que recubren el form es el fieldset 
	   form, legend, fieldset */

	fieldset {
		border: 1px solid darkgray; /* tiene un style, que es grooved */
	}

</style>
<body>
	<?php
		
		echo "descripcion: $_REQUEST[descripcion], precio: $_REQUEST[precio], rubro: $_REQUEST[rubro] <br>";
		if (!isset($_REQUEST['descripcion'], $_REQUEST['precio'], $_REQUEST['rubro'])) {
			die("Use un formulario para acceder a este documento");
		}	
		// me conecto a mysql y ahi directamente a la base de datos correspondiente, no uso el select de la base
		$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
		if ($mysqli->connect_errno) {
			die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
		}
		// descripcion, precio, codigorubro
		$mysqli->query("INSERT INTO articulos (descripcion, precio, codigorubro ) VALUES ('$_REQUEST[descripcion]', '$_REQUEST[precio]' , '$_REQUEST[rubro]')");
		if ($mysqli->error) {
			// cuidado, verificar que la insercion a la tabla este correcta, estaba insertando en la tabla de rubros y no en la tabla de articulos
			die("Hubo un error en la insercion a la tabla " . $mysqli->error);
		}

		echo "<h3>El alta del articulo $_REQUEST[descripcion] fue exitosa</h3>";
		$mysqli->close();

	?>
</body>
</html>	