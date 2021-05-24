<!DOCTYPE html>
<html>
<head>
	<title>ABM Articulos</title>
</head>
<style type="text/css">

	body {
		font-size: 14px;
		font-family: 'Arial';
		background-color: cornflowerblue;
		color: white;
		width: 850px;
		margin: 10px auto;
		padding: 40px;
		border: 1px solid khaki;
	}
	
</style>
<body>

	<?php
		if (isset($_GET['operacion'])) {
			if ($_GET['operacion'] == "alta") {
				// el alta tambien debe redirigir a un formulario que permita crear un articulo y mostrando los rubros disponibles en el select

			}

			if ($_GET['operacion'] == "modificar") {
				// es muy sucio poner todo aca, lo mejor es que redirija a un formulario y pasarle el codigo en cuestion, que dicho formulario
				// muestre los datos (se supone que el codigo de borrado y modificacion siempre es valido) que ese formulario a la vez envie los datos a otro php
				// y ese php retorne a la principal con los datos modificados
				
			}

			if ($_GET['operacion'] == "borrar") {
				borrar();		
			}
		}

		function borrar() {
			if (isset($_GET['codigo'])) {
				$link = getLink();		
				echo "Conexion a la base de datos exitosa <br>";
				// caso feliz, el codigo ingresado ya existe en la base de datos seguro

				/* $link->query("DELETE from articulos where codigo = $_GET[codigo]");
				if ($link->error) {
					die("Se produjo un error al borrar en la tabla articulos. El error es " . $link->error);
				} */
				echo "La baja del producto en la tabla de articulos con codigo $_GET[codigo] fue exitosa <br>";
				$link->close();
				header("Location: http://localhost:8080/project/lista-articulos.php");
			}
		}

		function getLink() {
			$link = new mysqli("localhost", "root", "", "mibasededatos");
			if ($link->error) {
				die("Hubo un error al conectarse a mysql a la base mibasededatos. El error es " . $link->error);
			}
			return $link;
		}

	?>	

</body>
</html>