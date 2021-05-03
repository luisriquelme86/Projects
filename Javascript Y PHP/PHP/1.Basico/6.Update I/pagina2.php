<!DOCTYPE html>
<html>
<head>
	<title>Modificar datos</title>

	<style type="text/css">
		
		body {
			background-color: teal;
			font-family: 'Arial';
			width: 750px;
			margin: 0 auto;
			border: 1px solid black;
			padding: 10px;
		}

		label {
			display: block;
		}

		input {
			margin-top: 5px;
		}

		.btn {
			margin-top: 20px;
			display: block;
		}

		.mensajeError {
			color: red;
			margin-bottom: 15px;	
		}

		 .mensajeEnvio {
		 	color: white;
		 	margin-top: 15px;
		 	margin-left: 5px;
	 	}

	</style>

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
				$datos = mysqli_fetch_array($result);

				if (!$datos) {
					die("El email $_REQUEST[email] no corresponde a ningun alumno actual!!!");
				}
			}

		}

		function modificar_email($link, $email) {
			// Armar un formulario y "escupirlo" con un echo
			// Por ahora no se como "escupir" o "pegar" en el html con php un javascript asi que no puedo hacer las validaciones necesarias

			echo "<h3>Ingrese el nuevo email del alumno</h3>";
			$formulario =  '<form action="http://localhost:8080/project/pagina3.php" method="post">' . 
							      '<fieldset> ' .
									   '<legend>Datos personales: </legend> ' .
									   '<label for="email_actual">Email actual: </label>' .
									   '<input type="text" disabled="true" id="email_actual" value="' . $email . '" size="50">' .
									   '<label for="email">Nuevo email: </label>' .
										'<input type="text" name="email" id="email" size="50">' .
										'<input type="hidden" name="viejo_email" value="' . $email . '">' .
										'<input class="btn" type="submit" value="Modificar">' .
									'</fieldset>' .
							   '</form>';
			echo "$formulario";				   

		}

		$link = conectar();

		$result = mysqli_query($link, 'SELECT * FROM alumnos');
		echo 'Hay ' . $result->num_rows . ' alumnos en la tabla' . "<br>";

		consulta_alumno($link);
		modificar_email($link, $_REQUEST['email']);

		mysqli_free_result($result);
		mysqli_close($link);

	?>

</body>
</html>