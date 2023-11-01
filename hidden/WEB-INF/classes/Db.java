import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Db")
public class Db extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Define the connection URL, username, and password
            String jdbcUrl = "jdbc:mysql://localhost:3306/db1";
            String dbUser = "root";
            String dbPassword = "";

            // Establish the database connection
            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            if (conn != null) {
                out.println("<h1>Connection successful</h1>");

                // Define the SQL statement
                String sql = "INSERT INTO users (name, dob, address, email) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, dob);
                statement.setString(3, address);
                statement.setString(4, email);

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    out.println("<h1>Signup Successful</h1>");
                } else {
                    out.println("<h1>Signup Failed</h1>");
                }

                // Close the database connection
                conn.commit();
                conn.close();
            } else {
                out.println("<h1>Connection failed</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>Connection failed</h1>");
        }
    }
}
