<?php
	

	// antes de abrir el archivo me fijo si existe
	$filename = "prueba.txt";
	if (!file_exists($filename)) {
		exit("Unable to open $filename");
	}	

	// abro el archivo en modo escritura
	$file = fopen("prueba.txt", "r");
	$linea = "";

	// recorro linea a linea hasta terminar de leer el archivo de texto
	while (!feof($file)) {
		$linea = $linea . fgets($file) . "<br>";
	}

	// "escupo" al html la respuesta
	echo $linea;

	// y cierro
	fclose($file);
?>