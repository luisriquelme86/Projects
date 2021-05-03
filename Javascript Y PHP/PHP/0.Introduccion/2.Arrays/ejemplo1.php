<html>
	<body>
		<?php

		// declaracion de arrays asociativos en php
		// En php los arrays son mas parecidos a mapas cuando se usan como asociativos
		// Esto ultimo hace que no siempre haya que tener indice numericos

		// no confundir esto con los objetos en javascript, estos son arrays

		$datos_persona['nombre'] = 'Luis';
		$datos_persona['apellidos'] = 'Riquelme';
		$datos_persona['domicilio'] = 'Rico 908';
		$datos_persona['edad'] = '34';
		$datos_persona['altura'] = '1.73';

		// sino asi

		$mas_datos = array(
			'nombre' => 'Juan',
			'apellidos' => 'Ramirez',
			'domicilio' => 'Saavedra 501',
			'edad' => '25',
			'altura' => '1.89',
		);

		foreach ($datos_persona as $key => $value) {
			echo "<br> El $key de la persona es $value";
		}

		foreach ($mas_datos as $key => $value) {
			echo "<br> El $key de la persona es $value";
		}

		?>
	</body>
</html>