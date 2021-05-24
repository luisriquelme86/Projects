<!DOCTYPE html>
<html>
<head>
	<title>Subida de imagenes</title>

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

		if(isset($_FILES['upload'])) {

			echo "Se subio un archivo de nombre " . $_FILES['upload']['name'];
			// copio el archivo de la carpeta temporal del servidor a la carpeta donde se encuentra este file
			copy($_FILES['upload']['tmp_name'], $_FILES['upload']['name']);
			// y lo muestro
			$file_name = $_FILES['upload']['name'];
			echo "<img src='./$file_name'>";
		}
		else {
			echo "No se cargo ningun archivo";
		}


	?>

</body>
</html>