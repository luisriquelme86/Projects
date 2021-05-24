<!DOCTYPE html>
<html>
	<head>
		<title>Listado de rubros</title>
		<meta charset="utf-8">
	</head>
	<style type="text/css">

		table {
			border: 1px solid black; /* aplicable a cualquier elemento. De esta manera es solo la tabla, pero no sus elementos internos */
		}

		th, td {
			border: 1px solid black;
		}

		/* Notar que con los estilos de arriba, la tabla tendra bordes, y cada elemento th y td tambien lo tendra, creando los famosos
		   "bordes dobles" que no siempre se desean. Para "fundir" los bordes dobles en uno solo, se puede usar la propiedad de colapse */

		table {
			border-collapse: collapse;
			width: 50%;
		}    

		body {
			background-color: teal;
			width: 750px;
			margin: 10px auto;
			font-family: 'Arial';
			border: 1px solid bisque;
			padding: 40px;
		}

		th {
			// height: 70px;
			text-align: left;
		}

		th, td {
			padding: 10px;
		}

		/* Muy bueno, "iluminar la tabla al pasar sobre cada fila */

		tr:hover {
			background-color: lightblue;
		}

		th {
			background-color: lightgreen;
		}
			
	</style>	
<body>
	<?php
			
		// me conecto a mysql y ahi directamente a la base de datos correspondiente, no uso el select de la base
		$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
		if ($mysqli->connect_errno) {
			die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
		}
		// codigo, descripcion
		$result = $mysqli->query("SELECT * FROM rubros as ru");
		if ($mysqli->error) {
			die("Hubo un error en la query a la base");
		}

		echo "<h3>Tabla de rubros</h3>";
		// dibujo la tabla. Supongo que ya hay datos
		echo "<table>";
		echo "<tr><th>Columna</th>";
		echo "<th>Rubro</th></tr>";
		while ($row = $result->fetch_assoc()) {
			echo "<tr><td>$row[codigo]</td><td>$row[descripcion]</td><tr>";
		}
		echo "</table>";
		$result->free();
		$mysqli->close();

	?>
</body>
</html>	