<?php 


	// leer los archivos de texto
   // https://www.php.net/manual/en/function.fopen.php
	
	$filename = $_GET["filename"];	
	if (!isset($filename) || empty($filename)) {
		echo "null";		
	}
	else {
		echo leerArchivo($filename);
	}

	
	function leerArchivo($name) {
		$filename = $name . ".txt";
		if (!file_exists($filename)) {
			return "nodssds";
		}
		$file = fopen($filename, "r");
		$line = "";
		while (!feof($file)) {
			$line = $line . fgets($file);

		}
		fclose($file);
		return $line;
	}

 ?>