import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscarCursos")
public class BuscarCursosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curso = request.getParameter("curso");
        String docente = request.getParameter("docente");
        String duracion = request.getParameter("duracion");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = DatabaseConnection.getConnection(); // Conexión a la base de datos
            String sql = "SELECT * FROM courses WHERE name LIKE ? AND teacher LIKE ? AND duration LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + curso + "%");
            ps.setString(2, "%" + docente + "%");
            ps.setString(3, "%" + duracion + "%");

            ResultSet rs = ps.executeQuery();
            out.println("<h2>Resultados de la Búsqueda:</h2>");
            out.println("<table border='1'><tr><th>Nombre</th><th>Docente</th><th>Duración</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("name") + "</td><td>" + rs.getString("teacher") + "</td><td>" + rs.getInt("duration") + "</td></tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
