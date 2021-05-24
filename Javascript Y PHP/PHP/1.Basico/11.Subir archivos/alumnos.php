<!DOCTYPE html>
<html>
<head>
	<title>Listado de alumnos paginado</title>

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

	<h3>Listado de alumnos paginado</h3>

	<?php

		$link = mysqli_connect("localhost", "root", "");
		mysqli_select_db($link, "mibasededatos");
		$query = "SELECT COUNT(*) as cantidad FROM alumnos";
		$result = mysqli_query($link, $query);
		$row = mysqli_fetch_assoc($result);

		// el offset es el numero de resultados a obtener, y por lo tanto aqui es fijo. Siempre obtengo 2 resultados a lo sumo porque la paginacion es de a 2
		$offset = 2;
		// el inicio es a partir de que registro empiezo a tomar los resultados. Como la pagina es de a 2, tiene que ser un numero par, comenzando de 0
		$inicio = 0;
		// el contador tiene que ser un numero par, por lo tanto, es el numero de registros divido 2, su parte entera hacia arriba
		$counter = round($row['cantidad'] / 2);

		if (isset($_REQUEST['pagina'])) {
			$inicio = $_REQUEST['pagina'] * 2;
		}

		$anchors = "";

		$query = "SELECT nombre, email, curso FROM alumnos limit $inicio,$offset";
		$result = mysqli_query($link, $query);
		while ($row = mysqli_fetch_assoc($result)) {
			echo "<p>Nombre: $row[nombre], Email: $row[email], Curso: $row[curso]</p>";
		}

		for ($index = 0; $index  < $counter; $index ++) { 
			$anchors .= "<a href='http://localhost:8080/project/alumnos.php?pagina=$index'>$index</a>";
		}

		echo "$anchors";

		mysqli_free_result($result);
		mysqli_close($link);
	?>

</body>
</html>