<!DOCTYPE html>
<html>
<head>
	<title>Alta de alumnos</title>
</head>
<body>

	<?php

		function conectar() {

			$link = mysqli_connect('localhost', 'root', '');

			if (mysqli_connect_errno()) {
				die('Hubo un error, no se pudo conectar a la base mysql. Error: ' . mysqli_connect_error());
			}
			else {
				echo 'Conexion exitosa a mysql' . "<br>";
			}

			$nombrebase = 'mibasededatos';
			$db = mysqli_select_db($link, $nombrebase);
			if (!$db) {
				die('Hubo un error, no se pudo conectar a la base ' . $nombrebase . '. Error: ' . mysqli_error($link));	
			}
			else {
				echo 'Conexion exitosa a la base de datos ' . $nombrebase . "<br>";
			}

			$tabla = 'alumnos';
			$result = mysqli_query($link, 'SELECT * FROM ' . $tabla);
			if (!$result) {
				die('Hubo un error al conectarse a la tabla ' . $nombrebase . '. Error: ' . mysqli_error($link));		
			}
			else {
				echo 'La tabla ' . $tabla . ' existe!' . "<br>";
			}

			return $link;
		}

		function alta_alumno($link) {

			if (empty($_REQUEST)) {
				die('No hay datos disponibles, por favor utilize el formulario');					
			}

			$nombre = $_REQUEST['nombre'];
			$email = $_REQUEST['email'];
			$curso = (integer) $_REQUEST['curso'];

			if (empty($nombre) || empty($email) || empty($curso)) {
				die('El valor del request es vacio o sus contenidos los son');					
			}
			// --- las comillas simples se ponen igual aunque sean un string y se esten parseando
			$query = "INSERT INTO alumnos values ('$nombre', '$email', '$curso')";
			// ---
			mysqli_query($link, $query);
			if (mysqli_errno($link)) {
				die('Error en la insercion de datos para la tabla de alumnos ' . mysqli_error($link));
			}
			else {
				echo 'Se insertaron los datos de ' . $nombre . ' en la base de alumnos correctamente';
			}

		}

		$link = conectar();

		$result = mysqli_query($link, 'SELECT * FROM alumnos');
		echo 'Hay ' . $result->num_rows . ' alumnos en la tabla' . "<br>";

		alta_alumno($link);

		mysqli_free_result($result);
		mysqli_close($link);


	?>

</body>
</html>