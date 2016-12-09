import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Leo on 2016/12/9.
 */
public class Index extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Index</title></head>");
        writer.println("<body");
        req.getRequestDispatcher("top").include(req,resp);
        writer.println("<h1>欢迎</h1>");
        req.getRequestDispatcher("bottom").include(req,resp);
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void destroy() {
    }
}
