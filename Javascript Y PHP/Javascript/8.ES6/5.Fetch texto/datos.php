<?php 
	
	
	// TIPS PHP: $_GET y demas son Variable Predefinidas, ver en https://www.php.net/manual/es/index.php, "Referencia del lenguaje"/"Variables predefinidas" 	
	if (!isset($_GET["signo"])) {
		echo "No hay informacion disponible";
	}
	else {
		$signo = $_GET["signo"];
		$filename = $signo . ".txt";
		if (file_exists($filename)) {
			$file = fopen($filename, "r"); // abro para lectura
			$line = "";
			while(!feof($file)) {
				$line .= fgets($file);
			}
			fclose($file); 					// cierro el stream
			echo $line;
		}
		else {
			echo "No hay informacion disponible";
		}
	}	

 ?>