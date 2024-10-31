package servlets;

import db.DatabaseConnection;
import models.Teacher;

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

@WebServlet("/viewTeachers")
public class ViewTeachersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teachers");
            while (rs.next()) {
                Teacher teacher = new Teacher(
                    rs.getString("name"),
                    rs.getString("document"),
                    rs.getString("email")
                );
                teachers.add(teacher);
            }
            request.setAttribute("teachers", teachers);
            request.getRequestDispatcher("viewTeachers.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
