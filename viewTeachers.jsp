<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Teacher"%>
<%@ page import="java.util.ArrayList"%>
<%
    ArrayList<Teacher> teachers = (ArrayList<Teacher>) request.getAttribute("teachers");
%>
<html>
<head>
    <title>Ver Docentes</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Docentes Disponibles</h1>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Documento</th>
        <th>Correo</th>
        <th>Acciones</th>
    </tr>
    <% for (Teacher teacher : teachers) { %>
    <tr>
        <td><%= teacher.getName() %></td>
        <td><%= teacher.getDocument() %></td>
        <td><%= teacher.getEmail() %></td>
        <td>
            <form action="editTeacher.jsp" method="get">
                <input type="hidden" name="id" value="<%= teacher.getId() %>">
                <input type="submit" value="Editar">
            </form>
            <form action="deleteTeacher" method="post">
                <input type="hidden" name="id" value="<%= teacher.getId() %>">
                <input type="submit" value="Eliminar">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<a href="addTeacher.jsp">Agregar Docente</a>
</body>
</html>
