package servlets;

import db.DatabaseConnection;
import dto.CourseDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int duration = Integer.parseInt(request.getParameter("duration"));
        double price = Double.parseDouble(request.getParameter("price"));
        String startDate = request.getParameter("startDate");
        String teacher = request.getParameter("teacher");

        CourseDTO course = new CourseDTO();
        course.setName(name);
        course.setDescription(description);
        course.setDuration(duration);
        course.setPrice(price);
        course.setStartDate(startDate);
        course.setTeacher(teacher);

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO courses (name, description, duration, price, start_date, teacher) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, course.getName());
            statement.setString(2, course.getDescription());
            statement.setInt(3, course.getDuration());
            statement.setDouble(4, course.getPrice());
            statement.setString(5, course.getStartDate());
            statement.setString(6, course.getTeacher());
            statement.executeUpdate();
            response.sendRedirect("viewCourses.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
