<!DOCTYPE html>
<html>
<head>
	<title>Alta de articulos</title>
</head>
<style type="text/css">
		
	body {
		font-size: 14px;
		font-family: 'Arial';
		background-color: darkkhaki;
		width: 800px;
		margin: 30px auto;
		border: 1px solid darkgray;
		padding: 10px;
	}	

	input, select {
		display: block;
	}

	.btn {
		margin-top: 20px;
	}

	/* El legend es la etiqueta de titulo del formulario. Las lineas INTERNAS que recubren el form es el fieldset 
	   form, legend, fieldset */

	fieldset {
		border: 1px solid darkgray; /* tiene un style, que es grooved */
	}

</style>
<body>

	<h3>Alta de articulos</h3>

	<!-- descripcion, precio, codigorubro-->
	<!-- el required es muy bueno para evitar estar programando los javascript y permiten hacer las cosas con rapidez, mientras
		  sepas porque lo estas haciendo -->

	<form action="http://localhost:8080/project/alta.php" method="post">
		<fieldset>
			<legend>Alta de articulo</legend>		
			<label for="descripcion">Descripcion: </label>
			<input type="text" name="descripcion" id="descripcion" size="50" required>

			<label for="precio">Precio: </label>
			<input type="number" name="precio" id="precio" step="0.01" required>

			<label for="rubro">Rubro: </label>
			<select id="rubro" name="rubro" required> <!-- El required del select funciona si un value esta marcado como vacio -->
				<?php 

					$mysqli = new mysqli("localhost", "root", "", "mibasededatos");
					if ($mysqli->connect_errno) {
						die("Hubo un error al conectar con la base de datos, el error es " . $mysqli->connect_error);
					}
					// tabla rubros, descripcion
					$result = $mysqli->query("SELECT * from rubros");
					if ($mysqli->error) {
						// cuidado, verificar que la insercion a la tabla este correcta, estaba insertando en la tabla de rubros y no en la tabla de articulos
						die("Hubo un error en la consulta de la tabla rubros " . $mysqli->error);
					}

					echo "<option value=''>Seleccione un rubro</option>";

					while($row = $result->fetch_assoc()) {
						echo "<option value='$row[codigo]'>$row[descripcion]</option>"; 
					}
					$result->free();
					$mysqli->close();

				?>
			</select>

			<input type="submit" value="Dar de alta" class="btn">
		</fieldset>
	</form>

</body>
</html>