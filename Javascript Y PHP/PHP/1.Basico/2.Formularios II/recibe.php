<!DOCTYPE html>
<html>
	<head>
		<title>Ejemplo de una web con PHP - aprenderaprogramar.com</title>
		<meta charset="utf-8">
	</head>
<body>
	<?php
		
		$factura = $_GET['factura'];
		$sexo = $_GET['sexo'];
		$nombre = $_GET['nombre'];
		$direccion = $_GET['direccion'];
		$email = $_GET['email'];

		echo "Desea recibir la factura?: $factura <br>";
		echo "El sexo es: $sexo <br>";
		echo "El nombre es: $nombre <br>";
		echo "La direccion es: $direccion <br>";
		echo "El email es: $email <br>";

	?>
</body>
</html>	
