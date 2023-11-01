import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p7_c1 extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      response.setContentType("text/html");
      PrintWriter pwriter = response.getWriter();
      String in_uname = request.getParameter("uname");

      pwriter.print("<html>");
      pwriter.print("<head>");
      pwriter.print("<style>");
      pwriter.print("/* CSS for styling the page */");
      pwriter.print("body {");
      pwriter.print("  background-image: url('background.jpg');");
      pwriter.print("  background-size: cover;");
      pwriter.print("}");
      pwriter.print("h1 {");
      pwriter.print("  color: #0783ff;");
      pwriter.print("}");
      pwriter.print("a {");
      pwriter.print("  text-decoration: none;");
      pwriter.print("  color: #0783ff;");
      pwriter.print("}");
      pwriter.print("a:hover {");
      pwriter.print("  text-decoration: underline;");
      pwriter.print("}");
      pwriter.print("</style>");
      pwriter.print("</head>");
      pwriter.print("<body>");

      pwriter.print("<form action='p7_c2' method='POST'>");
      pwriter.print("<input type='hidden' name='uname' value='" + in_uname + "'>");
      pwriter.print("<h1>Welcome: " + in_uname + "</h1>");
      pwriter.print("<br />CLICK TO SEE THE RECIPES OF THE DAY");
      pwriter.print("<br /><input type='submit' value='RECIPES'>");
      pwriter.print("</form>");

      pwriter.print("</body>");
      pwriter.print("</html>");

      pwriter.close();
    } catch (Exception exp) {
      System.out.println(exp);
    }
  }
}
