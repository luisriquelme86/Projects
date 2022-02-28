<html>
	<body>
		<?php

			// https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=612:php-consultas-mysql-mysqliconnect-selectdb-query-fetcharray-freeresult-close-ejemplos-cu00841b&catid=70&Itemid=193
		
			// Este ejemplo enseña a utilizar PHP con base de datos por primera vez
			/*
				Se presupone la existencia de la base de datos llamada "mibasededatos" y su tabla agenda creadas
				previamente con el phpmyadmin
				TIPS MYSQL con PHP

				FUNCION mysqli_connect
				FUNCION mysqli_select_db
				FUNCION mysqli_query 
				FUNCION mysqli_data_seek 
				FUNCION mysqli_fetch_array 
				FUNCION mysqli_free_result
				FUNCION mysqli_close

				y propiedades
				num_rows de al resultado de mysqli_query
			*/

			$link = mysqli_connect("localhost", "root", "");
			if (mysqli_connect_errno()) {
				die('No pudo conectarse: ' . mysqli_connect_error());
			}

			echo 'Conectado satisfactoriamente';
			mysqli_select_db($link, "mibasededatos");

			$tildes = mysqli_query($link, "SET NAMES 'utf8'"); 			// para que se muestren las tildes
			$result = mysqli_query($link, "SELECT * FROM agenda");

			mysqli_data_seek($result, 0);

			$extraido = mysqli_fetch_array($result);

			echo "<br>" . "- Nombre: " . $extraido['nombre'] . "<br/>";

			echo "- Apellidos: " . $extraido['apellidos'] . "<br/>";

			echo "- Dirección: " . $extraido['direccion'] . "<br/>";

			echo "- Teléfono: " . $extraido['telefono'] . "<br/>";

			echo "- Edad: " . $extraido['edad'] . "<br/>";

			echo "- Altura: " . $extraido['altura'] . "<br/>";

			mysqli_free_result($result); 								// libera la conexion establecida con la base de datos
			mysqli_close($link);

		?>
	</body>
</html>