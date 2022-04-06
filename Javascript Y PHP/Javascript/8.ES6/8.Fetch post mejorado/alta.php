<?php 

	
	$params = file_get_contents("php://input"); 
	if (!empty($params)) {
		$mysqli = conectar();
		agregarArticulo($mysqli, json_decode($params));
		$result = '{"status": "ok"}';
		$mysqli->close();
		echo json_encode($result);
	}

	function conectar() {
		$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
		if ($mysqli->connect_errno) {
			die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
		}
		return $mysqli;
	}

	function agregarArticulo($mysqli, $params) {
		$mysqli->query("INSERT INTO supermercado (nombre, precio) VALUES ('$params->nombre', '$params->precio')");
		if ($mysqli->error) {
			die("Hubo un error en la insercion a la tabla " . $mysqli->error);
		}
	}

 ?>