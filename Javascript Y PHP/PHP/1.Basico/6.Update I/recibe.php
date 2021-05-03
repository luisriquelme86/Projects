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

		function consulta_alumno($link) {

			if (empty($_REQUEST)) {
				die('No hay datos disponibles, por favor utilize el formulario');					
			}

			if (empty($_REQUEST['email'])) {
				die('El valor del request es vacio o sus contenidos los son');					
			}
			// --- las comillas simples se ponen igual aunque sean un string y se esten parseando
			$query = "SELECT * FROM alumnos where email = '$_REQUEST[email]'";
			// ---
			$result = mysqli_query($link, $query);
			if (mysqli_errno($link)) {
				die('Error en la consulta ' . mysqli_error($link));
			}
			else {
				echo 'Los datos del alumno son los siguientes: ' . "<br>";
				$datos = mysqli_fetch_array($result);
				$curso;
				switch ($datos['curso']) {
					case 1:
						$curso = 'PHP';
					break;
					case 2:
						$curso = 'ASP';
					break;
					case 3:
						$curso = 'JSP';
					break;
					default:
						
					break;
				}
				echo "Nombre : $datos[nombre] <br>email: $datos[email] <br>curso: $curso";
			}

		}

		$link = conectar();

		$result = mysqli_query($link, 'SELECT * FROM alumnos');
		echo 'Hay ' . $result->num_rows . ' alumnos en la tabla' . "<br>";

		consulta_alumno($link);

		mysqli_free_result($result);
		mysqli_close($link);

	?>

</body>
</html>