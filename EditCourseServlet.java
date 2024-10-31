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

@WebServlet("/editCourse")
public class EditCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int duration = Integer.parseInt(request.getParameter("duration"));
        double price = Double.parseDouble(request.getParameter("price"));
        String startDate = request.getParameter("startDate");
        String teacher = request.getParameter("teacher");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE courses SET name = ?, description = ?, duration = ?, price = ?, start_date = ?, teacher = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, duration);
            statement.setDouble(4, price);
            statement.setString(5, startDate);
            statement.setString(6, teacher);
            statement.setInt(7, id);
            statement.executeUpdate();
            response.sendRedirect("viewCourses.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
