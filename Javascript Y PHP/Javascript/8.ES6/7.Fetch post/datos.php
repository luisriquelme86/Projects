<?php 

	
	$mysqli = conectar();
	$postBody = file_get_contents("php://input"); 
	if (!empty($postBody)) {
		agregarArticulo($mysqli, json_decode($postBody));
	}
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

	function agregarArticulo($mysqli, $datos) {
		$mysqli->query("INSERT INTO supermercado (nombre, precio) VALUES ('$datos->nombre', '$datos->precio')");
		if ($mysqli->error) {
			die("Hubo un error en la insercion a la tabla " . $mysqli->error);
		}
	}

 ?>

<?php 

		// TIPS php y mysql -> mysqli_connect esta deprecado, no se usa mas desde el php 5.5
		/*
		$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
		if ($mysqli->connect_errno) {
			die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
		}

		// escritura orientada a objetos, devuelve un result set
		$result = $mysqli->query("SELECT * from supermercado");
		if ($mysqli->error) {
			die("Hubo un error en la consulta de la tabla supermercado " . $mysqli->error);
		}

		// el result set por si solo no tiene los datos, tengo que hacer algo mas para verlos
		// al invocar al $mysqli->query obtengo un mysqli_result con ciertas propiedades

		// si es MYSQLI_ASSOC entonces es asociativo, o sea, clave valor -> Returns an array of associative
		echo json_encode($result->fetch_all(MYSQLI_ASSOC));

		$result->free_result();
		$mysqli->close();

		// Tips PHP y mysql -> el metodo "query" se usa tambien para las inserciones, no solo para mostrar, aunque query sea "consulta"
		$mysqli->query("INSERT INTO articulos (descripcion, precio, codigorubro ) VALUES ('$_REQUEST[descripcion]', '$_REQUEST[precio]' , '$_REQUEST[rubro]')");
	}
	*/

 ?>