import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Leo on 2016/12/9.
 */
public class PublicSum extends HttpServlet {

    ServletContext servletContext;

    @Override
    public void init() throws ServletException {
        servletContext=this.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        String str=req.getParameter("number");
        int num=Integer.parseInt(str);
        HttpSession session=req.getSession();
        String o= (String) session.getAttribute("count");
        if (o!=null){
            count=Integer.parseInt(o);
        }else {
            count=0;
        }
        count+=num;
        String result=String.valueOf(count);
        session.setAttribute("count",result);
        writer.println("现在的累加结果是:"+count);
    }

    @Override
    public void destroy() {

    }
}
