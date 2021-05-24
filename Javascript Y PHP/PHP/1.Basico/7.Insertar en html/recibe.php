<!DOCTYPE html>
<html>
<head>
	<title>Alta de alumnos</title>

	<style type="text/css">
		
		body {
			background-color: teal;
			font-family: 'Arial';
			width: 750px;
			margin: 0 auto;
			border: 1px solid black;
			padding: 10px;
		}

		label {
			display: block;
		}

		input, select {
			margin-top: 5px;
		}

		.btn {
			margin-top: 20px;
			display: block;
		}

		.mensajeError {
			color: red;
			margin-bottom: 15px;	
		}

		.mensajeEnvio {
		 	color: white;
		 	margin-top: 15px;
		 	margin-left: 5px;
		}

	</style>
</head>
<body>


	<h3>Formulario para ingresar alumnos, todos los campos son obligatorios</h3>
	<div class="mensajeError"></div>
	<form action="http://localhost:8080/project/recibe2.php" method="get">

		<fieldset>
			
			<legend>Datos personales: </legend>

			<label for="nombre">Nombre: </label>
			<input type="text" name="nombre" id="nombre" size="50">

			<label for="email">Email: </label>
			<input type="text" name="email" id="email" size="50">

			<label for="curso">Curso: </label>
			<select id="curso" name="curso">
				<?php 

					$link = mysqli_connect('localhost', 'root', '');
					mysqli_select_db($link, 'mibasededatos');
					$result = mysqli_query($link, 'SELECT * FROM cursos');
					$rows = mysqli_fetch_all($result, MYSQLI_ASSOC);
					echo '<option value="0">Seleccione un curso: </option>';
					foreach ($rows as $row) {
						echo '<option value=' . "$row[codigo]'>" . strtoupper("$row[nombrecurso]") . '</option>'; 
					}
					mysqli_free_result($result);
					mysqli_close($link);
				?>
			</select>

			<input class="btn" type="submit" value="Enviar">
				
		</fieldset>

	</form>
	<div class="mensajeEnvio"></div>	
	
</body>
</html>