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
    <title>Inicio Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <div class="container-fluid">
    <form:form method="POST" action="/producto/registrar" modelAttribute="producto">
    	<form:label path="isbn" >ISBN: </form:label>
    	<form:input type="text" path="isbn" /> <br>
    	<form:label path="nombre">Nombre: </form:label>
    	<form:input type="text" path="nombre"/> <br>
    	<form:label path="autor">Autor: </form:label>
    	<form:input type="text" path="autor"/> <br>
    	<form:label path="editorial">Editorial: </form:label>
    	<form:input type="text" path="editorial"/> <br>
    	<input type="reset" value="Limpiar">
    	<input type="submit" value="Guardar">
    </form:form>
    <br>
    <hr>
    <table class="table">
    	<thead>
    		<tr>
    			<th scope="col">#</th>
    			<th scope="col">ISBN</th>
    			<th scope="col">Apellido</th>
    			<th scope="col">Autor</th>
    			<th scope="col">Editorial</th>
    			<th scope="col">Editar</th>
    			<th scope="col">Eliminar</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${listaProductos}" var="producto">
    			<tr>
    				<th scope="row">${producto.getId()}</th>
    				<td>${producto.getIsbn()}</td>
    				<td>${producto.getNombre()}</td>
    				<td>${producto.getAutor()}</td>
    				<td>${producto.getEditorial()}</td>
    				<td>
    					<form action="/producto/editar" method="POST">
    						<input type="Hidden" name="id" value="${producto.getId()}">
    						<input type="submit" value="Editar">
    					</form>
    				</td>
    				<td>
    					<form action="/producto/eliminar" method="POST">
    						<input type="Hidden" name="id" value="${producto.getId()}">
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