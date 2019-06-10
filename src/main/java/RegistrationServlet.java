import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<form method='post' action='/profile'>" +
                        "<label for='name'>Name: </label>" +
                        "<input type='text' name='name'><br>" +
                        "<label for='password'>Password: </label>" +
                        "<input type='password' name='password'><br>" +
                        "<label for='age'>Age: </label>" +
                        "<input type='text' name='age'><br>" +
                        "<button type='submit'>Submit</button>" +
                    "</form>");
    }
}
