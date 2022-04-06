<?php 



	$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
	if ($mysqli->connect_errno) {
		die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
	}

	// codigo, descripcion, precio, rubro
	$result = $mysqli->query("SELECT * FROM articulos as a");
	if ($mysqli->error) {
		die("Hubo un error en la query a la base");
	}

	/* [
			{"codigo":"2","descripcion":"monitor","precio":"350.8","codigorubro":"4"},
			{"codigo":"3","descripcion":"fideos","precio":"2.15","codigorubro":"1"},
			{"codigo":"4","descripcion":"radar","precio":"5000","codigorubro":"2"},
			{"codigo":"6","descripcion":"clonazepalm","precio":"700","codigorubro":"5"}
		] 
	*/

	// es con el parametro MYSQLI_ASSOC porque quiero los clave-valor
	echo json_encode($result->fetch_all(MYSQLI_ASSOC));

	$result->free();
	$mysqli->close()

 ?>