<!DOCTYPE html>
<html>
<head>
	<title>Consulta ciudades</title>
</head>
<body>

	<?php

		$link = mysqli_connect('localhost', 'root', ''); 					// abre una coneccion a mysql

		if (mysqli_connect_errno()) {
			echo "<br> ===========================================================";
			die("<br>" . 'No se puedo conectar a mysql. Error: ' . mysqli_connect_error());
		}

		$db_selected = mysqli_select_db($link, 'mibasededatos'); 			// es la base de datos, no la tabla
		if (!$db_selected) {
			echo "<br> ===========================================================";
			die("<br>" . 'No se pudo conectar a la base. Error: ' . mysqli_error($link));
		}

		// para usar una tabla en especial, tiro una query

		$result_ciudades = mysqli_query($link, "SELECT * FROM ciudades");

		echo "<br> El numero de ciudades es: " . $result_ciudades->num_rows;

		for ($index = 0; $index < $result_ciudades->num_rows; $index++) { 
			mysqli_data_seek($result_ciudades, $index); 					// posiciono el array de resultados
			$row = mysqli_fetch_array($result_ciudades); 				    // obtengo la fila en cuestion, un array asociativo, tiene nombres
			echo "<br>";
			$tieneMetro = $row['tieneMetro'] == 0 ? 'no' : 'si';
			echo 'Id: ' . $row['id'] . ' --- Ciudad: ' . $row['ciudad'] . ' --- Pais: ' . $row['pais'] . ' --- Habitantes: ' . $row['habitantes'] . ' --- Superficie: ' . $row['superficie']. ' --- TieneMetro: ' . $tieneMetro;
		}

		mysqli_free_result($result_ciudades);
		mysqli_close($link);
	?>

</body>
</html>