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

		$link = mysqli_connect('localhost', 'root', '');
		mysqli_select_db($link, 'mibasededatos');
		$curso = (integer) $_REQUEST['curso'];
		$result = mysqli_query($link, 'SELECT * FROM cursos');
		$query = "INSERT INTO alumnos values ('$_REQUEST[nombre]', '$_REQUEST[email]', '$curso')";
		mysqli_query($link, $query);
		if (mysqli_errno($link)) {
			die('Error en la insercion de datos para la tabla de alumnos ' . mysqli_error($link));
		}
		else {
			echo "Se insertaron los datos de $_REQUEST[nombre] en la base de alumnos correctamente";
		}

		mysqli_free_result($result);
		mysqli_close($link);

	?>

</body>
</html>