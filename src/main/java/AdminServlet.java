import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Leo on 2016/12/9.
 */
public class AdminServlet extends HttpServlet {
    ServletContext servletContext;

    @Override
    public void init() throws ServletException {
        servletContext=this.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        String newmsg=req.getParameter("msg");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=simpleDateFormat.format(new Date());
        String msg= (String) servletContext.getAttribute("msg");
        if (msg==null){
            String str="发布时间"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"发布内容"+"<br>"+date
                    +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+newmsg;
            servletContext.setAttribute("msg",str);
        }else {
            String str=msg+"<br>"+date+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+newmsg;
            servletContext.setAttribute("msg",str);
        }
        writer.println("设置成功");

    }
}
