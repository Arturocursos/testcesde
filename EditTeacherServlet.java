package servlets;

import db.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/editTeacher")
public class EditTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String document = request.getParameter("document");
        String email = request.getParameter("email");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE teachers SET name = ?, document = ?, email = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, document);
            statement.setString(3, email);
            statement.setInt(4, id);
            statement.executeUpdate();
            response.sendRedirect("viewTeachers.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
