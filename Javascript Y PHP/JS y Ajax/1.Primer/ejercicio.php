<meta charset = "utf-8"/>
	<?php // Datos

		$urlWikipedia = "https://es.wikipedia.org/wiki/";
		$paises[0] = "spain";
		$paises[1] = "mexico";
		$paises[2] = "argentina"; 
		$paises[3] = "colombia";

		$ciudadesSpain = [
			["Madrid", $urlWikipedia . "Madrid"],
			["Barcelona", $urlWikipedia . "Barcelona"],
			["Valencia", $urlWikipedia . "Valencia"],
			["Sevilla", $urlWikipedia . "Sevilla"],
			["Zaragoza", $urlWikipedia . "Zaragoza"],
			["Málaga", $urlWikipedia . "Málaga"],
			["Murcia", $urlWikipedia . "Murcia"]
		];

		$ciudadesMexico = [
			["México D.F.", $urlWikipedia . "Ciudad_de_México"],
			["Ecatepec", $urlWikipedia . "Ecatepec_de_Morelos"],
			["Guadalajara", $urlWikipedia . "Guadalajara_"],
			["Puebla", $urlWikipedia . "Puebla"],
			["Juárez", $urlWikipedia . "Ciudad_Juárez"],
			["Tijuana", $urlWikipedia . "Tijuana"],
			["León", $urlWikipedia . "León_(México)"],
			["Zapopan", $urlWikipedia . "Zapopan"]
		];
		
		$ciudadesArgentina = [
			["Buenos Aires", $urlWikipedia . "Buenos_Aires"],
			["Córdoba", $urlWikipedia . "Córdoba_(Argentina)"],
			["Rosario", $urlWikipedia . "Rosario_(Argentina)"],
			["La Plata", $urlWikipedia . "La_Plata"],
			["Mar del Plata", $urlWikipedia . "Mar_del_Plata"],
			["San Miguel de Tucumán", $urlWikipedia . "San_Miguel_de_Tucumán"],
			["Ciudad de Salta", $urlWikipedia . "Salta"]
		];

		$ciudadesColombia = [
			["Bogotá", $urlWikipedia . "Bogotá"],
			["Medellín", $urlWikipedia . "Medellín"],
			["Cali", $urlWikipedia . "Cali"],
			["Barranquilla", $urlWikipedia . "Barranquilla"],
			["Cartagena", $urlWikipedia . "Cartagena_de_Indias"],
			["Cúcuta", $urlWikipedia . "Cúcuta"],
			["Soledad", $urlWikipedia . "Soledad_(Atlántico)"],
			["Ibagué", $urlWikipedia . "Ibagué"]
		]; 

		$ciudades = [0 => $ciudadesSpain,
			1 => $ciudadesMexico,
			2 => $ciudadesArgentina,
			3 => $ciudadesColombia,
		];

		// Rescatamos el parámetro pais que nos llega mediante la url que invoca xmlhttp
		$paisRecibido = $_REQUEST["pais"];
		$ciudadesDevueltas = "";
		$existePais = false;

		for ($i = 0; $i < count($paises); $i++) {

		   if ($paisRecibido == $paises[$i]) {

		   	$indicePais = $i;
		   	$existePais = true;

		   } 
		}

		$msg = 'El pais recibido por get en segundo plano es '. $paisRecibido;

		if ($existePais) {

			$msg = $msg . ' y tiene indice '. $indicePais;

		}

		$ciudadesRespuesta = "";

		//  Creamos el array a devolver -> En realidad, las ciudades como string separadas por coma
		for ($i = 0; $i < count($ciudades[$indicePais]); $i++) {

		   $ciudadesRespuesta .= "," . $ciudades[$indicePais][$i][0] . "|" . $ciudades[$indicePais][$i][1];

		}

		echo $msg . $ciudadesRespuesta;

	?>