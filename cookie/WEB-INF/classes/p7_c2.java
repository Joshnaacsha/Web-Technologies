
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p7_c2 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      response.setContentType("text/html");
      PrintWriter pwriter = response.getWriter();
      Cookie[] ck = request.getCookies();

      String username = "Unidentified visitor";

      if (ck != null) {
        for (Cookie c : ck) {
          if (c.getName().equals("UserCookie")) {
            username = c.getValue();
            break;
          }
        }
      }

      pwriter.println("<html>");
      pwriter.println("<head>");
      pwriter.println("<style>");
      pwriter.println("/* CSS for styling links */");
      pwriter.println("a { text-decoration: none; color: #0783ff; }");
      pwriter.println("a:hover { text-decoration: underline; }");
      pwriter.println("body {");
      pwriter.println("  background-image: url('background.jpeg');");
      pwriter.println("  background-size: cover;");
      pwriter.println("}");
      pwriter.println(".recipe-link {");
      pwriter.println("  display: flex;");
      pwriter.println("  align-items: center;");
      pwriter.println("  margin: 10px;");
      pwriter.println("}");
      pwriter.println(".recipe-link img {");
      pwriter.println("  width: 80px;");
      pwriter.println("  height: 80px;");
      pwriter.println("  margin-right: 10px;");
      pwriter.println("}");
      pwriter.println("</style>");
      pwriter.println("</head>");
      pwriter.println("<body>");

      pwriter.println("<h1>Hello, " + username + ". Good to be here.</h1>");
      pwriter.println("<h3>RECIPES OF THE DAY</h3>");

      // Add links with images
      pwriter.println("<div class='recipe-link'>");
      pwriter.print(
          "<a class='link' href='https://www.food.com/recipe/bourbon-chicken-45809' target='content-iframe'>");
      pwriter.print("<img src='curry.jpg' alt='BOURBON CHICKEN' />");
      pwriter.print("BOURBON CHICKEN");
      pwriter.print("</a>");
      pwriter.println("</div>");

      pwriter.println("<div class='recipe-link'>");
      pwriter.print("<a class='link' href='https://www.food.com/recipe/paneer-tikka-43217' target='content-iframe'>");
      pwriter.print("<img src='paneer.jpeg' alt='Paneer Tikka' />");
      pwriter.print("PANEER TIKKA");
      pwriter.print("</a>");
      pwriter.println("</div>");

      pwriter.println("<div class='recipe-link'>");
      pwriter.print(
          "<a class='link' href='https://www.food.com/recipe/gobi-manchurian-cauliflower-in-a-sweet-sour-spicy-sauce-508887' target='content-iframe'>");
      pwriter.print("<img src='gobi.jpg' alt='Gobi Manchurian' />");
      pwriter.print("GOBI MANCHURIAN");
      pwriter.print("</a>");
      pwriter.println("</div>");

      pwriter.println("<div class='recipe-link'>");
      pwriter.print(
          "<a class='link' href='https://www.food.com/recipe/spicy-mutton-curry-119515' target='content-iframe'>");
      pwriter.print("<img src='chukka.jpg' alt='Mutton Curry' />");
      pwriter.print("MUTTON CURRY");
      pwriter.print("</a>");
      pwriter.println("</div>");

      pwriter.println("</body>");
      pwriter.println("</html>");

      pwriter.close();
    } catch (Exception exp) {
      System.out.println(exp);
    }
  }
}
