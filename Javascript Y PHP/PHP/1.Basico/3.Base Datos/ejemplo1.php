<html>
	<body>
		<?php

			$link = mysqli_connect("localhost", "root", "");
			if (mysqli_connect_errno()) {
				die('No pudo conectarse: ' . mysqli_connect_error());
			}

			echo 'Conectado satisfactoriamente';
			mysqli_select_db($link, "mibasededatos");

			$tildes = mysqli_query($link, "SET NAMES 'utf8'"); 			//Para que se muestren las tildes
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