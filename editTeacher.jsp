<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Teacher"%>
<%@ page import="java.util.ArrayList"%>
<%
    Teacher teacher = (Teacher) request.getAttribute("teacher");
%>
<html>
<head>
    <title>Editar Docente</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Editar Docente</h1>
<form action="editTeacher" method="post">
    <input type="hidden" name="id" value="<%= teacher.getId() %>">
    Nombre: <input type="text" name="name" value="<%= teacher.getName() %>" required><br>
    Documento: <input type="text" name="document" value="<%= teacher.getDocument() %>" required><br>
    Correo: <input type="email" name="email" value="<%= teacher.getEmail() %>" required><br>
    <input type="submit" value="Actualizar Docente">
</form>
<a href="viewTeachers.jsp">Volver a Docentes</a>
</body>
</html>
