import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/db1";
            String dbUser = "root";
            String dbPassword = "";

            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            if (conn != null) {
                out.println("<h1>Connection successful</h1>");

                // Check if the email already exists in the database to determine whether to
                // insert or update
                PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
                selectStatement.setString(1, email);
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    // If the email exists, perform an update
                    PreparedStatement updateStatement = conn
                            .prepareStatement("UPDATE users SET name = ?, dob = ?, address = ? WHERE email = ?");
                    updateStatement.setString(1, name);
                    updateStatement.setString(2, dob);
                    updateStatement.setString(3, address);
                    updateStatement.setString(4, email);

                    int rowsUpdated = updateStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        out.println("<h1>Row Updated Successfully</h1>");
                        out.println("<h2>Updated Row:</h2>");
                        displayRow(out, conn, email);
                    } else {
                        out.println("<h1>Update Failed</h1>");
                    }
                } else {
                    // If the email doesn't exist, perform an insert
                    PreparedStatement insertStatement = conn
                            .prepareStatement("INSERT INTO users (name, dob, address, email) VALUES (?, ?, ?, ?)");
                    insertStatement.setString(1, name);
                    insertStatement.setString(2, dob);
                    insertStatement.setString(3, address);
                    insertStatement.setString(4, email);

                    int rowsInserted = insertStatement.executeUpdate();

                    if (rowsInserted > 0) {
                        out.println("<h1>Signup Successful</h1>");
                        out.println("<h2>Inserted Row:</h2>");
                        displayRow(out, conn, email);
                    } else {
                        out.println("<h1>Insertion Failed</h1>");
                    }
                }

                conn.close();
            } else {
                out.println("<h1>Connection failed</h1>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<h1>Operation failed</h1>");
        }
    }

    // Method to display a specific row
    private void displayRow(PrintWriter out, Connection conn, String email) throws SQLException {
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
        selectStatement.setString(1, email);
        ResultSet resultSet = selectStatement.executeQuery();

        if (resultSet.next()) {
            out.println("Name: " + resultSet.getString("name") + "<br>");
            out.println("Date of Birth: " + resultSet.getString("dob") + "<br>");
            out.println("Address: " + resultSet.getString("address") + "<br>");
            out.println("Email: " + resultSet.getString("email") + "<br>");
        } else {
            out.println("<p>No data found for email: " + email + "</p>");
        }
    }
}
