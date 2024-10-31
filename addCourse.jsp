<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Curso</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Agregar Curso</h1>
<form action="addCourse" method="post">
    Nombre: <input type="text" name="name" required><br>
    Descripción: <textarea name="description" required></textarea><br>
    Duración (semanas): <input type="number" name="duration" required><br>
    Precio: <input type="number" step="0.01" name="price" required><br>
    Fecha de inicio: <input type="datetime-local" name="startDate" required><br>
    Docente: <input type="text" name="teacher" required><br>
    <input type="submit" value="Agregar Curso">
</form>
<a href="viewCourses.jsp">Volver a Cursos</a>
</body>
</html>
