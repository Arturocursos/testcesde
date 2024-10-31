package servlets;

import db.DatabaseConnection;
import models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/viewCourses")
public class ViewCoursesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Course> courses = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                Course course = new Course(
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("duration"),
                    rs.getDouble("price"),
                    rs.getString("start_date"),
                    rs.getString("teacher")
                );
                courses.add(course);
            }
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("viewCourses.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
