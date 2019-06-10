import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Profile: </h1>");
        out.println("<h4>"+req.getParameter("name")+"</h4>");
        out.println("<h4>"+req.getParameter("password")+"</h4>");
        out.println("<h4>"+req.getParameter("age")+"</h4>");
    }
}
