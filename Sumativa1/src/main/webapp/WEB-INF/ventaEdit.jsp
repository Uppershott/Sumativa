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
    <title>Editar Venta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <div class="container-fluid">
	    <form:form method="POST" action="/venta/editarVenta" modelAttribute="ventaEdit">
	    	<form:label path="nombreCliente" >Nombre cliente: </form:label>
	    	<form:input type="text" path="nombreCliente" /> <br>
	    	<form:label path="nombreLibro">Nombre libro: </form:label>
	    	<form:input type="text" path="nombreLibro"/> <br>
	    	<form:label path="precioLibro">Precio libro: </form:label>
	    	<form:input type="text" path="precioLibro"/> <br>
	    	<input type="button" onClick="window.history.back()" value="Cancelar">
	    	<input type="submit" value="Confirmar">
	    </form:form>
   </div>
</body>

</html>