<!DOCTYPE html>
<html>
<head>
	<title>Consulta ciudades</title>
</head>
<body>

	<?php

		$link = mysqli_connect('localhost', 'root', '');

		// en caso de que falle el mysqli_connect no se puede utilizar el mysqli_errno porque espera una coneccion mysql, que ya fallo
		// entonces hay que usar otro funcion, relacionado a la falla de la conexion, exclusivo para eso

		if (mysqli_connect_errno()){
			echo "<br> ========================================================================== <br>";
			die('No se pudo establecer una coneccion con mysql. El error: ' . mysqli_connect_error());
		}

		// abro la base de datos correspondiente
		mysqli_select_db($link, 'mibasededatos');

		// lanzo una query y me fijo si la tabla que busco (agenda) tiene datos
		$result = mysqli_query($link, 'SELECT * FROM agenda');
		echo "<br> La tabla agenda tiene " . $result->num_rows . " filas"; 
		echo "<br> Se haran 4 inserciones";

		mysqli_query($link, 'INSERT INTO agenda values ("Pedro", "Somoza Castro", "Solera nº88", "88834321", "44", "1.66")');
		mysqli_query($link, 'INSERT INTO agenda values ("Juana", "Pérez Rozas", "Avda. Luarcato nº22", "888111222", "22", "1.77")');
		mysqli_query($link, 'INSERT INTO agenda values ("Jesús", "Murillo Moreno", "Pintor Murillo nº33", "655221122", "34", "1.67")');


		// echo 'Conexion con mysql establecida!';
		mysqli_close($link);
	?>

</body>
</html>