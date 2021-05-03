<!DOCTYPE html>
<html>
<head>
	<title>Actualizacion de alumno</title>
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

		// Se supone o se quiere creer que desde la pagina2 a la pagina3 (que es la actual) la base de datos
		// sigue funcionando como tal

		if (empty($_REQUEST)) {
			die('Por favor, utilize el formulario correspondiente para la actualizacion del alumno');
		}

		if(empty($_REQUEST['email'])) {
			die('Se requiere un email para poder realizar la operacion');
		}

		// conecto directamente a la base sin tantas validaciones de por medio, lo hago sencillo, en otro
		// momento descubrire como tener todo esto ordenado y validando como corresponde (servicio o algo?)

		$link = mysqli_connect("localhost", "root", "", "mibasededatos");
		$query = "UPDATE alumnos SET email='$_REQUEST[email]' WHERE EMAIL='$_REQUEST[viejo_email]'";
		mysqli_query($link, $query);
		echo "Actualizacion exitosa, se actualizo el email $_REQUEST[viejo_email] por $_REQUEST[email]";

	?>

</body>
</html>










