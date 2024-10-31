<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Docente</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Agregar Docente</h1>
<form action="addTeacher" method="post">
    Nombre: <input type="text" name="name" required><br>
    Documento: <input type="text" name="document" required><br>
    Correo: <input type="email" name="email" required><br>
    <input type="submit" value="Agregar Docente">
</form>
<a href="viewTeachers.jsp">Volver a Docentes</a>
</body>
</html>
