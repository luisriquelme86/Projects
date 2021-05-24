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
		// $query = "SELECT nombre, email, nombrecurso FROM alumnos as alum JOIN cursos as cur ON alum.curso = cur.codigo"; 
		$query = "SELECT nombre, email, nombrecurso FROM alumnos as alum " .
					"JOIN cursos as cur " .
					"ON alum.curso = cur.codigo"; 		
		$result = mysqli_query($link, $query);
		while ($row = mysqli_fetch_assoc($result)) {
			echo "<p> Nombre: $row[nombre], Email: $row[email], Curso: $row[nombrecurso]</p>";
		} 

		mysqli_free_result($result);
		mysqli_close($link);

	?>

</body>
</html>