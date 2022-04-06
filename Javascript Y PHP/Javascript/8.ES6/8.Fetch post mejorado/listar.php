<?php 

	
	$mysqli = conectar();
	echo json_encode(mostrarArticulos($mysqli));
	$mysqli->close();
	
	function conectar() {
		$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
		if ($mysqli->connect_errno) {
			die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
		}
		return $mysqli;
	}

	function mostrarArticulos($mysqli) {
		$queryresult = $mysqli->query("SELECT * from supermercado");
		if ($mysqli->error) {
			die("Hubo un error en la consulta de la tabla supermercado " . $mysqli->error);
		}
		$result = $queryresult->fetch_all(MYSQLI_ASSOC);
		$queryresult->free_result();
		return $result;
	}

 ?>