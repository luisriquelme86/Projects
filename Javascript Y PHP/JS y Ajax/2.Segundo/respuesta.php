<?php 
	if (isset($_GET["nombre"])) {
		$str = strtolower($_GET["nombre"]);
		if ($str == "alberto") {
			echo "Alberto esta realizando un curso de programacion";
		}
		else if ($str == "juan") {
			echo "Juan esta realizando practicas de ingenieria de sistemas";
		}
		else if (empty($str)) {
			echo "No hay informacion. Revise la peticion";
		}
		else {
			echo "No hay informacion. Revise la peticion";	
		}

	}
	else {
		echo "No hay informacion. Revise la peticion";	
	}

?>