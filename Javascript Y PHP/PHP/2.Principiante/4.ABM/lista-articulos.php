<!DOCTYPE html>
<html>
<head>
	<title>Articulos</title>
</head>
<style type="text/css">
	
	body {
		font-size: 14px;
		font-family: 'Arial';
		background-color: cornflowerblue;
		color: white;
		width: 850px;
		margin: 10px auto;
		padding: 40px;
		border: 1px solid khaki;
	}

	table	{
		border-collapse: collapse;
		width: 90%;
	}

	table, th, td {
		border: 1px solid lavender;
	}

	th {
		background-color: mediumaquamarine;
		height: 50px;
	}

	td {
		padding: 10px;
	}

	tr:hover {
		background-color: lightsteelblue;
	}

	.add {
		display: block;
		margin-top: 20px;
	}

</style>
<body>

	<h3>Listado de articulos</h3>	

	<table>
		<tr>
			<th>Columna</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th>Rubro</th>
			<th></th>
			<th></th>
		</tr>

		<?php 

			$link = new mysqli("localhost", "root", "", "mibasededatos");
			if ($link->error) {
				die("Hubo un error al conectarse a mysql a la base mibasededatos. El error es " . $link->error);
			}
			$result = $link->query("select a.codigo, a.descripcion, a.precio, r.descripcion as rubro from articulos as a inner join rubros as r where a.codigorubro = r.codigo");
			$articulo;
			while ($row = $result->fetch_assoc()) { 
				$articulo = "<tr>";
				$articulo .= "<td>$row[codigo]</td>";
				$articulo .= "<td>$row[descripcion]</td>";
				$articulo .= "<td>$row[precio]</td>";
				$articulo .= "<td>$row[rubro]</td>";
				$articulo .= "<td><a href='http://localhost:8080/project/articulos.php?operacion=modificar&codigo=$row[codigo]" . "'>Modificar</a></td>";
				$articulo .= "<td><a href='http://localhost:8080/project/articulos.php?operacion=borrar&codigo=$row[codigo]" . "'>Borrar</a></td>";
				$articulo .= "</tr>";
				echo "$articulo";
			}
			echo "</table>";
			$result->free();
			$link->close();
		?>

	<span class="add"><a href="http://localhost:8080/project/articulos.php?operacion=alta">Agregar un nuevo articulo</a></span>

</body>
</html>