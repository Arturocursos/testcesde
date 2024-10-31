package servlets;

import db.DatabaseConnection;
import dto.TeacherDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/addTeacher")
public class AddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String document = request.getParameter("document");
        String email = request.getParameter("email");

        TeacherDTO teacher = new TeacherDTO();
        teacher.setName(name);
        teacher.setDocument(document);
        teacher.setEmail(email);

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO teachers (name, document, email) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, teacher.getName());
            statement.setString(2, teacher.getDocument());
            statement.setString(3, teacher.getEmail());
            statement.executeUpdate();
            response.sendRedirect("viewTeachers.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
