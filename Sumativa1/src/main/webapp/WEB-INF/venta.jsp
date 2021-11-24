<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Ventas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <div class="container-fluid">
    <form:form method="POST" action="/venta/registrar" modelAttribute="venta">
    	<form:label path="nombreCliente" >Nombre cliente: </form:label>
    	<form:input type="text" path="nombreCliente" /> <br>
    	<form:label path="nombreLibro">Nombre libro: </form:label>
    	<form:input type="text" path="nombreLibro"/> <br>
    	<form:label path="precioLibro">Precio libro: </form:label>
    	<form:input type="text" path="precioLibro"/> <br>
    	<input type="reset" value="Limpiar">
    	<input type="submit" value="Guardar">
    </form:form>
    <br>
    <hr>
    <table class="table">
    	<thead>
    		<tr>
    			<th scope="col">#</th>
    			<th scope="col">Nombre cliente</th>
    			<th scope="col">Nombre libro</th>
    			<th scope="col">Precio libro</th>
    			<th scope="col">Editar</th>
    			<th scope="col">Eliminar</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${listaVentas}" var="venta">
    			<tr>
    				<th scope="row">${venta.getId()}</th>
    				<td>${venta.getNombreCliente()}</td>
    				<td>${venta.getNombreLibro()}</td>
    				<td>${venta.getPrecioLibro()}</td>
    				<td>
    					<form action="/venta/editar" method="POST">
    						<input type="Hidden" name="id" value="${venta.getId()}">
    						<input type="submit" value="Editar">
    					</form>
    				</td>
    				<td>
    					<form action="/venta/eliminar" method="POST">
    						<input type="Hidden" name="id" value="${venta.getId()}">
    						<input type="submit" value="Eliminar">
    					</form>
    				</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    <form action="/">
		<input type="submit" value="Inicio">
	</form>
    </div>
</body>

</html>