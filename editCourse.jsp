<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Course"%>
<%@ page import="java.util.ArrayList"%>
<%
    Course course = (Course) request.getAttribute("course");
%>
<html>
<head>
    <title>Editar Curso</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Editar Curso</h1>
<form action="editCourse" method="post">
    <input type="hidden" name="id" value="<%= course.getId() %>">
    Nombre: <input type="text" name="name" value="<%= course.getName() %>" required><br>
    Descripción: <textarea name="description" required><%= course.getDescription() %></textarea><br>
    Duración (semanas): <input type="number" name="duration" value="<%= course.getDuration() %>" required><br>
    Precio: <input type="number" step="0.01" name="price" value="<%= course.getPrice() %>" required><br>
    Fecha de inicio: <input type="datetime-local" name="startDate" value="<%= course.getStartDate() %>" required><br>
    Docente: <input type="text" name="teacher" value="<%= course.getTeacher() %>" required><br>
    <input type="submit" value="Actualizar Curso">
</form>
<a href="viewCourses.jsp">Volver a Cursos</a>
</body>
</html>
