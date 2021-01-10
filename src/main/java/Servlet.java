import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String zona = request.getParameter("cas_zona");
            ZoneId zone = ZoneId.of(zona);
            ZonedDateTime now = ZonedDateTime.now(zone);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + now + "</h1>");
            out.println("</body></html>");

        }catch (java.time.zone.ZoneRulesException e){

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> neplatna zona </h1>");
            out.println("</body></html>");

        }
    }
}
