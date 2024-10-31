<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Course"%>
<%@ page import="java.util.ArrayList"%>
<%
    ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("courses");
%>
<html>
<head>
    <title>Ver Cursos</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Cursos Disponibles</h1>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Duración</th>
        <th>Precio</th>
        <th>Fecha de Inicio</th>
        <th>Docente</th>
        <th>Acciones</th>
    </tr>
    <% for (Course course : courses) { %>
    <tr>
        <td><%= course.getName() %></td>
        <td><%= course.getDescription() %></td>
        <td><%= course.getDuration() %></td>
        <td><%= course.getPrice() %></td>
        <td><%= course.getStartDate() %></td>
        <td><%= course.getTeacher() %></td>
        <td>
            <form action="editCourse.jsp" method="get">
                <input type="hidden" name="id" value="<%= course.getId() %>">
                <input type="submit" value="Editar">
            </form>
            <form action="deleteCourse" method="post">
                <input type="hidden" name="id" value="<%= course.getId() %>">
                <input type="submit" value="Eliminar">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<a href="addCourse.jsp">Agregar Curso</a>
</body>
</html>
