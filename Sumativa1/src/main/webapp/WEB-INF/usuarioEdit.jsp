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
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
     <div class="container-fluid">
	    <form:form method="POST" action="/usuario/editarUsuario" modelAttribute="usuarioEdit">
	    	<form:label path="nombre" >Nombre: </form:label>
	    	<form:input type="text" path="nombre" /> <br>
	    	<form:label path="apellido">Apellido: </form:label>
	    	<form:input type="text" path="apellido"/> <br>
	    	<form:label path="telefono">Telefono: </form:label>
	    	<form:input type="text" path="telefono"/> <br>
	    	<form:label path="correo">Correo: </form:label>
	    	<form:input type="text" path="correo"/> <br>
	    	<input type="button" onClick="window.history.back()" value="Cancelar">
	    	<input type="submit" value="Confirmar">
	    </form:form>
    </div>
</body>

</html>