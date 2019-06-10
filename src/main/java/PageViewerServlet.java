import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PageViewerServlet", urlPatterns = "/count")
public class PageViewerServlet  extends HttpServlet {
    private static int count=0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1>Page views: "+count+"</h1>");

    }
}
