<!DOCTYPE html>
<html>
	<head>
		<title>Muestra la pagina los 10 primeros dias del mes</title>
		<meta charset="utf-8">
	</head>
<body>
	<?php
		
		$dia = date("d");
		if ($dia > 30) {
			echo 'sitio activo';
		}
		else {
			echo 'el sitio se muestra solo los dias 30 y 31 del mes';
		}

	?>
</body>
</html>	