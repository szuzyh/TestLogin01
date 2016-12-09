import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Leo on 2016/12/9.
 */
public class UserServlet extends HttpServlet {
    ServletContext servletContext;
    @Override
    public void init() throws ServletException {
        servletContext=this.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        String msg= (String) servletContext.getAttribute("msg");
        writer.println("<h1>"+"发布消息"+"</h1>");
        writer.println(msg);
    }
}
